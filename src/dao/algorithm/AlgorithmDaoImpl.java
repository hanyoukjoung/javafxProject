package dao.algorithm;

import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import dao.util.BuildedSqlMapClient;
import main.vo.AlgCateVO;
import main.vo.AlgorithmTableVO;
import main.vo.AlgorithmVO;

public class AlgorithmDaoImpl implements IAlgorithmDao {
	private static AlgorithmDaoImpl dao;
	private SqlMapClient smc;

	private AlgorithmDaoImpl() {
		smc = BuildedSqlMapClient.getSqlMapClient();
	}

	public static AlgorithmDaoImpl getInstance() {
		if (dao == null) {
			dao = new AlgorithmDaoImpl();
		}
		return dao;
	}

	@Override
	public List<AlgorithmTableVO> getAlgorithmEx(String alg_cate) {
		List<AlgorithmTableVO> list;
		try {
			list = smc.queryForList("algorithm.getAlgExe", alg_cate);
		} catch (Exception e) {
			list = null;
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean addALGExer(AlgorithmVO alg) {
		boolean result;
		try {
			Object obj = smc.insert("algorithm.addALGExer", alg);
			if (obj == null) {
				result = true;
			} else {
				result = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	@Override
	public List<AlgCateVO> getAllALGCate() {
		List<AlgCateVO> list;
		try {
			list = smc.queryForList("algorithm.getAllAlgCate");
		} catch (Exception e) {
			list = null;
			e.printStackTrace();
		}
		return list;
	}

}
