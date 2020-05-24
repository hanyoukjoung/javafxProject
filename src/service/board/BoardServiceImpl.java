package service.board;

import java.util.List;
import java.util.Map;

import dao.board.BoardDaoImpl;
import main.vo.FAQBoardVO;
import main.vo.FboardVO;
import main.vo.LboardVO;
import main.vo.NBoardVO;
import main.vo.TotalBoardVO;

public class BoardServiceImpl implements IBoardService {
	private static BoardServiceImpl service;
	private static BoardDaoImpl dao;

	private BoardServiceImpl() {
		dao = BoardDaoImpl.getInstance();
	}

	public static BoardServiceImpl getInstance() {
		if (service == null) {
			service = new BoardServiceImpl();
		}
		return service;
	}
	
	@Override
	public List<LboardVO> selectBoard(){
		return dao.selectBoard();
	}
	
	@Override
	public void insertLBoard(LboardVO lBoardVo) {
		dao.insertLBoard(lBoardVo);
	}

	@Override
	public List<TotalBoardVO> getAllFBoardList() {
		return dao.getAllFBoardList();
	}

	@Override
	public List<TotalBoardVO> getAllFAQBoardList() {
		return dao.getAllFAQBoardList();
	}

	@Override
	public void insertFBoard(FboardVO fboardVo) {
		dao.insertFBoard(fboardVo);
	}

	@Override
	public void deleteFBoard(int free_board_no) {
		dao.deleteFBoard(free_board_no);
	}

	@Override
	public void cntPlusFBoard(Map<String, Object> params) {
		dao.cntPlusFBoard(params);		
	}

	@Override
	public void updateFBoard(FboardVO fboardVo) {
		dao.updateFBoard(fboardVo);
	}

	@Override
	public void insertFAQBoard(FAQBoardVO faqBoardVo) {
		dao.insertFAQBoard(faqBoardVo);
	}
	
	@Override
	public void deleteFAQBoard(int faqBoard_no) {
		dao.deleteFAQBoard(faqBoard_no);
	}

	@Override
	public void insertNBoard(NBoardVO nBoardVo) {
		dao.insertNBoard(nBoardVo);
	}

	@Override
	public List<TotalBoardVO> getAllReportFBoard() {
		return dao.getAllReportFBoard();
	}
	
	
	
	
}
