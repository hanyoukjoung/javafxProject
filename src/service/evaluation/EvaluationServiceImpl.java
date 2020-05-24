package service.evaluation;

import dao.evaluation.EvaluationDaoImpl;

public class EvaluationServiceImpl implements IEvaluationSercice {
	private static EvaluationServiceImpl service;
	private static EvaluationDaoImpl dao;

	private EvaluationServiceImpl() {
		dao = EvaluationDaoImpl.getInstance();
	}

	public static EvaluationServiceImpl getInstance() {
		if (service == null) {
			service = new EvaluationServiceImpl();
		}
		return service;
	}
}
