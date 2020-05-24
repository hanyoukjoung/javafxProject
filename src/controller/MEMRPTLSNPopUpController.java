package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.vo.MemberVO;
import main.vo.ReportCateVO;
import main.vo.ReportVO;
import main.vo.TotalBoardVO;
import service.report.IReportService;
import service.report.ReportServiceImpl;

public class MEMRPTLSNPopUpController {
	private IReportService service;

	private MemberVO loginMem;
	public MEMRPTLSNPopUpController(){
		service = ReportServiceImpl.getInstance();
	}
	
	//라벨 멘튼 getter,setter
	public Label getLblTitle() {
		return lblTitle;
	}
	public void setLblTitle(String lblTitle) {
		this.lblTitle.setText(lblTitle);
	}

	//게시글 신고시
	private TotalBoardVO fBoardVo = null;
	public TotalBoardVO getfBoardVo() {
		return fBoardVo;
	}
	public void setfBoardVo(TotalBoardVO fBoardVo) {
		this.fBoardVo = fBoardVo;
	}

	
	List<ReportCateVO> reportCateVoList;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane Frame;
    private double xOffset=0;
    private double yOffset=0;

    @FXML
    private Label lblTitle;

    @FXML
    private ComboBox<String> rpt_cate;

    @FXML
    private TextArea rpt_cont;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnRPTConfirm;
    
    @FXML
    void btnCancelClick(ActionEvent event) {
    	Stage rptPopUpStage = (Stage)Frame.getScene().getWindow();
    	rptPopUpStage.close();
    }

    @FXML
    void btnRPTConfirmClick(ActionEvent event) throws IOException {
    	if(rpt_cate.getSelectionModel().getSelectedItem() == null) {
    		Stage popUpStage = new Stage();
    		
    		FXMLLoader loader = new FXMLLoader(MEMShowBoardDetailController.class.getResource("../fxml/BasicPopUp.fxml"));
    		
    		Parent basicPopUpChild = loader.load();
    		
    		BasicPopUpController basicPopUpController = loader.getController();
    		basicPopUpController.setMemRPTLSNPopUpController(this);
    		basicPopUpController.getBtnMiddleConfirm().setVisible(true);
    		basicPopUpController.getBtnCancel().setVisible(false);
    		basicPopUpController.getBtnConfirm().setVisible(false);
    		basicPopUpController.setLbText("신고 사유를 선택하세요.");
    		
    		Scene scene = new Scene(basicPopUpChild);
    		popUpStage.setScene(scene);
    		popUpStage.initStyle(StageStyle.UNDECORATED);
    		popUpStage.show();
    		
    	}else if(rpt_cont.getText().equals(null) || rpt_cont.getText().equals("")) {
    		Stage popUpStage = new Stage();
    		
    		FXMLLoader loader = new FXMLLoader(MEMShowBoardDetailController.class.getResource("../fxml/BasicPopUp.fxml"));
    		
    		Parent basicPopUpChild = loader.load();
    		
    		BasicPopUpController basicPopUpController = loader.getController();
    		basicPopUpController.setMemRPTLSNPopUpController(this);
    		basicPopUpController.getBtnMiddleConfirm().setVisible(true);
    		basicPopUpController.getBtnCancel().setVisible(false);
    		basicPopUpController.getBtnConfirm().setVisible(false);
    		basicPopUpController.setLbText("신고 내용을 입력하세요.");
    		
    		Scene scene = new Scene(basicPopUpChild);
    		popUpStage.setScene(scene);
    		popUpStage.initStyle(StageStyle.UNDECORATED);
    		popUpStage.show();
    	}else {
    		if(fBoardVo != null) {
    			ReportVO fBoardReportVo = new ReportVO();
    			
    			fBoardReportVo.setRpt_target("fb"+fBoardVo.getBoard_no());
    			fBoardReportVo.setMem_id(loginMem.getMem_id());
    			for(int i=0; i<reportCateVoList.size();i++) {
    				if(rpt_cate.getSelectionModel().getSelectedItem().equals(reportCateVoList.get(i).getRpt_cate())) {
    					fBoardReportVo.setRpt_cate_no( reportCateVoList.get(i).getRpt_cate_no() );
    				}
    			}
    			fBoardReportVo.setRpt_cont(rpt_cont.getText());
    			
    			int cnt = service.insertReport(fBoardReportVo);
    			
    			Stage rptPopUpStage = (Stage)Frame.getScene().getWindow();
    			rptPopUpStage.close();
    			if(cnt == 1 ) {
    				Stage popUpStage = new Stage();
    	    		
    	    		FXMLLoader loader = new FXMLLoader(MEMShowBoardDetailController.class.getResource("../fxml/BasicPopUp.fxml"));
    	    		
    	    		Parent basicPopUpChild = loader.load();
    	    		
    	    		BasicPopUpController basicPopUpController = loader.getController();
    	    		basicPopUpController.setMemRPTLSNPopUpController(this);
    	    		basicPopUpController.getBtnMiddleConfirm().setVisible(true);
    	    		basicPopUpController.getBtnCancel().setVisible(false);
    	    		basicPopUpController.getBtnConfirm().setVisible(false);
    	    		basicPopUpController.setLbText("게시글이 정상적으로 신고되었습니다.");
    	    		
    	    		Scene scene = new Scene(basicPopUpChild);
    	    		popUpStage.setScene(scene);
    	    		popUpStage.initStyle(StageStyle.UNDECORATED);
    	    		popUpStage.show();
    			}
    		}
    		
    	}
    }

    @FXML
    void initialize() {
    	//폰트 경로 설정하기
    	Font.loadFont(getClass().getResourceAsStream("../z.source/GODOM.ttf"), 12);
    	loginMem = LoginController.getSession();
    	
    	Frame.setOnMousePressed(new EventHandler<MouseEvent>() {
	         @Override
	         public void handle(MouseEvent event) {
	            xOffset = event.getSceneX(); 
	            yOffset = event.getSceneY(); 
	         }
	     });
	    
    	Frame.setOnMouseDragged(new EventHandler<MouseEvent>() { 
	         @Override 
	         public void handle(MouseEvent event) { 
	               Stage primaryStage = (Stage)Frame.getScene().getWindow();
	             primaryStage.setX(event.getScreenX() - xOffset); 
	             primaryStage.setY(event.getScreenY() - yOffset); 
	         } 
	    });
    	
    	reportCateVoList = service.getAllReportCateList();
    	
    	for(ReportCateVO rpcVo : reportCateVoList) {
    		rpt_cate.getItems().add(rpcVo.getRpt_cate());
    	}
    	
    	rpt_cont.setText("");
    	
    }
}
