package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.vo.ReportCateVO;
import main.vo.ReportVO;
import service.report.IReportService;
import service.report.ReportServiceImpl;

public class MEMFinishLSNPopUpController {
	private int rctInsert =0;
	private int starInsert=0;
	private IReportService serviceReport;
	List<ReportCateVO> reportCateVoList;
	
	public MEMFinishLSNPopUpController (){
		serviceReport = ReportServiceImpl.getInstance();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane mainFrame;

    @FXML
    private Button btnStar;

    @FXML
    private Button btnRPT;

    @FXML
    private AnchorPane subFrameStar;

    @FXML
    private Button btnStar1;

    @FXML
    private Button btnStar2;

    @FXML
    private Button btnStar3;

    @FXML
    private Button btnStar4;

    @FXML
    private Button btnStar5;

    @FXML
    private TextArea taEval;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnConfirm;

    @FXML
    private ComboBox<String> comboRCT;

    @FXML
    private AnchorPane subFrameStar1;

    @FXML
    private Button btnRPTCancel;

    @FXML
    private Button btnRPTConfirm;
    
    @FXML
    private Label lblFirst;
    
    @FXML
    private Label lblSecond;

    @FXML
    void btnCancelClick(ActionEvent event) {
    	Stage popUpStage = (Stage)subFrameStar.getScene().getWindow();
    	popUpStage.close();
    	

    }

    @FXML
    void btnConfirmClick(ActionEvent event) throws IOException {
    	if(rctInsert == 1) {
    		if(comboRCT.getSelectionModel().getSelectedItem() == null) {
    			Stage popUpStage = new Stage();
    			
    			FXMLLoader loader = new FXMLLoader(MEMFinishLSNPopUpController.class.getResource("../fxml/BasicPopUp.fxml"));
    			
    			Parent basicPopUpChild = loader.load();
    			
    			BasicPopUpController basicPopUpController = loader.getController();
    			basicPopUpController.setMemFinishLSNPopUpController(this);
    			basicPopUpController.getBtnMiddleConfirm().setVisible(true);
    			basicPopUpController.getBtnCancel().setVisible(false);
    			basicPopUpController.getBtnConfirm().setVisible(false);
    			basicPopUpController.setLbText("신고 사유를 선택하세요");
    			
    			Scene scene = new Scene(basicPopUpChild);
    			popUpStage.setScene(scene);
    			popUpStage.initStyle(StageStyle.UNDECORATED);
    			popUpStage.show();
    		}else if(taEval.getText().equals("")){
    			Stage popUpStage = new Stage();
    			
    			FXMLLoader loader = new FXMLLoader(MEMFinishLSNPopUpController.class.getResource("../fxml/BasicPopUp.fxml"));
    			
    			Parent basicPopUpChild = loader.load();
    			
    			BasicPopUpController basicPopUpController = loader.getController();
    			basicPopUpController.setMemFinishLSNPopUpController(this);
    			basicPopUpController.getBtnMiddleConfirm().setVisible(true);
    			basicPopUpController.getBtnCancel().setVisible(false);
    			basicPopUpController.getBtnConfirm().setVisible(false);
    			basicPopUpController.setLbText("신고 내용을 입력하세요");
    			
    			Scene scene = new Scene(basicPopUpChild);
    			popUpStage.setScene(scene);
    			popUpStage.initStyle(StageStyle.UNDECORATED);
    			popUpStage.show();
    			
    		}else {
    			ReportVO reportMemberVo = new ReportVO();
    			reportMemberVo.setRpt_target(""); // 채팅 진행한 상대 아이디
    			reportMemberVo.setMem_id(LoginController.getSession().getMem_id());
    			for(int i=0; i<reportCateVoList.size(); i++) {
    				if(comboRCT.getSelectionModel().getSelectedItem() == reportCateVoList.get(i).getRpt_cate()) {
    					reportMemberVo.setRpt_cate_no(reportCateVoList.get(i).getRpt_cate_no());
    				}
    			}
    			reportMemberVo.setRpt_cont(taEval.getText());
    			
    			
    			int cnt = serviceReport.insertReport(reportMemberVo);
    			
    			if(cnt == 1) {
    				Stage popUpStage = new Stage();
    				
    				FXMLLoader loader = new FXMLLoader(MEMFinishLSNPopUpController.class.getResource("../fxml/BasicPopUp.fxml"));
    				
    				Parent basicPopUpChild = loader.load();
    				
    				BasicPopUpController basicPopUpController = loader.getController();
    				basicPopUpController.setMemFinishLSNPopUpController(this);
    				basicPopUpController.getBtnMiddleConfirm().setVisible(true);
    				basicPopUpController.getBtnCancel().setVisible(false);
    				basicPopUpController.getBtnConfirm().setVisible(false);
    				basicPopUpController.setLbText("상대방이 신고되었습니다.");
    				
    				Scene scene = new Scene(basicPopUpChild);
    				popUpStage.setScene(scene);
    				popUpStage.initStyle(StageStyle.UNDECORATED);
    				popUpStage.show();
    			}
    			Stage popUpStage = (Stage)subFrameStar.getScene().getWindow();
    			popUpStage.close();
    		}
    		rctInsert=0;
    	}
    }

    @FXML
    void btnRPTClick(ActionEvent event) {
    	rctInsert = 1;
    	starInsert = 0;
    	
    	if(comboRCT.isVisible() == false) comboRCT.setVisible(true);
    	if(btnStar1.isVisible() == true) btnStar1.setVisible(false);
    	if(btnStar2.isVisible() == true) btnStar2.setVisible(false);
    	if(btnStar3.isVisible() == true) btnStar3.setVisible(false);
    	if(btnStar4.isVisible() == true) btnStar4.setVisible(false);
    	if(btnStar5.isVisible() == true) btnStar5.setVisible(false);
    	
    	lblFirst.setText("신고 사유를 선택해주세요");
    	lblSecond.setText("신고 내용을 입력해주세요");
    	taEval.setPromptText("100자 내외로 입력하세요");
    }

    @FXML
    void btnStar1Click(ActionEvent event) {
    	starInsert = 1;
    	rctInsert = 0;
    	 
    	if(comboRCT.isVisible() == true) comboRCT.setVisible(false);
    	if(btnStar1.isVisible() == false) btnStar1.setVisible(true);
    	if(btnStar2.isVisible() == false) btnStar2.setVisible(true);
    	if(btnStar3.isVisible() == false) btnStar3.setVisible(true);
    	if(btnStar4.isVisible() == false) btnStar4.setVisible(true);
    	if(btnStar5.isVisible() == false) btnStar5.setVisible(true);
    	
    	lblFirst.setText("내 파트너의 평점은?");
    	lblSecond.setText("내 파트너의 한줄평은?");
    	taEval.setPromptText("50자 내외로 입력하세요");


    	starInsert = 0;
    }

    @FXML
    void btnStar2Click(ActionEvent event) {

    }

    @FXML
    void btnStar3Click(ActionEvent event) {

    }

    @FXML
    void btnStar4Click(ActionEvent event) {

    }

    @FXML
    void btnStar5Click(ActionEvent event) {

    }

    @FXML
    void btnStarClick(ActionEvent event) {

    }

    @FXML
    void comboRCTClick(ActionEvent event) {

    }

    @FXML
    void initialize() {
    	//콤보박스 셋팅 해줘야함 
    	reportCateVoList = serviceReport.getAllReportCateList();
    	
    	for(ReportCateVO rpcVo : reportCateVoList) {
    		comboRCT.getItems().add(rpcVo.getRpt_cate());
    	}
    	
    	taEval.setText("");
    }
}
