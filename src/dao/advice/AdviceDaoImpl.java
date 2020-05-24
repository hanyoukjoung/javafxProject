package dao.advice;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import dao.util.BuildedSqlMapClient;
import main.vo.AdviceVO;

public class AdviceDaoImpl implements IAdvideDao {
	private static AdviceDaoImpl dao;
	private SqlMapClient smc;
	
	private AdviceDaoImpl() {
		smc = BuildedSqlMapClient.getSqlMapClient();
	}
	
	public static AdviceDaoImpl getInstance() {
		if(dao == null) {
			dao = new AdviceDaoImpl();
		}
		return dao;
	}

	@Override
	public List<AdviceVO> getjavaadviceList() {
		List<AdviceVO> adviceList = new ArrayList<AdviceVO>();
		try {
			adviceList = smc.queryForList("advice.getjavaadviceList");
		} catch (SQLException e) {
			adviceList=null;
			e.printStackTrace();
		}
		return adviceList;
	}

	@Override
	public List<AdviceVO> getoracleList() {
		List<AdviceVO> adviceoracleList = new ArrayList<AdviceVO>();
		try {
			adviceoracleList = smc.queryForList("advice.getoracleList");
		} catch (SQLException e) {
			adviceoracleList = null;
			e.printStackTrace();
		}
		return adviceoracleList;
	}

	@Override
	public List<AdviceVO> getsearchjava(String tagjava) {
		List<AdviceVO> advicelist = null;
		try {
			advicelist =smc.queryForList("advice.getsearchjava",tagjava);
			
		} catch (SQLException e) {
			advicelist = null;
			e.printStackTrace();
		}
		return advicelist;
	}

	@Override
	public List<AdviceVO> getsearchoracle(String tagoracle) {
		List<AdviceVO> advicelist = null;
		try {
			advicelist =smc.queryForList("advice.getsearchoracle",tagoracle);
			
		} catch (SQLException e) {
			advicelist = null;
			e.printStackTrace();
		}
		return advicelist;
	}

	@Override
	public List<AdviceVO> getSearch(String advtitle) {
		if(advtitle==null) advtitle ="";
		List<AdviceVO> advlist = null;
		try {
			advlist = smc.queryForList("advice.getsearch",advtitle);
		} catch (SQLException e) {
			advlist = null;
			e.printStackTrace();
		}		
		return advlist;
	}
	
	
	
	
}
