package service.lecture;

import java.util.List;

import main.vo.ContentsCttGBVO;
import main.vo.LctProfFileVO;
import main.vo.LectureVO;
import main.vo.MEMShowMYLCTVO;
import main.vo.PaidMemVO;
import main.vo.SubslctevalVO;

public interface ILectureService {
	/**
	 * JDBC_BOARD테이블의 전체 레코드를 가져와 List에 담아서 반환하는 메서드
	 * 
	 * @return JdbcBoardVO객체를 담고 있는 List객체
	 */
	public List<MEMShowMYLCTVO> getALLlectureList(String mem_id);
	
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
