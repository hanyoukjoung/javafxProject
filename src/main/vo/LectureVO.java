package main.vo;
//lectures
public class LectureVO {
	private int lct_no;
	private String lct_name;
	private String lct_cont;
	private String mem_id;
	private int lang_no;
	private int lct_status;
	private int lct_price;
	private String lct_upload_date;
	private String lct_permit_date;
	
	
	public String getLct_cont() {
		return lct_cont;
	}

	public void setLct_cont(String lct_cont) {
		this.lct_cont = lct_cont;
	}

	public int getLct_no() {
		return lct_no;
	}
	
	public void setLct_no(int lct_no) {
		this.lct_no = lct_no;
	}
	
	public String getLct_name() {
		return lct_name;
	}
	
	public void setLct_name(String lct_name) {
		this.lct_name = lct_name;
	}
	
	public String getMem_id() {
		return mem_id;
	}
	
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	
	public int getLang_no() {
		return lang_no;
	}
	
	public void setLang_no(int lang_no) {
		this.lang_no = lang_no;
	}
	
	public int getLct_status() {
		return lct_status;
	}
	
	public void setLct_status(int lct_status) {
		this.lct_status = lct_status;
	}
	
	public int getLct_price() {
		return lct_price;
	}
	
	public void setLct_price(int lct_price) {
		this.lct_price = lct_price;
	}
	
	public String getLct_upload_date() {
		return lct_upload_date;
	}
	
	public void setLct_upload_date(String lct_upload_date) {
		this.lct_upload_date = lct_upload_date;
	}
	
	public String getLct_permit_date() {
		return lct_permit_date;
	}
	
	public void setLct_permit_date(String lct_permit_date) {
		this.lct_permit_date = lct_permit_date;
	}

	public LectureVO() {
		
	}

	public LectureVO(int lct_no, String lct_name, String lct_cont, String mem_id, int lang_no, int lct_status,
			int lct_price, String lct_upload_date, String lct_permit_date) {
		super();
		this.lct_no = lct_no;
		this.lct_name = lct_name;
		this.lct_cont = lct_cont;
		this.mem_id = mem_id;
		this.lang_no = lang_no;
		this.lct_status = lct_status;
		this.lct_price = lct_price;
		this.lct_upload_date = lct_upload_date;
		this.lct_permit_date = lct_permit_date;
	}

	
}
