package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.SearchMaterial;

@WebServlet("/DeleteMaterial")
public class DeleteMaterial extends SearchMaterial implements Sakujo{
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
			String delSql = "DELETE FROM webbook WHERE material_id=?";
			//PreparedStatementオブジェクトの取得
			PreparedStatement st = con.prepareStatement(delSql);
			//パラメータ取得
			String material_id[] = request.getParameterValues("date");
			 for (int i = 0; i < material_id.length; i++ ) {
				//プレースホルダの設定
				st.setString(1,material_id[i] );
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
				System.out.println(rs.getInt("material_name") );
				System.out.println(rs.getInt("material_id") );
				System.out.println(rs.getInt("material_author") );
				System.out.println(rs.getInt("material_publishing") );
				System.out.println(rs.getInt("material_publish_date") );
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