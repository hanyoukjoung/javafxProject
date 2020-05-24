package main.vo;

public class PaidMemVO {
	private String mem_id;
	private int pqs_no;
	
	public String getMem_id() {
		return mem_id;
	}
	
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	
	public int getPqs_no() {
		return pqs_no;
	}
	
	public void setPqs_no(int pqs_no) {
		this.pqs_no = pqs_no;
	}

	public PaidMemVO() {
		
	}

	public PaidMemVO(String mem_id, int pqs_no) {
		this.mem_id = mem_id;
		this.pqs_no = pqs_no;
	}
}
