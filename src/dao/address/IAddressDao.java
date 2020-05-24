package dao.address;

import java.util.List;
import java.util.Map;

import main.vo.AddrVO;

public interface IAddressDao {
	
	/**
	 * 검색한 주소의 결과를 리스트에 담아 반환하는 메서드
	 * @param params 검색할 내용
	 * @return 검색한 내용
	 * @author 우영래
	 * @since 2020-02-07
	 */
	List<AddrVO> getSearchAddr(Map<String, String> params);
	
}
