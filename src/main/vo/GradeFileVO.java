package main.vo;

public class GradeFileVO {
	private String grade_name;
	private String grade_img_name;
	private String grade_img_save_name;
	private int grade_img_size;
	private String grade_img_date;
	public String getGrade_name() {
		return grade_name;
	}
	public void setGrade_name(String grade_name) {
		this.grade_name = grade_name;
	}
	public String getGrade_img_name() {
		return grade_img_name;
	}
	public void setGrade_img_name(String grade_img_name) {
		this.grade_img_name = grade_img_name;
	}
	public String getGrade_img_save_name() {
		return grade_img_save_name;
	}
	public void setGrade_img_save_name(String grade_img_save_name) {
		this.grade_img_save_name = grade_img_save_name;
	}
	public int getGrade_img_size() {
		return grade_img_size;
	}
	public void setGrade_img_size(int grade_img_size) {
		this.grade_img_size = grade_img_size;
	}
	public String getGrade_img_date() {
		return grade_img_date;
	}
	public void setGrade_img_date(String grade_img_date) {
		this.grade_img_date = grade_img_date;
	}
	
	public GradeFileVO() {
		
	}
	public GradeFileVO(String grade_name, String grade_img_name, String grade_img_save_name, int grade_img_size,
			String grade_img_date) {
		super();
		this.grade_name = grade_name;
		this.grade_img_name = grade_img_name;
		this.grade_img_save_name = grade_img_save_name;
		this.grade_img_size = grade_img_size;
		this.grade_img_date = grade_img_date;
	}
	
	

}
