package main.vo;

public class IdCertVO {
	private String mem_id;
	private String cert_cord;
	private String cert_date;
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getCert_cord() {
		return cert_cord;
	}
	public void setCert_cord(String cert_cord) {
		this.cert_cord = cert_cord;
	}
	public String getCert_date() {
		return cert_date;
	}
	public void setCert_date(String cert_date) {
		this.cert_date = cert_date;
	}
	
	public IdCertVO() {
	
	}
	public IdCertVO(String mem_id, String cert_cord, String cert_date) {
		super();
		this.mem_id = mem_id;
		this.cert_cord = cert_cord;
		this.cert_date = cert_date;
	}
	
	

}
