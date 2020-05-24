package main.packet;

import java.io.Serializable;

/**
 * @author 정재훈
 * 
 * 파일 전송 성공 시 반환용 패킷
 * 
 */
public class FileSuccessPacket extends Packet implements Serializable{
	
	private static final long serialVersionUID = -21491191556495082L;

	public FileSuccessPacket(String forwardId, String destinationId) {
		super(Purpose.FILE_SUCCESS, forwardId, destinationId);
	}
}
