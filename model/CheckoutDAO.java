package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.CheckOutBean;

public class CheckoutDAO{
	private Connection con;
	public CheckoutDAO()throws DAOException{
		getConnection();
	}

	public List<CheckOutBean> findAll() throws DAOException{
		if(con==null) {
			getConnection();
		}

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			//SQL文の作成
			String sql = "SeLECT * FROM kasidaichou";
			//PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			//SQLの実行
			rs = st.executeQuery();
			//結果の取得および表示
			List<CheckOutBean> list = new ArrayList<CheckOutBean>();
			while(rs.next()) {
				//ここはデータベースの列に則る。
				int userId = rs.getInt("user_id");
				int materialId = rs.getInt("material_id");
				int materialCheckoutNumber = rs.getInt("material_checkout_number");
				String materialCheckoutDate = rs.getString("material_checkout_date");
				String  materialReturnDate = rs.getString(" material_return_date");
				String  materialReturnedDate = rs.getString(" material_returned_date");
				String materialColumm = rs.getString("material_columm");
				CheckOutBean bean = new CheckOutBean(userId, materialId, materialCheckoutNumber, materialCheckoutDate, materialReturnDate, materialReturnedDate, materialColumm);
				list.add(bean);
			}
			//貸出台帳をListとして返す
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}finally {
			try {
				//リソースの開放
				if(rs != null)rs.close();
				if(rs != null)st.close();
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}
	}

	private void getConnection() throws DAOException {
		try {
			//JDBCドライバの登録
			Class.forName("org.postgresql.Driver");
			//URL,ユーザ名、パスワードの設定
			String url = "jdbc:postgresql:webbook";
			String user = "student";
			String pass = "himitu";
			//データベースへアクセス
			Connection con = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			throw new DAOException("接続に失敗しました。");
		}
	}

	private void close() throws SQLException {
		if(con != null) {
			con.close();
			con = null;
		}
	}

}