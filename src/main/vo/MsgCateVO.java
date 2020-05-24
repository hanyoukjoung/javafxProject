package main.vo;

public class MsgCateVO {
	private int msg_cate_no;
	private String msg_cate;
	
	public int getMsg_cate_no() {
		return msg_cate_no;
	}
	
	public void setMsg_cate_no(int msg_cate_no) {
		this.msg_cate_no = msg_cate_no;
	}
	
	public String getMsg_cate() {
		return msg_cate;
	}
	
	public void setMsg_cate(String msg_cate) {
		this.msg_cate = msg_cate;
	}

	public MsgCateVO() {
		
	}

	public MsgCateVO(int msg_cate_no, String msg_cate) {
		this.msg_cate_no = msg_cate_no;
		this.msg_cate = msg_cate;
	}
	
}
