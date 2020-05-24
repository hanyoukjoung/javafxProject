package dao.lecture;

import java.util.List;

import main.vo.ContentsCttGBVO;
import main.vo.LctProfFileVO;
import main.vo.LectureVO;
import main.vo.MEMShowMYLCTVO;
import main.vo.PaidMemVO;
import main.vo.SubslctevalVO;



public interface ILectureDao {
	
	public List<MEMShowMYLCTVO> getALLlectureList(String mem_id);
	
	/**
	 * LectureVO객체에 담겨진 자료를 DB에 insert하는 매서드 
	 * 
	 * @param LectureVO DB에 insert할 자료가 저장된 LectureVO객체
	 * @return 작업성공:1,작업실패:0
	 * 
	 */
	public int insertLecture(LectureVO LectureVO);
	
	public int insertimg(LctProfFileVO LctProfFileVO);
	
	public int getpaid(String mem_id);
	
	public int insertpaylecture(LectureVO LectureVO);
	
//	public int deleteimg(int lct_no);
	
	public List<ContentsCttGBVO> getallvideolist(int lct_no);
    
	public int deletelecture(int lct_no);
	
	public int updatelecture(LectureVO LectureVO);
	
	public int updateimg(LctProfFileVO lctprofFileVO);
}
