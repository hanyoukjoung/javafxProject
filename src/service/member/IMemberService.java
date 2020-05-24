package service.member;

import java.util.List;
import java.util.Map;

import main.vo.GenderChartVO;
import main.vo.MemFileVO;
import main.vo.MemberVO;

public interface IMemberService {
	
	/**
	 * ID가 데이터베이스에 존재하는지 검사하는 메서드
	 * @param mem_id 검사할 회원 ID
	 * @return 데이터베이스에 존재하면 true 그렇지 않다면 false;
	 * @author 우영래
	 * @since 2020-01-29
	 */
	boolean isExistMemId(String mem_id);
	
	/**
	 * ID와 비밀번호(암호화된)가 데이터베이스에서 일치하는지 체크하는 메서드
	 * @param params ID와 비밀번호(암호화된)
	 * @return 일치한다면 true 그렇지 않으면 false
	 * @author 우영래
	 * @since 2020-01-29
	 */
	boolean isExistAccount(Map<String, String> params);
	
	/**
	 * 회원가입에 필요한 정보를 데이터베이스에 추가하는 메서드
	 * @param member 회원가입에 필요한 정보를 담은 VO
	 * @return 등록에 성공하면 true 실패하면 false
	 * @author 우영래
	 * @since 2020-01-31
	 */
	boolean memberJoin(MemberVO member);
	
	/**
	 * 회원 아이디에 해당하는 회원정보를 반환하는 메서드
	 * @param mem_id 검색하고 싶은 회원 아이디
	 * @return 회원아이디의 모든 정보
	 * @author 우영래
	 * @since 2020-02-03
	 */
	MemberVO getMemberData(String mem_id);
	
	/**
	 * 회원 아이디에 해당하는 회원비밀번호를 변경하는 메서드
	 * @param params 변경할 회원 아이디와 변경할 비밀번호
	 * @return 변경에 성공하면 true 실패하면 false
	 * @author 우영래
	 * @since 2020-02-04
	 */
	boolean updateMemPass(Map<String, String> params);

	/**
	 * 이름과 이메일주소가 맞는 회원 아이디리스트를 반환하는 메서드
	 * @param params 검색할 아이디의 이름과 이메일주소
	 * @return 검색된 모든 아이디 리스트
	 * @author 우영래
	 * @since 2020-02-04
	 */
	List<String> getMemId(Map<String, String> params);
	
	/**
	 * 회원정보를 수정하는 메서드
	 * @param mem 수정할 회원정보
	 * @return 수정에 성공하면 true 실패하면 false
	 * @author 우영래
	 * @since 2020-02-07
	 */
	boolean updateMember(MemberVO mem);
	
	/**
	 * @author 정재훈
	 * @param mem_id 검색할 프로필 사진의 회원
	 * @return 회원 프로필 사진의 파일정보
	 */
	MemFileVO getMemberFile(String mem_id);
	
	/**
	 * @author 정재훈
	 * @return 전체 회원의 남/여 수
	 */
	GenderChartVO getMemStat();
	
	/**
	 * 해당 아이디의 mem_act_yn을 'N'으로 바꾸는 메서드
	 * @param mem_id 바꿀 회원 아이디
	 * @return 수정에 성공하면 true 실패하면 false
	 * @author 우영래
	 * @since 2020-02-07
	 */
	boolean deleteMemAccount(String mem_id);
}
