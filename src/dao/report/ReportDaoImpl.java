package dao.report;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import dao.util.BuildedSqlMapClient;
import main.vo.ReportCateVO;
import main.vo.ReportVO;

public class ReportDaoImpl implements IReportDao{
	private static ReportDaoImpl dao;
	private SqlMapClient smc;
	
	private ReportDaoImpl() {
		smc = BuildedSqlMapClient.getSqlMapClient();
	}
	
	public static ReportDaoImpl getInstance() {
		if(dao == null) dao = new ReportDaoImpl();
		return dao;
	}
	
	

	@Override
	public List<ReportCateVO> getAllReportCateList() {
		List<ReportCateVO> reportCateList = null;
		
		try {
			reportCateList = smc.queryForList("report.getAllReportCateList");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reportCateList;
	}

	@Override
	public int insertReport(ReportVO reportVo) {
		int result=0;
		Object obj;
		try {
			obj = smc.insert("report.insertReport",reportVo);
			if(obj == null) result=1;
		} catch (SQLException e) {
			result=0;
			e.printStackTrace();
		}
		return result;
	}
	
	
}
