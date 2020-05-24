package dao.advice;

import java.util.List;

import main.vo.AdviceVO;

public interface IAdvideDao {
	public List<AdviceVO> getjavaadviceList();
	
	public List<AdviceVO> getoracleList();
	
	public List<AdviceVO> getsearchjava(String tagjava); 
	
	public List<AdviceVO> getsearchoracle(String tagoracle);
	
	public List<AdviceVO> getSearch(String advtitle);
}
