package main.vo;

/**
 * 16th VO클래스
 * @author 강인경
 * @since 2020-01-28
 */
public class CttSFileVO {

	// field
	
	private int ctt_sfile_no;		//컨텐츠 해답파일 식별번호
	private String ctt_sfile_name;	//컨텐츠 해답파일 명
	private String ctt_sfile_sname; //컨텐츠 해답파일 저장명
	private int ctt_sfile_size;    	//컨텐츠 해답파일 사이즈
    private String ctt_sfile_date;	//컨텐츠 해답파일 등록일
    private int ctt_no;				//컨텐츠 식별번호

    // getter & setter
	
    public int getCtt_sfile_no() {
		return ctt_sfile_no;
	}
	
    public void setCtt_sfile_no(int ctt_sfile_no) {
		this.ctt_sfile_no = ctt_sfile_no;
	}
	
    public String getCtt_sfile_name() {
		return ctt_sfile_name;
	}
	
    public void setCtt_sfile_name(String ctt_sfile_name) {
		this.ctt_sfile_name = ctt_sfile_name;
	}
	
    public String getCtt_sfile_sname() {
		return ctt_sfile_sname;
	}
	
    public void setCtt_sfile_sname(String ctt_sfile_sname) {
		this.ctt_sfile_sname = ctt_sfile_sname;
	}
	
    public int getCtt_sfile_size() {
		return ctt_sfile_size;
	}
	
    public void setCtt_sfile_size(int ctt_sfile_size) {
		this.ctt_sfile_size = ctt_sfile_size;
	}
	
    public String getCtt_sfile_date() {
		return ctt_sfile_date;
	}
	
    public void setCtt_sfile_date(String ctt_sfile_date) {
		this.ctt_sfile_date = ctt_sfile_date;
	}
	
    public int getCtt_no() {
		return ctt_no;
	}
	
    public void setCtt_no(int ctt_no) {
		this.ctt_no = ctt_no;
	}

    // constructor

    public CttSFileVO() {}

	public CttSFileVO(int ctt_sfile_no, String ctt_sfile_name, String ctt_sfile_sname, int ctt_sfile_size,
			String ctt_sfile_date, int ctt_no) {
		super();
		this.ctt_sfile_no = ctt_sfile_no;
		this.ctt_sfile_name = ctt_sfile_name;
		this.ctt_sfile_sname = ctt_sfile_sname;
		this.ctt_sfile_size = ctt_sfile_size;
		this.ctt_sfile_date = ctt_sfile_date;
		this.ctt_no = ctt_no;
	}
}
