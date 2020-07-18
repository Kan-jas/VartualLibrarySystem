package la.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.BookingBean;
import la.dao.BookingRegistDAO;



public class BookingRegistServlet extends HttpServlet{



    public void doGet(HttpServletRequest request ,HttpServletResponse response)

    throws ServletException ,IOException{



        String error = "";



        try{

            //文字エンコーディングの指定

            request.setCharacterEncoding("UTF-8");



            //DTOオブジェクト宣言

            BookingBean bookingbean = new BookingBean();



            //パラメータの取得

            bookingbean.setUser_id(request.getParameter("user_id"));

            bookingbean.setMaterial_id(request.getParameter("material_id"));

            bookingbean.setMaterial_booking_date(request.getParameter("material_booking_date"));

            bookingbean.setMaterial_column(request.getParameter("material_column"));







            //DAOオブジェクト宣言

            BookingRegistDAO objDao4 = new BookingRegistDAO();



            //1件登録メソッドを呼び出し

            int count = objDao4.insert(bookingbean);



            //登録された件数を持ってlist.jspにフォワード

            request.setAttribute("count", count);



        }catch (IllegalStateException e) {

            error ="DB接続エラーの為、登録できませんでした。";


        }catch(Exception e){

            error ="予期せぬエラーが発生しました。<br>"+e;



        }finally{

            request.setAttribute("error", error);

           request.getRequestDispatcher("/comformBookRegist.jsp").forward(request, response);

        }

    }

 }
