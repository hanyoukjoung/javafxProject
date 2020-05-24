package service.chat;

import java.util.List;
import java.util.Map;

import main.vo.ChatContVO;
import main.vo.ChatFileVO;
import main.vo.ChatVO;
import main.vo.MemberVO;
import main.vo.ScheduleVO;

public interface IChatService {
	
	/**
	 * @author 정재훈
	 * @param String mem_id 현재 세션의 아이디
	 * @return 로그인중인 회원의 참여중인 레슨 방
	 */
	public List<ChatVO> getRoomList(String mem_id);
	
	/**
	 * @author 정재훈
	 * @param chat_room_no 현재 방의 
	 * @return
	 */
	public MemberVO getUserNameForChatNo(Map<String, String> params);
	
	/**
	 * @author 정재훈
	 * @param chat 채팅방의 채팅 데이터
	 * @param code 채팅방의 코드 데이터
	 * @return true : 성공 false : 실패
	 */
	public boolean saveData(Map<String, String> params);
	
	/**
	 * @author 정재훈
	 * @param roomNum 방번호
	 * @return 해당 방에 대한 채팅, 코딩 내역
	 */
	public ChatContVO getRoomInfo(int roomNum);
	
	/**
	 * @author 정재훈
	 * @param roomNum 방번호
	 * @return 해당 방에 대한 파일 목록
	 */
	public List<ChatFileVO> getFileList(int roomNum); 
	
	/**
	 * @author 정재훈
	 * @param SCH_DATE : 검색할 스케줄의 연 + 월, MEM_ID : 검색할 스케줄의 회원 아이디 
	 * @return 해당 월의 스케줄의 일자
	 */
	public List<Integer> getMonthSCH(Map<String, String> params);
	
	/**
	 * @author 정재훈
	 * @param params {MEM_ID 회원 아이디, SCH_DATE 스케줄 날짜}
	 * @return 회원의 해당 날짜 스케줄
	 */
	public ScheduleVO getDaySCH(Map<String, String> params);
	
	/**
	 * @author 정재훈
	 * @param params {SCHE_NO 스케줄 식별번호, SCHE_CONT 스케줄 내용}
	 * @return 1 : Update 성공, 0 : Update 실패
	 */
	public int updateSCHECont(Map<String, String> params);
	
	/**
	 * @author 정재훈
	 * @param ScheduleVO
	 * @return 1 : Insert 성공, 0 : Insert 실패
	 */
	public int insertSCHECont(ScheduleVO params);
	
}
