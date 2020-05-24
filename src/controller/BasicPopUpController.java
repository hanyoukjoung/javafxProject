package controller;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import main.crypto.Sha256;
import service.member.MemberServiceImpl;

public class BasicPopUpController {
	
	private MEMShowMainController memShowMainController;
	private MEMJoinPopUpController memJoinPopUpController;
	private MEMFindPWPopUpController memFindPWPopUpController;
	private MEMFindIDPopUpController memFindIDPopUpController;
	private MEMShowBoardDetailController memShowBoardDetailController;
	private MEMShowMyPageController memShowMyPageController;
	private MEMAddLSNBoardController memAddLSNBoardController;
	private AdminShowBoardDetailController adminShowBoardDetailController;
	private MEMShowMyPageController btnDeleteMem;
	private MEMRPTLSNPopUpController memRPTLSNPopUpController;
	private MEMAddBoardController memAddBoardController;
	private MemberServiceImpl memberSerivce;
	private MEMFinishLSNPopUpController memFinishLSNPopUpController;
	private Sha256 sha256;
	
    public MEMShowMainController getMemShowMainController() {
		return memShowMainController;
	}

	public void setMemShowMainController(MEMShowMainController memShowMainController) {
		this.memShowMainController = memShowMainController;
	}

	public MEMShowMyPageController getBtnDeleteMem() {
		return btnDeleteMem;
	}

	public void setBtnDeleteMem(MEMShowMyPageController btnDeleteMem) {
		this.btnDeleteMem = btnDeleteMem;
	}

	public MEMJoinPopUpController getMemJoinPopUpController() {
		return memJoinPopUpController;
	}

	public void setMemJoinPopUpController(MEMJoinPopUpController memJoinPopUpController) {
		this.memJoinPopUpController = memJoinPopUpController;
	}

	public MEMFindIDPopUpController getMemFindIDPopUpController() {
		return memFindIDPopUpController;
	}

	public void setMemFindIDPopUpController(MEMFindIDPopUpController memFindIDPopUpController) {
		this.memFindIDPopUpController = memFindIDPopUpController;
	}

	public MEMFindPWPopUpController getMemFindPWPopUpController() {
		return memFindPWPopUpController;
	}

	public void setMemFindPWPopUpController(MEMFindPWPopUpController memFindPWPopUpController) {
		this.memFindPWPopUpController = memFindPWPopUpController;
	}
	//회원 자유게시판상세보기 컨트롤러
	public MEMShowBoardDetailController getMemShowBoardDetailController() {
		return memShowBoardDetailController;
	}

	public void setMemShowBoardDetailController(MEMShowBoardDetailController memShowBoardDetailController) {
		this.memShowBoardDetailController = memShowBoardDetailController;
	}

	public MEMShowMyPageController getMemShowMyPageController() {
		return memShowMyPageController;
	}

	public void setMemShowMyPageController(MEMShowMyPageController memShowMyPageController) {
		this.memShowMyPageController = memShowMyPageController;
	}

	public MEMAddLSNBoardController getMemAddLSNBoardController() {
		return memAddLSNBoardController;
	}

	public void setMemAddLSNBoardController(MEMAddLSNBoardController memAddLSNBoardController) {
		this.memAddLSNBoardController = memAddLSNBoardController;
	}

	public AdminShowBoardDetailController getAdminShowBoardDetailController() {
		return adminShowBoardDetailController;
	}

	public void setAdminShowBoardDetailController(AdminShowBoardDetailController adminShowBoardDetailController) {
		this.adminShowBoardDetailController = adminShowBoardDetailController;
	}

	public MEMRPTLSNPopUpController getMemRPTLSNPopUpController() {
		return memRPTLSNPopUpController;
	}

	public void setMemRPTLSNPopUpController(MEMRPTLSNPopUpController memRPTLSNPopUpController) {
		this.memRPTLSNPopUpController = memRPTLSNPopUpController;
	}

