package service.comment;

import java.util.List;
import java.util.Map;

import main.vo.FboardCmntVO;

public interface ICommentService {
	
	/**
	 * 자유게시판 댓글을 insert하는 메서드 
	 * @param fboardCmntVo
	 */
	void insertComment(FboardCmntVO fboardCmntVo);
	
	/**
	 * 댓글을 update하는 메서드
	 * @param fboardCmntVo
	 */
	void updateComment(FboardCmntVO fboardCmntVo);
	
	/**
	 * 댓글을 delete하는 메서드 
	 * @param cmnt_no
	 */
	void deleteCommnet(int cmnt_no);
	
	/**
	 * 자유게시판 해당 게시글의 댓글 리스트를 반환하는 메서드 
	 * @param free_board_no
	 * @return FboardCmntVO타입의 리스트 
	 */
	List<FboardCmntVO> getAllCommentList(int free_board_no);
	
	/**
	 * 타겟이 있는 댓글(대댓글)을 insert하는 메서드 
	 * @param fboardCmntVo
	 */
	void insertCmntCmnt(FboardCmntVO fboardCmntVo);
	
	/**
	 * 자유게시판 해당 게시글의 대댓글 리스트를 반환하는 메서드 
	 * 키="free_board_no" 값 ="자유게시판 게시글 번호"
	 * 키="cmnt_target" 값 ="타겟 댓글 번호"
	 * @param map
	 * @return FboardCmntVO타입의 리스트
	 */
	List<FboardCmntVO> getAllFBoardCmntCmntList(Map<String, Integer> params);

}
