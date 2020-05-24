package service.comment;

import java.util.List;
import java.util.Map;

import dao.comment.CommentDaoImpl;
import main.vo.FboardCmntVO;

public class CommentServiceImpl implements ICommentService{
	private static CommentServiceImpl service;
	private static CommentDaoImpl dao;
	
	private CommentServiceImpl() {
		dao = CommentDaoImpl.getInstance();
	}
	
	public static CommentServiceImpl getInstance() {
		if(service == null) service = new CommentServiceImpl();
		
		return service;
	}
	
	
	

	@Override
	public void insertComment(FboardCmntVO fboardCmntVo) {
		dao.insertComment(fboardCmntVo);
		
	}
	
	@Override
	public void updateComment(FboardCmntVO fboardCmntVo) {
		dao.updateComment(fboardCmntVo);
	}
	
	@Override
	public void deleteCommnet(int cmnt_no) {
		dao.deleteCommnet(cmnt_no);
	}

	@Override
	public List<FboardCmntVO> getAllCommentList(int free_board_no) {
		return dao.getAllCommentList(free_board_no);
	}
	

	@Override
	public void insertCmntCmnt(FboardCmntVO fboardCmntVo) {
		dao.insertCmntCmnt(fboardCmntVo);
	}

	@Override
	public List<FboardCmntVO> getAllFBoardCmntCmntList(Map<String, Integer> params) {
		return dao.getAllFBoardCmntCmntList(params);
	}
	
	
	
	
	
}
