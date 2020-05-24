package main.packet;

import java.io.Serializable;

/**
 * @author 정재훈
 * 
 * 레슨방 채팅 시 사용되는 패킷
 * 
 * msg : 채팅 내용
 * roomNum : 해당 채팅방 번호
 */
public class ChatPacket extends Packet implements Serializable{

	private static final long serialVersionUID = -450809483243750241L;
	
	private String msg;
	private int roomNum;
	
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
	
	public ChatPacket(String forwardId, String destinationId, String msg, int roomNum) {
		super(Purpose.CHAT, forwardId, destinationId);
		this.msg = msg;
		this.roomNum = roomNum;
	}
}
