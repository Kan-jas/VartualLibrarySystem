package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.MaterialBean;

public class SearchMaterialDAO {
	private static final ArrayList<MaterialBean> count = null;
	//接続用の情報をフィールドに定数として定義
	 private static String URL = "jdbc:postgresql:sample";
	 private static String USER = "student";//結合時に変更の可能性あり
	 private static String PASS = "himitu";

	//データベース接続を行うメソッド
	 public static Connection getConnection(){
		 try{
			 Class.forName("org.postgresql.Driver");

			 Connection con = DriverManager.getConnection(URL, USER, PASS);
			 return con;
		 } catch(Exception e) {
			 throw new IllegalStateException(e);
		 }
	 }


	//データベースから全てのアカウント情報の検索を行うメソッド
	//戻り値としてArrayList<AccountInfo>型の変数を利用
	 public ArrayList<MaterialBean> selectAll(){
		//変数宣言
		 Connection con = null;
		 Statement  smt = null;

		 //return用オブジェクトの生成
		 ArrayList<MaterialBean> list = new ArrayList<MaterialBean>();

		//SQL文
		 String sql = "SELECT * FROM material_catalog";

		 try{
			 con = getConnection();
			 smt = con.createStatement();

			//SQLをDBへ発行
			 ResultSet rs = smt.executeQuery(sql);

		//検索結果を配列に格納
			 while(rs.next()) {
				 MaterialBean materialbean =new MaterialBean();
				 materialbean.setMaterial_ISBN(rs.getString("material_ISBN"));
				 materialbean.setMaterial_name(rs.getString("material_name"));
				 materialbean.setMaterial_class_code(rs.getString("material_class_code"));
				 materialbean.setMaterial_author(rs.getString("material_author"));
				 materialbean.setMaterial_publishing(rs.getString("material_publishing"));
				 materialbean.setMaterial_published_date(rs.getString("material_published_date"));
				 materialbean.setMaterial_id(rs.getString("material_id"));
				 list.add(materialbean);
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
