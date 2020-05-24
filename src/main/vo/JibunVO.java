package main.vo;

public class JibunVO {
	private String gwanri_no;
	private int ilryeon_no;
	private String bj_dong_cord;
	private String sido_name;
	private String sigungoo_name;
	private String bj_emd_name;
	private String bj_lee_name;
	private String mountain_yn;
	private int jibun_bunji;
	private int jibun_ho;
	private String rep_yn;
	
	public String getGwanri_no() {
		return gwanri_no;
	}
	public void setGwanri_no(String gwanri_no) {
		this.gwanri_no = gwanri_no;
	}
	public int getIlryeon_no() {
		return ilryeon_no;
	}
	public void setIlryeon_no(int ilryeon_no) {
		this.ilryeon_no = ilryeon_no;
	}
	public String getBj_dong_cord() {
		return bj_dong_cord;
	}
	public void setBj_dong_cord(String bj_dong_cord) {
		this.bj_dong_cord = bj_dong_cord;
	}
	public String getSido_name() {
		return sido_name;
	}
	public void setSido_name(String sido_name) {
		this.sido_name = sido_name;
	}
	public String getSigungoo_name() {
		return sigungoo_name;
	}
	public void setSigungoo_name(String sigungoo_name) {
		this.sigungoo_name = sigungoo_name;
	}
	public String getBj_emd_name() {
		return bj_emd_name;
	}
	public void setBj_emd_name(String bj_emd_name) {
		this.bj_emd_name = bj_emd_name;
	}
	public String getBj_lee_name() {
		return bj_lee_name;
	}
	public void setBj_lee_name(String bj_lee_name) {
		this.bj_lee_name = bj_lee_name;
	}
	public String getMountain_yn() {
		return mountain_yn;
	}
	public void setMountain_yn(String mountain_yn) {
		this.mountain_yn = mountain_yn;
	}
	public int getJibun_bunji() {
		return jibun_bunji;
	}
	public void setJibun_bunji(int jibun_bunji) {
		this.jibun_bunji = jibun_bunji;
	}
	public int getJibun_ho() {
		return jibun_ho;
	}
	public void setJibun_ho(int jibun_ho) {
		this.jibun_ho = jibun_ho;
	}
	public String getRep_yn() {
		return rep_yn;
	}
	public void setRep_yn(String rep_yn) {
		this.rep_yn = rep_yn;
	}
	
	public JibunVO() {
		
	}
	public JibunVO(String gwanri_no, int ilryeon_no, String bj_dong_cord, String sido_name, String sigungoo_name,
			String bj_emd_name, String bj_lee_name, String mountain_yn, int jibun_bunji, int jibun_ho, String rep_yn) {
		super();
		this.gwanri_no = gwanri_no;
		this.ilryeon_no = ilryeon_no;
		this.bj_dong_cord = bj_dong_cord;
		this.sido_name = sido_name;
		this.sigungoo_name = sigungoo_name;
		this.bj_emd_name = bj_emd_name;
		this.bj_lee_name = bj_lee_name;
		this.mountain_yn = mountain_yn;
		this.jibun_bunji = jibun_bunji;
		this.jibun_ho = jibun_ho;
		this.rep_yn = rep_yn;
	}
	
	

}
