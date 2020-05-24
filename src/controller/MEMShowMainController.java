package controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.common.ServerConnector;
import main.packet.FileRequestPacket;
import main.packet.ServerPath;
import main.vo.MemFileVO;
import main.vo.MemberVO;
import service.member.IMemberService;
import service.member.MemberServiceImpl;

public class MEMShowMainController {

	private Stage memShowMainStage;
	private IMemberService memberService;
	private BasicPopUpController basicPopUpController;
	
	public Stage getMemShowMainStage() {
		return memShowMainStage;
	}

	public void setMemShowMainStage(Stage memShowMainStage) {
		this.memShowMainStage = memShowMainStage;
	}
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane mainFrame;
    private double xOffset=0;
    private double yOffset=0;

    @FXML
    private Button btnMini;

    @FXML
    private Button btnClose;

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
    private Button btnMessage;

    @FXML
    private ImageView btnMsg;

    @FXML
    private Label lblMSGNo;

    @FXML
    private Button btnSearch;

    @FXML
    private TextField tfSearch;

    @FXML
    private ComboBox<String> comboMLang;

    @FXML
    private ComboBox<String> comboILang;

    @FXML
    private AnchorPane subFrameList;

    @FXML
    private VBox underSubframeList;

    @FXML
    private Button btnLSN;

    @FXML
    private Button btnAllLCT;
    
    @FXML
    private Label black;

    @FXML
    private Button btnMyPage;

    @FXML
    private Button btnSubLCT;

    @FXML
    private Button btnMyLCT;

    @FXML
    private Button btnALG;
    
    @FXML
    private AnchorPane mainTitleC;
    
    @FXML
    private Button btnBoard;

    @FXML
    private Label lblRight2;

    @FXML
    private Label lblRight1;
    
    @FXML
    private Label lblTitle;

    @FXML
    private AnchorPane subFrame;

	@FXML
    void btnSearchClick(ActionEvent event) {

    }

	public void setMainFrame(AnchorPane mainFrame) {
		this.mainFrame = mainFrame;
	}

	public AnchorPane getMainFrame() {
		return mainFrame;
	}

