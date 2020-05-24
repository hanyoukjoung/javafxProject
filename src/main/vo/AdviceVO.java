package main.vo;

public class AdviceVO {
	private int adv_no;
	private String adv_tag;
	private String adv_title;
	private String adv_cont;
	private int lang_no;
	
	//getter, setter
	public int getAdv_no() {
		return adv_no;
	}

	public void setAdv_no(int adv_no) {
		this.adv_no = adv_no;
	}

	public String getAdv_tag() {
		return adv_tag;
	}

	public void setAdv_tag(String adv_tag) {
		this.adv_tag = adv_tag;
	}

	public String getAdv_title() {
		return adv_title;
	}

	public void setAdv_title(String adv_title) {
		this.adv_title = adv_title;
	}

	public String getAdv_cont() {
		return adv_cont;
	}

	public void setAdv_cont(String adv_cont) {
		this.adv_cont = adv_cont;
	}

	public int getLang_no() {
		return lang_no;
	}

	public void setLang_no(int lang_no) {
		this.lang_no = lang_no;
	}
	
	//생성자
	public AdviceVO() { }
	
	public AdviceVO(int adv_no, String adv_tag, String adv_title, String adv_cont, int lang_no) {
		this.adv_no = adv_no;
		this.adv_tag = adv_tag;
		this.adv_title = adv_title;
		this.adv_cont = adv_cont;
		this.lang_no = lang_no;
	}
}
