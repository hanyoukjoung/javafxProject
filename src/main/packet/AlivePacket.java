package main.packet;

import java.io.Serializable;

/**
 * @author 정재훈
 * 
 * 소켓 유지용 패킷
 * 주기적으로 전송하여 Socket이 close되는 것을 막는다.
 * 
 */
public class AlivePacket extends Packet implements Serializable{
	
	private static final long serialVersionUID = -6449941721577103922L;

	public AlivePacket(String forwardId, String destinationId){
		super(Purpose.ALIVE, forwardId, destinationId);
	}
}
