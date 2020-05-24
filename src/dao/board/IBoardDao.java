package dao.board;

import java.util.List;
import java.util.Map;

import main.vo.FAQBoardVO;
import main.vo.FboardVO;
import main.vo.LboardVO;
import main.vo.NBoardVO;
import main.vo.TotalBoardVO;

public interface IBoardDao {
	/**
	 * 레슨게시판 전체 게시글을 가져오는 메서드 
	 * @return LboardVO타입의 List를 반환한다 
	 */
	List<LboardVO> selectBoard();
	
	/**
	 * 레슨게시판에 insert하는 메서드 
	 * @param lBoardVo
	 * @since 2020-02-05
	 * @author 정수민
	 */
	void insertLBoard(LboardVO lBoardVo);
	
	/**
	 * 자유게시판 전체 게시글을 가져오는 메서드
	 * @return TotalBoardVO 타입의 List를 반환한다 
	 * @since 2020-02-04
	 * @author 정수민
	 */
	List<TotalBoardVO> getAllFBoardList();
	
	/**
	 * FAQ게시판 전체 게시글을 가져오는 메서드 
	 * @return TotalBoardVO 타입의 List를 반환한다 
	 * @since 2020-02-04
	 * @author 정수민
	 */
	List<TotalBoardVO> getAllFAQBoardList();
	
	/**
	 * 자유게시판에 게시글을 insert 하는 메서드 
	 * @since 2020-02-04
	 * @author 정수민 
	 */
	void insertFBoard(FboardVO fboardVo);
	
	/**
	 * 자유게시판 게시글의 게시글 번호를 매개변수로 받아 해당 게시글을 delete하는 메서드 
	 * @param free_board_no
	 */
	void deleteFBoard(int free_board_no);
	
	/**
	 * 상세보기한 자유게시판 게시글의 조회수를 증가시키는 메서드 
	 * @param free_board_no
	 */
	void cntPlusFBoard(Map<String, Object> params);
	
	/**
	 * 자유게시판 게시글을 수정하는 메서드
	 * @param fboardVo
	 */
	void updateFBoard(FboardVO fboardVo);
	
	/**
	 * FAQ게시판 게시글 insert하는 메서드 
	 * @param faqBoardVo
	 */
	void insertFAQBoard(FAQBoardVO faqBoardVo);
	
	/**
	 * faq게시판 게시글을 삭제하는 메서드
	 * @param faqBoard_no
	 */
	void deleteFAQBoard(int faqBoard_no);
	
	/**
	 * 공지게시판 게시글을 insert하는 메서드
	 * @param nBoardVo
	 */
	void insertNBoard(NBoardVO nBoardVo);
	
	/**
	 * 신고당한 게시글 List를 가져오는 메서드
	 * @return
	 */
	List<TotalBoardVO> getAllReportFBoard();
}
