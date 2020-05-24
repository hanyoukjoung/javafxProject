package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import main.vo.AlgCateVO;
import main.vo.AlgorithmVO;
import service.algorithm.AlgorithmServiceImpl;

public class AdminAddALGController {
	
	private AlgorithmServiceImpl algService;
	private List<AlgCateVO> list;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane subFrameAlgInsert;

    @FXML
    private TextArea taAlgExerCode;

    @FXML
    private TextArea taAlgExerCont;

    @FXML
    private TextField tfAlgExerTitle;

    @FXML
    private ComboBox<String> comboAlgCate;

    @FXML
    private Label lblMainTitle;

    @FXML
    private Button btnAlgExerInsert;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnAddCRCTCode;

    // 문제 정답 소스 추가 버튼
    @FXML
    void btnAddCRCTCodeClick(ActionEvent event) {
    	
    }

    // 문제 등록하기 버튼
    @FXML
    void btnAlgExerInsertClick(ActionEvent event) {
    	if(tfAlgExerTitle.getText().isEmpty() || comboAlgCate.getSelectionModel().isEmpty() ||
    	   taAlgExerCode.getText().isEmpty() || taAlgExerCont.getText().isEmpty()) {
    		return;
    	}else {
    		AlgorithmVO alg = new AlgorithmVO();
    		List<AlgCateVO> list = algService.getAllALGCate();
    		int algCateNo = 0;
    		for(int i = 0; i < list.size(); i++) {
    			String comboAlgCateItem = comboAlgCate.getSelectionModel().getSelectedItem();
    			if(comboAlgCateItem.equals(list.get(i).getAlg_cate())) {
    				algCateNo = list.get(i).getAlg_cate_no();
    			}
    		}
    		alg.setAlg_cate_no(algCateNo); // 알고리즘문제 카테고리 번호
    		alg.setAlg_cnt(0); // 조회수
    		alg.setAlg_cont(taAlgExerCont.getText()); // 문제 내용
    		alg.setAlg_crct_cnt(0); // 정답수
    		alg.setAlg_sbmit_cnt(0); // 제출수 
    		alg.setAlg_title(tfAlgExerTitle.getText()); // 기본 코드 폼
    		alg.setLang_no(1); // 일단 자바만 가능하니까 자바는 1번이므로 1
    		
    		if(algService.addALGExer(alg)) {
    			// 등록 성공
    		} else {
    			// 등록 실패
    		}
    	}
    }
 
    // 뒤로 가기 버튼
    @FXML
    void btnBackClick(ActionEvent event) {
    	
    }

    @FXML
    void initialize() {
    	Font.loadFont(getClass().getResourceAsStream("z_source/GODOM.ttf"), 12);
    	algService = AlgorithmServiceImpl.getInstance();
    	List<AlgCateVO> list = algService.getAllALGCate();
    	for(int i = 0; i < list.size(); i++) {
    		String algCate = list.get(i).getAlg_cate();
    		comboAlgCate.getItems().add(algCate);
    	}
    }
}
