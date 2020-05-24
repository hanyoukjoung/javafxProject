package main.vo;

/**
 * 17th VO클래스
 * @author 강인경
 * @since 2020-01-28
 */
public class EvaluationVO {
	
	// field
	
	private int eval_no;  			//평가 식별번호
	private String eval_target;   	//평가 대상
	private String eval_star;		//평가 평점
	private String eval_cont;		//평가 내용
	private String eval_date;		//평가 날짜
	private int chat_ptcp_no;		//채팅 참여 식별번호
	
	// getter & setter
	
	public int getEval_no() {
		return eval_no;
	}
	
	public void setEval_no(int eval_no) {
		this.eval_no = eval_no;
	}
	
	public String getEval_target() {
		return eval_target;
	}
	
	public void setEval_target(String eval_target) {
		this.eval_target = eval_target;
	}
	
	public String getEval_star() {
		return eval_star;
	}
	
	public void setEval_star(String eval_star) {
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
	
	public int getChat_ptcp_no() {
		return chat_ptcp_no;
	}
	
	public void setChat_ptcp_no(int chat_ptcp_no) {
		this.chat_ptcp_no = chat_ptcp_no;
	}

	// constructor

	public EvaluationVO() {}

	public EvaluationVO(int eval_no, String eval_target, String eval_star, String eval_cont, String eval_date,
			int chat_ptcp_no) {
		super();
		this.eval_no = eval_no;
		this.eval_target = eval_target;
		this.eval_star = eval_star;
		this.eval_cont = eval_cont;
		this.eval_date = eval_date;
		this.chat_ptcp_no = chat_ptcp_no;
	}
	
}
