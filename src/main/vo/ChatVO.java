package main.vo;

/**
 * 10th VO클래스
 * @author 강인경
 * @since 2020-01-28
 */
public class ChatVO {
	
	// field
	
	private int chat_room_no; 			//채팅방 식별번호
	private String chat_cont; 			//채팅 내용
	private String cord_cont; 			//코딩 내용
	private String chat_start_date;		//채팅 시작 날짜
	private String chat_end_date;		//채팅 종료 날짜
	private String chat_end_yn;			//채팅 종료 여부
	
	// getter & setter
	
	public int getChat_room_no() {
		return chat_room_no;
	}
	
	public void setChat_room_no(int chat_room_no) {
		this.chat_room_no = chat_room_no;
	}
	
	public String getChat_cont() {
		return chat_cont;
	}
	
	public void setChat_cont(String chat_cont) {
		this.chat_cont = chat_cont;
	}
	
	public String getCord_cont() {
		return cord_cont;
	}
	
	public void setCord_cont(String cord_cont) {
		this.cord_cont = cord_cont;
	}
	
	public String getChat_start_date() {
		return chat_start_date;
	}
	
	public void setChat_start_date(String chat_start_date) {
		this.chat_start_date = chat_start_date;
	}
	
	public String getChat_end_date() {
		return chat_end_date;
	}
	
	public void setChat_end_date(String chat_end_date) {
		this.chat_end_date = chat_end_date;
	}
	
	public String getChat_end_yn() {
		return chat_end_yn;
	}
	
	public void setChat_end_yn(String chat_end_yn) {
		this.chat_end_yn = chat_end_yn;
	}

	// constructor
	
	public ChatVO() {}
	
	public ChatVO(int chat_room_no, String chat_cont, String cord_cont, String chat_start_date, String chat_end_date,
			String chat_end_yn) {
		super();
		this.chat_room_no = chat_room_no;
		this.chat_cont = chat_cont;
		this.cord_cont = cord_cont;
		this.chat_start_date = chat_start_date;
		this.chat_end_date = chat_end_date;
		this.chat_end_yn = chat_end_yn;
	}
	
	
	
	
	
	
}
