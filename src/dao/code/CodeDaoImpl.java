package dao.code;

import com.ibatis.sqlmap.client.SqlMapClient;

import dao.util.BuildedSqlMapClient;

public class CodeDaoImpl implements ICodeDao {
	private static CodeDaoImpl dao;
	private SqlMapClient smc;

	private CodeDaoImpl() {
		smc = BuildedSqlMapClient.getSqlMapClient();
	}

	public static CodeDaoImpl getInstance() {
		if (dao == null) {
			dao = new CodeDaoImpl();
		}
		return dao;
	}
}
