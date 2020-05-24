package main.vo;

public class AlgSubmtVO {
	private int alg_sbmt_no;
	private int alg_no;
	private String mem_id;
	private String crct_yn;
	
	//getter, setter
	public int getAlg_sbmit_no() {
		return alg_sbmt_no;
	}
	public void setAlg_sbmit_no(int alg_sbmit_no) {
		this.alg_sbmt_no = alg_sbmit_no;
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
	public String getCrct_yn() {
		return crct_yn;
	}
	public void setCrct_yn(String crct_yn) {
		this.crct_yn = crct_yn;
	}
	
	//������
	public AlgSubmtVO() { }
	
	public AlgSubmtVO(int alg_sbmit_no, int alg_no, String mem_id, String crct_yn) {
		super();
		this.alg_sbmt_no = alg_sbmit_no;
		this.alg_no = alg_no;
		this.mem_id = mem_id;
		this.crct_yn = crct_yn;
	}
}
