package dao.admin;

import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import dao.util.BuildedSqlMapClient;
import main.vo.AdminLineChartVO;
import main.vo.RepotMemberVO;

public class AdminDaoImpl implements IAdminDao {
	private static AdminDaoImpl dao;
	private SqlMapClient smc;

	private AdminDaoImpl() {
		smc = BuildedSqlMapClient.getSqlMapClient();
	}

	public static AdminDaoImpl getInstance() {
		if (dao == null) {
			dao = new AdminDaoImpl();
		}
		return dao;
	}
	
	@Override
	public boolean isExistadminId(String admin_id) {
		boolean result;
		try {
			int tmp = (int) smc.queryForObject("admin.isExistadminId", admin_id);
			if (tmp == 1) {
				result = true;
			} else {
				result = false;
			}
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * ID와 비밀번호(암호화된)가 데이터베이스에서 일치하는지 체크하는 메서드
	 * 
	 * @param params ID와 비밀번호(암호화된)
	 * @return 일치한다면 true 그렇지 않으면 false
	 * @author 김범수
	 * @since 2020-01-30
	 */
	@Override
	public boolean isExistAccount(Map<String, String> params) {
		boolean result;
		try {
			int tmp = (int) smc.queryForObject("admin.isExistAccount", params);
			if (tmp == 1) {
				result = true;
			} else {
				result = false;
			}
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	// 강의,회원 차트
	@Override
	public AdminLineChartVO getLctMember() {
		AdminLineChartVO result = null;
		try {
			result = (AdminLineChartVO)smc.queryForObject("admin.getLctMember");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	
	//관리자회원관리
	@Override
	public List<RepotMemberVO> getAllmemberlist() {
		List<RepotMemberVO> list = null;
		try {
			list = smc.queryForList("admin.getAllmemberlist");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(RepotMemberVO rptMem : list) {
			rptMem.setLang_major(rptMem.getLang_major().equals("1")? "JAVA" : 
								 rptMem.getLang_major().equals("2")? "C++"  :
								 rptMem.getLang_major().equals("3")? "ORACLE" : "PYTHON");
//			System.out.println("rptMem.getLang_major()"+rptMem.getLang_major());
			rptMem.setLang_itrst(rptMem.getLang_itrst().equals("1")? "JAVA" : 
								 rptMem.getLang_itrst().equals("2")? "C++"  :
								 rptMem.getLang_itrst().equals("3")? "ORACLE" : "PYTHON");
//			System.out.println("rptMem.getLang_itrst()"+rptMem.getLang_itrst());
		}
		
		return list;
	}

	

}
