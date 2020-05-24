package main.vo;

public class AlgBFileVO {
	private int alg_bfile_no;
	private String alg_bfile_name;
	private String alg_bfile_sname;
	private int alg_bfile_size;
	private String alg_bfile_date;
	private int alg_no;
	
	//getter, setter
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

	public String getAlg_bfile_save_name() {
		return alg_bfile_sname;
	}

	public void setAlg_bfile_save_name(String alg_bfile_save_name) {
		this.alg_bfile_sname = alg_bfile_save_name;
	}

	public int getAlg_bfile_size() {
		return alg_bfile_size;
	}

	public void setAlg_bfile_size(int alg_bfile_size) {
		this.alg_bfile_size = alg_bfile_size;
	}

	public String getAlg_bfile_date() {
		return alg_bfile_date;
	}

	public void setAlg_bfile_date(String alg_bfile_date) {
		this.alg_bfile_date = alg_bfile_date;
	}

	public int getAlg_no() {
		return alg_no;
	}

	public void setAlg_no(int alg_no) {
		this.alg_no = alg_no;
	}
	
	//������
	public AlgBFileVO() { }
	
	public AlgBFileVO(int alg_bfile_no, String alg_bfile_name, String alg_bfile_save_name, int alg_bfile_size,
			String alg_bfile_date, int alg_no) {
		this.alg_bfile_no = alg_bfile_no;
		this.alg_bfile_name = alg_bfile_name;
		this.alg_bfile_sname = alg_bfile_save_name;
		this.alg_bfile_size = alg_bfile_size;
		this.alg_bfile_date = alg_bfile_date;
		this.alg_no = alg_no;
	}
}
