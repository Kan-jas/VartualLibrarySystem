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

@WebServlet("/SearchMaterial")
public class SearchMaterial{


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		//actionパラメータの読み込み
		String action = request.getParameter("action");
		if (action.equals("search")) {
			// パラメータのエラーチェックは省略
			String materialId = request.getParameter("materialId");
			int id = Integer.parseInt(materialId);
			search(id);

		}
	}


	public void search(int materialId) {
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

			if(materialId != 0) {
				sql = "SELECT * "
						+ "From material_catalog Where like material_id = ?";
				//プレースホルダの設定
				st.setInt(1, materialId);
			}

			//SQLの実行
			ResultSet rs = st.executeQuery();
			//結果の取得と表示
			while(rs.next()) {//表示させるデータ数で変わる
				System.out.println(rs.getInt("material_ISBN") );
				System.out.println(rs.getInt("material_name") );
				System.out.println(rs.getInt("material_class_code") );
				System.out.println(rs.getInt("material_author") );
				System.out.println(rs.getInt("material_publishing") );
				System.out.println(rs.getInt("material_publish_date") );
				System.out.println(rs.getInt("material_id") );
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