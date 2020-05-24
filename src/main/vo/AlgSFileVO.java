package main.vo;

public class AlgSFileVO {
	private int alg_sfile_no;
	private String alg_sfile_name;
	private String alg_sfile_sname;
	private int alg_sfile_size;
	private String alg_sfile_date;
	private int alg_no;
	
	//getter, setter
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
	public int getAlg_no() {
		return alg_no;
	}
	public void setAlg_no(int alg_no) {
		this.alg_no = alg_no;
	}
	
	//������
	public AlgSFileVO() { }
	
	public AlgSFileVO(int alg_sfile_no, String alg_sfile_name, String alg_sfile_sname, int alg_sfile_size,
			String alg_sfile_date, int alg_no) {
		this.alg_sfile_no = alg_sfile_no;
		this.alg_sfile_name = alg_sfile_name;
		this.alg_sfile_sname = alg_sfile_sname;
		this.alg_sfile_size = alg_sfile_size;
		this.alg_sfile_date = alg_sfile_date;
		this.alg_no = alg_no;
	}
}
