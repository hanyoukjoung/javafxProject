package main.packet;

import java.io.Serializable;

/**
 * @author 정재훈
 *
 * 알고리즘 처리 요청용 패킷
 * algNo : 알고리즘 문제 번호
 * code : 알고리즘 문제에 대한 제출 코드값
 */
public class AlgPacket extends Packet implements Serializable{
	
	private static final long serialVersionUID = 8805072305207825692L;

	private int algNo;
	private String code;
	
	public AlgPacket(String forwardId, String destinationId, int algNo, String code) {
		super(Purpose.ALG, forwardId, destinationId);
		this.algNo = algNo;
		this.code = code;
	}
}
