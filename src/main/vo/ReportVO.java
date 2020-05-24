package main.vo;

public class ReportVO {
	private int rpt_no;
	private String rpt_target;
	private String mem_id;
	private int rpt_cate_no;
	private String rpt_cont;
	private String rpt_data;
	private String rpt_yn;
	private String rpt_proc_date;
	private String admin_id;
	
	// get & set
	
	public int getRpt_no() {
		return rpt_no;
	}
	public void setRpt_no(int rpt_no) {
		this.rpt_no = rpt_no;
	}
	public String getRpt_target() {
		return rpt_target;
	}
	public void setRpt_target(String rpt_target) {
		this.rpt_target = rpt_target;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public int getRpt_cate_no() {
		return rpt_cate_no;
	}
	public void setRpt_cate_no(int rpt_cate_no) {
		this.rpt_cate_no = rpt_cate_no;
	}
	public String getRpt_cont() {
		return rpt_cont;
	}
	public void setRpt_cont(String rpt_cont) {
		this.rpt_cont = rpt_cont;
	}
	public String getRpt_data() {
		return rpt_data;
	}
	public void setRpt_data(String rpt_data) {
		this.rpt_data = rpt_data;
	}
	public String getRpt_yn() {
		return rpt_yn;
	}
	public void setRpt_yn(String rpt_yn) {
		this.rpt_yn = rpt_yn;
	}
	public String getRpt_proc_date() {
		return rpt_proc_date;
	}
	public void setRpt_proc_date(String rpt_proc_date) {
		this.rpt_proc_date = rpt_proc_date;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	
	
	
	//  ������ 
	
	public ReportVO() {}
	
	
	public ReportVO(int rpt_no, String rpt_target, String mem_id, int rpt_cate_no, String rpt_cont, String rpt_data,
			String rpt_yn, String rpt_proc_date, String admin_id) {
		super();
		this.rpt_no = rpt_no;
		this.rpt_target = rpt_target;
		this.mem_id = mem_id;
		this.rpt_cate_no = rpt_cate_no;
		this.rpt_cont = rpt_cont;
		this.rpt_data = rpt_data;
		this.rpt_yn = rpt_yn;
		this.rpt_proc_date = rpt_proc_date;
		this.admin_id = admin_id;
	}
	
	
	
}
