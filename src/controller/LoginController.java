package controller;

import java.io.File;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.crypto.Sha256;
import main.vo.MemberVO;
import service.admin.AdminServiceImpl;
import service.member.MemberServiceImpl;

public class LoginController {
	
	private MemberServiceImpl memberService;
	private AdminServiceImpl adminService;
	private static MemberVO session;
	private Sha256 sha256;
	
	public static MemberVO getSession() {
		return session;
	}

	public static void setSession(MemberVO session) {
		LoginController.session = session;
	}

	private Stage logInStage;

	public Stage getLogInStage() {
		return logInStage;
	}

	public void setLogInStage(Stage logInStage) {
		this.logInStage = logInStage;
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane mainFrame;
    private double xOffset = 0;
	private double yOffset = 0;

    @FXML
    private MediaView mediaView;
    private MediaPlayer mp;
	private Media me;

    @FXML
    private Button btnMin;

    @FXML
    private Button btnClose;

    @FXML
    private TextField tfUserID;

    @FXML
    private PasswordField tfPassword;

    @FXML
    private Label lblLoginClickFeedback;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnSearchID;

    @FXML
    private Button btnSearchPW;

    @FXML
    private Button btnCreateAcc;
    
    public AnchorPane getMainFrame() {
		return mainFrame;
	}

	public void setMainFrame(AnchorPane mainFrame) {
		this.mainFrame = mainFrame;
	}

	@FXML
    void keyReleasedLogIn(KeyEvent event) {
    	// 이 이벤트는 없는거랍니다 찡긋 ㅡ★
    }
    
    @FXML
    void btnCloseAction(ActionEvent event) {
    	Stage loginStage = (Stage) mainFrame.getScene().getWindow();
		loginStage.close();
    }

    @FXML
    void btnCreateAccAction(ActionEvent event) {
    	Stage memJoinPopUpStatge = new Stage();
		memJoinPopUpStatge.initModality(Modality.APPLICATION_MODAL);
		memJoinPopUpStatge.initOwner(logInStage);

		try {
			FXMLLoader loader = new FXMLLoader(MEMJoinPopUpController.class.getResource("../fxml/MEMJoinPopUp.fxml"));
			Parent memJoinPopUpControllerRoot = loader.load();

			MEMJoinPopUpController memJoinPopUpController = loader.getController();
			memJoinPopUpController.setLogInController(this);

			Scene scene = new Scene(memJoinPopUpControllerRoot);
			memJoinPopUpStatge.setScene(scene);
			memJoinPopUpStatge.initStyle(StageStyle.UNDECORATED);
			memJoinPopUpStatge.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btnLoginAction(ActionEvent event) {
    	Map<String, String> params = new HashMap<String, String>(); // 아이디와 비밀번호를 담을 변수
		boolean result; // 결과를 담을 변수

		try {
			params.put("mem_id", tfUserID.getText()); // id담기
			params.put("mem_pw", sha256.encrypt(tfPassword.getText()));
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} // pw담기
		result = memberService.isExistAccount(params); // id와 pw가 맞는지 결과를 가져옴
		
		
		if(adminService.isExistAccount(params)) { // 어드민 테이블에 있는지 검사하는 조건
			// 어드민 메인 페이지로 이동
			try {
				Stage logInStage = (Stage) mainFrame.getScene().getWindow();
				FXMLLoader loader = new FXMLLoader(AdminShowMainController.class.getResource("../fxml/AdminShowMain.fxml"));
				Parent adminShowMainRoot = loader.load();

				Scene scene = new Scene(adminShowMainRoot);
				logInStage.setScene(scene);
				logInStage.show();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}else { // 어드민 테이블에 없을경우
			if(result) { // 회원 테이블에 있는지 검사하는 조건
				// 회원 메인페이지로 이동
				try {
					Stage logInStage = (Stage) mainFrame.getScene().getWindow();
					FXMLLoader loader = new FXMLLoader(MEMShowMainController.class.getResource("../fxml/MEMShowMain.fxml"));
					session = memberService.getMemberData(tfUserID.getText());
					Parent memShowMainRoot = loader.load();
					
					MEMShowMainController ctl = loader.getController();
					
					ctl.starter();
					
					Scene scene = new Scene(memShowMainRoot);
					logInStage.setScene(scene);
					logInStage.show();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if (tfUserID.getText().isEmpty() || tfPassword.getText().isEmpty()){
				lblLoginClickFeedback.setText("아이디와 비밀번호를 입력해주세요.");
			}else {// 회원테이블에도 없을경우
				// 로그인실패
				lblLoginClickFeedback.setText("아이디나 비밀번호가 틀렸습니다.");
			}
		}
		
//		
    }

    @FXML
    void btnMinAction(ActionEvent event) {
    	Stage LoginStage = (Stage)mainFrame.getScene().getWindow();
    	LoginStage.setIconified(true);
    }

    @FXML
    void btnSearchIDAction(ActionEvent event) {
    	Stage memFindIDPopUpStage = new Stage();
		memFindIDPopUpStage.initModality(Modality.APPLICATION_MODAL);
		memFindIDPopUpStage.initOwner(logInStage);

		try {
			FXMLLoader loader = new FXMLLoader(
					MEMFindIDPopUpController.class.getResource("../fxml/MEMFindIDPopUp.fxml"));
			Parent memFindIDPopUpRoot = loader.load();

			MEMFindIDPopUpController memFindIDPopUpController = loader.getController();
			memFindIDPopUpController.setLogInController(this);

			Scene scene = new Scene(memFindIDPopUpRoot);
			memFindIDPopUpStage.setScene(scene);
			memFindIDPopUpStage.initStyle(StageStyle.UNDECORATED);
			memFindIDPopUpStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btnSearchPWAction(ActionEvent event) {
    	Stage memFindPWPopUpStage = new Stage();
		memFindPWPopUpStage.initModality(Modality.APPLICATION_MODAL);
		memFindPWPopUpStage.initOwner(logInStage);

		try {
			FXMLLoader loader = new FXMLLoader(
					MEMFindPWPopUpController.class.getResource("../fxml/MEMFindPWPopUp.fxml"));
			Parent memFindPWPopUpRoot = loader.load();

			MEMFindPWPopUpController memFindPWPopUpController = loader.getController();
			memFindPWPopUpController.setLogInController(this);

			Scene scene = new Scene(memFindPWPopUpRoot);
			memFindPWPopUpStage.setScene(scene);
			memFindPWPopUpStage.initStyle(StageStyle.UNDECORATED);
			memFindPWPopUpStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void mainFrameOnMouseDrag(MouseEvent event) {

    }
    
    public void focusId() {
    	tfUserID.requestFocus();
    }
    
    @FXML
    void initialize() throws Exception {
    	
    	Font.loadFont(getClass().getResourceAsStream("../z.source/KaushanScript-Regular.otf"), 12);
    	
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
				Stage primaryStage = (Stage) mainFrame.getScene().getWindow();
				primaryStage.setX(event.getScreenX() - xOffset);
				primaryStage.setY(event.getScreenY() - yOffset);


			}
		});

		String path = new File("./src/z.source/loginVideo.mp4").getCanonicalPath();
		me = new Media(new File(path).toURI().toString());
		mp = new MediaPlayer(me);
		mediaView.setMediaPlayer(mp);
		mp.setAutoPlay(true);
		DoubleProperty width = mediaView.fitWidthProperty();
		DoubleProperty height = mediaView.fitHeightProperty();

		width.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
		height.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));

		memberService = MemberServiceImpl.getInstance();
		adminService = AdminServiceImpl.getInstance();
		sha256 = new Sha256();

		tfPassword.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				try {
					if (event.getCode() == KeyCode.ENTER) {
						Map<String, String> params = new HashMap<String, String>(); // 아이디와 비밀번호를 담을 변수
						boolean result; // 결과를 담을 변수
						
						params.put("mem_id", tfUserID.getText()); // id담기
						params.put("mem_pw", sha256.encrypt(tfPassword.getText())); // pw담기
						result = memberService.isExistAccount(params); // id와 pw가 맞는지 결과를 가져옴
						
						
						if(adminService.isExistAccount(params)) { // 어드민 테이블에 있는지 검사하는 조건
							// 어드민 메인 페이지로 이동
							try {
								Stage logInStage = (Stage) mainFrame.getScene().getWindow();
								FXMLLoader loader = new FXMLLoader(AdminShowMainController.class.getResource("../fxml/AdminShowMain.fxml"));
								Parent adminShowMainRoot = loader.load();
								
								Scene scene = new Scene(adminShowMainRoot);
								logInStage.setScene(scene);
								logInStage.show();
								
							} catch (Exception e) {
								e.printStackTrace();
							}
						}else { // 어드민 테이블에 없을경우
							if(result) { // 회원 테이블에 있는지 검사하는 조건
								// 회원 메인페이지로 이동
								try {
									Stage logInStage = (Stage) mainFrame.getScene().getWindow();
									FXMLLoader loader = new FXMLLoader(MEMShowMainController.class.getResource("../fxml/MEMShowMain.fxml"));
									session = memberService.getMemberData(tfUserID.getText());
									Parent memShowMainRoot = loader.load();
									
									Scene scene = new Scene(memShowMainRoot);
									logInStage.setScene(scene);
									logInStage.show();
									
								} catch (Exception e) {
									e.printStackTrace();
								}
							}else if (tfUserID.getText().isEmpty() || tfPassword.getText().isEmpty()){
								lblLoginClickFeedback.setText("아이디와 비밀번호를 입력해주세요.");
							}else {// 회원테이블에도 없을경우
								// 로그인실패
								lblLoginClickFeedback.setText("아이디나 비밀번호가 틀렸습니다.");
							}
						}
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			};
		});
		
		 tfUserID.setOnKeyReleased(new EventHandler<KeyEvent>() {
	         @Override
	         public void handle(KeyEvent event) {
	        	 try {
						if (event.getCode() == KeyCode.ENTER) {
							Map<String, String> params = new HashMap<String, String>(); // 아이디와 비밀번호를 담을 변수
							boolean result; // 결과를 담을 변수
							
							params.put("mem_id", tfUserID.getText()); // id담기
							params.put("mem_pw", sha256.encrypt(tfPassword.getText())); // pw담기
							result = memberService.isExistAccount(params); // id와 pw가 맞는지 결과를 가져옴
							
							
							if(adminService.isExistAccount(params)) { // 어드민 테이블에 있는지 검사하는 조건
								// 어드민 메인 페이지로 이동
								try {
									Stage logInStage = (Stage) mainFrame.getScene().getWindow();
									FXMLLoader loader = new FXMLLoader(AdminShowMainController.class.getResource("../fxml/AdminShowMain.fxml"));
									Parent adminShowMainRoot = loader.load();
									
									Scene scene = new Scene(adminShowMainRoot);
									logInStage.setScene(scene);
									logInStage.show();
									
								} catch (Exception e) {
									e.printStackTrace();
								}
							}else { // 어드민 테이블에 없을경우
								if(result) { // 회원 테이블에 있는지 검사하는 조건
									// 회원 메인페이지로 이동
									try {
										Stage logInStage = (Stage) mainFrame.getScene().getWindow();
										FXMLLoader loader = new FXMLLoader(MEMShowMainController.class.getResource("../fxml/MEMShowMain.fxml"));
										session = memberService.getMemberData(tfUserID.getText());
										Parent memShowMainRoot = loader.load();
										
										Scene scene = new Scene(memShowMainRoot);
										logInStage.setScene(scene);
										logInStage.show();
										
									} catch (Exception e) {
										e.printStackTrace();
									}
								}else if (tfUserID.getText().isEmpty() || tfPassword.getText().isEmpty()){
									lblLoginClickFeedback.setText("아이디와 비밀번호를 입력해주세요.");
								}else {// 회원테이블에도 없을경우
									// 로그인실패
									lblLoginClickFeedback.setText("아이디나 비밀번호가 틀렸습니다.");
								}
							}
						}
						
					} catch (Exception e) {
						e.printStackTrace();
					}
	         };
	      });
    }
}
