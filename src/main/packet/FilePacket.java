package main.packet;

import java.io.Serializable;
import java.util.StringTokenizer;

/**
 * @author 정재훈
 * 파일 전송 요청 시 사용하는 패킷
 * 
 * fileName : 파일명
 * fileExtName : 확장자명
 * roomNum : 전송한 레슨방 번호
 * fileSize : 파일 크기(byte단위)
 * forwardName : 보낸 회원 명
 * 
 */
public class FilePacket extends Packet implements Serializable {
	
	private static final long serialVersionUID = 7240091120951637141L;
	private String fileName;				// 순수 파일명
	private String fileExtName;				// 파일 확장자명
	private int roomNum;
	private long fileSize;
	private String forwardName;				// 보낸 사람 이름
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getFileExtName() {
		return fileExtName;
	}

	public void setFileExtName(String fileExtName) {
		this.fileExtName = fileExtName;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	
	public String getForwardName() {
		return forwardName;
	}

	public void setForwardName(String forwardName) {
		this.forwardName = forwardName;
	}

	public FilePacket(String forwardId, String forwardName, String destinationId, String fileName, int roomNum, long fileSize) {
		super(Purpose.FILE, forwardId, destinationId);
		this.forwardName = forwardName;
		
		StringTokenizer st = new StringTokenizer(fileName, ".");
		
		if(st.countTokens() == 2) {					//파일명에 .이 확장자에만 있을 경우
			this.fileName = st.nextToken();
			this.fileExtName = st.nextToken();
		} else {									//파일명에 .이 확장자 외에 더 있을 경우 스트링빌더를 통한 파일명, 확장자명 필터링
			StringBuilder sb = new StringBuilder();
			
			for(int i=0; i<=st.countTokens(); i++) {
				sb.append(st.nextToken());
			}
			this.fileName = sb.toString();
			this.fileExtName = st.nextToken();
		}
		this.roomNum = roomNum;
		this.fileSize = fileSize;
	}
}
