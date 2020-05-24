package service.algorithm;

import java.util.List;

import main.vo.AlgCateVO;
import main.vo.AlgorithmTableVO;
import main.vo.AlgorithmVO;

public interface IAlgorithmService {

	/**
	 * 선택한 카테고리에 해당하는 문제들을 리스트에 담아 반환하는 메서드
	 * @param alg_cate 선택한 카테고리
	 * @return 선택한 카테고리가 담긴 list
	 * @author 우영래
	 * @since 2020-02-05
	 */
	List<AlgorithmTableVO> getAlgorithmEx(String alg_cate);
	
	/**
	 * 알고리즘 문제를 데이터베이스에 등록하는 메서드
	 * @param alg 등록한 알고리즘 문제
	 * @return 등록에 성공하면 true 실패하면 false 반환
	 * @author 우영래
	 * @since 2020-02-06
	 */
	boolean addALGExer(AlgorithmVO alg);
	
	/**
	 * 알고리즘 카테고리를 전부 리스트에 담아 반환하는 메서드
	 * @return 알고리즘 카테고리를 전부 담은 list
	 * @author 우영래
	 * @since 2020-02-08
	 */
	List<AlgCateVO> getAllALGCate();
	
}
