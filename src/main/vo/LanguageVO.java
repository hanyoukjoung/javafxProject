package main.vo;

public class LanguageVO {
	private int lang_no;
	private String lang;
	public int getLang_no() {
		return lang_no;
	}
	public void setLang_no(int lang_no) {
		this.lang_no = lang_no;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	
	public LanguageVO() {
	
	}
	public LanguageVO(int lang_no, String lang) {
		super();
		this.lang_no = lang_no;
		this.lang = lang;
	}
	
	

}
