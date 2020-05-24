package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import main.vo.LctProfFileVO;
import main.vo.LectureVO;
import service.lecture.LectureServiceImpl;

public class MEMaddMyPayPopUpController {
	private MEMAddMyLCTPopUpController myController;
	private MEMAddMyLCTPopUpController memPayPopupController;
	
	public MEMAddMyLCTPopUpController getMemPayPopupController() {
		return memPayPopupController;
	}

	public void setMemPayPopupController(MEMAddMyLCTPopUpController memAddMyLCTPopUpController) {
		this.memPayPopupController = memAddMyLCTPopUpController;
		
	}
	
	private LectureServiceImpl service;
	
	public MEMaddMyPayPopUpController() {
		service =LectureServiceImpl.getInstance();
	}
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private AnchorPane frame;

    @FXML
    private TextField tfprice;

    @FXML
    private Button btnConfirm;

    @FXML
    private ImageView btnMin;

    @FXML
    private ImageView btnClose;

    @FXML
    private Label lblText;

    @FXML
    private Label lblWon;
    /**
     * 확인버튼누르면 유료강의가 등록되는 매서드
     * @author 한유경
     */

    @FXML
    void btnConfirmClick(ActionEvent event) {
    	int Tfprice = Integer.parseInt(tfprice.getText());
    	LectureVO lctVo1 = new LectureVO();
    	lctVo1.setLct_name(memPayPopupController.getLecpayVo().getLct_name());
    	lctVo1.setLct_cont(memPayPopupController.getLecpayVo().getLct_cont());
    	lctVo1.setMem_id(memPayPopupController.getLecpayVo().getMem_id());
    	lctVo1.setLang_no(1);
    	lctVo1.setLct_status(4);
    	lctVo1.setLct_price(Tfprice);
    	lctVo1.setLct_permit_date("2020-02-06");
    	
    	LctProfFileVO lprofileVo = new LctProfFileVO();
    	lprofileVo.setLct_img_name(memPayPopupController.getLctproVo().getLct_img_name());
//		lprofileVo.setLct_img_sname(fileName);
//		lprofileVo.setLct_img_size(foldersize);
    	int cnt = service.insertpaylecture(lctVo1);
    	
    	Stage thisStage =(Stage) btnClose.getScene().getWindow();
    	thisStage.close();
    	myController.getPrimaryStage().close();
    }

    @FXML
    void btnMinClick(MouseEvent event) {
    	Stage thisStage =(Stage) btnClose.getScene().getWindow();
    	thisStage.setIconified(true);

    }

    @FXML
    void btnCloseClick(MouseEvent event) {
    	Stage thisStage =(Stage) btnClose.getScene().getWindow();
    	thisStage.close();
    	
    }

    @FXML
    void initialize() {
    	
    	//폰트 경로 설정하기
    	Font.loadFont(getClass().getResourceAsStream("../z.source/GODOM.ttf"), 12); 

    }

	
}
