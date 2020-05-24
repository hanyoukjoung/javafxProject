package main.vo;

public class ScheduleVO {
	private int sche_no;
	private String mem_id;
	private String target_id;
	private String sche_date;
	private String sche_cont;
	
	// get & set
	
	public int getSche_no() {
		return sche_no;
	}
	public void setSche_no(int sche_no) {
		this.sche_no = sche_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getTarget_id() {
		return target_id;
	}
	public void setTarget_id(String target_id) {
		this.target_id = target_id;
	}
	public String getSche_date() {
		return sche_date;
	}
	public void setSche_date(String sche_date) {
		this.sche_date = sche_date;
	}
	public String getSche_cont() {
		return sche_cont;
	}
	public void setSche_cont(String sche_cont) {
		this.sche_cont = sche_cont;
	}
	// ������
	
	public ScheduleVO() {}
	
	public ScheduleVO(int sche_no, String mem_id, String target_id, String sche_date, String sche_cont) {
		this.sche_no = sche_no;
		this.mem_id = mem_id;
		this.target_id = target_id;
		this.sche_date = sche_date;
		this.sche_cont = sche_cont;
	}
	
	
	
	
}
