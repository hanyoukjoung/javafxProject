package main.vo;

public class RnEtcInfoVO {
	private String gwanri_no;
	private String hangjung_dong_cord;
	private String hangjung_dong_name;
	private String post_no;
	private String post_ilryeon_no;
	private String gqd_name;
	private String breg_building_name;
	private String sigungoo_building_name;
	private String apt_yn;
	
	// get & set
	
	public String getGwanri_no() {
		return gwanri_no;
	}
	public void setGwanri_no(String gwanri_no) {
		this.gwanri_no = gwanri_no;
	}
	public String getHangjung_dong_cord() {
		return hangjung_dong_cord;
	}
	public void setHangjung_dong_cord(String hangjung_dong_cord) {
		this.hangjung_dong_cord = hangjung_dong_cord;
	}
	public String getHangjung_dong_name() {
		return hangjung_dong_name;
	}
	public void setHangjung_dong_name(String hangjung_dong_name) {
		this.hangjung_dong_name = hangjung_dong_name;
	}
	public String getPost_no() {
		return post_no;
	}
	public void setPost_no(String post_no) {
		this.post_no = post_no;
	}
	public String getPost_ilryeon_no() {
		return post_ilryeon_no;
	}
	public void setPost_ilryeon_no(String post_ilryeon_no) {
		this.post_ilryeon_no = post_ilryeon_no;
	}
	public String getGqd_name() {
		return gqd_name;
	}
	public void setGqd_name(String gqd_name) {
		this.gqd_name = gqd_name;
	}
	public String getBreg_building_name() {
		return breg_building_name;
	}
	public void setBreg_building_name(String breg_building_name) {
		this.breg_building_name = breg_building_name;
	}
	public String getSigungoo_building_name() {
		return sigungoo_building_name;
	}
	public void setSigungoo_building_name(String sigungoo_building_name) {
		this.sigungoo_building_name = sigungoo_building_name;
	}
	public String getApt_yn() {
		return apt_yn;
	}
	public void setApt_yn(String apt_yn) {
		this.apt_yn = apt_yn;
	}
	
	// ������
	
	public RnEtcInfoVO() {}
	
	public RnEtcInfoVO(String gwanri_no, String hangjung_dong_cord, String hangjung_dong_name, String post_no,
			String post_ilryeon_no, String gqd_name, String breg_building_name, String sigungoo_building_name,
			String apt_yn) {
		super();
		this.gwanri_no = gwanri_no;
		this.hangjung_dong_cord = hangjung_dong_cord;
		this.hangjung_dong_name = hangjung_dong_name;
		this.post_no = post_no;
		this.post_ilryeon_no = post_ilryeon_no;
		this.gqd_name = gqd_name;
		this.breg_building_name = breg_building_name;
		this.sigungoo_building_name = sigungoo_building_name;
		this.apt_yn = apt_yn;
	}
	
	
	
	
}
