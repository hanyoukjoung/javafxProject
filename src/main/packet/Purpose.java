package main.packet;

/**
 * @author 정재훈
 * 
 * 패킷 통신시 사용하는 Enum
 * 각 패킷의 목적을 나타낸다.
 * 
 */
public enum Purpose {
	
	ADD_ROOM, 
	DEL_ROOM, 
	
	LOG_IN, 
	LOG_OUT, 
	
	CHAT, 
	CHAT_FAIL, 
	
	FILE, 
	FILE_FAIL, 
	FILE_SUCCESS,
	FILE_REQUEST,
	
	CODE, 
	CODE_FAIL, 
	CODE_RESULT, 
	CODE_RUN, 
	
	ALG, 
	ALG_RESULT, 
	
	CTT, 
	CTT_RESULT, 
	
	ALIVE;
	
}
