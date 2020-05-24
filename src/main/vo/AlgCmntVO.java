package main.vo;

public class AlgCmntVO {
	private int alg_cmnt_no;
	private int alg_cmnt_target;
	private String alg_cmnt_reply_yn;
	private String alg_cmnt_cont;
	private int alg_no;
	private String mem_id;
	private String alg_cmnt_date;

	//getter, setter
	public int getAlg_cmnt_no() {
		return alg_cmnt_no;
	}

	public void setAlg_cmnt_no(int alg_cmnt_no) {
		this.alg_cmnt_no = alg_cmnt_no;
	}

	public int getAlg_cmnt_target() {
		return alg_cmnt_target;
	}

	public void setAlg_cmnt_target(int alg_cmnt_target) {
		this.alg_cmnt_target = alg_cmnt_target;
	}

	public String getAlg_cmnt_reply_yn() {
		return alg_cmnt_reply_yn;
	}

	public void setAlg_cmnt_reply_yn(String alg_cmnt_reply_yn) {
		this.alg_cmnt_reply_yn = alg_cmnt_reply_yn;
	}

	public String getAlg_cmnt_cont() {
		return alg_cmnt_cont;
	}

	public void setAlg_cmnt_cont(String alg_cmnt_cont) {
		this.alg_cmnt_cont = alg_cmnt_cont;
	}

	public int getAlg_no() {
		return alg_no;
	}

	public void setAlg_no(int alg_no) {
		this.alg_no = alg_no;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getAlg_cmnt_date() {
		return alg_cmnt_date;
	}

	public void setAlg_cmnt_date(String alg_cmnt_date) {
		this.alg_cmnt_date = alg_cmnt_date;
	}
	
	//������
	public AlgCmntVO() { }
	
	public AlgCmntVO(int alg_cmnt_no, int alg_cmnt_target, String alg_cmnt_reply_yn, String alg_cmnt_cont, int alg_no,
			String mem_id, String alg_cmnt_date) {
		this.alg_cmnt_no = alg_cmnt_no;
		this.alg_cmnt_target = alg_cmnt_target;
		this.alg_cmnt_reply_yn = alg_cmnt_reply_yn;
		this.alg_cmnt_cont = alg_cmnt_cont;
		this.alg_no = alg_no;
		this.mem_id = mem_id;
		this.alg_cmnt_date = alg_cmnt_date;
	}
}
