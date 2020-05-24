package main.packet;

import java.io.Serializable;

/**
 * @author 정재훈
 * 
 * 코드전송 실패 시 사용하는 패킷
 * 
 */
public class CodeFailPacket extends Packet implements Serializable{
	
	private static final long serialVersionUID = -7653513144436931639L;
	
	public CodeFailPacket(String forwardId, String destinationId){
		super(Purpose.CODE_FAIL, forwardId, destinationId);
	}
}
