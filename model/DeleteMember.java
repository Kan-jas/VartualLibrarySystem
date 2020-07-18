package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.SearchMember;

public class DeleteMember extends SearchMember implements Sakujo{

	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			//JDBCドライバの登録
			Class.forName("org.postgresql.Driver");
			//URL,ユーザ名、パスワードの設定
			String url = "jdbc:postgresql:webbook";
			String user = "student";
			String pass = "himitu";
			//データベースへアクセス
			Connection con = DriverManager.getConnection(url, user, pass);
			//削除用SQLの用意
			String delSql = "DELETE FROM webbook WHERE user_id=?";
			//PreparedStatementオブジェクトの取得
			PreparedStatement st = con.prepareStatement(delSql);
			//パラメータ取得
			String user_id[] = request.getParameterValues("date");
			 for (int i = 0; i < user_id.length; i++ ) {
				//プレースホルダの設定
				st.setString(1,user_id[i] );
		        }

			//SQLの実行
			int rs = st.executeUpdate();
			//削除完了の画面を表示する。
			// 呼び出し先Jspに渡すデータセット
			String jsp = request.getParameter("delete");
			request.setAttribute("complete", jsp);

			// result.jsp にページ遷移
			RequestDispatcher dispatch = request.getRequestDispatcher("result.jsp");
			dispatch.forward(request, response);
			//リソースの開放
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

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