package main.vo;

public class ChatContVO {
	private String chat_cont;
	private String code_cont;
	
	public String getChat_cont() {
		return chat_cont;
	}
	
	public void setChat_cont(String chat_cont) {
		this.chat_cont = chat_cont;
	}
	
	public String getCode_cont() {
		return code_cont;
	}
	
	public void setCode_cont(String code_cont) {
		this.code_cont = code_cont;
	}
	public ChatContVO() { }
	
	public ChatContVO(String chat_cont, String code_cont) {
		super();
		this.chat_cont = chat_cont;
		this.code_cont = code_cont;
	}
}
