package main.vo;

/**
 * 13th VO클래스
 * @author 강인경
 * @since 2020-01-28
 */
public class CttBFileVO {

	// field
	
	private int ctt_bfile_no;		//컨텐츠 기본파일 식별번호
	private String ctt_bfile_name;	//컨텐츠 기본파일명
	private String ctt_bfile_sname;	//컨텐츠 기본파일 저장 명
	private int ctt_bfile_size;		//컨텐츠 기본파일 사이즈
	private String ctt_bfile_date;	//컨텐츠 기본파일 등록일
	private int ctt_no;				//컨텐츠 식별번호

	// getter & setter
	
	public int getCtt_bfile_no() {
		return ctt_bfile_no;
	}
	
	public void setCtt_bfile_no(int ctt_bfile_no) {
		this.ctt_bfile_no = ctt_bfile_no;
	}
	
	public String getCtt_bfile_name() {
		return ctt_bfile_name;
	}
	
	public void setCtt_bfile_name(String ctt_bfile_name) {
		this.ctt_bfile_name = ctt_bfile_name;
	}
	
	public String getCtt_bfile_sname() {
		return ctt_bfile_sname;
	}
	
	public void setCtt_bfile_sname(String ctt_bfile_sname) {
		this.ctt_bfile_sname = ctt_bfile_sname;
	}
	
	public int getCtt_bfile_size() {
		return ctt_bfile_size;
	}
	
	public void setCtt_bfile_size(int ctt_bfile_size) {
		this.ctt_bfile_size = ctt_bfile_size;
	}
	
	public String getCtt_bfile_date() {
		return ctt_bfile_date;
	}
	
	public void setCtt_bfile_date(String ctt_bfile_date) {
		this.ctt_bfile_date = ctt_bfile_date;
	}
	
	public int getCtt_no() {
		return ctt_no;
	}
	
	public void setCtt_no(int ctt_no) {
		this.ctt_no = ctt_no;
	}

	// constructor

	public CttBFileVO() {}

	public CttBFileVO(int ctt_bfile_no, String ctt_bfile_name, String ctt_bfile_sname, int ctt_bfile_size,
			String ctt_bfile_date, int ctt_no) {
		super();
		this.ctt_bfile_no = ctt_bfile_no;
		this.ctt_bfile_name = ctt_bfile_name;
		this.ctt_bfile_sname = ctt_bfile_sname;
		this.ctt_bfile_size = ctt_bfile_size;
		this.ctt_bfile_date = ctt_bfile_date;
		this.ctt_no = ctt_no;
	}
	
}
