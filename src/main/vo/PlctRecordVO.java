package main.vo;

public class PlctRecordVO {
	private int plct_rec_no;
	private int lct_no;
	private String plct_rec_date;
	private String plct_rec_cate;
	private String plct_rec_reason;
	private String admin_id;
	
	// get & set
	
	public int getPlct_rec_no() {
		return plct_rec_no;
	}
	public void setPlct_rec_no(int plct_rec_no) {
		this.plct_rec_no = plct_rec_no;
	}
	public int getLct_no() {
		return lct_no;
	}
	public void setLct_no(int lct_no) {
		this.lct_no = lct_no;
	}
	public String getPlct_rec_date() {
		return plct_rec_date;
	}
	public void setPlct_rec_date(String plct_rec_date) {
		this.plct_rec_date = plct_rec_date;
	}
	public String getPlct_rec_cate() {
		return plct_rec_cate;
	}
	public void setPlct_rec_cate(String plct_rec_cate) {
		this.plct_rec_cate = plct_rec_cate;
	}
	public String getPlct_rec_reason() {
		return plct_rec_reason;
	}
	public void setPlct_rec_reason(String plct_rec_reason) {
		this.plct_rec_reason = plct_rec_reason;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	
	
	// ������
	
	public PlctRecordVO() {}
	
	
	public PlctRecordVO(int plct_rec_no, int lct_no, String plct_rec_date, String plct_rec_cate,
			String plct_rec_reason, String admin_id) {
		super();
		this.plct_rec_no = plct_rec_no;
		this.lct_no = lct_no;
		this.plct_rec_date = plct_rec_date;
		this.plct_rec_cate = plct_rec_cate;
		this.plct_rec_reason = plct_rec_reason;
		this.admin_id = admin_id;
	}
	
	
}
