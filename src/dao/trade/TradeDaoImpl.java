package dao.trade;

import com.ibatis.sqlmap.client.SqlMapClient;

import dao.util.BuildedSqlMapClient;

public class TradeDaoImpl implements ITradeDao {
	private static TradeDaoImpl dao;
	private SqlMapClient smc;

	private TradeDaoImpl() {
		smc = BuildedSqlMapClient.getSqlMapClient();
	}

	public static TradeDaoImpl getInstance() {
		if (dao == null) {
			dao = new TradeDaoImpl();
		}
		return dao;
	}
}
