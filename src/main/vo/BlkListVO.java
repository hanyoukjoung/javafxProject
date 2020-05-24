package main.vo;

public class BlkListVO {
	private int blk_no;
	private String mem_id;
	private String blk_date;
	private String blk_reason;
	private String admin_id;
	
	//getter, setter
	public int getBlk_no() {
		return blk_no;
	}
	public void setBlk_no(int blk_no) {
		this.blk_no = blk_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getBlk_date() {
		return blk_date;
	}
	public void setBlk_date(String blk_date) {
		this.blk_date = blk_date;
	}
	public String getBlk_reason() {
		return blk_reason;
	}
	public void setBlk_reason(String blk_reason) {
		this.blk_reason = blk_reason;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	//������
	public BlkListVO() { }
	
	public BlkListVO(int blk_no, String mem_id, String blk_date, String blk_reason, String admin_id) {
		super();
		this.blk_no = blk_no;
		this.mem_id = mem_id;
		this.blk_date = blk_date;
		this.blk_reason = blk_reason;
		this.admin_id = admin_id;
	}
}
