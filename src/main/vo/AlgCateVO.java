package main.vo;

public class AlgCateVO {
	private int alg_cate_no;
	private String alg_cate;

	//getter, setter
	public int getAlg_cate_no() {
		return alg_cate_no;
	}

	public void setAlg_cate_no(int alg_cate_no) {
		this.alg_cate_no = alg_cate_no;
	}

	public String getAlg_cate() {
		return alg_cate;
	}

	public void setAlg_cate(String alg_cate) {
		this.alg_cate = alg_cate;
	}
	
	//������
	public AlgCateVO() { }
	
	public AlgCateVO(int alg_cate_no, String alg_cate) {
		this.alg_cate_no = alg_cate_no;
		this.alg_cate = alg_cate;
	}
}
