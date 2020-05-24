package main.vo;

public class FboardCmntVO {
	private int cmnt_no;
	private int free_board_no;
	private int cmnt_target;
	private String cmnt_reply_yn;
	private String cmnt_cont;
	private String mem_id;
	private String cmnt_date;
	public int getCmnt_no() {
		return cmnt_no;
	}
	public void setCmnt_no(int cmnt_no) {
		this.cmnt_no = cmnt_no;
	}
	public int getFree_board_no() {
		return free_board_no;
	}
	public void setFree_board_no(int free_board_no) {
		this.free_board_no = free_board_no;
	}
	public int getCmnt_target() {
		return cmnt_target;
	}
	public void setCmnt_target(int cmnt_target) {
		this.cmnt_target = cmnt_target;
	}
	public String getCmnt_reply_yn() {
		return cmnt_reply_yn;
	}
	public void setCmnt_reply_yn(String cmnt_reply_yn) {
		this.cmnt_reply_yn = cmnt_reply_yn;
	}
	public String getCmnt_cont() {
		return cmnt_cont;
	}
	public void setCmnt_cont(String cmnt_cont) {
		this.cmnt_cont = cmnt_cont;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getCmnt_date() {
		return cmnt_date;
	}
	public void setCmnt_date(String cmnt_date) {
		this.cmnt_date = cmnt_date;
	}
	public FboardCmntVO() {
		
	}
	public FboardCmntVO(int cmnt_no, int free_board_no, int cmnt_target, String cmnt_reply_yn, String cmnt_cont,
			String mem_id, String cmnt_date) {
		super();
		this.cmnt_no = cmnt_no;
		this.free_board_no = free_board_no;
		this.cmnt_target = cmnt_target;
		this.cmnt_reply_yn = cmnt_reply_yn;
		this.cmnt_cont = cmnt_cont;
		this.mem_id = mem_id;
		this.cmnt_date = cmnt_date;
	}
	
	
	

}
