package service.advice;

import java.util.List;

import dao.advice.AdviceDaoImpl;
import main.vo.AdviceVO;

public class AdviceServiceImpl implements IAdviceService {
	private static AdviceServiceImpl service;
	private static AdviceDaoImpl dao;

	private AdviceServiceImpl() {
		dao = AdviceDaoImpl.getInstance();
	}

	public static AdviceServiceImpl getInstance() {
		if (service == null) {
			service = new AdviceServiceImpl();
		}
		return service;
	}

	@Override
	public List<AdviceVO> getjavaadviceList() {
		// TODO Auto-generated method stub
		return dao.getjavaadviceList();
	}

	@Override
	public List<AdviceVO> getoracleList() {
		// TODO Auto-generated method stub
		return dao.getoracleList();
	}

	@Override
	public List<AdviceVO> getsearchjava(String tagjava) {
		// TODO Auto-generated method stub
		return dao.getsearchjava(tagjava);
	}

	@Override
	public List<AdviceVO> getsearchoracle(String tagoracle) {
		// TODO Auto-generated method stub
		return dao.getsearchoracle(tagoracle);
	}

	@Override
	public List<AdviceVO> getSearch(String advtitle) {
		// TODO Auto-generated method stub
		return dao.getSearch(advtitle);
	}

	
}
