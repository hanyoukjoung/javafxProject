package main.packet;

import java.io.Serializable;

/**
 * @author 정재훈
 * 
 * 파일 불러오기 요청용 패킷
 * 
 * path : 파일 분류용 Enum
 * file_name : 파일 명
 * file_sname : 파일 저장명
 * file_size : 파일 크기(byte 단위)
 * file_date : 파일 생성 일
 * 
 */
public class FileRequestPacket extends Packet implements Serializable{
	
	private static final long serialVersionUID = -2458205586509494478L;
	
	private ServerPath path;
	private String file_name;
	private String file_sname;
	private long file_size;
	private String file_date;
	
	public ServerPath getPath() {
		return path;
	}

	public void setPath(ServerPath path) {
		this.path = path;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getFile_sname() {
		return file_sname;
	}

	public void setFile_sname(String file_sname) {
		this.file_sname = file_sname;
	}

	public long getFile_size() {
		return file_size;
	}

	public void setFile_size(long file_size) {
		this.file_size = file_size;
	}

	public String getFile_date() {
		return file_date;
	}

	public void setFile_date(String file_date) {
		this.file_date = file_date;
	}

	public FileRequestPacket(String forwardId, String destinationId, ServerPath path, String file_name,
			String file_sname, long file_size, String file_date) {
		super(Purpose.FILE_REQUEST, forwardId, destinationId);
		this.path = path;
		this.file_name = file_name;
		this.file_sname = file_sname;
		this.file_size = file_size;
		this.file_date = file_date;
	}
	
}
