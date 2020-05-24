package service.message;

import java.util.List;

import dao.message.MessageDaoImpl;
import main.vo.MessageMemNameVO;
import main.vo.MessageVO;

public class MessageServiceImpl implements IMessageService {
	private static MessageServiceImpl service;
	private static MessageDaoImpl dao;

	private MessageServiceImpl() {
		dao = MessageDaoImpl.getInstance();
	}

	public static MessageServiceImpl getInstance() {
		if (service == null) {
			service = new MessageServiceImpl();
		}
		return service;
	}

	@Override
	public List<MessageMemNameVO> getAllMSGList(String mem_id) {
		return dao.getAllMSGList(mem_id);
	}
}
