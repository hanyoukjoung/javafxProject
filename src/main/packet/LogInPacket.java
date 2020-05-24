package main.packet;

import java.io.Serializable;

/**
 * @author 정재훈
 * 
 * 레슨 방 접속 시 사용하는 패킷
 * 
 * roomNum : 해당 레슨방 번호
 * 
 */
public class LogInPacket extends Packet implements Serializable{

	private static final long serialVersionUID = -2746270738259680512L;
	private int roomNum;
	
	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public LogInPacket(String forwardId, String destinationId, int roomNum) {
		super(Purpose.LOG_IN, forwardId, destinationId);
		this.roomNum = roomNum;
	}
}