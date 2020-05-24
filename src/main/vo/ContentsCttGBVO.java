package main.vo;
//contents테이블과 ctt_gb테이블 join vo

public class ContentsCttGBVO {
	private String ctt_title;
	private String ctt_cont;
	private int ctt_no;
	private String ctt_gb_name;
	private int lct_no;
	
	public String getCtt_title() {
		return ctt_title;
	}
	public void setCtt_title(String ctt_title) {
		this.ctt_title = ctt_title;
	}
	public String getCtt_cont() {
		return ctt_cont;
	}
	public void setCtt_cont(String ctt_cont) {
		this.ctt_cont = ctt_cont;
	}
	public int getCtt_no() {
		return ctt_no;
	}
	public void setCtt_no(int ctt_no) {
		this.ctt_no = ctt_no;
	}
	public String getCtt_gb_name() {
		return ctt_gb_name;
	}
	public void setCtt_gb_name(String ctt_gb_name) {
		this.ctt_gb_name = ctt_gb_name;
	}
	public int getLct_no() {
		return lct_no;
	}
	public void setLct_no(int lct_no) {
		this.lct_no = lct_no;
	}
	
	
	
	

}
