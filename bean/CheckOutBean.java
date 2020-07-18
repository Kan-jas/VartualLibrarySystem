package bean;

public class CheckOutBean {
	private int user_id;                         //会員ID
	private int material_id;                     //資料ID
	private String material_checkout_date;         //貸出日（年月日）
	private String material_return_date;          //返却期日（年月日）
	private String material_returned_date;        //返却日（年月日）
	private String material_columm;              //備考欄

	public CheckOutBean(int user_id, int material_id,int material_checkout_number,
			String material_checkout_date, String material_return_date,
			String material_returned_date,String material_columm) {

		this.user_id = user_id;
		this.material_id = material_id;
		this.material_checkout_date = material_checkout_date;
		this.material_return_date = material_return_date;
		this.material_returned_date = material_returned_date;
		this.material_columm = material_columm;
	}
//
//	public CheckOutBean() {
//
//	}
//
//	public int getUser_id() {
//		return user_id;
//	}
//
//	public void setUser_id(int user_id) {
//		this.user_id = user_id;
//	}
//
//	public int getMaterial_id() {
//		return material_id;
//	}
//
//	public void setMaterial_id(int material_id) {
//		this.material_id = material_id;
//	}
//
//	public String getMaterial_checkout_date() {
//		return material_checkout_date;
//	}
//
//	public void setMaterial_checkout_date(String material_checkout_date) {
//		this.material_checkout_date = material_checkout_date;
//	}
//
//	public String getMaterial_return_date() {
//		return material_return_date;
//	}
//
//	public void setMaterial_return_date(String material_return_date) {
//		this.material_return_date = material_return_date;
//	}
//
//	public String getMaterial_returned_date() {
//		return material_returned_date;
//	}
//
//	public void setMaterial_returned_date(String material_returned_date) {
//		this.material_returned_date = material_returned_date;
//	}
//
//	public String getMaterial_columm() {
//		return material_columm;
//	}
//
//	public void setMaterial_columm(String material_columm) {
//		this.material_columm = material_columm;
//	}
}
