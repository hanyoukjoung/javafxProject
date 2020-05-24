package main.vo;

public class MessageMemNameVO {

	private int msg_no;
	private int msg_cate_no;
	private String msg_target_id;
	private String admin_id;
	private String mem_id;
	private String msg_cont;
	private String msg_snd_date;
	private String msg_rcv_date;
	private int lang_major;
	private int lang_itrst;
	private String mem_name;
	
	public int getMsg_no() {
		return msg_no;
	}
	
	public void setMsg_no(int msg_no) {
		this.msg_no = msg_no;
	}
	
	public int getMsg_cate_no() {
		return msg_cate_no;
	}
	
	public void setMsg_cate_no(int msg_cate_no) {
		this.msg_cate_no = msg_cate_no;
	}
	
	public String getMsg_target_id() {
		return msg_target_id;
	}
	
	public void setMsg_target_id(String msg_target_id) {
		this.msg_target_id = msg_target_id;
	}
	
	public String getAdmin_id() {
		return admin_id;
	}
	
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	
	public String getMem_id() {
		return mem_id;
	}
	
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	
	public String getMsg_cont() {
		return msg_cont;
	}
	
	public void setMsg_cont(String msg_cont) {
		this.msg_cont = msg_cont;
	}
	
	public String getMsg_snd_date() {
		return msg_snd_date;
	}
	
	public void setMsg_snd_date(String msg_snd_date) {
		this.msg_snd_date = msg_snd_date;
	}
	
	public String getMsg_rcv_date() {
		return msg_rcv_date;
	}
	
	public void setMsg_rcv_date(String msg_rcv_date) {
		this.msg_rcv_date = msg_rcv_date;
	}
	
	public int getLang_major() {
		return lang_major;
	}
	
	public void setLang_major(int lang_major) {
		this.lang_major = lang_major;
	}
	
	public int getLang_itrst() {
		return lang_itrst;
	}
	
	public void setLang_itrst(int lang_itrst) {
		this.lang_itrst = lang_itrst;
	}
	
	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public MessageMemNameVO() {
		
	}

	public MessageMemNameVO(int msg_no, int msg_cate_no, String msg_target_id, String admin_id, String mem_id, String msg_cont,
			String msg_snd_date, String msg_rcv_date, int lang_major, int lang_itrst, String mem_name) {
		this.msg_no = msg_no;
		this.msg_cate_no = msg_cate_no;
		this.msg_target_id = msg_target_id;
		this.admin_id = admin_id;
		this.mem_id = mem_id;
		this.msg_cont = msg_cont;
		this.msg_snd_date = msg_snd_date;
		this.msg_rcv_date = msg_rcv_date;
		this.lang_major = lang_major;
		this.lang_itrst = lang_itrst;
		this.mem_name = mem_name;
	}
	
}
