package main.vo;

public class MemFileVO {
	private int mem_prof_img_no;
	private String mem_id;
	private String mem_prof_img_name;
	private String mem_prof_img_sname;
	private long mem_prof_img_size;
	private String mem_prof_img_date;
	
	public int getMem_prof_img_no() {
		return mem_prof_img_no;
	}
	
	public void setMem_prof_img_no(int mem_prof_img_no) {
		this.mem_prof_img_no = mem_prof_img_no;
	}
	
	public String getMem_id() {
		return mem_id;
	}
	
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	
	public String getMem_prof_img_name() {
		return mem_prof_img_name;
	}
	
	public void setMem_prof_img_name(String mem_prof_img_name) {
		this.mem_prof_img_name = mem_prof_img_name;
	}
	
	public String getMem_prof_img_sname() {
		return mem_prof_img_sname;
	}
	
	public void setMem_prof_img_sname(String mem_prof_img_sname) {
		this.mem_prof_img_sname = mem_prof_img_sname;
	}
	
	public long getMem_prof_img_size() {
		return mem_prof_img_size;
	}
	
	public void setMem_prof_img_size(long mem_prof_img_size) {
		this.mem_prof_img_size = mem_prof_img_size;
	}
	
	public String getMem_prof_img_date() {
		return mem_prof_img_date;
	}
	
	public void setMem_prof_img_date(String mem_prof_img_date) {
		this.mem_prof_img_date = mem_prof_img_date;
	}

	public MemFileVO() {
		
	}

	public MemFileVO(int mem_prof_img_no, String mem_id, String mem_prof_img_name, String mem_prof_img_sname,
			long mem_prof_img_size, String mem_prof_img_date) {
		this.mem_prof_img_no = mem_prof_img_no;
		this.mem_id = mem_id;
		this.mem_prof_img_name = mem_prof_img_name;
		this.mem_prof_img_sname = mem_prof_img_sname;
		this.mem_prof_img_size = mem_prof_img_size;
		this.mem_prof_img_date = mem_prof_img_date;
	}
	
}
