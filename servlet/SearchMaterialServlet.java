package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MaterialBean;
import model.SearchMaterialDAO;
/**
 * Servlet implementation class MaterialSearchServlet
 */
@WebServlet("/SearchMaterialServlet")
public class SearchMaterialServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String error = "";

		try{
			 //文字エンコーディングの指定
			request.setCharacterEncoding("UTF-8");

			//DTOオブジェクト宣言
			MaterialBean matIdIinfo = new MaterialBean();

			//パラメータの取得
			matIdIinfo.setMaterial_id(request.getParameter("id"));

			//DAOオブジェクト宣言
			SearchMaterialDAO objDao = new SearchMaterialDAO();

			//全検索メソッドを呼び出し
			 ArrayList<MaterialBean> list = objDao.selectAll();

			//検索結果を持ってlist.jspにフォワード
			 request.setAttribute("list", list);

		} catch (IllegalStateException e) {
			error ="DB接続エラーの為、一覧表示はできませんでした。";

		} catch(Exception e){
			error ="予期せぬエラーが発生しました。<br>"+e;

		} finally{
			request.setAttribute("error", error);
			request.getRequestDispatcher("/searchFrame.jsp").forward(request, response);
		}
	}
}
