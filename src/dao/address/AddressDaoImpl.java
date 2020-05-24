package dao.address;

import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import dao.util.BuildedSqlMapClient;
import main.vo.AddrVO;

public class AddressDaoImpl implements IAddressDao{
	private static AddressDaoImpl dao;
	private SqlMapClient smc;
	
	private AddressDaoImpl() {
		smc = BuildedSqlMapClient.getSqlMapClient();
	}
	
	public static AddressDaoImpl getInstance() {
		if(dao == null) {
			dao = new AddressDaoImpl();
		}
		return dao;
	}

	@Override
	public List<AddrVO> getSearchAddr(Map<String, String> params) {
		List<AddrVO> list;
		try {
			list = smc.queryForList("address.getSearchAddr", params);
		} catch (Exception e) {
			e.printStackTrace();
			list = null;
		}
		return list;
	}
}
