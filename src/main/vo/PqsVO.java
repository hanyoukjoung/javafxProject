package main.vo;

public class PqsVO {
	private	int pqs_no;
	private String mem_id;
	private String mem_acc_no;
	private	String pqs_date; 
	private String pqs_permit_yn;
	private String pqs_proc_date;
	private String pqs_proc_reason;
	private String admin_id;
	
	// get & set
	
	
	public int getPqs_no() {
		return pqs_no;
	}
	public void setPqs_no(int pqs_no) {
		this.pqs_no = pqs_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_acc_no() {
		return mem_acc_no;
	}
	public void setMem_acc_no(String mem_acc_no) {
		this.mem_acc_no = mem_acc_no;
	}
	public String getPqs_date() {
		return pqs_date;
	}
	public void setPqs_date(String pqs_date) {
		this.pqs_date = pqs_date;
	}
	public String getPqs_permit_yn() {
		return pqs_permit_yn;
	}
	public void setPqs_permit_yn(String pqs_permit_yn) {
		this.pqs_permit_yn = pqs_permit_yn;
	}
	public String getPqs_proc_date() {
		return pqs_proc_date;
	}
	public void setPqs_proc_date(String pqs_proc_date) {
		this.pqs_proc_date = pqs_proc_date;
	}
	public String getPqs_proc_reason() {
		return pqs_proc_reason;
	}
	public void setPqs_proc_reason(String pqs_proc_reason) {
		this.pqs_proc_reason = pqs_proc_reason;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	
	
	
	// ������
	
	public PqsVO() {}
	
	
	public PqsVO(int pqs_no, String mem_id, String mem_acc_no, String pqs_date, String pqs_permit_yn,
			String pqs_proc_date, String pqs_proc_reason, String admin_id) {
		super();
		this.pqs_no = pqs_no;
		this.mem_id = mem_id;
		this.mem_acc_no = mem_acc_no;
		this.pqs_date = pqs_date;
		this.pqs_permit_yn = pqs_permit_yn;
		this.pqs_proc_date = pqs_proc_date;
		this.pqs_proc_reason = pqs_proc_reason;
		this.admin_id = admin_id;
	}
	
	
	
	
}