	@FXML
    void btnAllLCTClick(ActionEvent event) {
    	btnSearch.setVisible(false);
    	tfSearch.setVisible(false);
    	comboILang.setVisible(false);
    	comboMLang.setVisible(false);
    	subFrame.getChildren().clear();
    	try {
			AnchorPane anchorPane = FXMLLoader.load(MEMShowALGListController.class.getResource("../fxml/MEMShowLCTList.fxml"));
			subFrame.getChildren().add(anchorPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    @FXML
    void mainTitleClick(MouseEvent event) {
    	btnSearch.setVisible(true);
    	tfSearch.setVisible(true);
    	comboILang.setVisible(true);
    	comboMLang.setVisible(true);
    	subFrame.getChildren().clear();
    	try {
			AnchorPane anchorPane = FXMLLoader.load(MEMShowALGListController.class.getResource("../fxml/ShowLSNList.fxml"));
			subFrame.getChildren().add(anchorPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void btnALGClick(ActionEvent event) {
    	btnSearch.setVisible(false);
    	tfSearch.setVisible(false);
    	comboILang.setVisible(false);
    	comboMLang.setVisible(false);
    	subFrame.getChildren().clear();
    	try {
			AnchorPane anchorPane = FXMLLoader.load(MEMShowALGListController.class.getResource("../fxml/MEMShowALGList.fxml"));
			subFrame.getChildren().add(anchorPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btnBoardClick(ActionEvent event) {
    	btnSearch.setVisible(false);
    	tfSearch.setVisible(false);
    	comboILang.setVisible(false);
    	comboMLang.setVisible(false);
    	subFrame.getChildren().clear();
    	try {
			AnchorPane anchorPane = FXMLLoader.load(MEMShowBoardListController.class.getResource("../fxml/MEMShowBoardList.fxml"));
			subFrame.getChildren().add(anchorPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btnCloseClick(ActionEvent event) {
    	Stage memShowMainStage = (Stage)mainFrame.getScene().getWindow();
		memShowMainStage.close();
    }

    @FXML
    void btnLSNClick(ActionEvent event) {
    	Stage memShowLSNListStage = new Stage();
    	memShowLSNListStage.initStyle(StageStyle.UNDECORATED);
    	
    	try {
			FXMLLoader loader = new FXMLLoader(MEMShowLSNListController.class.getResource("../fxml/MEMShowLSNList.fxml"));
			Parent memShowLSNListRoot = loader.load();
			
			MEMShowLSNListController ctl = loader.getController();
			
			ctl.starter(LoginController.getSession());
			
			Scene sene = new Scene(memShowLSNListRoot);
			memShowLSNListStage.setScene(sene);
			memShowLSNListStage.initStyle(StageStyle.UNDECORATED);
			memShowLSNListStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btnLogOutClick(ActionEvent event) {/////////////-----------------------------
		try {
			LoginController.setSession(null);
			AnchorPane mainfAnchorPane = FXMLLoader.load(ShowLSNListController.class.getResource("../fxml/Login.fxml"));
			mainFrame.getChildren().add(mainfAnchorPane);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btnMSGClick(ActionEvent event) {
    	Stage memShowMSGPopUpStage = new Stage();
		memShowMSGPopUpStage.initModality(Modality.APPLICATION_MODAL);
		memShowMSGPopUpStage.initOwner(memShowMainStage);

		try {
			FXMLLoader loader = new FXMLLoader(
					MEMShowMSGPopUpController.class.getResource("../fxml/MEMShowMSGPopUp.fxml"));
			Parent memShowMSGPopUpRoot = loader.load();

			MEMShowMSGPopUpController memShowMSGPopUpController = loader.getController();
			memShowMSGPopUpController.setMemShowMainController(this);

			Scene scene = new Scene(memShowMSGPopUpRoot);
			memShowMSGPopUpStage.setScene(scene);
			memShowMSGPopUpStage.initStyle(StageStyle.UNDECORATED);
			memShowMSGPopUpStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btnMiniClick(ActionEvent event) {
    	Stage memShowMainStage = (Stage)mainFrame.getScene().getWindow();
		memShowMainStage.setIconified(true);
    }
    
    @FXML
    void btnMyLCTClick(ActionEvent event) {
    	btnSearch.setVisible(false);
    	tfSearch.setVisible(false);
    	comboILang.setVisible(false);
    	comboMLang.setVisible(false);
    	subFrame.getChildren().clear();
    	try {
			AnchorPane anchorPane = FXMLLoader.load(MEMShowMyLCTController.class.getResource("../fxml/MEMShowMyLCT.fxml"));
			subFrame.getChildren().add(anchorPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btnMyPageClick(ActionEvent event) {
    	btnSearch.setVisible(false);
    	tfSearch.setVisible(false);
    	comboILang.setVisible(false);
    	comboMLang.setVisible(false);
    	subFrame.getChildren().clear();
    	try {
    		FXMLLoader loader = new FXMLLoader(MEMShowMyPageController.class.getResource("../fxml/MEMShowMyPage.fxml"));
			AnchorPane anchorPane = loader.load();
			MEMShowMyPageController mypageController = loader.getController();
			mypageController.setMemShowMainController(this);
			mypageController.setLblUserName(lblUserName);
			
			subFrame.getChildren().add(anchorPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void btnSubLCTClick(ActionEvent event) {
    	btnSearch.setVisible(false);
    	tfSearch.setVisible(false);
    	comboILang.setVisible(false);
    	comboMLang.setVisible(false);
    	subFrame.getChildren().clear();
    	try {
			AnchorPane anchorPane = FXMLLoader.load(MEMShowSUBSLCTController.class.getResource("../fxml/MEMShowSUBSLCT.fxml"));
			subFrame.getChildren().add(anchorPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void starter() {
    	System.out.println("################################################################################################");
    	System.out.println("#################################MainView Starter Method Start##################################");
    	System.out.println("################################################################################################");
    	
    	// 프로필사진 검색
	    try {
	    	System.out.println("Call ibatis to Member File VO");
	    	Object temp = memberService.getMemberFile(LoginController.getSession().getMem_id());
	    	
	    	if(temp != null) {
	    		System.out.println("ibatis's result is not null");
	    		MemFileVO memFileVo = (MemFileVO)temp;
	    		
	    		System.out.println("file searching . . .");
	    		File file = new File(ServerPath.MEM_PROF.getPath() + "client/" + memFileVo.getMem_prof_img_sname());
	    		if(file.isFile()){
	    			System.out.println("found file!");
	    			imgUser.setImage(new Image(new FileInputStream(file)));
		    	} else {
		    		
		    		System.out.println("Not found file");
		    		
		    		FileRequestPacket fileRequestPacket = new FileRequestPacket(
		    				LoginController.getSession().getMem_id(), null, ServerPath.MEM_PROF,
		    				memFileVo.getMem_prof_img_name(), memFileVo.getMem_prof_img_sname(), memFileVo.getMem_prof_img_size(), memFileVo.getMem_prof_img_date());
		    		
		    		new ServerConnector().fileRequest(fileRequestPacket, file);
		    		
//		    		System.out.println("Socket(8887) Connecting . . .");
//		    		Socket socket = new Socket("192.168.203.33", 8887);
//		    		
//		    		
//		    		System.out.println("Oos Connecting . . .");
//		    		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
//		    		
//		    		System.out.println("Oos Flushing . . .");
//		    		oos.flush();
//		    		
//		    		System.out.println("Ois Connecting . . .");
//		    		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
//		    		
//		    		System.out.println("File Request Packet Transfer ready . . .");
//		    		
//		    		
//		    		System.out.println("Packet Transfer . . .");
//		    		oos.writeObject(frPacket);
//		    		oos.flush();
//		    		
//		    		System.out.println("Finish Transfer");
//		    		
//		    		
//		    		System.out.println("Make Buffer");
//		    		byte[] buf = new byte[(int)frPacket.getFile_size()];
//					
//		    		System.out.println("Connecting Stream");
//					FileOutputStream fos = new FileOutputStream(file);
//					InputStream is = socket.getInputStream();
//					int i = 0;
//					int cnt=0;
//					while(( i = is.read(buf) ) != -1) {
//						fos.write(buf);
//						System.out.println("flush " + cnt++ );
//					}
//					
//					System.out.println("Finish File Receiving . . . ");
//					
//					fos.close();
//					ois.close();
//					oos.close();
//					socket.close();
//					System.out.println("Socket / Stream Close");
					
					imgUser.setImage(new Image(new FileInputStream(file)));
					System.out.println("User Image Setting");
		    	}
	    	}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void initialize() throws IOException {
    	
    	Font.loadFont(getClass().getResourceAsStream("../z.source/GODOM.ttf"), 12);
    	Font.loadFont(getClass().getResourceAsStream("../z.source/CAC_____.ttf"), 12);
    	//Font.loadFont(getClass().getResourceAsStream("../z.source/DXpro.ttf"), 12);
    	
    	memberService = MemberServiceImpl.getInstance();
    	
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
			AnchorPane anchorPane = FXMLLoader.load(ShowLSNListController.class.getResource("../fxml/ShowLSNList.fxml"));
			subFrame.getChildren().add(anchorPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    lblUserName.setText(LoginController.getSession().getMem_name());
	    comboMLang.getItems().addAll("JAVA", "C++", "PYTHON", "ORACLE");
	    comboILang.getItems().addAll("JAVA", "C++", "PYTHON", "ORACLE");
	    
    }
    
}

