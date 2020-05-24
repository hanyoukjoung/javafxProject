package service.chat;

import java.util.List;
import java.util.Map;

import dao.chat.ChatDaoImpl;
import main.vo.ChatContVO;
import main.vo.ChatFileVO;
import main.vo.ChatVO;
import main.vo.MemberVO;
import main.vo.ScheduleVO;

public class ChatServiceImpl implements IChatService {
	private static ChatServiceImpl service;
	private static ChatDaoImpl dao;

	private ChatServiceImpl() {
		dao = ChatDaoImpl.getInstance();
	}

	public static ChatServiceImpl getInstance() {
		if (service == null) {
			service = new ChatServiceImpl();
		}
		return service;
	}

	@Override
	public List<ChatVO> getRoomList(String mem_id) {
		return dao.getRoomList(mem_id);
	}

	@Override
	public MemberVO getUserNameForChatNo(Map<String, String> params) {
		return dao.getUserNameForChatNo(params);
	}

	@Override
	public boolean saveData(Map<String, String> params) {
		return dao.saveData(params);
	}

	@Override
	public ChatContVO getRoomInfo(int roomNum) {
		return dao.getRoomInfo(roomNum);
	}

	@Override
	public List<ChatFileVO> getFileList(int roomNum) {
		return dao.getFileList(roomNum);
	}

	@Override
	public List<Integer> getMonthSCH(Map<String, String> params) {
		return dao.getMonthSCH(params);
	}

	@Override
	public ScheduleVO getDaySCH(Map<String, String> params) {
		return dao.getDaySCH(params);
	}

	@Override
	public int updateSCHECont(Map<String, String> params) {
		return dao.updateSCHECont(params);
	}

	@Override
	public int insertSCHECont(ScheduleVO params) {
		return dao.insertSCHECont(params);
	}
}
