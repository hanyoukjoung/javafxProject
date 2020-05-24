package main.vo;

/**
 * 18th VO클래스
 * @author 강인경
 * @since 2020-01-28
 */
public class FAQBoardVO {
	
	//field
	
	private int faq_board_no;		//FAQ 게시판 번호
	private String faq_board_title; //FAQ 게시판 제목
	private String faq_board_cont;	//FAQ 게시판 내용
	private String admin_id;		//관리자 아이디
	private String faq_board_date;	//FAQ 게시판 일자

	// getter & setter
	
	public int getFaq_board_no() {
		return faq_board_no;
	}
	
	public void setFaq_board_no(int faq_board_no) {
		this.faq_board_no = faq_board_no;
	}
	
	public String getFaq_board_title() {
		return faq_board_title;
	}
	
	public void setFaq_board_title(String faq_board_title) {
		this.faq_board_title = faq_board_title;
	}
	
	public String getFaq_board_cont() {
		return faq_board_cont;
	}
	
	public void setFaq_board_cont(String faq_board_cont) {
		this.faq_board_cont = faq_board_cont;
	}
	
	public String getAdmin_id() {
		return admin_id;
	}
	
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	
	public String getFaq_board_date() {
		return faq_board_date;
	}
	
	public void setFaq_board_date(String faq_board_date) {
		this.faq_board_date = faq_board_date;
	}

	// constructor

	public FAQBoardVO() {}

	public FAQBoardVO(int faq_board_no, String faq_board_title, String faq_board_cont, String admin_id,
			String faq_board_date) {
		super();
		this.faq_board_no = faq_board_no;
		this.faq_board_title = faq_board_title;
		this.faq_board_cont = faq_board_cont;
		this.admin_id = admin_id;
		this.faq_board_date = faq_board_date;
	}	
}