	public MEMAddBoardController getMemAddBoardController() {
		return memAddBoardController;
	}
	public void setMemAddBoardController(MEMAddBoardController memAddBoardController) {
		this.memAddBoardController = memAddBoardController;
	}

	public MEMFinishLSNPopUpController getMemFinishLSNPopUpController() {
		return memFinishLSNPopUpController;
	}
	public void setMemFinishLSNPopUpController(MEMFinishLSNPopUpController memFinishLSNPopUpController) {
		this.memFinishLSNPopUpController = memFinishLSNPopUpController;
	}







	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Button btnMiddleConfirm;

    @FXML
    private AnchorPane subFrameSubsAlert;
	private double xOffset = 0;
	private double yOffset = 0;

    @FXML
    private Label lbText;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnConfirm;

    @FXML
    private ImageView btnMin;
    
    @FXML
    void btnMiddleConfirmClick(ActionEvent event) {
    	if(memJoinPopUpController != null) {
    		Stage basicPopUpStage = (Stage) subFrameSubsAlert.getScene().getWindow();
    		basicPopUpStage.close();
    	}
    	
    	if(memFindIDPopUpController != null) {
    		Stage basicPopUpStage = (Stage) subFrameSubsAlert.getScene().getWindow();
    		memFindIDPopUpController = null;
    		basicPopUpStage.close();
    	}
    	
    	if(memFindPWPopUpController != null) {
    		Stage basicPopUpStage = (Stage) subFrameSubsAlert.getScene().getWindow();
    		memFindIDPopUpController = null;
    		basicPopUpStage.close();
    	}
    	
    	if(memFindIDPopUpController != null) {
    		Stage basicPopUpStage = (Stage) subFrameSubsAlert.getScene().getWindow();
    		memFindIDPopUpController = null;
    		basicPopUpStage.close();
    	}
    	
    	if(memFindPWPopUpController != null) {
    		Stage basicPopUpStage = (Stage) subFrameSubsAlert.getScene().getWindow();
    		memFindIDPopUpController = null;
    		basicPopUpStage.close();
    	}
    	
    	if(memJoinPopUpController != null) {
    		Stage basicPopUpStage = (Stage) subFrameSubsAlert.getScene().getWindow();
    		memFindIDPopUpController = null;
    		basicPopUpStage.close();
    	}
    	
    	if(memShowMyPageController != null) {
    		Stage basicPopUpStage = (Stage) subFrameSubsAlert.getScene().getWindow();
        	basicPopUpStage.close();
    	}
    	
    	if(memRPTLSNPopUpController != null) {
    		Stage basicPopUpStage = (Stage) subFrameSubsAlert.getScene().getWindow();
    		basicPopUpStage.close();
    	}
    	
    	if(memShowBoardDetailController != null) {
    		Stage basicPopUpStage = (Stage) subFrameSubsAlert.getScene().getWindow();
    		memShowBoardDetailController = null;
    		basicPopUpStage.close();
    	}
    	
    	if(memAddBoardController != null) {
    		Stage basicPopUpStage = (Stage) subFrameSubsAlert.getScene().getWindow();
    		memAddBoardController = null;
    		basicPopUpStage.close();
    	}
    	
    	if(memFinishLSNPopUpController != null) {
    		Stage basicPopUpStage = (Stage) subFrameSubsAlert.getScene().getWindow();
    		memFinishLSNPopUpController = null;
    		basicPopUpStage.close();
    	}
    	
    }

    @FXML
    private ImageView btnClose;
    
    @FXML
    private PasswordField tfText;

