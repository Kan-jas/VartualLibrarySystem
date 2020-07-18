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

@WebServlet("/SearchBook")
public class SearchBook{


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		//actionパラメータの読み込み
		String action = request.getParameter("action");
		if (action.equals("search")) {
			// パラメータのエラーチェックは省略
			String ISBN = request.getParameter("ISBN");
			int id = Integer.parseInt(ISBN);
			search(id);

		}
	}


	public void search(int ISBN) {
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

			if(ISBN != 0) {
				sql = "SELECT * "
						+ "From yoyakudaichou Where like user_ISBN = ?";
				//プレースホルダの設定
				st.setInt(1, ISBN);
			}

			//SQLの実行
			ResultSet rs = st.executeQuery();
			//結果の取得と表示
			while(rs.next()) {//表示させるデータ数で変わる
				System.out.println(rs.getInt("material_ISBN") );
				System.out.println(rs.getInt("user_id") );
				System.out.println(rs.getInt("user_booking_date") );
				System.out.println(rs.getInt("user_ensured_id") );
				System.out.println(rs.getInt("user_column") );
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