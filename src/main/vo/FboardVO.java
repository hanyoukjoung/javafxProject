package main.vo;

public class FboardVO {
	private int free_board_no;
	private String free_board_title;
	private String free_board_cont;
	private String mem_id;
	private String free_board_date;
	private int free_board_cnt;
	
	public int getFree_board_no() {
		return free_board_no;
	}
	public void setFree_board_no(int free_board_no) {
		this.free_board_no = free_board_no;
	}
	public String getFree_board_title() {
		return free_board_title;
	}
	public void setFree_board_title(String free_board_title) {
		this.free_board_title = free_board_title;
	}
	public String getFree_board_cont() {
		return free_board_cont;
	}
	public void setFree_board_cont(String free_board_cont) {
		this.free_board_cont = free_board_cont;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getFree_board_date() {
		return free_board_date;
	}
	public void setFree_board_date(String free_board_date) {
		this.free_board_date = free_board_date;
	}
	public int getFree_board_cnt() {
		return free_board_cnt;
	}
	public void setFree_board_cnt(int free_board_cnt) {
		this.free_board_cnt = free_board_cnt;
	}
	
	
	public FboardVO() {
		
	}
	
	public FboardVO(int free_board_no, String free_board_title, String free_board_cont, String mem_id,
			String free_board_date, int free_board_cnt) {
		super();
		this.free_board_no = free_board_no;
		this.free_board_title = free_board_title;
		this.free_board_cont = free_board_cont;
		this.mem_id = mem_id;
		this.free_board_date = free_board_date;
		this.free_board_cnt = free_board_cnt;
	}
	
	
	
	
	
}
