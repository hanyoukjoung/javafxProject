package main.packet;

/**
 * 
 * @author 정재훈
 * 
 * 서버 - 클라이언트간 파일 전송 시 사용하는 Enum
 * 전송할 파일의 분류와 경로를 나타낸다.
 * Field로 파일 분류별 경로값을 가진다.
 * 
 */
public enum ServerPath {
	
	MEM_PROF("d:/DLDL/MEM/PROF/"),
	CHAT_FILE("d:/DLDL/CHAT/FILE/"),
	CODE_RUN("d:/DLDL/CODE/RUN/"),
	ALG_SBMT("d:/DLDL/ALG/SBMT/"),
	CTT_SBMT("d:/DLDL/CTT/SBMT/"),
	CTT_VIDEO("d:/DLDL/CTT/VIDEO/");
	
	private String path;
	
	public String getPath() {
		return path;
	}

	private ServerPath(String path) {
		this.path = path;
	}
}
