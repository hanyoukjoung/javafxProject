package dao.comment;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import dao.util.BuildedSqlMapClient;
import main.vo.FboardCmntVO;

public class CommentDaoImpl implements ICommentDao{
	private static CommentDaoImpl dao;
	private SqlMapClient smc;
	
	private CommentDaoImpl () {
		smc = BuildedSqlMapClient.getSqlMapClient();
	}
	
	public static CommentDaoImpl getInstance() {
		if(dao == null) dao = new CommentDaoImpl();
		
		return dao;
	}
	
	
	

	@Override
	public void insertComment(FboardCmntVO fboardCmntVo) {
		Object obj;
		try {
			obj = smc.insert("comment.insertFBoardComment",fboardCmntVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateComment(FboardCmntVO fboardCmntVo) {
		int cnt;
		try {
			cnt = smc.update("comment.updateFBoardCommnet",fboardCmntVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

	@Override
	public void deleteCommnet(int cmnt_no) {
		int cnt; 
		try {
			cnt = smc.delete("comment.deleteFBoardCommnet",cmnt_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<FboardCmntVO> getAllCommentList(int free_board_no) {
		List<FboardCmntVO> fBoardCmntVo = null;
		try {
			fBoardCmntVo = smc.queryForList("comment.getAllFBoardCmntList",free_board_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fBoardCmntVo;
	}

	@Override
	public void insertCmntCmnt(FboardCmntVO fboardCmntVo) {
		Object obj;
		try {
			obj = smc.insert("comment.insertFBoardCommentComment",fboardCmntVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<FboardCmntVO> getAllFBoardCmntCmntList(Map<String, Integer> params) {
		List<FboardCmntVO> fBoardCmntVo = null;
		try {
			fBoardCmntVo = smc.queryForList("comment.getAllFBoardCmntCmntList",params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fBoardCmntVo;
	}
	
	
	
	
	
	

}
