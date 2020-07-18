package bean;

public class MaterialBean {
	private String material_ISBN;                   //資料ISBN
	private String material_name;                   //資料の名前・タイトル
	private String material_class_code;             //分類コード
	private String material_author;                 //著者
	private String material_publishing;             //出版社
	private String material_published_date;         //出版日
	private String material_id;                     //資料ID
	private String material_store_date;             //蔵書日
	private String material_dispose_date;           //廃棄日
	private String material_columm;                 //備考欄

	public MaterialBean(String material_ISBN, String material_name, String material_class_code,
			String material_author, String material_publishing, String material_publishd_date,
			String material_id, String material_store_date, String material_dispose_date, String material_columm) {

		this.material_ISBN = material_ISBN;
		this.material_name = material_name;
		this.material_class_code = material_class_code;
		this.material_author = material_author;
		this.material_publishing = material_publishing;
		this.material_published_date = material_publishd_date;
		this.material_id = material_id;
		this.material_store_date = material_store_date;
		this.material_dispose_date = material_dispose_date;
		this.material_columm = material_columm;
	}

	public MaterialBean() {

	}

	public String getMaterial_ISBN() {
		return material_ISBN;
	}

	public void setMaterial_ISBN(String material_ISBN) {
		this.material_ISBN = material_ISBN;
	}

	public String getMaterial_name() {
		return material_name;
	}

	public void setMaterial_name(String material_name) {
		this.material_name = material_name;
	}

	public String getMaterial_class_code() {
		return material_class_code;
	}

	public void setMaterial_class_code(String material_class_code) {
		this.material_class_code = material_class_code;
	}

	public String getMaterial_author() {
		return material_author;
	}

	public void setMaterial_author(String material_author) {
		this.material_author = material_author;
	}

	public String getMaterial_publishing() {
		return material_publishing;
	}

	public void setMaterial_publishing(String material_publishing) {
		this.material_publishing = material_publishing;
	}

	public String getMaterial_publishd_date() {
		return material_published_date;
	}

	public void setMaterial_published_date(String material_publishd_date) {
		this.material_published_date = material_publishd_date;
	}

	public String getMaterial_id() {
		return material_id;
	}

	public void setMaterial_id(String material_id) {
		this.material_id = material_id;
	}

	public String getMaterial_store_date() {
		return material_store_date;
	}

	public void setMaterial_store_date(String material_store_date) {
		this.material_store_date = material_store_date;
	}

	public String getMaterial_dispose_date() {
		return material_dispose_date;
	}

	public void setMaterial_dispose_date(String material_dispose_date) {
		this.material_dispose_date = material_dispose_date;
	}

	public String getMaterial_columm() {
		return material_columm;
	}

	public void setMaterial_columm(String material_columm) {
		this.material_columm = material_columm;
	}


}
