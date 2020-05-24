package main.packet;

import java.io.Serializable;

/**
 * @author 정재훈
 * 
 * 레슨방 접속 해제 시 사용하는 패킷
 * 
 */
public class LogOutPacket extends Packet implements Serializable{
	
	private static final long serialVersionUID = 2191260247319580952L;

	public LogOutPacket(String forwardId) {
		super(Purpose.LOG_OUT, forwardId, null);
	}
}
