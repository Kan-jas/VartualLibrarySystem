package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MaterialBean;
import model.MaterialRegistDAO;



public class MaterialRegistServlet extends HttpServlet{



    public void doGet(HttpServletRequest request ,HttpServletResponse response)

    throws ServletException ,IOException{



        String error = "";



        try{

            //文字エンコーディングの指定

            request.setCharacterEncoding("UTF-8");



            //DTOオブジェクト宣言

            MaterialBean materialbean = new MaterialBean();



            //パラメータの取得

            materialbean.setMaterial_ISBN(request.getParameter("material_ISBN"));

            materialbean.setMaterial_name(request.getParameter("material_name"));

            materialbean.setMaterial_class_code(request.getParameter("material_class_code"));

            materialbean.setMaterial_author(request.getParameter("material_author"));

            materialbean.setMaterial_publishing(request.getParameter("material_publishing"));

            materialbean.setMaterial_published_date(request.getParameter("material_published_date"));

            materialbean.setMaterial_id(request.getParameter("material_id"));

            materialbean.setMaterial_dispose_date(request.getParameter("naterial_dispose_date"));

            materialbean.setMaterial_columm(request.getParameter("material_column"));


            //DAOオブジェクト宣言

            MaterialRegistDAO objDao4 = new MaterialRegistDAO();



            //1件登録メソッドを呼び出し

            int count = objDao4.insert(materialbean);



            //登録された件数を持ってlist.jspにフォワード

            request.setAttribute("count", count);



        }catch (IllegalStateException e) {

            error ="DB接続エラーの為、登録できませんでした。";


        }catch(Exception e){

            error ="予期せぬエラーが発生しました。<br>"+e;



        }finally{

            request.setAttribute("error", error);

           request.getRequestDispatcher("/comformMatRegist.jsp").forward(request, response);

        }

    }

 }
