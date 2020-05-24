package service.message;

import java.util.List;

import main.vo.MessageMemNameVO;
import main.vo.MessageVO;

public interface IMessageService {
	
	/**
	 * @author 정재훈
	 * @return 모든 쪽지 리스트 반환
	 */
	List<MessageMemNameVO> getAllMSGList(String mem_id);
}
