package main.vo;

public class RnCodeVO {
	private String rna;
	private String sido_name;
	private String emd_ilryeon_no;
	private String rna_cord;
	private String sigungoo_name;
	private String sido_eng;
	private String rna_eng;
	private String sigungoo_eng;
	private String emd_name;
	private String emd_eng;
	private String emd_div;
	private String emd_cord;
	private String use_yn;
	private String chg_reason;
	private String chg_rec_info;
	private String ntf_date;
	private String erasure_date;
	
	// get & set
	
	public String getRna() {
		return rna;
	}
	public void setRna(String rna) {
		this.rna = rna;
	}
	public String getSido_name() {
		return sido_name;
	}
	public void setSido_name(String sido_name) {
		this.sido_name = sido_name;
	}
	public String getEmd_ilryeon_no() {
		return emd_ilryeon_no;
	}
	public void setEmd_ilryeon_no(String emd_ilryeon_no) {
		this.emd_ilryeon_no = emd_ilryeon_no;
	}
	public String getRna_cord() {
		return rna_cord;
	}
	public void setRna_cord(String rna_cord) {
		this.rna_cord = rna_cord;
	}
	public String getSigungoo_name() {
		return sigungoo_name;
	}
	public void setSigungoo_name(String sigungoo_name) {
		this.sigungoo_name = sigungoo_name;
	}
	public String getSido_eng() {
		return sido_eng;
	}
	public void setSido_eng(String sido_eng) {
		this.sido_eng = sido_eng;
	}
	public String getRna_eng() {
		return rna_eng;
	}
	public void setRna_eng(String rna_eng) {
		this.rna_eng = rna_eng;
	}
	public String getSigungoo_eng() {
		return sigungoo_eng;
	}
	public void setSigungoo_eng(String sigungoo_eng) {
		this.sigungoo_eng = sigungoo_eng;
	}
	public String getEmd_name() {
		return emd_name;
	}
	public void setEmd_name(String emd_name) {
		this.emd_name = emd_name;
	}
	public String getEmd_eng() {
		return emd_eng;
	}
	public void setEmd_eng(String emd_eng) {
		this.emd_eng = emd_eng;
	}
	public String getEmd_div() {
		return emd_div;
	}
	public void setEmd_div(String emd_div) {
		this.emd_div = emd_div;
	}
	public String getEmd_cord() {
		return emd_cord;
	}
	public void setEmd_cord(String emd_cord) {
		this.emd_cord = emd_cord;
	}
	public String getUse_yn() {
		return use_yn;
	}
	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}
	public String getChg_reason() {
		return chg_reason;
	}
	public void setChg_reason(String chg_reason) {
		this.chg_reason = chg_reason;
	}
	public String getChg_rec_info() {
		return chg_rec_info;
	}
	public void setChg_rec_info(String chg_rec_info) {
		this.chg_rec_info = chg_rec_info;
	}
	public String getNtf_date() {
		return ntf_date;
	}
	public void setNtf_date(String ntf_date) {
		this.ntf_date = ntf_date;
	}
	public String getErasure_date() {
		return erasure_date;
	}
	public void setErasure_date(String erasure_date) {
		this.erasure_date = erasure_date;
	}
	
	// ������
	
	public RnCodeVO() {}
	
	public RnCodeVO(String rna, String sido_name, String emd_ilryeon_no, String rna_cord, String sigungoo_name,
			String sido_eng, String rna_eng, String sigungoo_eng, String emd_name, String emd_eng, String emd_div,
			String emd_cord, String use_yn, String chg_reason, String chg_rec_info, String ntf_date,
			String erasure_date) {
		super();
		this.rna = rna;
		this.sido_name = sido_name;
		this.emd_ilryeon_no = emd_ilryeon_no;
		this.rna_cord = rna_cord;
		this.sigungoo_name = sigungoo_name;
		this.sido_eng = sido_eng;
		this.rna_eng = rna_eng;
		this.sigungoo_eng = sigungoo_eng;
		this.emd_name = emd_name;
		this.emd_eng = emd_eng;
		this.emd_div = emd_div;
		this.emd_cord = emd_cord;
		this.use_yn = use_yn;
		this.chg_reason = chg_reason;
		this.chg_rec_info = chg_rec_info;
		this.ntf_date = ntf_date;
		this.erasure_date = erasure_date;
	}
	
	
}
