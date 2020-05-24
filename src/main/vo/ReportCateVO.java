package main.vo;

public class ReportCateVO {
	private int rpt_cate_no;
	private String rpt_cate;
	
	// get & set
	
	public int getRpt_cate_no() {
		return rpt_cate_no;
	}
	public void setRpt_cate_no(int rpt_cate_no) {
		this.rpt_cate_no = rpt_cate_no;
	}
	public String getRpt_cate() {
		return rpt_cate;
	}
	public void setRpt_cate(String rpt_cate) {
		this.rpt_cate = rpt_cate;
	}
	
	
	// ������
	
	public ReportCateVO() {}
	
	
	public ReportCateVO(int rpt_cate_no, String rpt_cate) {
		super();
		this.rpt_cate_no = rpt_cate_no;
		this.rpt_cate = rpt_cate;
	}
	
	
	
	
	
	
}
