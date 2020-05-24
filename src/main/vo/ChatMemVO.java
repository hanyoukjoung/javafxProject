package main.vo;

/**
 * 11th VO클래스
 * @author 강인경
 * @since 2020-01-28
 */
public class ChatMemVO {

	// field
	
	private int chat_ptcp_no; //채팅 참여 식별번호
	private int chat_room_no; //채팅방 식별번호
	private String mem_id;    //회원 아이디
	
	// getter & setter
	
	public int getChat_ptcp_no() {
		return chat_ptcp_no;
	}
	
	public void setChat_ptcp_no(int chat_ptcp_no) {
		this.chat_ptcp_no = chat_ptcp_no;
	}
	
	public int getChat_room_no() {
		return chat_room_no;
	}
	
	public void setChat_room_no(int chat_room_no) {
		this.chat_room_no = chat_room_no;
	}
	
	public String getMem_id() {
		return mem_id;
	}
	
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	// constructor
	
	public ChatMemVO() {}
	
	public ChatMemVO(int chat_ptcp_no, int chat_room_no, String mem_id) {
		super();
		this.chat_ptcp_no = chat_ptcp_no;
		this.chat_room_no = chat_room_no;
		this.mem_id = mem_id;
	}
	
	
	
	
	
	
	
	
	
	
}
