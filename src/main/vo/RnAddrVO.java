package main.vo;

public class RnAddrVO {
	private String gwanri_no;
	private String rna_cord;
	private String rmd_ilryeon_no;
	private String basement_yn;
	private int building_bonbun;
	private int building_boobun;
	private String gicho_area_no;
	private String chg_reason_cord;
	private String gosi_date;
	private String before_rna;
	private String dtl_addt_auth_yn;
	
	
	// get & set

	public String getGwanri_no() {
		return gwanri_no;
	}
	public void setGwanri_no(String gwanri_no) {
		this.gwanri_no = gwanri_no;
	}
	public String getRna_cord() {
		return rna_cord;
	}
	public void setRna_cord(String rna_cord) {
		this.rna_cord = rna_cord;
	}
	public String getRmd_ilryeon_no() {
		return rmd_ilryeon_no;
	}
	public void setRmd_ilryeon_no(String rmd_ilryeon_no) {
		this.rmd_ilryeon_no = rmd_ilryeon_no;
	}
	public String getBasement_yn() {
		return basement_yn;
	}
	public void setBasement_yn(String basement_yn) {
		this.basement_yn = basement_yn;
	}
	public int getBuilding_bonbun() {
		return building_bonbun;
	}
	public void setBuilding_bonbun(int building_bonbun) {
		this.building_bonbun = building_bonbun;
	}
	public int getBuilding_boobun() {
		return building_boobun;
	}
	public void setBuilding_boobun(int building_boobun) {
		this.building_boobun = building_boobun;
	}
	public String getGicho_area_no() {
		return gicho_area_no;
	}
	public void setGicho_area_no(String gicho_area_no) {
		this.gicho_area_no = gicho_area_no;
	}
	public String getChg_reason_cord() {
		return chg_reason_cord;
	}
	public void setChg_reason_cord(String chg_reason_cord) {
		this.chg_reason_cord = chg_reason_cord;
	}
	public String getGosi_date() {
		return gosi_date;
	}
	public void setGosi_date(String gosi_date) {
		this.gosi_date = gosi_date;
	}
	public String getBefore_rna() {
		return before_rna;
	}
	public void setBefore_rna(String before_rna) {
		this.before_rna = before_rna;
	}
	public String getDtl_addt_auth_yn() {
		return dtl_addt_auth_yn;
	}
	public void setDtl_addt_auth_yn(String dtl_addt_auth_yn) {
		this.dtl_addt_auth_yn = dtl_addt_auth_yn;
	}
	
	
	// ������
	
	public RnAddrVO() {}
	
	public RnAddrVO(String gwanri_no, String rna_cord, String rmd_ilryeon_no, String basement_yn, int building_bonbun,
			int building_boobun, String gicho_area_no, String chg_reason_cord, String gosi_date, String before_rna,
			String dtl_addt_auth_yn) {
		super();
		this.gwanri_no = gwanri_no;
		this.rna_cord = rna_cord;
		this.rmd_ilryeon_no = rmd_ilryeon_no;
		this.basement_yn = basement_yn;
		this.building_bonbun = building_bonbun;
		this.building_boobun = building_boobun;
		this.gicho_area_no = gicho_area_no;
		this.chg_reason_cord = chg_reason_cord;
		this.gosi_date = gosi_date;
		this.before_rna = before_rna;
		this.dtl_addt_auth_yn = dtl_addt_auth_yn;
	}
	
	
	
	
	
	
	
}
