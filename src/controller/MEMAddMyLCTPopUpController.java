package controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.vo.LctProfFileVO;
import main.vo.LectureVO;
import main.vo.MemberVO;
import main.vo.SubslctevalVO;
import service.lecture.LectureServiceImpl;
/**
 * @author 강인경
 * @since 2020-02-04
 * 강의를 업로드하는 PopUp창d
 */
public class MEMAddMyLCTPopUpController {
	private Stage primaryStage;
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	private LectureVO lecpayVo;
	
	public LectureVO getLecpayVo() {
		return lecpayVo;
	}

	public void setLecpayVo(LectureVO lecpayVo) {
		this.lecpayVo = lecpayVo;
	}
	
	private LctProfFileVO lctproVo;
	
	
	private LectureServiceImpl service;
	
	public MEMAddMyLCTPopUpController() {
		service = LectureServiceImpl.getInstance();
		
	}
	
	private MEMShowMyLCTController lctpopUpmainController;
	
	public MEMShowMyLCTController getLctpopUpmainController() {
		return lctpopUpmainController;
	}

	public void setLctpopUpmainController(MEMShowMyLCTController memShowMyLCTController) {
		this.lctpopUpmainController = memShowMyLCTController;
	}
	
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane subFrameLCTbtnInsert;

    @FXML
    private VBox subFrameMLBA;

    @FXML
    private Button btnMin;

    @FXML
    private Button btnClose;


    @FXML
    private TextField LCEtitle;
  

    @FXML
    private Label lblMVFolderName;

    @FXML
    private Label lblVideoInfo;

    @FXML
    private TextArea taVideoInfo;

    @FXML
    private Label lblAddImg;

    @FXML
    private TextField tfImgRoute;

    @FXML
    private Button btnImgAdd;

    @FXML
    private Button btnInsertPaid;

    @FXML
    private Button btnInsertFree;

    @FXML
    private TextField tfprice;

    //창 닫기 버튼 이벤트
    @FXML
    void btnCloseClick(ActionEvent event) {
    	Stage thisStage = (Stage) btnClose.getScene().getWindow();
    	thisStage.close();

    }

    //강의 이미지 첨부 버튼 이벤트
    @FXML
    void btnImgAddClick(ActionEvent event) {
    	
    	FileChooser chooser = new FileChooser();
    	File file = chooser.showOpenDialog(null);
    	try {
			String m = file.toURI().toURL().toString();
			
			tfImgRoute.setText(m);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	

    }

    //강의 무료로 등록하기 버튼 이벤트
    @FXML
    void btnInsertFreeClick(ActionEvent event) {
    	
    	String name = LCEtitle.getText().trim();
    	
    	String cont = taVideoInfo.getText().trim();
		String foldername = "img"+LCEtitle.getText();
		String folderpath =tfImgRoute.getText();
		String fileName = folderpath.substring(folderpath.indexOf('/')+1, folderpath.length());
		MemberVO member =LoginController.getSession();
		
	
		int foldersize = tfImgRoute.getText().length();
		//loginMem = LoginController.getSession();
		System.out.println(fileName);
    	int lang = 1;
    	
    	if(name.isEmpty()) {
    		LCEtitle.requestFocus();
    		return;
    	}
    	if(cont.isEmpty()) {
    		taVideoInfo.requestFocus();
    		return;
    	}
    	LectureVO lctVo = new LectureVO();
    	lctVo.setLct_name(name);
    	lctVo.setLct_cont(cont);
    	lctVo.setMem_id(member.getMem_id());
    	lctVo.setLang_no(lang);
    	lctVo.setLct_status(4);
    	lctVo.setLct_price(0);
    	
    	LctProfFileVO lprofileVo = new LctProfFileVO();
    	lprofileVo.setLct_img_name(foldername);
		lprofileVo.setLct_img_sname(fileName);
		lprofileVo.setLct_img_size(foldersize);
    	int cnt = service.insertLecture(lctVo);
    	          service.insertimg(lprofileVo);
    	
    		lctpopUpmainController.setTextArea();	
    	
    	
    	LCEtitle.clear();
    	taVideoInfo.clear();
    	Stage thisStage = (Stage) btnInsertFree.getScene().getWindow();
    	thisStage.close();

    }
    public void alert(String head, String msg) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("경고");
		alert.setHeaderText(head);
		alert.setContentText(msg);
		
		alert.showAndWait();
	}
    
   
    
    //강의 유료로 등록하기 버튼 이벤트
    @FXML
    void btnInsertPaidClick(ActionEvent event) {
    	
    	MemberVO member =LoginController.getSession();
   	
   		
	String name = LCEtitle.getText().trim();
    	
    	String cont = taVideoInfo.getText().trim();
		String foldername = "img"+LCEtitle.getText();
		String folderpath =tfImgRoute.getText();
		String fileName = folderpath.substring(folderpath.indexOf('/')+1, folderpath.length());
		int price = Integer.parseInt(tfprice.getText());
		
		int foldersize = tfImgRoute.getText().length();
		//loginMem = LoginController.getSession();
		System.out.println(fileName);
    	int lang = 1;
    	
    	if(name.isEmpty()) {
    		LCEtitle.requestFocus();
    		return;
    	}
    	if(cont.isEmpty()) {
    		taVideoInfo.requestFocus();
    		return;
    	}
    	LectureVO lctVo = new LectureVO();
    	lctVo.setLct_name(name);
    	lctVo.setLct_cont(cont);
    	lctVo.setMem_id(member.getMem_id());
    	lctVo.setLang_no(lang);
    	lctVo.setLct_status(4);
    	lctVo.setLct_price(price);
    	lctVo.setLct_permit_date("2020-02-06");
    	
    	LctProfFileVO lprofileVo = new LctProfFileVO();
    	lprofileVo.setLct_img_name(foldername);
		lprofileVo.setLct_img_sname(fileName);
		lprofileVo.setLct_img_size(foldersize);
    	int cnt = service.insertpaylecture(lctVo);
    	          service.insertimg(lprofileVo);
    	
    		lctpopUpmainController.setTextArea();	
    	LCEtitle.clear();
    	taVideoInfo.clear();
    	Stage thisStage = (Stage) btnInsertFree.getScene().getWindow();
    	thisStage.close();
    	}   	
    	
 
    //창 크기를 최소화하는 버튼 이벤트
    @FXML
    void btnMinClick(ActionEvent event) {

    }

    @FXML
    void initialize() {
    	//폰트 경로 설정
    	Font.loadFont(getClass().getResourceAsStream("../z.source/GODOM.ttf"), 12);
    	MemberVO member =LoginController.getSession();
        if((service.getpaid(member.getMem_id()))>=1) {
        	btnInsertPaid.setDisable(false);
        }else if((service.getpaid(member.getMem_id()))<1){
        	btnInsertPaid.setDisable(true);
        }
    	
    }
  

	public LctProfFileVO getLctproVo() {
		return lctproVo;
	}

	public void setLctproVo(LctProfFileVO lctproVo) {
		this.lctproVo = lctproVo;
	}

	

	
	
}
