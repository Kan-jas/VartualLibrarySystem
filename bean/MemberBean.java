package bean;

public class MemberBean {
	private String name;          //会員の名前
	private String adress;        //会員の住所
	private int postalCode;       //会員の郵便番号
	private int phoneNumber;      //会員の電話番号
	private String email;         //会員のメールアドレス
	private String birthDay;      //会員の生年月日
	private String joinDate;      //会員の入会日
	private int userId;           //会員ID

	public MemberBean(String name, String adress, int postalCode,
					int phoneNumber, String email, String birthDay,
					String joinDate, int userId) {

		this.name = name;
		this.adress = adress;
		this.postalCode = postalCode;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.birthDay = birthDay;
		this.joinDate = joinDate;
		this.userId = userId;
	}

	public MemberBean() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getbirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getjoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
