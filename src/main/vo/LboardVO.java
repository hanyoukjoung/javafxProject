package main.vo;

public class LboardVO {
	private int lsn_board_no;
	private String lsn_board_title;
	private String lsn_board_cont;
	private String mem_id;
	private String lsn_board_date;
	private int lsn_board_cnt;
	private int lang_major;
	private int lang_itrst;
	public int getLsn_board_no() {
		return lsn_board_no;
	}
	public void setLsn_board_no(int lsn_board_no) {
		this.lsn_board_no = lsn_board_no;
	}
	public String getLsn_board_title() {
		return lsn_board_title;
	}
	public void setLsn_board_title(String lsn_board_title) {
		this.lsn_board_title = lsn_board_title;
	}
	public String getLsn_board_cont() {
		return lsn_board_cont;
	}
	public void setLsn_board_cont(String lsn_board_cont) {
		this.lsn_board_cont = lsn_board_cont;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getLsn_board_date() {
		return lsn_board_date;
	}
	public void setLsn_board_date(String lsn_board_date) {
		this.lsn_board_date = lsn_board_date;
	}
	public int getLsn_board_cnt() {
		return lsn_board_cnt;
	}
	public void setLsn_board_cnt(int lsn_board_cnt) {
		this.lsn_board_cnt = lsn_board_cnt;
	}
	public int getLang_major() {
		return lang_major;
	}
	public void setLang_major(int lang_major) {
		this.lang_major = lang_major;
	}
	public int getLang_itrst() {
		return lang_itrst;
	}
	public void setLang_itrst(int lang_itrst) {
		this.lang_itrst = lang_itrst;
	}
	
	public LboardVO() {
		
	}
	public LboardVO(int lsn_board_no, String lsn_board_title, String lsn_board_cont, String mem_id,
			String lsn_board_date, int lsn_board_cnt, int lang_major, int lang_itrst) {
		super();
		this.lsn_board_no = lsn_board_no;
		this.lsn_board_title = lsn_board_title;
		this.lsn_board_cont = lsn_board_cont;
		this.mem_id = mem_id;
		this.lsn_board_date = lsn_board_date;
		this.lsn_board_cnt = lsn_board_cnt;
		this.lang_major = lang_major;
		this.lang_itrst = lang_itrst;
	}
	
	
	

}
