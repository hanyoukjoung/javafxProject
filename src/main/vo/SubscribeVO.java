package main.vo;

public class SubscribeVO {
	private int subs_no;
	private String mem_id;
	private int lct_no;
	private String subs_start_date;
	private String subs_end_yn;
	
	// get & set
	
	public int getSubs_no() {
		return subs_no;
	}
	public void setSubs_no(int subs_no) {
		this.subs_no = subs_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public int getLct_no() {
		return lct_no;
	}
	public void setLct_no(int lct_no) {
		this.lct_no = lct_no;
	}
	public String getSubs_start_date() {
		return subs_start_date;
	}
	public void setSubs_start_date(String subs_start_date) {
		this.subs_start_date = subs_start_date;
	}
	public String getSubs_end_yn() {
		return subs_end_yn;
	}
	public void setSubs_end_yn(String subs_end_yn) {
		this.subs_end_yn = subs_end_yn;
	}
	
	// ������
	
	public SubscribeVO() {}
	
	public SubscribeVO(int subs_no, String mem_id, int lct_no, String subs_start_date, String subs_end_yn) {
		super();
		this.subs_no = subs_no;
		this.mem_id = mem_id;
		this.lct_no = lct_no;
		this.subs_start_date = subs_start_date;
		this.subs_end_yn = subs_end_yn;
	}
	
}
