package main.packet;

import java.io.Serializable;

/**
 * @author 정재훈
 * 
 * 코드 결과값 전송용 패킷
 * 
 * resultMsg : 코드 실행 결과값
 * roomNum : 해당 레슨방 번호
 * 
 */
public class CodeResultPacket extends Packet implements Serializable{

	private static final long serialVersionUID = -4444661431052175957L;
	private String resultMsg;
	private int roomNum;

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public CodeResultPacket(String forwardId, String destinationId, String resultMsg, int roomNum) {
		super(Purpose.CODE_RESULT, forwardId, destinationId);
		this.resultMsg = resultMsg;
		this.roomNum = roomNum;
	}
}
