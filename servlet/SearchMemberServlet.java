package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.MemberBean;

/**
 * Servlet implementation class MemberSearchServlet
 */
@WebServlet("/MemberSearchServlet")
public class SearchMemberServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String error = "";

		try{
			//配列宣言
			ArrayList<MemberBean> list = new ArrayList<MemberBean>();

			//オブジェクト宣言
			MemberBean objDao = new MemberBean();

			//全検索メソッドを呼び出し
			 list = objDao.selectAll();

			//検索結果を持ってlist.jspにフォワード
			 request.setAttribute("list", list);

		} catch (IllegalStateException e) {
			error ="DB接続エラーの為、一覧表示はできませんでした。";

		} catch(Exception e){
			error ="予期せぬエラーが発生しました。<br>"+e;

		} finally{
			request.setAttribute("error", error);
			request.getRequestDispatcher("/view/ch13/list1.jsp").forward(request, response);
		}
	}
}
