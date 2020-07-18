package la.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.MemberBean;
import la.dao.MemberRegistDAO;



public class MemberRegistServlet extends HttpServlet{



    public void doGet(HttpServletRequest request ,HttpServletResponse response)

    throws ServletException ,IOException{



        String error = "";



        try{
            //文字エンコーディングの指定

            request.setCharacterEncoding("UTF-8");



            //DTOオブジェクト宣言

            MemberBean memberbean = new MemberBean();



            //パラメータの取得

            memberbean.setUser_family_name(request.getParameter("user_family_name"));

            memberbean.setUser_name(request.getParameter("user_name"));

            memberbean.setUser_birthday_date(request.getParameter("user_birthday_date"));

            memberbean.setUser_postal_code(request.getParameter("user_postal_code"));

            memberbean.setUser_adress(request.getParameter("user_adress"));

            memberbean.setUser_tel(request.getParameter("user_tel"));

            memberbean.setUser_email(request.getParameter("user_email"));




            //DAOオブジェクト宣言

            MemberRegistDAO objDao4 = new MemberRegistDAO();



            //1件登録メソッドを呼び出し

            int count = objDao4.insert(memberbean);



            //登録された件数を持ってlist.jspにフォワード

            request.setAttribute("count", count);



        }catch (IllegalStateException e) {

            error ="DB接続エラーの為、登録できませんでした。";


        }catch(Exception e){

            error ="予期せぬエラーが発生しました。<br>"+e;



        }finally{

            request.setAttribute("error", error);

           request.getRequestDispatcher("/comformMemRegist.jsp").forward(request, response);

        }

    }

 }
