package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.vo.LboardVO;
import main.vo.MemberVO;
import service.board.BoardServiceImpl;
import service.board.IBoardService;

public class MEMAddLSNBoardController {
	private IBoardService service;
	private MemberVO loginMem;
	private ShowLSNListController showLSNListController;
	
 	public ShowLSNListController getShowLSNListController() {
		return showLSNListController;
	}

	public void setShowLSNListController(ShowLSNListController showLSNListController) {
		this.showLSNListController = showLSNListController;
	}

	public MEMAddLSNBoardController() {
		service = BoardServiceImpl.getInstance();
	}
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane pane;
    private double xOffset=0;
    private double yOffset=0;

    /*-----------------------------*/
    
    //CSS 작업을 위해 부여한 ID
    //UI 담당자가 필요한 부분입니다.
    
    @FXML
    private Label lbl_MajorLang;

    @FXML
    private Label lbl_InterestLang;
    
    @FXML
    private Label lblCont;
    
    /*------------------------------*/
    
    @FXML
    private RadioButton radioMLangJava; //배우고 싶은 언어 Java

    @FXML
    private RadioButton radioMLangCpp; //배우고 싶은 언어 C++

    @FXML
    private RadioButton radioMLangOracle; //배우고 싶은 언어 Oracle

    @FXML
    private RadioButton radioMLangPython; //배우고 싶은 언어 Python

    @FXML
    private RadioButton radioILangJava; //가르칠 수 있는 언어 Java

    @FXML
    private RadioButton radioILangCpp; //가르칠 수 있는 언어 C++

    @FXML
    private RadioButton radioILangOracle; //가르칠 수 있는 언어 Oracle

    @FXML
    private RadioButton radioILangPython; //가르칠 수 있는 언어 Python

    @FXML
    private ToggleGroup mLang; //배우고 싶은 언어 Toggle 그룹

    @FXML
    private ToggleGroup iLang; //가르칠 수 있는 언어 Toggle 그룹

    @FXML
    private TextArea taContent; //내용작성 Text Area

    @FXML
    private Button btnClose;

    @FXML
    private Button btnMin;
    
    @FXML
    private Button btnInsertLBoard;
    
    @FXML
    void btnInsertLBoardClick(ActionEvent event) {
    	radioMLangJava.setUserData(1);
    	radioMLangCpp.setUserData(2);
    	radioMLangOracle.setUserData(3);
    	radioMLangPython.setUserData(4);
    	
    	radioILangJava.setUserData(1);
    	radioILangCpp.setUserData(2);
    	radioILangOracle.setUserData(3);
    	radioILangPython.setUserData(4);
    	
    	if (mLang.getSelectedToggle() == null || iLang.getSelectedToggle() == null) {
    		try {
    			Stage popUpStage = new Stage();
    			popUpStage.initModality(Modality.APPLICATION_MODAL);
    			
    			FXMLLoader loader = new FXMLLoader(BasicPopUpController.class.getResource("../fxml/BasicPopUp.fxml"));
    			Parent basicPopUpRoot = loader.load();
    			
    			BasicPopUpController basicPopUpController = loader.getController();
    			basicPopUpController.setMemAddLSNBoardController(this);
    			basicPopUpController.getBtnMiddleConfirm().setVisible(false);
    			basicPopUpController.setLbText("언어는 필수 선택 항목입니다.");
    			
    			Scene scene = new Scene(basicPopUpRoot);
    			popUpStage.setScene(scene);
    			popUpStage.initStyle(StageStyle.UNDECORATED);
    			popUpStage.show();
    			
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
    	
    	LboardVO lBoardVo = new LboardVO();
    	
    	lBoardVo.setLsn_board_cont(taContent.getText());
    	lBoardVo.setLang_itrst((int)mLang.getSelectedToggle().getUserData());
    	lBoardVo.setLang_major((int)iLang.getSelectedToggle().getUserData());
    	lBoardVo.setMem_id(loginMem.getMem_id());
    	
    	service.insertLBoard(lBoardVo);

    	showLSNListController.setTextArea(); 
    	
    	
    	Stage memAddLSNBoardStage = (Stage)pane.getScene().getWindow();
    	memAddLSNBoardStage.close();
    	
    }

    @FXML
    void btnCloseClick(ActionEvent event) {
    	Stage memAddLSNBoardStage = (Stage)pane.getScene().getWindow();
    	memAddLSNBoardStage.close();
    }

    @FXML
    void btnMinClick(ActionEvent event) {
    	Stage memAddLSNBoardStage = (Stage)pane.getScene().getWindow();
    	memAddLSNBoardStage.setIconified(true);
    }

    @FXML
    void initialize() {
    	loginMem = LoginController.getSession();
    	
    	//폰트의 경로를 설정한다.
    	Font.loadFont(getClass().getResourceAsStream("../z.source/GODOM.ttf"), 12);
    	
    	pane.setOnMousePressed(new EventHandler<MouseEvent>() {
	         @Override
	         public void handle(MouseEvent event) {
	            xOffset = event.getSceneX(); 
	            yOffset = event.getSceneY(); 
	         }
	     });
	    
    	pane.setOnMouseDragged(new EventHandler<MouseEvent>() { 
	         @Override 
	         public void handle(MouseEvent event) { 
	               Stage primaryStage = (Stage)pane.getScene().getWindow();
	             primaryStage.setX(event.getScreenX() - xOffset); 
	             primaryStage.setY(event.getScreenY() - yOffset); 
	         } 
	    });
    }
}
