package main.packet;

import java.io.Serializable;

/**
 * @author 정재훈
 * 
 * 서버와 통신 시 사용하는 최상위 객체
 * 객체 통신 시 사용하며 각 하위 객체들은 고유한 목적을 가진다.
 * 해당 객체의 목적은 Purpose 객체를 통해 분류하며, 하위 객체의 생성자에서 할당된다.
 * 
 * purpose : 해당 패킷의 목적 (Enum)
 * forwardId : 패킷 전송자
 * destinationId : 패킷 수신자
 * 
 */
public class Packet implements Serializable{
	
	private static final long serialVersionUID = -4017930000979076863L;
	
	private Purpose purpose;
	private String forwardId;
	private String destinationId;
	
	public Purpose getPurpose() {
		return purpose;
	}
	
	public String getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(String destinationId) {
		this.destinationId = destinationId;
	}
	
	public String getForwardId() {
		return forwardId;
	}

	public void setForwardId(String forwardId) {
		this.forwardId = forwardId;
	}

	public Packet(Purpose purpose, String forwardId, String destinationId) {
		this.purpose = purpose;
		this.forwardId = forwardId;
		this.destinationId = destinationId;
	}
}
