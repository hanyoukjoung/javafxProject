package dao.admin;

import java.util.List;
import java.util.Map;

import main.vo.AdminLineChartVO;
import main.vo.RepotMemberVO;


public interface IAdminDao {
	/**
	 * ID가 데이터베이스에 존재하는지 검사하는 메서드
	 * @param admin 검사할 회원 ID
	 * @return 데이터베이스에 존재하면 true 그렇지 않다면 false;
	 * @author 김범수
	 * @since 2020-02-05
	 */
	boolean isExistadminId(String admin_id);
	
	/**
	 * ID와 비밀번호(암호화된)가 데이터베이스에서 일치하는지 체크하는 메서드
	 * @param params ID와 비밀번호(암호화된)
	 * @return 일치한다면 true 그렇지 않으면 false
	 * @author 김범수
	 * @since 2020-02-05
	 */
	boolean isExistAccount(Map<String, String> params);
	
	/**
	 * 회원,강의,게시판의 매월증가율반환하는 메서드
	 * @return 회원,강의,게시판의 매월증가율반환
	 * @author 김범수
	 * @since 2020-02-05
	 */
	AdminLineChartVO getLctMember();
	
	/**
	 * @return 전체 회원 리스트 반환
	 * @author 김범수
	 * @since 2020-02-07
	 */
	List<RepotMemberVO> getAllmemberlist();
	
}
