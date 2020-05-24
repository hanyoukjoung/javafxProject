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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import service.admin.AdminServiceImpl;
import service.admin.IAdminSevice;
import service.member.IMemberService;
import service.member.MemberServiceImpl;

public class AdminShowMainController {
				
	private IAdminSevice adminService;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane mainFrame;
    private double xOffset=0;
    private double yOffset=0;
    
    @FXML
    private ImageView btnMin;

    @FXML
    private ImageView btnClose;

    @FXML
    private AnchorPane mainTitleC;

    @FXML
    private Label mainTitle;

    @FXML
    private ImageView imgUser;

    @FXML
    private Label lblUserName;

    @FXML
    private Label lblWelcome;

    @FXML
    private Button btnLogOut;

    @FXML
    private Button btnMSG;

    @FXML
    private Label lblMSGNo;

    @FXML
    private Button btnSearch;

    @FXML
    private TextField tfSearch;
    
    @FXML
    private AnchorPane subFrameList;

    @FXML
    private VBox underSubframeList;

    @FXML
    private Button btnShowChart;
    
    @FXML
    private Button btnBoard;

    @FXML
    private Button btnALG;

    @FXML
    private Button btnMyLCT;

    @FXML
    private Button btnSubLCT;

    @FXML
    private Label lblRight1;

    @FXML
    private Label lblRight2;

    @FXML
    private AnchorPane subFrame;
    
    @FXML
    void btnShowChartClick(ActionEvent event) {	// 차트보기
    	btnSearch.setVisible(false);
    	tfSearch.setVisible(false);
    	subFrame.getChildren().clear();
    	try {
			AnchorPane anchorPane = FXMLLoader.load(AdminShowMainController.class.getResource("../fxml/AdminChartMain.fxml"));
			subFrame.getChildren().add(anchorPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void btnALGClick(ActionEvent event) {	// 알고리즘문제관리
    	btnSearch.setVisible(false);
    	tfSearch.setVisible(false);
    	subFrame.getChildren().clear();
    	try {
			AnchorPane anchorPane = FXMLLoader.load(AdminShowMainController.class.getResource("../fxml/AdminShowALGList.fxml"));
			subFrame.getChildren().add(anchorPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btnBoardClick(ActionEvent event) { // 게시판관리
    	btnSearch.setVisible(false);
    	tfSearch.setVisible(false);
    	subFrame.getChildren().clear();
    	try {
			AnchorPane anchorPane = FXMLLoader.load(AdminShowMainController.class.getResource("../fxml/AdminShowBoardList.fxml"));
			subFrame.getChildren().add(anchorPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btnCloseClick(MouseEvent event) {
    	Stage stage = (Stage) mainFrame.getScene().getWindow();
    	stage.close();
    }

    @FXML
	void btnLogOutClick(ActionEvent event) {
		try {
			LoginController.setSession(null);
			AnchorPane mainfAnchorPane = FXMLLoader.load(AdminShowMainController.class.getResource("../fxml/Login.fxml"));
			mainFrame.getChildren().add(mainfAnchorPane);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    @FXML
    void btnMSGClick(ActionEvent event) { // 메시지
    	Stage memShowMSGPopUpStage = new Stage();
		memShowMSGPopUpStage.initModality(Modality.APPLICATION_MODAL);

		try {
			FXMLLoader loader = new FXMLLoader(AdminShowMainController.class.getResource("../fxml/MEMShowMSGPopUp.fxml"));
			Parent memShowMSGPopUpRoot = loader.load();

			Scene scene = new Scene(memShowMSGPopUpRoot);
			memShowMSGPopUpStage.setScene(scene);
			memShowMSGPopUpStage.initStyle(StageStyle.UNDECORATED);
			memShowMSGPopUpStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btnMinClick(MouseEvent event) {
    	Stage Stage = (Stage)mainFrame.getScene().getWindow();
    	Stage.setIconified(true);
    }

    @FXML
    void btnMyLCTClick(ActionEvent event) {// 강의관리
    	btnSearch.setVisible(false);
    	tfSearch.setVisible(false);
    	subFrame.getChildren().clear();
    	try {
			AnchorPane anchorPane = FXMLLoader.load(AdminShowMainController.class.getResource("../fxml/AdminShowPLCTList.fxml"));
			subFrame.getChildren().add(anchorPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btnSubLCTClick(ActionEvent event) {// 회원관리
    	btnSearch.setVisible(false);
    	tfSearch.setVisible(false);
    	subFrame.getChildren().clear();
    	try {
			FXMLLoader loader = new FXMLLoader(AdminShowMainController.class.getResource("../fxml/AdminShowMEMList.fxml"));
			
			AnchorPane child = loader.load();
			
			AdminShowMEMListController adminShowMEMListController =  loader.getController();
			adminShowMEMListController.setTableView("일반회원");
			subFrame.getChildren().add(child);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void mainTitleClick(MouseEvent event) {
    	btnSearch.setVisible(true);
    	tfSearch.setVisible(true);
    	subFrame.getChildren().clear();
    	try {
			AnchorPane anchorPane = FXMLLoader.load(AdminShowMainController.class.getResource("../fxml/ShowLSNList.fxml"));
			subFrame.getChildren().add(anchorPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void initialize() {
    	  //폰트 경로 설정하기
        Font.loadFont(getClass().getResourceAsStream("../z.source/GODOM.ttf"), 12);
        Font.loadFont(getClass().getResourceAsStream("../z.source/CAC_____.ttf"), 12);
        adminService = AdminServiceImpl.getInstance();
    	
	    mainFrame.setOnMousePressed(new EventHandler<MouseEvent>() {
	         @Override
	         public void handle(MouseEvent event) {
	            xOffset = event.getSceneX(); 
	            yOffset = event.getSceneY(); 
	         }
	     });
	    
	    mainFrame.setOnMouseDragged(new EventHandler<MouseEvent>() { 
	         @Override 
	         public void handle(MouseEvent event) { 
	               Stage primaryStage = (Stage)mainFrame.getScene().getWindow();
	             primaryStage.setX(event.getScreenX() - xOffset); 
	             primaryStage.setY(event.getScreenY() - yOffset); 
	         } 
	    });
	    
	    try {
	    	
	    	btnSearch.setVisible(false);
	    	tfSearch.setVisible(false);
	    	
			FXMLLoader loader = new FXMLLoader(ShowLSNListController.class.getResource("../fxml/AdminChartMain.fxml"));
			
			AnchorPane anchorPane = loader.load();
			subFrame.getChildren().add(anchorPane);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
