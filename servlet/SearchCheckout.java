package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchCheckout")
public class SearchCheckout{


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		//actionパラメータの読み込み
		String action = request.getParameter("action");
		if (action.equals("search")) {
			// パラメータのエラーチェックは省略
			String userId = request.getParameter("materialId");
			int id = Integer.parseInt(userId);
			search(id, 0);

		}else if(action.equals("search3")) {
			String materialId = request.getParameter("tel");
			int matId = Integer.parseInt(materialId);
			search(0, matId);
		}
	}


	public void search(int userId, int materialId) {
		try {
			//JDBCドライバの登録
			Class.forName("org.postgresql.Driver");
			//URL,ユーザ名、パスワードの設定
			String url = "jdbc:postgresql:webbook";
			String user = "student";
			String pass = "himitu";
			//データベースへアクセス
			Connection con = DriverManager.getConnection(url, user, pass);
			//SQL文の作成
			String sql = null;
			//PreparedStatementオブジェクトの取得
			PreparedStatement st = con.prepareStatement(sql);

			if(userId != 0) {
				sql = "SELECT * "
						+ "From kashidaichou Where like user_id = ?";
				//プレースホルダの設定
				st.setInt(1, userId);
			}else if(materialId != 0) {
				sql = "SELECT * "
						+ "From kashidaichou Where like material_id = ?";
				//プレースホルダの設定
				st.setInt(1,materialId );
			}

			//SQLの実行
			ResultSet rs = st.executeQuery();
			//結果の取得と表示
			while(rs.next()) {//表示させるデータ数で変わる
				System.out.println(rs.getInt("user_id") );
				System.out.println(rs.getInt("material_id") );
				System.out.println(rs.getInt("material_check_out") );
				System.out.println(rs.getInt("material_return_period") );
				System.out.println(rs.getInt("material_returned_date") );
			}
			//リソースの開放
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}