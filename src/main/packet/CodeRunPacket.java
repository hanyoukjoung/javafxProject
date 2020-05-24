package main.packet;

import java.io.Serializable;

/**
 * @author 정재훈
 * 
 * 코드 실행 요청용 패킷
 * 
 * msg : 요청 코드 내용
 * roomNum : 해당 레슨방 번호
 * codeType : 해당 코드 언어정보
 * 
 */
public class CodeRunPacket extends Packet implements Serializable{
	
	private static final long serialVersionUID = 535665933478576730L;
	private String msg;
	private int roomNum;
	private String codeType;
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	
	public String getCodeType() {
		return codeType;
	}
	
	public String getCodeExtType() {
		String codeExtType = codeType;
		if(codeExtType.equals("java")) codeExtType = "java";
		else if(codeExtType.equals("c++")) codeExtType = "cpp";
		else if(codeExtType.equals("python")) codeExtType = "py";
		
		return codeExtType;
	}
	
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public CodeRunPacket(String forwardId, String destinationId, String msg, int roomNum, String codeType) {
		super(Purpose.CODE_RUN, forwardId, destinationId);
		this.msg = msg;
		this.roomNum = roomNum;
		this.codeType = codeType;
	}
	
	
}
