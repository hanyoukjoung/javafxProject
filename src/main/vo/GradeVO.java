package main.vo;

public class GradeVO {
	private String grade_name;
	private int grade_std_pnt;
	public String getGrade_name() {
		return grade_name;
	}
	public void setGrade_name(String grade_name) {
		this.grade_name = grade_name;
	}
	public int getGrade_std_pnt() {
		return grade_std_pnt;
	}
	public void setGrade_std_pnt(int grade_std_pnt) {
		this.grade_std_pnt = grade_std_pnt;
	}
	
	public GradeVO() {
		
	}
	
	public GradeVO(String grade_name, int grade_std_pnt) {
		super();
		this.grade_name = grade_name;
		this.grade_std_pnt = grade_std_pnt;
	}

	
	

}
