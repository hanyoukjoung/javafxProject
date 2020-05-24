package main.vo;

public class LctEvalVO {
	private int eval_no;
	private int subs_no;
	private int eval_star;
	private String eval_cont;
	private String eval_date;
	
	public int getEval_no() {
		return eval_no;
	}

	public void setEval_no(int eval_no) {
		this.eval_no = eval_no;
	}

	public int getSubs_no() {
		return subs_no;
	}

	public void setSubs_no(int subs_no) {
		this.subs_no = subs_no;
	}

	public int getEval_star() {
		return eval_star;
	}

	public void setEval_star(int eval_star) {
		this.eval_star = eval_star;
	}

	public String getEval_cont() {
		return eval_cont;
	}

	public void setEval_cont(String eval_cont) {
		this.eval_cont = eval_cont;
	}

	public String getEval_date() {
		return eval_date;
	}

	public void setEval_date(String eval_date) {
		this.eval_date = eval_date;
	}

	public LctEvalVO() {
		
	}
	
	public LctEvalVO(int eval_no, int subs_no, int eval_star, String eval_cont, String eval_date) {
		this.eval_no = eval_no;
		this.subs_no = subs_no;
		this.eval_star = eval_star;
		this.eval_cont = eval_cont;
		this.eval_date = eval_date;
	}
	
}
