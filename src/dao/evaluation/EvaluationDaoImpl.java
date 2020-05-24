package dao.evaluation;

import com.ibatis.sqlmap.client.SqlMapClient;

import dao.util.BuildedSqlMapClient;

public class EvaluationDaoImpl implements IEvaluationDao {
	private static EvaluationDaoImpl dao;
	private SqlMapClient smc;

	private EvaluationDaoImpl() {
		smc = BuildedSqlMapClient.getSqlMapClient();
	}

	public static EvaluationDaoImpl getInstance() {
		if (dao == null) {
			dao = new EvaluationDaoImpl();
		}
		return dao;
	}
}