    @FXML
    void btnCancelClick(ActionEvent event) {
    	
    	if(memAddLSNBoardController != null) {
    		Stage basicPopUpStage = (Stage) subFrameSubsAlert.getScene().getWindow();
    		memAddLSNBoardController = null;
    		basicPopUpStage.close();
    	}
    	
    	if(btnDeleteMem != null) {
    		Stage basicPopUpStage = (Stage) subFrameSubsAlert.getScene().getWindow();
    		btnDeleteMem = null;
    		basicPopUpStage.close();
    	}
    	
    	if(memShowMyPageController != null) {
    		Stage basicPopUpStage = (Stage) subFrameSubsAlert.getScene().getWindow();
    		memShowMyPageController = null;
    		basicPopUpStage.close();
    	}
    }

    @FXML
    void btnCloseClick(MouseEvent event) {
    	Stage basicPopUpStage = (Stage) subFrameSubsAlert.getScene().getWindow();
    	basicPopUpStage.close();
    	
    	
    }

    // 확인 버튼을 누를때
    @FXML
    void btnConfirmClick(ActionEvent event) throws Exception {
    	
    	
    	if(memAddLSNBoardController != null) {
    		Stage basicPopUpStage = (Stage) subFrameSubsAlert.getScene().getWindow();
    		memAddLSNBoardController = null;
    		basicPopUpStage.close();
    	}
    	
    	if(memShowMyPageController != null) {
    		Map<String, String> params = new HashMap<String, String>();
    		params.put("mem_id", LoginController.getSession().getMem_id());
    		params.put("mem_pw", sha256.encrypt(tfText.getText()));
    		if(memberSerivce.isExistAccount(params)) {
    			memShowMyPageController.setIscorrectPW(true);
    			Stage basicPopUpStage = (Stage) subFrameSubsAlert.getScene().getWindow();
        		memFindIDPopUpController = null;
        		basicPopUpStage.close();
        		memShowMyPageController.changeStanceModify();
    		}else {
    			lbText.setText("비밀번호가 틀렸습니다.");
    		}
    	}
    	
    	// 마이페이지에서 회원탈퇴를 누를 경우
    	if(btnDeleteMem != null) {
    		btnDeleteMem.setDeleteMemOk(true);
    		btnDeleteMem = null;
    		Stage basicPopUpStage = (Stage) subFrameSubsAlert.getScene().getWindow();
    		basicPopUpStage.close();
    	}
    }

    @FXML
    void btnMinClick(MouseEvent event) {
    	Stage basicPopUpStage = (Stage)subFrameSubsAlert.getScene().getWindow();
    	basicPopUpStage.setIconified(true);
    }
    
    public String getLbText() {
		return lbText.getText();
	}

	public void setLbText(String lbText) {
		this.lbText.setText(lbText);
	}
	
	public PasswordField getTfText() {
		return tfText;
	}

	public void setTfText(PasswordField tfText) {
		this.tfText = tfText;
	}

	public Button getBtnMiddleConfirm() {
		return btnMiddleConfirm;
	}

	public void setBtnMiddleConfirm(Button btnMiddleConfirm) {
		this.btnMiddleConfirm = btnMiddleConfirm;
	}

	public Button getBtnCancel() {
		return btnCancel;
	}

	public void setBtnCancel(Button btnCancel) {
		this.btnCancel = btnCancel;
	}

	public Button getBtnConfirm() {
		return btnConfirm;
	}

	public void setBtnConfirm(Button btnConfirm) {
		this.btnConfirm = btnConfirm;
	}

	@FXML
    void initialize() {
		
		
		//폰트 경로 설정하기
    	Font.loadFont(getClass().getResourceAsStream("../z.source/GODOM.ttf"), 12);
		
		memberSerivce = MemberServiceImpl.getInstance();
		sha256 = new Sha256();
		
		subFrameSubsAlert.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				xOffset = event.getSceneX();
				yOffset = event.getSceneY();
			}
		});

		subFrameSubsAlert.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Stage primaryStage = (Stage) subFrameSubsAlert.getScene().getWindow();
				primaryStage.setX(event.getScreenX() - xOffset);
				primaryStage.setY(event.getScreenY() - yOffset);
			}
		});
		
    }
}
