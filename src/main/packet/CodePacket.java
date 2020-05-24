package main.packet;

import java.io.Serializable;

/**
 * @author 정재훈
 * 
 * 레슨방 코드 공유시 사용하는 패킷
 * 
 * msg : 공유한 코드 내용
 * roomNum : 해당 레슨방 번호
 * 
 */
public class CodePacket extends Packet implements Serializable{

	private static final long serialVersionUID = -279852761816101285L;

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

	public CodePacket(String forwardId, String destinationId, String msg, int roomNum) {
		super(Purpose.CODE, forwardId, destinationId);
		this.msg = msg;
		this.roomNum = roomNum;
	}
}
