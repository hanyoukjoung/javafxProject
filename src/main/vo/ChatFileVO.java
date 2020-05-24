package main.vo;

public class ChatFileVO {
	private int chat_file_no;
	private String chat_file_name;
	private String chat_file_sname;
	private String chat_file_size;
	private String chat_file_date;
	private int chat_room_no;
	
	public ChatFileVO() {}
	
	public ChatFileVO(int chat_file_no, String chat_file_name, String chat_file_sname, String chat_file_size,
			String chat_file_date, int chat_room_no) {
		super();
		this.chat_file_no = chat_file_no;
		this.chat_file_name = chat_file_name;
		this.chat_file_sname = chat_file_sname;
		this.chat_file_size = chat_file_size;
		this.chat_file_date = chat_file_date;
		this.chat_room_no = chat_room_no;
	}

	public int getChat_file_no() {
		return chat_file_no;
	}

	public void setChat_file_no(int chat_file_no) {
		this.chat_file_no = chat_file_no;
	}

	public String getChat_file_name() {
		return chat_file_name;
	}

	public void setChat_file_name(String chat_file_name) {
		this.chat_file_name = chat_file_name;
	}

	public String getChat_file_sname() {
		return chat_file_sname;
	}

	public void setChat_file_sname(String chat_file_sname) {
		this.chat_file_sname = chat_file_sname;
	}

	public String getChat_file_size() {
		return chat_file_size;
	}

	public void setChat_file_size(String chat_file_size) {
		this.chat_file_size = chat_file_size;
	}

	public String getChat_file_date() {
		return chat_file_date;
	}

	public void setChat_file_date(String chat_file_date) {
		this.chat_file_date = chat_file_date;
	}

	public int getChat_room_no() {
		return chat_room_no;
	}

	public void setChat_room_no(int chat_room_no) {
		this.chat_room_no = chat_room_no;
	}
	
}
