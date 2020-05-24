package main.packet;

import java.io.Serializable;

/**
 * @author 정재훈
 * 
 * 채팅 전송 실패시 사용되는 패킷
 * 
 */
public class ChatFailPacket extends Packet implements Serializable{

	private static final long serialVersionUID = 4536153182928189238L;

	public ChatFailPacket(String forwardId, String destinationId) {
		super(Purpose.CHAT_FAIL, forwardId, destinationId);
	}
}
