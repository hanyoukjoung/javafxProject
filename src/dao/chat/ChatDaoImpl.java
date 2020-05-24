package dao.chat;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import dao.util.BuildedSqlMapClient;
import main.vo.ChatContVO;
import main.vo.ChatFileVO;
import main.vo.ChatVO;
import main.vo.MemberVO;
import main.vo.ScheduleVO;

public class ChatDaoImpl implements IChatDao {
	private static ChatDaoImpl dao;
	private SqlMapClient smc;

	private ChatDaoImpl() {
		smc = BuildedSqlMapClient.getSqlMapClient();
	}

	public static ChatDaoImpl getInstance() {
		if (dao == null) {
			dao = new ChatDaoImpl();
		}
		return dao;
	}

	@Override
	public List<ChatVO> getRoomList(String mem_id) {
		List<ChatVO> result = null;
		try {
			result = smc.queryForList("lesson.getRoomList", mem_id);
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}

	@Override
	public MemberVO getUserNameForChatNo(Map<String, String> params) {
		System.out.println("Start DAO Method");
		MemberVO result = null;
		try {
			System.out.println("DAO --- Call ibatis");
			result = (MemberVO)smc.queryForObject("lesson.getUserNameForChatNo", params);
			System.out.println("result :" + result.getMem_id());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean saveData(Map<String, String> params) {
		int result = 0;
		try {
			result = smc.update("lesson.saveData", params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public ChatContVO getRoomInfo(int roomNum) {
		
		ChatContVO result = null;
		try {
			result = (ChatContVO)smc.queryForObject("lesson.getRoomInfo", roomNum);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}

	@Override
	public List<ChatFileVO> getFileList(int roomNum) {
		List<ChatFileVO> result = null;
		try {
			result = smc.queryForList("lesson.getFileList", roomNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Integer> getMonthSCH(Map<String, String> params) {
		List<Integer> result = null;
		try {
			result = smc.queryForList("lesson.getMonthSCHE", params);
		} catch (SQLException e) {
		}
		return result;
	}

	@Override
	public ScheduleVO getDaySCH(Map<String, String> params) {
		ScheduleVO result = null;
		try {
			result = (ScheduleVO)smc.queryForObject("lesson.getDaySCHE", params);
		} catch (SQLException e) {
		}
		return result;
	}

	@Override
	public int updateSCHECont(Map<String, String> params) {
		int result = 0;
		try {
			result = smc.update("lesson.updateSCHECont", params);
		} catch (SQLException e) {
		}
		return result;
	}

	@Override
	public int insertSCHECont(ScheduleVO params) {
		int result = 0;
		try { 
			
			if(smc.insert("lesson.insertSCHECont", params) == null) result = 1;
			System.out.println("DAO ===== result = " + (result==1?"success":"fail"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
