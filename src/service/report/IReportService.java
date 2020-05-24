package service.report;

import java.util.List;

import main.vo.ReportCateVO;
import main.vo.ReportVO;

public interface IReportService {
	/**
	 * 신고 카테고리 리스트를 가져오는 메서드
	 * @return ReportCateVO타입 리스트
	 */
	List<ReportCateVO> getAllReportCateList();
	
	/**
	 * repoertVO를 insert하는 메서드 
	 * @param reportVo
	 */
	int insertReport(ReportVO reportVo);
	

}
