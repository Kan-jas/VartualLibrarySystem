package Bean;

public class BookingBean {
	private int user_id;                               //会員ID
	private int material_booking_number;               //合計冊数
	private String material_booking_date;              //予約日（年月日）
	private int material_ensured_id;                   //確保済資料ID
	private boolean material_is_booked;                //貸出済み
	private boolean material_is_cancel;                //キャンセル
	private String material_columm;                    //備考欄

	public BookingBean(int user_id, int material_booking_number,
			String material_booking_date, int material_ensured_id,
			boolean material_is_booked,boolean material_is_cancel, String material_columm) {

		this.user_id = user_id;
		this.material_booking_number = material_booking_number;
		this.material_booking_date = material_booking_date;
		this.material_ensured_id = material_ensured_id;
		this.material_is_booked = material_is_booked;
		this.material_is_cancel = material_is_cancel;
		this.material_columm = material_columm;
	}

	public BookingBean() {

	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getMaterial_booking_number() {
		return material_booking_number;
	}

	public void setMaterial_booking_number(int material_booking_number) {
		this.material_booking_number = material_booking_number;
	}

	public String getMaterial_booking_date() {
		return material_booking_date;
	}

	public void setMaterial_booking_date(String material_booking_date) {
		this.material_booking_date = material_booking_date;
	}

	public int getMaterial_ensured_id() {
		return material_ensured_id;
	}

	public void setMaterial_ensured_id(int material_ensured_id) {
		this.material_ensured_id = material_ensured_id;
	}

	public boolean getMaterial_is_booked() {
		return material_is_booked;
	}

	public void setMaterial_is_booked(boolean material_is_booked) {
		this.material_is_booked = material_is_booked;
	}

	public boolean getMaterial_is_cancel() {
		return material_is_cancel;
	}

	public void setMaterial_is_cancel(boolean material_is_cancel) {
		this.material_is_cancel = material_is_cancel;
	}

	public String getMaterial_columm() {
		return material_columm;
	}

	public void setMaterial_columm(String material_columm) {
		this.material_columm = material_columm;
	}
}
