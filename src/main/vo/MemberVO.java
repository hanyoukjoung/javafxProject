package main.vo;

public class MemberVO {
	private String mem_id;
	private String mem_name;
	private String mem_pw;
	private String mem_regno1;
	private String mem_regno2;
	private String mem_tel;
	private String mem_email;
	private String mem_addr;
	private String mem_dtladdr;
	private String mem_join_date;
	private int mem_point;
	private String mem_grade;
	private String mem_introd;
	private String mem_act_yn;
	private int lang_major;
	private int lang_itrst;
	private String mem_zip;
	
	public String getMem_id() {
		return mem_id;
	}
	
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	
	public String getMem_name() {
		return mem_name;
	}
	
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	
	public String getMem_pw() {
		return mem_pw;
	}
	
	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}
	
	public String getMem_regno1() {
		return mem_regno1;
	}
	
	public void setMem_regno1(String mem_regno1) {
		this.mem_regno1 = mem_regno1;
	}
	
	public String getMem_regno2() {
		return mem_regno2;
	}
	
	public void setMem_regno2(String mem_regno2) {
		this.mem_regno2 = mem_regno2;
	}
	
	public String getMem_tel() {
		return mem_tel;
	}
	
	public void setMem_tel(String mem_tel) {
		this.mem_tel = mem_tel;
	}
	
	public String getMem_email() {
		return mem_email;
	}
	
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	
	public String getMem_addr() {
		return mem_addr;
	}
	
	public void setMem_addr(String mem_addr) {
		this.mem_addr = mem_addr;
	}
	
	public String getMem_dtladdr() {
		return mem_dtladdr;
	}
	
	public void setMem_dtladdr(String mem_dtladdr) {
		this.mem_dtladdr = mem_dtladdr;
	}
	
	public String getMem_join_date() {
		return mem_join_date;
	}
	
	public void setMem_join_date(String mem_join_date) {
		this.mem_join_date = mem_join_date;
	}
	
	public int getMem_point() {
		return mem_point;
	}
	
	public void setMem_point(int mem_point) {
		this.mem_point = mem_point;
	}
	
	public String getMem_grade() {
		return mem_grade;
	}
	
	public void setMem_grade(String mem_grade) {
		this.mem_grade = mem_grade;
	}
	
	public String getMem_introd() {
		return mem_introd;
	}
	
	public void setMem_introd(String mem_introd) {
		this.mem_introd = mem_introd;
	}
	
	public String getMem_act_yn() {
		return mem_act_yn;
	}
	
	public void setMem_act_yn(String mem_act_yn) {
		this.mem_act_yn = mem_act_yn;
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

	public MemberVO() {
		super();
	}

	public String getMem_zip() {
		return mem_zip;
	}

	public void setMem_zip(String mem_zip) {
		this.mem_zip = mem_zip;
	}

	public MemberVO(String mem_id, String mem_name, String mem_pw, String mem_regno1, String mem_regno2, String mem_tel,
			String mem_email, String mem_addr, String mem_dtladdr, String mem_join_date, int mem_point,
			String mem_grade, String mem_introd, String mem_act_yn, int lang_major, int lang_itrst) {
		super();
		this.mem_id = mem_id;
		this.mem_name = mem_name;
		this.mem_pw = mem_pw;
		this.mem_regno1 = mem_regno1;
		this.mem_regno2 = mem_regno2;
		this.mem_tel = mem_tel;
		this.mem_email = mem_email;
		this.mem_addr = mem_addr;
		this.mem_dtladdr = mem_dtladdr;
		this.mem_join_date = mem_join_date;
		this.mem_point = mem_point;
		this.mem_grade = mem_grade;
		this.mem_introd = mem_introd;
		this.mem_act_yn = mem_act_yn;
		this.lang_major = lang_major;
		this.lang_itrst = lang_itrst;
	}
	
}
