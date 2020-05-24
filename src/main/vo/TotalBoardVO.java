package main.vo;

public class TotalBoardVO {
	private int board_no; // pk
	private int no;
	private String board_title; // 제목
	private String board_cont; // 내용
	private String mem_id; // 글쓴이
	private String board_date; // 글쓴날짜
	private int board_cnt; // 조회수
	
	private String rpt_cate;    // 신고 카테고리
	private String rpt_mem_id;  // 신고한 회원 
	private String rpt_cont;    // 신고 내용
	private String rpt_date;    // 신고 날짜
	private int rpt_cnt;        // 신고 횟수
	

	public String getRpt_cate() {
		return rpt_cate;
	}
	public void setRpt_cate(String rpt_cate) {
		this.rpt_cate = rpt_cate;
	}
	public String getRpt_cont() {
		return rpt_cont;
	}
	public void setRpt_cont(String rpt_cont) {
		this.rpt_cont = rpt_cont;
	}
	public String getRpt_date() {
		return rpt_date;
	}
	public void setRpt_date(String rpt_date) {
		this.rpt_date = rpt_date;
	}
	public int getRpt_cnt() {
		return rpt_cnt;
	}
	public void setRpt_cnt(int rpt_cnt) {
		this.rpt_cnt = rpt_cnt;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	
	public String getRpt_mem_id() {
		return rpt_mem_id;
	}
	public void setRpt_mem_id(String rpt_mem_id) {
		this.rpt_mem_id = rpt_mem_id;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_cont() {
		return board_cont;
	}
	public void setBoard_cont(String board_cont) {
		this.board_cont = board_cont;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getBoard_date() {
		return board_date;
	}
	public void setBoard_date(String board_date) {
		this.board_date = board_date;
	}
	public int getBoard_cnt() {
		return board_cnt;
	}
	public void setBoard_cnt(int board_cnt) {
		this.board_cnt = board_cnt;
	}
	
	public TotalBoardVO() { }
	public TotalBoardVO(int board_no, String board_title, String board_cont, String mem_id, String board_date,
			int board_cnt) {
		this.board_no = board_no;
		this.board_title = board_title;
		this.board_cont = board_cont;
		this.mem_id = mem_id;
		this.board_date = board_date;
		this.board_cnt = board_cnt;
	}
	
	public TotalBoardVO(int board_no, String board_title, String board_cont, String mem_id, String board_date) {
		this.board_no = board_no;
		this.board_title = board_title;
		this.board_cont = board_cont;
		this.mem_id = mem_id;
		this.board_date = board_date;
	}
	
}
