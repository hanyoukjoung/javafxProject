package main.vo;

public class AdminVO {
	private String admin_id;   //
	private String admin_pw;
	
	//getter setter
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_pw() {
		return admin_pw;
	}
	public void setAdmin_pw(String admin_pw) {
		this.admin_pw = admin_pw;
	}

	//생성자
	public AdminVO() { }
	
	public AdminVO(String admin_id, String admin_pw) {
		this.admin_id = admin_id;
		this.admin_pw = admin_pw;
	}
}
