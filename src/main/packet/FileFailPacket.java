package main.packet;

import java.io.Serializable;

/**
 * @author 정재훈
 * 
 * 파일 전송 실패시 사용하는 패킷
 * 
 */
public class FileFailPacket extends Packet implements Serializable{

	private static final long serialVersionUID = -8866163999764984451L;

	public FileFailPacket(String forwardId, String destinationId) {
		super(Purpose.FILE_FAIL, forwardId, destinationId);
	}
}
