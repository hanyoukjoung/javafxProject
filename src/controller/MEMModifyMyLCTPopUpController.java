package controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import main.vo.LectureVO;
import main.vo.MEMShowMYLCTVO;
import service.lecture.LectureServiceImpl;

public class MEMModifyMyLCTPopUpController {
	private MEMShowMYLCTVO memShowMYLCTVO;
	public MEMShowMYLCTVO getMemShowMYLCTVO() {
		return memShowMYLCTVO;
	}

	public void setMemShowMYLCTVO(MEMShowMYLCTVO memShowMYLCTVO) {
		this.memShowMYLCTVO = memShowMYLCTVO;
	}




	private MEMShowMyLCTController mainController;
	public MEMShowMyLCTController getMainController() {
		return mainController;
	}

	public void setMainController(MEMShowMyLCTController memShowMyLCTController) {
		this.mainController = memShowMyLCTController;
		//showModify();
	}
	private LectureServiceImpl service;
	
	public MEMModifyMyLCTPopUpController() {
		service = LectureServiceImpl.getInstance();
		
	}
	
	public void showModify() {
		tfMVFolderName.setText(memShowMYLCTVO.getLct_name());
	    tfCont.setText(memShowMYLCTVO.getLct_cont());
	    
		
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane subFrameMyLCTbtnModify;

    @FXML
    private VBox subFrameMLBA;

    @FXML
    private Button btnMin;

    @FXML
    private Button btnClose;

    @FXML
    private TextField tfMVFolderName;

    @FXML
    private TextArea tfCont;

    @FXML
    private Button btnimg;

    @FXML
    private Button btnModify;

    @FXML
    void btnCloseClick(ActionEvent event) {
    	Stage memModifyMyLCTPopUpStage = (Stage)subFrameMyLCTbtnModify.getScene().getWindow();
    	memModifyMyLCTPopUpStage.close();
    }

    @FXML
    void btnMinClick(ActionEvent event) {
    	Stage memModifyMyLCTPopUpStage = (Stage)subFrameMyLCTbtnModify.getScene().getWindow();
    	memModifyMyLCTPopUpStage.setIconified(true);
    }

    @FXML
    void btnModifyClick(ActionEvent event) {
    	String title = tfMVFolderName.getText();
    	String cont = tfCont.getText();
    	LectureVO lectureVO = new LectureVO();
    	lectureVO.setLct_no(memShowMYLCTVO.getLct_no());
    	lectureVO.setLct_name(title);
    	lectureVO.setLct_cont(cont);
    	
    	int cnt =service.updatelecture(lectureVO);
    	Stage thisStage = (Stage)btnModify.getScene().getWindow();
    	thisStage.close();

    }

    @FXML
    void btnimgClick(ActionEvent event) {
    	

    }

    @FXML
    void initialize() {
     

    }

		
}
