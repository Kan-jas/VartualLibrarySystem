package la.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.CheckOutBean;
import la.dao.CheckoutRegistDAO;



public class CheckoutRegistServlet extends HttpServlet{



    public void doGet(HttpServletRequest request ,HttpServletResponse response)

    throws ServletException ,IOException{



        String error = "";



        try{

            //文字エンコーディングの指定

            request.setCharacterEncoding("UTF-8");



            //DTOオブジェクト宣言

            CheckOutBean checkoutbean = new CheckOutBean();



            //パラメータの取得

            checkoutbean.setUser_id(request.getParameter("user_id"));

            checkoutbean.setMaterial_id(request.getParameter("material_id"));

            checkoutbean.setMaterial_lending_date(request.getParameter("material_lending_date"));





            //DAOオブジェクト宣言

            CheckoutRegistDAO objDao4 = new CheckoutRegistDAO();



            //1件登録メソッドを呼び出し

            int count = objDao4.insert(checkoutbean);



            //登録された件数を持ってlist.jspにフォワード

            request.setAttribute("count", count);



        }catch (IllegalStateException e) {

            error ="DB接続エラーの為、登録できませんでした。";


        }catch(Exception e){

            error ="予期せぬエラーが発生しました。<br>"+e;



        }finally{

            request.setAttribute("error", error);

           request.getRequestDispatcher("/comformCheckRegist.jsp").forward(request, response);

        }

    }

 }
