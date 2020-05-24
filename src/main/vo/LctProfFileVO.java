package main.vo;
//이미지

public class LctProfFileVO {
	private int lct_img_no;
	private int lct_no;
	private String lct_img_name;
	private String lct_img_sname;
	private int lct_img_size;
	private String lct_img_date;
	
	public int getLct_img_no() {
		return lct_img_no;
	}
	
	public void setLct_img_no(int lct_img_no) {
		this.lct_img_no = lct_img_no;
	}
	
	public int getLct_no() {
		return lct_no;
	}
	
	public void setLct_no(int lct_no) {
		this.lct_no = lct_no;
	}
	
	public String getLct_img_name() {
		return lct_img_name;
	}
	
	public void setLct_img_name(String lct_img_name) {
		this.lct_img_name = lct_img_name;
	}
	
	public String getLct_img_sname() {
		return lct_img_sname;
	}
	
	public void setLct_img_sname(String lct_img_sname) {
		this.lct_img_sname = lct_img_sname;
	}
	
	public int getLct_img_size() {
		return lct_img_size;
	}
	
	public void setLct_img_size(int lct_img_size) {
		this.lct_img_size = lct_img_size;
	}
	
	public String getLct_img_date() {
		return lct_img_date;
	}
	
	public void setLct_img_date(String lct_img_date) {
		this.lct_img_date = lct_img_date;
	}

	public LctProfFileVO() {
		
	}

	public LctProfFileVO(int lct_img_no, int lct_no, String lct_img_name, String lct_img_sname, int lct_img_size,
			String lct_img_date) {
		this.lct_img_no = lct_img_no;
		this.lct_no = lct_no;
		this.lct_img_name = lct_img_name;
		this.lct_img_sname = lct_img_sname;
		this.lct_img_size = lct_img_size;
		this.lct_img_date = lct_img_date;
	}
	
}
