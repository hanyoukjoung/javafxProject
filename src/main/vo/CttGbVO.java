package main.vo;

/**
 * 15th VO클래스
 * @author 강인경
 * @since 2020-01-28
 */
public class CttGbVO {
	
	// field
	private int ctt_gb_no;   	//컨텐츠 구분 식별번호
	private String ctt_gb_name;	//컨텐츠 구분 명

	// getter & setter
	
	public int getCtt_gb_no() {
		return ctt_gb_no;
	}
	
	public void setCtt_gb_no(int ctt_gb_no) {
		this.ctt_gb_no = ctt_gb_no;
	}
	
	public String getCtt_gb_name() {
		return ctt_gb_name;
	}
	
	public void setCtt_gb_name(String ctt_gb_name) {
		this.ctt_gb_name = ctt_gb_name;
	}

	// constructor

	public CttGbVO() {}

	public CttGbVO(int ctt_gb_no, String ctt_gb_name) {
		super();
		this.ctt_gb_no = ctt_gb_no;
		this.ctt_gb_name = ctt_gb_name;
	}
}
