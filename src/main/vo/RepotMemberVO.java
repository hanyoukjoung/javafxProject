package main.vo;

public class RepotMemberVO {
	private String mem_id; 
    private String mem_name; 
    private String mem_addr;
    private String lang_itrst;
    private String lang_major; 
    private int rpt_cnt;
	
    public String getMem_id() {
		return mem_id;
	}
	
    public String getMem_name() {
		return mem_name;
	}
	
	public String getMem_addr() {
		return mem_addr;
	}
	
	public String getLang_itrst() {
		return lang_itrst;
	}
	
	public String getLang_major() {
		return lang_major;
	}
	
	public int getRpt_cnt() {
		return rpt_cnt;
	}
	
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public void setMem_addr(String mem_addr) {
		this.mem_addr = mem_addr;
	}

	public void setLang_itrst(String lang_itrst) {
		this.lang_itrst = lang_itrst;
	}

	public void setLang_major(String lang_major) {
		this.lang_major = lang_major;
	}

	public void setRpt_cnt(int rpt_cnt) {
		this.rpt_cnt = rpt_cnt;
	}

	public RepotMemberVO(String mem_id, String mem_name, String mem_addr, String lang_itrst, String lang_major,
			int rpt_cnt) {
		super();
		this.mem_id = mem_id;
		this.mem_name = mem_name;
		this.mem_addr = mem_addr;
		this.lang_itrst = lang_itrst;
		this.lang_major = lang_major;
		this.rpt_cnt = rpt_cnt;
	}

	public RepotMemberVO() {}
    
}
