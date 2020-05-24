package service.member;

import java.util.List;
import java.util.Map;

import dao.member.MemberDaoImpl;
import main.vo.GenderChartVO;
import main.vo.MemFileVO;
import main.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {
	private static MemberServiceImpl service;
	private static MemberDaoImpl dao;

	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}

	public static MemberServiceImpl getInstance() {
		if (service == null) {
			service = new MemberServiceImpl();
		}
		return service;
	}

	@Override
	public boolean isExistMemId(String mem_id) {
		return dao.isExistMemId(mem_id);
	}

	@Override
	public boolean isExistAccount(Map<String, String> params) {
		return dao.isExistAccount(params);
	}

	@Override
	public boolean memberJoin(MemberVO member) {
		return dao.memberJoin(member);
	}

	@Override
	public MemberVO getMemberData(String mem_id) {
		return dao.getMemberData(mem_id);
	}

	@Override
	public boolean updateMemPass(Map<String, String> params) {
		return dao.updateMemPass(params);
	}

	@Override
	public List<String> getMemId(Map<String, String> params) {
		return dao.getMemId(params);
	}

	@Override
	public MemFileVO getMemberFile(String mem_id) {
		return dao.getMemberFile(mem_id);
	}

	@Override
	public GenderChartVO getMemStat() {
		return dao.getMemStat();
	}

	@Override
	public boolean updateMember(MemberVO mem) {
		return dao.updateMember(mem);
	}

	@Override
	public boolean deleteMemAccount(String mem_id) {
		return dao.deleteMemAccount(mem_id);
	}
}
