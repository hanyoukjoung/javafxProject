package service.code;

import dao.code.CodeDaoImpl;

public class CodeServiceImpl implements ICodeService {
	private static CodeServiceImpl service;
	private static CodeDaoImpl dao;

	private CodeServiceImpl() {
		dao = CodeDaoImpl.getInstance();
	}

	public static CodeServiceImpl getInstance() {
		if (service == null) {
			service = new CodeServiceImpl();
		}
		return service;
	}
}
