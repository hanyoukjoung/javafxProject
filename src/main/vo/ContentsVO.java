package main.vo;

/**
 * 12th VO클래스
 * @author 강인경
 * @since 2020-01-28
 */
public class ContentsVO {
	
	// field
	
	private int ctt_no;				//컨텐츠 식별번호
	private int ctt_gb_no;			//컨텐츠 구분 식별번호
	private String ctt_title;		//컨텐츠 제목
	private String ctt_cont;		//컨텐츠 내용
	private String ctt_upload_date;	//컨텐츠 업로드 날짜
	private int lct_no;				//강의 식별번호
	
	// getter & setter
	
	public int getCtt_no() {
		return ctt_no;
	}

	public void setCtt_no(int ctt_no) {
		this.ctt_no = ctt_no;
	}
	
	public int getCtt_gb_no() {
		return ctt_gb_no;
	}
	
	public void setCtt_gb_no(int ctt_gb_no) {
		this.ctt_gb_no = ctt_gb_no;
	}
	
	public String getCtt_title() {
		return ctt_title;
	}
	
	public void setCtt_title(String ctt_title) {
		this.ctt_title = ctt_title;
	}
	
	public String getCtt_cont() {
		return ctt_cont;
	}
	
	public void setCtt_cont(String ctt_cont) {
		this.ctt_cont = ctt_cont;
	}
	
	public String getCtt_upload_date() {
		return ctt_upload_date;
	}
	
	public void setCtt_upload_date(String ctt_upload_date) {
		this.ctt_upload_date = ctt_upload_date;
	}
	
	public int getLct_no() {
		return lct_no;
	}
	
	public void setLct_no(int lct_no) {
		this.lct_no = lct_no;
	}

	// constructor
	
	public ContentsVO() {}

	public ContentsVO(int ctt_no, int ctt_gb_no, String ctt_title, String ctt_cont, String ctt_upload_date, int lct_no) {
		super();
		this.ctt_no = ctt_no;
		this.ctt_gb_no = ctt_gb_no;
		this.ctt_title = ctt_title;
		this.ctt_cont = ctt_cont;
		this.ctt_upload_date = ctt_upload_date;
		this.lct_no = lct_no;
	}
	
}
