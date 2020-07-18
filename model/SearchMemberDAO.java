package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.MemberBean;

public class SearchMemberDAO {
	private static final ArrayList<MemberBean> count = null;
	//接続用の情報をフィールドに定数として定義
	 private static String RDB_DRIVE = "com.mysql.jdbc.Driver";
	 private static String URL = "jdbc:mysql://localhost/accountdb";
	 private static String USER = "user";
	 private static String PASS = "himitu";

	//データベース接続を行うメソッド
	 public static Connection getConnection(){
		 try{
			 Class.forName(RDB_DRIVE);
			 Connection con = DriverManager.getConnection(URL, USER, PASS);
			 return con;
		 } catch(Exception e) {
			 throw new IllegalStateException(e);
		 }

	 }

	//データベースから全てのアカウント情報の検索を行うメソッド
	//戻り値としてArrayList<AccountInfo>型の変数を利用
	 public ArrayList<MemberBean> selectAll(){
		//変数宣言
		 Connection con = null;
		 Statement  smt = null;

		 //return用オブジェクトの生成
		 ArrayList<MemberBean> list = new ArrayList<MemberBean>();

		//SQL文
		 String sql = "SELECT * FROM member";

		 try{
			 con = getConnection();
			 smt = con.createStatement();

			//SQLをDBへ発行
			 ResultSet rs = smt.executeQuery(sql);

		//検索結果を配列に格納
		 while(rs.next()){
			 MemberBean memberbean =new MemberBean();
			 memberbean.setUser_name(rs.getString("user_name"));
			 memberbean.setUser_id(rs.getString("user_id"));
			 memberbean.setUser_adress(rs.getString("user_adress"));
			 memberbean.setUser_tel(rs.getString("user_tel"));
			 memberbean.setUser_email(rs.getString("user_email"));
			 memberbean.setUser_birthday_date(rs.getString("user_birthday_date"));
			 memberbean.setUser_join_date(rs.getString("user_oin_date"));
			 memberbean.setUser_taikai_date(rs.getString("user_taikai_date"));
			 list.add(memberbean);
		 }
	 } catch(Exception e) {
		 throw new IllegalStateException(e);
	 } finally {
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
