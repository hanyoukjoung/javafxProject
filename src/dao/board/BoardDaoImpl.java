package dao.board;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import dao.util.BuildedSqlMapClient;
import main.vo.FAQBoardVO;
import main.vo.FboardVO;
import main.vo.LboardVO;
import main.vo.NBoardVO;
import main.vo.TotalBoardVO;

public class BoardDaoImpl implements IBoardDao{
	private static BoardDaoImpl dao;
	private SqlMapClient smc;

	private BoardDaoImpl() {
		smc = BuildedSqlMapClient.getSqlMapClient();
	}

	public static BoardDaoImpl getInstance() {
		if (dao == null) {
			dao = new BoardDaoImpl();
		}
		return dao;
	}

	@Override
	public List<LboardVO> selectBoard() {
		List<LboardVO> list;
		try {
			list = smc.queryForList("board.selectBoard");
		} catch (Exception e) {
			list = null;
			e.printStackTrace();
		}
		return list;
	}
	

	@Override
	public void insertLBoard(LboardVO lBoardVo) {
		Object obj;
		
		try {
			
			obj = smc.insert("board.insertLBoard",lBoardVo);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<TotalBoardVO> getAllFBoardList() {
		List<TotalBoardVO> boardVo = null;
		List<TotalBoardVO> fBoardVo = null;
		
		try {
			
			boardVo = smc.queryForList("board.getAllNBoardList");
			
			int no = boardVo.size();
			for(TotalBoardVO bList : boardVo){
				bList.setNo(no--);
				bList.setMem_id("관리자");
				bList.setBoard_title("[공지사항] "+bList.getBoard_title());
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
//		for(TotalBoardVO addList : NBoardVo) {
//			totalBoardVo.add(addList);
//		}
		
		try {
			
			fBoardVo = smc.queryForList("board.getAllFBoardList");
		
			int no = fBoardVo.size();
			for(TotalBoardVO bList : fBoardVo){
				bList.setNo(no--);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
//		for(TotalBoardVO addList : fBoardVo) {
//			totalBoardVo.add(addList);
//		}
		boardVo.addAll(fBoardVo);
		return boardVo;
	}

	@Override
	public List<TotalBoardVO> getAllFAQBoardList() {
		List<TotalBoardVO> faqBoardVo = null;
		
		try {
			
			faqBoardVo = smc.queryForList("board.getAllFAQBoardList");
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		int no = faqBoardVo.size();
		for(TotalBoardVO bList : faqBoardVo){
			bList.setNo(no--);
		}
		
		return faqBoardVo;
	}

	@Override
	public void insertFBoard(FboardVO fboardVo) {
		Object obj;
		
		try {
			
			obj = smc.insert("board.insertFBoard",fboardVo);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteFBoard(int free_board_no) {
		int cnt; 
		try {
			
			cnt = smc.delete("board.deleteFBoard",free_board_no);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void cntPlusFBoard(Map<String, Object> params) {
		int cnt;
		try {
			cnt = smc.update("board.cntPlusFBoard",params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateFBoard(FboardVO fboardVo) {
		int cnt;
		
		try {
			
			cnt = smc.update("board.updateFBoard",fboardVo);
			
			System.out.println("dao"+cnt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertFAQBoard(FAQBoardVO faqBoardVo) {
		Object obj;
		
		try {
			obj = smc.insert("board.insertFAQBoard",faqBoardVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}  
	}
	
	

	@Override
	public void deleteFAQBoard(int faqBoard_no) {
		int cnt;
		
		try {
			cnt = smc.delete("board.deleteFAQBoard",faqBoard_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertNBoard(NBoardVO nBoardVo) {
		
	}

	@Override
	public List<TotalBoardVO> getAllReportFBoard() {
		List<TotalBoardVO> reportFBoardList =null;
		
		try {
			
			reportFBoardList = smc.queryForList("board.getAllReportFBoard");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		int no = reportFBoardList.size();
		for(TotalBoardVO bList : reportFBoardList){
			bList.setNo(no--);
		}
		
		return reportFBoardList;
	}
	
	
	
	
}
