package service.algorithm;

import java.util.List;

import dao.algorithm.AlgorithmDaoImpl;
import main.vo.AlgCateVO;
import main.vo.AlgorithmTableVO;
import main.vo.AlgorithmVO;

public class AlgorithmServiceImpl implements IAlgorithmService {
	private static AlgorithmServiceImpl service;
	private static AlgorithmDaoImpl dao;

	private AlgorithmServiceImpl() {
		dao = AlgorithmDaoImpl.getInstance();
	}

	public static AlgorithmServiceImpl getInstance() {
		if (service == null) {
			service = new AlgorithmServiceImpl();
		}
		return service;
	}

	@Override
	public List<AlgorithmTableVO> getAlgorithmEx(String alg_cate) {
		return dao.getAlgorithmEx(alg_cate);
	}

	@Override
	public boolean addALGExer(AlgorithmVO alg) {
		return dao.addALGExer(alg);
	}

	@Override
	public List<AlgCateVO> getAllALGCate() {
		return dao.getAllALGCate();
	}
	
}
