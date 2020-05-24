package service.admin;

import java.util.List;
import java.util.Map;

import dao.admin.AdminDaoImpl;
import main.vo.AdminLineChartVO;
import main.vo.RepotMemberVO;

public class AdminServiceImpl implements IAdminSevice{
	
	private static AdminServiceImpl service;
	private static AdminDaoImpl dao;

	private AdminServiceImpl() {
		dao = AdminDaoImpl.getInstance();
	}

	public static AdminServiceImpl getInstance() {
		if (service == null) {
			service = new AdminServiceImpl();
		}
		return service;
	}

	@Override
	public boolean isExistadminId(String admin_id) {
		return dao.isExistadminId(admin_id);
	}

	@Override
	public boolean isExistAccount(Map<String, String> params) {
		return dao.isExistAccount(params);
	}

	@Override
	public AdminLineChartVO getLctMember() {
		return dao.getLctMember();
	}

	@Override
	public List<RepotMemberVO> getAllmemberlist() {
		return dao.getAllmemberlist();
	}

}
