package main.vo;

/**
 * 14th VO클래스
 * @author 강인경
 * @since 2020-01-28
 */
public class CttCmntVO {

	// field
	
	private int cmnt_no;			//댓글 식별번호
	private int ctt_no;				//컨텐츠 식별번호
	private int cmnt_target;		//댓글 대상
	private String cmnt_reply_yn;	//댓글 대댓글 여부
	private String cmnt_cont;		//댓글 내용
	private String cmnt_date;		//댓글 날짜
	private int subs_no;			//구독 식별번호
	
	// getter & setter
	
	public int getCmnt_no() {
		return cmnt_no;
	}
	
	public void setCmnt_no(int cmnt_no) {
		this.cmnt_no = cmnt_no;
	}
	
	public int getCtt_no() {
		return ctt_no;
	}
	
	public void setCtt_no(int ctt_no) {
		this.ctt_no = ctt_no;
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
	
	public String getCmnt_date() {
		return cmnt_date;
	}
	
	public void setCmnt_date(String cmnt_date) {
		this.cmnt_date = cmnt_date;
	}
	
	public int getSubs_no() {
		return subs_no;
	}
	
	public void setSubs_no(int subs_no) {
		this.subs_no = subs_no;
	}

	// constructor

	public CttCmntVO() {}

	public CttCmntVO(int cmnt_no, int ctt_no, int cmnt_target, String cmnt_reply_yn, String cmnt_cont, String cmnt_date,
			int subs_no) {
		super();
		this.cmnt_no = cmnt_no;
		this.ctt_no = ctt_no;
		this.cmnt_target = cmnt_target;
		this.cmnt_reply_yn = cmnt_reply_yn;
		this.cmnt_cont = cmnt_cont;
		this.cmnt_date = cmnt_date;
		this.subs_no = subs_no;
	}
	
}
