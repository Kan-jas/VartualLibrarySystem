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

@WebServlet("/SearchMember")
public class SearchMember{


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		//actionパラメータの読み込み
		String action = request.getParameter("action");
		if (action.equals("search1")) {
			// パラメータのエラーチェックは省略
			String userId = request.getParameter("userId");
			int id = Integer.parseInt(userId);
			search(id, null, 0);

		}else if(action.equals("search2")) {
			String name = request.getParameter("name");
			search(0, name, 0);

		}else if(action.equals("search3")) {
			String tel = request.getParameter("tel");
			int pnumber = Integer.parseInt(tel);
			search(0, null, pnumber);
		}
	}


	public void search(int userId,String name, int tel) {
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
			String sql = "SELECT (userId, phoneNumber, nameのどれか) "
					+ "From (会員の入ったテーブル) Where like UsesrID = ?";
			//PreparedStatementオブジェクトの取得
			PreparedStatement st = con.prepareStatement(sql);

			if(userId != 0) {
				sql = "SELECT * "
						+ "From webbook Where like user_id = ?";
				//プレースホルダの設定
				st.setInt(1, userId);
			}else if(name != null) {
				sql = "SELECT * "
						+ "From webbook Where like user_tel = ?";
				//プレースホルダの設定
				st.setString(1,name );
			}else if(tel != 0) {
				sql = "SELECT * "
						+ "From webbook Where like user_name = ?";
				//プレースホルダの設定
				st.setInt(1, tel);
			}

			//SQLの実行
			ResultSet rs = st.executeQuery();
			//結果の取得と表示
			while(rs.next()) {//表示させるデータ数で変わる
				System.out.println(rs.getInt("user_name") );
				System.out.println(rs.getInt("user_id") );
				System.out.println(rs.getInt("user_address") );
				System.out.println(rs.getInt("user_tel") );
				System.out.println(rs.getInt("user_email") );
				System.out.println(rs.getInt("user_birthday") );
				System.out.println(rs.getInt("user_join_date") );
				System.out.println(rs.getInt("user_taikai_date") );
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