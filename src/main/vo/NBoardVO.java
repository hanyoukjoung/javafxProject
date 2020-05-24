package main.vo;

public class NBoardVO {
	private int ntc_board_no;
	private String ntc_board_title;
	private String ntc_board_cont;
	private String admin_id;
	private String ntc_board_date;
	private int ntc_board_cnt;
	
	public int getNtc_board_no() {
		return ntc_board_no;
	}
	
	public void setNtc_board_no(int ntc_board_no) {
		this.ntc_board_no = ntc_board_no;
	}
	
	public String getNtc_board_title() {
		return ntc_board_title;
	}
	
	public void setNtc_board_title(String ntc_board_title) {
		this.ntc_board_title = ntc_board_title;
	}
	
	public String getNtc_board_cont() {
		return ntc_board_cont;
	}
	
	public void setNtc_board_cont(String ntc_board_cont) {
		this.ntc_board_cont = ntc_board_cont;
	}
	
	public String getAdmin_id() {
		return admin_id;
	}
	
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	
	public String getNtc_board_date() {
		return ntc_board_date;
	}
	
	public void setNtc_board_date(String ntc_board_date) {
		this.ntc_board_date = ntc_board_date;
	}
	
	public int getNtc_board_cnt() {
		return ntc_board_cnt;
	}
	
	public void setNtc_board_cnt(int ntc_board_cnt) {
		this.ntc_board_cnt = ntc_board_cnt;
	}

	public NBoardVO() {
		
	}

	public NBoardVO(int ntc_board_no, String ntc_board_title, String ntc_board_cont, String admin_id,
			String ntc_board_date, int ntc_board_cnt) {
		this.ntc_board_no = ntc_board_no;
		this.ntc_board_title = ntc_board_title;
		this.ntc_board_cont = ntc_board_cont;
		this.admin_id = admin_id;
		this.ntc_board_date = ntc_board_date;
		this.ntc_board_cnt = ntc_board_cnt;
	}
	
}
