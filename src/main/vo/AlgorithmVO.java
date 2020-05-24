package main.vo;

public class AlgorithmVO {
	private int alg_no;
	private int alg_cate_no;
	private int lang_no;
	private String alg_title;
	private String alg_cont;
	private int alg_cnt;
	private int alg_sbmt_cnt;
	private int alg_crct_cnt;
	
	//getter, setter
	public int getAlg_no() {
		return alg_no;
	}
	public void setAlg_no(int alg_no) {
		this.alg_no = alg_no;
	}
	public int getAlg_cate_no() {
		return alg_cate_no;
	}
	public void setAlg_cate_no(int alg_cate_no) {
		this.alg_cate_no = alg_cate_no;
	}
	public int getLang_no() {
		return lang_no;
	}
	public void setLang_no(int lang_no) {
		this.lang_no = lang_no;
	}
	public String getAlg_title() {
		return alg_title;
	}
	public void setAlg_title(String alg_title) {
		this.alg_title = alg_title;
	}
	public String getAlg_cont() {
		return alg_cont;
	}
	public void setAlg_cont(String alg_cont) {
		this.alg_cont = alg_cont;
	}
	public int getAlg_cnt() {
		return alg_cnt;
	}
	public void setAlg_cnt(int alg_cnt) {
		this.alg_cnt = alg_cnt;
	}
	public int getAlg_sbmit_cnt() {
		return alg_sbmt_cnt;
	}
	public void setAlg_sbmit_cnt(int alg_sbmit_cnt) {
		this.alg_sbmt_cnt = alg_sbmit_cnt;
	}
	public int getAlg_crct_cnt() {
		return alg_crct_cnt;
	}
	public void setAlg_crct_cnt(int alg_crct_cnt) {
		this.alg_crct_cnt = alg_crct_cnt;
	}
	//������
	public AlgorithmVO() { }
	
	public AlgorithmVO(int alg_no, int alg_cate_no, int lang_no, String alg_title, String alg_cont, int alg_cnt,
			int alg_sbmit_cnt, int alg_crct_cnt) {
		super();
		this.alg_no = alg_no;
		this.alg_cate_no = alg_cate_no;
		this.lang_no = lang_no;
		this.alg_title = alg_title;
		this.alg_cont = alg_cont;
		this.alg_cnt = alg_cnt;
		this.alg_sbmt_cnt = alg_sbmit_cnt;
		this.alg_crct_cnt = alg_crct_cnt;
	}
}
