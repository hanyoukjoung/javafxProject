package dao.lecture;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import dao.util.BuildedSqlMapClient;
import main.vo.ContentsCttGBVO;
import main.vo.LctProfFileVO;
import main.vo.LectureVO;
import main.vo.MEMShowMYLCTVO;
import main.vo.PaidMemVO;
import main.vo.SubslctevalVO;

public class LectureDaoImpl implements ILectureDao {
	private static LectureDaoImpl dao;
	private SqlMapClient smc;
	private int lct_no;
	
	
	private LectureDaoImpl() {
		smc = BuildedSqlMapClient.getSqlMapClient();
	}

	public static LectureDaoImpl getInstance() {
		if (dao == null) {
			dao = new LectureDaoImpl();
		}
		return dao;
	}

	

	

	@Override
	public int insertimg(LctProfFileVO LctProfFileVO) {
		LctProfFileVO.setLct_no(lct_no);
		System.out.println("lct_no" + lct_no);
		int cnt =0;
		try {
			smc.insert("lecture.insertimg",LctProfFileVO);
		} catch (SQLException e) {
			cnt=0;
			e.printStackTrace();
		}
		return cnt;
	}
	
	

	

	@Override
	public int insertLecture(LectureVO LectureVO) {
		int cnt = 0;
		try {
			lct_no = (int) smc.insert("lecture.insertfreelecture",LectureVO);
			
		} catch (SQLException e) {
			cnt=0;
			e.printStackTrace();
		}
		return cnt;
	}
	
	@Override
	public int insertpaylecture(LectureVO LectureVO) {
		int cnt =0;
		try {
			lct_no = (int) smc.insert("lecture.insertpaylecture",LectureVO);
		} catch (Exception e) {
			cnt =0;
			e.printStackTrace();
		}
		
		return cnt;
	}

	

//	@Override
//	public SubslctevalVO getSubslcteval(String mem_id) {
//		SubslctevalVO subslcteval = null;
//		try {
//			subslcteval =(SubslctevalVO) smc.queryForObject("lecture.getpaidmem",mem_id);
//			
//		} catch (SQLException e) {
//			subslcteval =null;
//		}
//		return subslcteval;
//	}
//	
	@Override
	public int getpaid(String mem_id) {
		if(mem_id==null) mem_id="";
		int cnt =0;
		try {
			cnt=(int) smc.queryForObject("lecture.getpaidmem",mem_id);
		} catch (SQLException e) {
			cnt=0;
			e.printStackTrace();
		}
		return cnt;
	}
	
	@Override
	public List<MEMShowMYLCTVO> getALLlectureList(String mem_id) {
		List<MEMShowMYLCTVO> LectureList = new ArrayList<MEMShowMYLCTVO>();
		try {
			LectureList = smc.queryForList("lecture.getALLlectureList",mem_id);
		} catch (SQLException e) {
			LectureList =null;
		}
		return LectureList;
	}
	
	
	@Override
	public List<ContentsCttGBVO> getallvideolist(int lct_no) {
		
		List<ContentsCttGBVO> getallvideolist;
		
		
		try {
			getallvideolist = smc.queryForList("lecture.getallvideolist",lct_no);
		} catch (SQLException e) {
			getallvideolist = null;
			e.printStackTrace();
		}
		return getallvideolist;
	}

	@Override
	public int deletelecture(int lct_no) {
		int cnt =0;
		try {
			cnt = smc.delete("lecture.deletelecture",lct_no);
		} catch (SQLException e) {
			cnt =0;
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updatelecture(LectureVO LectureVO) {
		int cnt =0;
		try {
			cnt = smc.update("lecture.updatelecture",LectureVO);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
			
		}
		return cnt;
	}
	

	@Override
	public int updateimg(LctProfFileVO lctprofFileVO) {
		int cnt =0;
		try {
			cnt = smc.update("lecture.updateimg",lctprofFileVO);
		} catch (Exception e) {
			cnt =0;
			e.printStackTrace();
		}
		return cnt;
	}


	
//	@Override
//	public int deleteimg(int lct_no) {
//		int cnt =0;
//		try {
//			cnt = smc.delete("lecture.deleteimgfile",lct_no);
//			
//		} catch (SQLException e) {
//			cnt=0;
//			e.printStackTrace();
//		}
//		return cnt;
//	}
}
