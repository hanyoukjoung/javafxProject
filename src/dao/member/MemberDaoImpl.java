package dao.member;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import dao.util.BuildedSqlMapClient;
import main.vo.GenderChartVO;
import main.vo.MemFileVO;
import main.vo.MemberVO;

public class MemberDaoImpl implements IMemberDao {
	private static MemberDaoImpl dao;
	private SqlMapClient smc;

	private MemberDaoImpl() {
		smc = BuildedSqlMapClient.getSqlMapClient();
	}

	public static MemberDaoImpl getInstance() {
		if (dao == null) {
			dao = new MemberDaoImpl();
		}
		return dao;
	}

	/**
	 * ID가 데이터베이스에 존재하는지 검사하는 메서드
	 * 
	 * @param mem_id 검사할 회원 ID
	 * @return 데이터베이스에 존재하면 true 그렇지 않다면 false;
	 * @author 우영래
	 * @since 2020-01-30
	 */
	@Override
	public boolean isExistMemId(String mem_id) {
		boolean result;
		try {
			int tmp = (int) smc.queryForObject("member.isExistMemId", mem_id);
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
	 * @author 우영래
	 * @since 2020-01-30
	 */
	@Override
	public boolean isExistAccount(Map<String, String> params) {
		boolean result;
		try {
			int tmp = (int) smc.queryForObject("member.isExistAccount", params);
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
	 * 회원가입에 필요한 정보를 데이터베이스에 추가하는 메서드
	 * 
	 * @param member 회원가입에 필요한 정보를 담은 VO
	 * @return 등록에 성공하면 true 실패하면 false
	 * @author 우영래
	 * @since 2020-01-31
	 */
	@Override
	public boolean memberJoin(MemberVO member) {
		boolean result;
		try {
			Object obj = smc.insert("member.memberJoin", member);
			if (obj == null) {
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

	@Override
	public MemberVO getMemberData(String mem_id) {
		MemberVO mem;
		try {
			mem = (MemberVO) smc.queryForObject("member.getMemberData", mem_id);
		} catch (Exception e) {
			mem = null;
			e.printStackTrace();
		}
		return mem;
	}

	@Override
	public boolean updateMemPass(Map<String, String> params) {
		boolean result;
		try {
			int tmp = smc.update("member.updateMemPass", params);
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

	@Override
	public List<String> getMemId(Map<String, String> params) {
		List<String> result;
		try {
			result = smc.queryForList("member.getMemId", params);
		} catch (Exception e) {
			result = null;
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public MemFileVO getMemberFile(String mem_id) {
		MemFileVO result = null;
		try {
			result = (MemFileVO) smc.queryForObject("member.getMemberFile", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}

	@Override
	public GenderChartVO getMemStat() {
		GenderChartVO result = null;
		try {
			result = (GenderChartVO) smc.queryForObject("member.getMemStat");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean updateMember(MemberVO mem) {
		boolean result;
		try {
			int tmp = smc.update("member.updateMember", mem);
			if (tmp == 1) {
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
	public boolean deleteMemAccount(String mem_id) {
		boolean result;
		try {
			int tmp = smc.update("member.deleteMemAccount", mem_id);
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
}
