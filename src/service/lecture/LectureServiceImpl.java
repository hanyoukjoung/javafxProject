package service.lecture;

import java.util.List;

import dao.lecture.LectureDaoImpl;
import main.vo.ContentsCttGBVO;
import main.vo.LctProfFileVO;
import main.vo.LectureVO;
import main.vo.MEMShowMYLCTVO;
import main.vo.PaidMemVO;
import main.vo.SubslctevalVO;


public class LectureServiceImpl implements ILectureService {
	private static LectureServiceImpl service;
	private static LectureDaoImpl dao;

	private LectureServiceImpl() {
		dao = LectureDaoImpl.getInstance();
	}

	public static LectureServiceImpl getInstance() {
		if (service == null) {
			service = new LectureServiceImpl();
		}
		return service;
	}

	@Override
	public List<MEMShowMYLCTVO> getALLlectureList(String mem_id) {
		// TODO Auto-generated method stub
		return dao.getALLlectureList(mem_id);
	}

	@Override
	public int insertLecture(LectureVO LectureVO) {
		// TODO Auto-generated method stub
		return dao.insertLecture(LectureVO);
	}

	@Override
	public int insertimg(LctProfFileVO LctProfFileVO) {
		
		return dao.insertimg(LctProfFileVO);
		
	}

	

	@Override
	public int insertpaylecture(LectureVO LectureVO) {
		
		return dao.insertpaylecture(LectureVO);
	}

	@Override
	public int getpaid(String mem_id) {
		// TODO Auto-generated method stub
		return dao.getpaid(mem_id);
	}

	@Override
	public List<ContentsCttGBVO> getallvideolist(int lct_no) {
		// TODO Auto-generated method stub
		return dao.getallvideolist(lct_no);
	}

	@Override
	public int deletelecture(int lct_no) {
		// TODO Auto-generated method stub
		return dao.deletelecture(lct_no);
	}

	@Override
	public int updatelecture(LectureVO LectureVO) {
		// TODO Auto-generated method stub
		return dao.updatelecture(LectureVO);
	}

	@Override
	public int updateimg(LctProfFileVO lctprofFileVO) {
		// TODO Auto-generated method stub
		return dao.updateimg(lctprofFileVO);
	}

//	@Override
//	public int deleteimg(int lct_no) {
//		// TODO Auto-generated method stub
//		return dao.deleteimg(lct_no);
//	}

	
	
	

	
	
}