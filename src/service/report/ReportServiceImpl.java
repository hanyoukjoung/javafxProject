package service.report;

import java.util.List;

import dao.report.ReportDaoImpl;
import main.vo.ReportCateVO;
import main.vo.ReportVO;

public class ReportServiceImpl implements IReportService{
	private static ReportServiceImpl service;
	private static ReportDaoImpl dao;
	
	private ReportServiceImpl() {
		dao = ReportDaoImpl.getInstance();
	}
	
	public static ReportServiceImpl getInstance() {
		if(service == null) service = new ReportServiceImpl();
		return service;
	}

	
	
	
	@Override
	public List<ReportCateVO> getAllReportCateList() {
		return dao.getAllReportCateList();
	}

	@Override
	public int insertReport(ReportVO reportVo) {
		return dao.insertReport(reportVo);
	}
	
	
}
