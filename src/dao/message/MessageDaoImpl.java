package dao.message;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import dao.util.BuildedSqlMapClient;
import main.vo.MessageMemNameVO;
import main.vo.MessageVO;

public class MessageDaoImpl implements IMessageDao {
	private static MessageDaoImpl dao;
	private SqlMapClient smc;

	private MessageDaoImpl() {
		smc = BuildedSqlMapClient.getSqlMapClient();
	}

	public static MessageDaoImpl getInstance() {
		if (dao == null) {
			dao = new MessageDaoImpl();
		}
		return dao;
	}

	@Override
	public List<MessageMemNameVO> getAllMSGList(String mem_id) {
		List<MessageMemNameVO> result = null;
		try {
			result = smc.queryForList("message.getAllMSGList", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
