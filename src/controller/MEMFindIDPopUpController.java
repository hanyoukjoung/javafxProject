package controller;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.mail.Mail;
import service.member.MemberServiceImpl;

public class MEMFindIDPopUpController {

	private LoginController logInController;
	private MemberServiceImpl memberService;
	private Stage memFindIDPopUpStage;

	private String passNum = "";
	private String newPass = "";

	public LoginController getLogInController() {
		return logInController;
	}

	public void setLogInController(LoginController logInController) {
		this.logInController = logInController;
	}

	public Stage getMemFindIDPopUpStage() {
		return memFindIDPopUpStage;
	}

	public void setMemFindIDPopUpStage(Stage memFindIDPopUpStage) {
		this.memFindIDPopUpStage = memFindIDPopUpStage;
	}

	// 이메일을 보내는 메서드
	private void sendMail(String email_from, String email_to, String email_subject, String email_content) {
		String from = email_from;
		String to = email_to;
		String cc = "";
		String subject = email_subject;
		String content = email_content;

		if (from.trim().equals("")) {
			// 보낸사람을 입력하지 않았을 때
		} else if (to.trim().equals("")) {
			// 받는 사람을 입력하지 않았을 때
		} else {
			try {
				Mail mail = new Mail();

				// 메일보내기
				mail.sendMail(from, to, cc, subject, content);

				// 메일보내기에 성공했을 시
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// 이메일에 보낼 난수를 만드는 메서드
	private void getPassNum() {
		if (passNum != null) { // 이미 만들어져 있다면 초기화하고 다시 넣음
			passNum = "";
		}
		for (int i = 0; i < 11; i++) { // 10자리만듬
			int tmp = (int) (Math.random() * 36); // tmp에 난수를 넣음
			if (tmp < 10) { // 0~9는 그냥 더함
				passNum += tmp;
			}
			switch (tmp) { // 10~35는 영문자를 더함
			case 10:
				passNum += "a";
				break;
			case 11:
				passNum += "b";
				break;
			case 12:
				passNum += "c";
				break;
			case 13:
				passNum += "d";
				break;
			case 14:
				passNum += "e";
				break;
			case 15:
				passNum += "f";
				break;
			case 16:
				passNum += "g";
				break;
			case 17:
				passNum += "h";
				break;
			case 18:
				passNum += "i";
				break;
			case 19:
				passNum += "j";
				break;
			case 20:
				passNum += "k";
				break;
			case 21:
				passNum += "l";
				break;
			case 22:
				passNum += "n";
				break;
			case 23:
				passNum += "m";
				break;
			case 24:
				passNum += "o";
				break;
			case 25:
				passNum += "p";
				break;
			case 26:
				passNum += "q";
				break;
			case 27:
				passNum += "r";
				break;
			case 28:
				passNum += "s";
				break;
			case 29:
				passNum += "t";
				break;
			case 30:
				passNum += "u";
				break;
			case 31:
				passNum += "v";
				break;
			case 32:
				passNum += "w";
				break;
			case 33:
				passNum += "x";
				break;
			case 34:
				passNum += "y";
				break;
			case 35:
				passNum += "z";
				break;
			}
		}

	}

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private AnchorPane pane;
	private double xOffset = 0;
	private double yOffset = 0;

	@FXML
	private TextField tfName;

	@FXML
	private TextField tfEmail;

	@FXML
	private ComboBox<String> emailComBo;

	@FXML
	private Button btnAdductionCheck;

	@FXML
	private ImageView btnClose;

	@FXML
	private ImageView btnMin;

	@FXML
	private Label lblSendResult;

	@FXML
	void btnAdductionCheckClick(ActionEvent event) {
		if (tfName.getText().isEmpty() || tfEmail.getText().isEmpty() || emailComBo.getSelectionModel().isEmpty()) {
			lblSendResult.setText("아이디와 이메일 주소를 입력해주세요.");
		} else {
			lblSendResult.setText("");
			Map<String, String> params = new HashMap<String, String>();
			params.put("mem_name", tfName.getText());
			params.put("mem_email", tfEmail.getText() + "@" + emailComBo.getSelectionModel().getSelectedItem());
			List<String> list = memberService.getMemId(params);

			if (list.size() == 0) {
				Stage popUpStage = new Stage();
				popUpStage.initModality(Modality.APPLICATION_MODAL);
				popUpStage.initOwner(memFindIDPopUpStage);

				try {
					FXMLLoader loader = new FXMLLoader(
							BasicPopUpController.class.getResource("../fxml/BasicPopUp.fxml"));
					Parent basicPopUpRoot = loader.load();

					BasicPopUpController basicPopUpController = loader.getController();
					basicPopUpController.setMemFindIDPopUpController(this);
					basicPopUpController.setLbText("일치하는 ID가 없습니다.");

					Scene scene = new Scene(basicPopUpRoot);
					popUpStage.setScene(scene);
					popUpStage.initStyle(StageStyle.UNDECORATED);
					popUpStage.show();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}else {
				String email_content = "회원명 : " +tfName.getText() +"으로 검색된 결과입니다. \n";
				for(int i = 0; i < list.size(); i++) {
					email_content += "[" +list.get(i) +"]";
					if(list.size() != i+1) {
						email_content += ", ";
					}
					if(i%5 == 0) {
						email_content += "\n";
					}
				}
				sendMail("woodudfo@naver.com", tfEmail.getText() +"@" +emailComBo.getSelectionModel().getSelectedItem(), "[두런두런] 아이디 검색 결과입니다.", email_content);
				
				Stage popUpStage = new Stage();
				popUpStage.initModality(Modality.APPLICATION_MODAL);
				popUpStage.initOwner(memFindIDPopUpStage);

				try {
					FXMLLoader loader = new FXMLLoader(
							BasicPopUpController.class.getResource("../fxml/BasicPopUp.fxml"));
					Parent basicPopUpRoot = loader.load();

					BasicPopUpController basicPopUpController = loader.getController();
					basicPopUpController.setMemFindIDPopUpController(this);
					basicPopUpController.setLbText(tfEmail.getText() +"@" +emailComBo.getSelectionModel().getSelectedItem() +"로 \n아이디를 전송했습니다.");

					Scene scene = new Scene(basicPopUpRoot);
					popUpStage.setScene(scene);
					popUpStage.initStyle(StageStyle.UNDECORATED);
					popUpStage.show();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		/*
		 * 1. 이름과 이메일을 받아 2. 이름 = 이메일에 맞는 id들을 list에 담아 3. 입력받았던 이메일로 id들을 보냄. 4. 만약
		 * list가 null이면 보내지 말고 팝업으로 존재하는 id가 없다고 알림
		 */
	}

	@FXML
	void btnCloseClick(MouseEvent event) {
		Stage memJoinPopUpStage = (Stage) pane.getScene().getWindow();
		memJoinPopUpStage.close();
	}

	@FXML
	void btnMinClick(MouseEvent event) {
		Stage memFindIDPopUpStage = (Stage)pane.getScene().getWindow();
		memFindIDPopUpStage.setIconified(true);
	}

	@FXML
	void initialize() {
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
				Stage primaryStage = (Stage) pane.getScene().getWindow();
				primaryStage.setX(event.getScreenX() - xOffset);
				primaryStage.setY(event.getScreenY() - yOffset);
			}
		});

		emailComBo.getItems().addAll("gmail.com", "naver.com", "daum.net");
		memberService = MemberServiceImpl.getInstance();
	}
}
