package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import la.bean.BookingBean;


public class BookingRegistDAO {



    //接続用の情報をフィールドに定数として定義

    private static String RDB_DRIVE = "org.postgresql.Driver";

    private static String URL = "jdbc:postgresql:library";

    private static String USER = "student";

    private static String PASS = "himitu";


    //データベース接続を行うメソッド

    public static Connection getConnection(){

        try{

            Class.forName(RDB_DRIVE);

            Connection con = DriverManager.getConnection(URL, USER, PASS);

            return con;

        }catch(Exception e){

            throw new IllegalStateException(e);

        }

    }



    //データベースへデータを登録するメソッド

    public int insert(BookingBean bookingbean){

        //変数宣言

        Connection con = null;

        Statement  smt = null;



        //return用変数

        int count = 0;


        //SQL文

        String sql =  "INSERT INTO yoyakudaichou VALUES('"

                + bookingbean.getUser_id() + "','"

                + bookingbean.getMaterial_ensured_id() + "','"

                + bookingbean.getMaterial_booking_date() + "','"

                + bookingbean.getMaterial_column() + "','";






        try{

            con = getConnection();

            smt = con.createStatement();



            //SQLをDBへ発行

            count = smt.executeUpdate(sql);



        }catch(Exception e){

            throw new IllegalStateException(e);

        }finally{

            //リソースの開放

            if(smt != null){

                try{smt.close();}catch(SQLException ignore){}

            }

            if(con != null){

                try{con.close();}catch(SQLException ignore){}

            }

        }

       return count;

    }
}

