package main.vo;

public class AlgorithmTableVO {
	private int alg_no; // 문제 pk
	private String alg_cate; // 문제 카테고리 (레벨, 거시기 기타등등)
	private String alg_title; // 문제 제목
	private String alg_content; // 문제 내용
	private int alg_submit; // 문제 제출 수
	private int alg_crct_cnt; // 문제 정답 수
	private String alg_crct_per; // 문제 정답 비율
	
	// 알고리즘 문제 기본파일
	private int alg_bfile_no;
	private String alg_bfile_name;
	private String basicFile_sname;
	private int bfile_size;
	private String alg_bfile_date;

	// 알고리즘 문제 해답 파일 
	private int alg_sfile_no;
	private String alg_sfile_name;
	private String alg_sfile_sname;
	private int alg_sfile_size;
	private String alg_sfile_date;
	
	public int getAlg_no() {
		return alg_no;
	}
	public void setAlg_no(int alg_no) {
		this.alg_no = alg_no;
	}
	public String getAlg_cate() {
		return alg_cate;
	}
	public void setAlg_cate(String alg_cate) {
		this.alg_cate = alg_cate;
	}
	public String getAlg_title() {
		return alg_title;
	}
	public void setAlg_title(String alg_title) {
		this.alg_title = alg_title;
	}
	public String getAlg_content() {
		return alg_content;
	}
	public void setAlg_content(String alg_content) {
		this.alg_content = alg_content;
	}
	public int getAlg_submit() {
		return alg_submit;
	}
	public void setAlg_submit(int alg_submit) {
		this.alg_submit = alg_submit;
	}
	public int getAlg_crct_cnt() {
		return alg_crct_cnt;
	}
	public void setAlg_crct_cnt(int alg_crct_cnt) {
		this.alg_crct_cnt = alg_crct_cnt;
	}
	public String getAlg_crct_per() {
		return alg_crct_per;
	}
	public void setAlg_crct_per(String alg_crct_per) {
		this.alg_crct_per = alg_crct_per;
	}
	public int getAlg_bfile_no() {
		return alg_bfile_no;
	}
	public void setAlg_bfile_no(int alg_bfile_no) {
		this.alg_bfile_no = alg_bfile_no;
	}
	public String getAlg_bfile_name() {
		return alg_bfile_name;
	}
	public void setAlg_bfile_name(String alg_bfile_name) {
		this.alg_bfile_name = alg_bfile_name;
	}
	public String getBasicFile_sname() {
		return basicFile_sname;
	}
	public void setBasicFile_sname(String basicFile_sname) {
		this.basicFile_sname = basicFile_sname;
	}
	public int getBfile_size() {
		return bfile_size;
	}
	public void setBfile_size(int bfile_size) {
		this.bfile_size = bfile_size;
	}
	public String getAlg_bfile_date() {
		return alg_bfile_date;
	}
	public void setAlg_bfile_date(String alg_bfile_date) {
		this.alg_bfile_date = alg_bfile_date;
	}
	public int getAlg_sfile_no() {
		return alg_sfile_no;
	}
	public void setAlg_sfile_no(int alg_sfile_no) {
		this.alg_sfile_no = alg_sfile_no;
	}
	public String getAlg_sfile_name() {
		return alg_sfile_name;
	}
	public void setAlg_sfile_name(String alg_sfile_name) {
		this.alg_sfile_name = alg_sfile_name;
	}
	public String getAlg_sfile_sname() {
		return alg_sfile_sname;
	}
	public void setAlg_sfile_sname(String alg_sfile_sname) {
		this.alg_sfile_sname = alg_sfile_sname;
	}
	public int getAlg_sfile_size() {
		return alg_sfile_size;
	}
	public void setAlg_sfile_size(int alg_sfile_size) {
		this.alg_sfile_size = alg_sfile_size;
	}
	public String getAlg_sfile_date() {
		return alg_sfile_date;
	}
	public void setAlg_sfile_date(String alg_sfile_date) {
		this.alg_sfile_date = alg_sfile_date;
	}
}
