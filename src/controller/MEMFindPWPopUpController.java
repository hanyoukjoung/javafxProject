package controller;

import java.net.URL;
import java.util.HashMap;
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
import main.crypto.Sha256;
import main.mail.Mail;
import main.vo.MemberVO;
import service.member.MemberServiceImpl;

public class MEMFindPWPopUpController {

	private LoginController logInController;
	private MemberServiceImpl memberService;
	private Stage memFindIDPopUpStage;
	private Sha256 sha256;

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
				passNum += tmp+"";
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

	// 랜덤비밀번호 난수를 만드는 메서드
	private void getNewPass() {
		if (newPass != null) {
			newPass = "";
		}
		for (int i = 0; i < 13; i++) {
			int tmp = (int) (Math.random() * 38);
			if (tmp < 10) {
				newPass += tmp+"";
			}
			switch (tmp) { // 10~35는 영문자를 더함
			case 10:
				newPass += "a";
				break;
			case 11:
				newPass += "b";
				break;
			case 12:
				newPass += "c";
				break;
			case 13:
				newPass += "d";
				break;
			case 14:
				newPass += "e";
				break;
			case 15:
				newPass += "f";
				break;
			case 16:
				newPass += "g";
				break;
			case 17:
				newPass += "h";
				break;
			case 18:
				newPass += "i";
				break;
			case 19:
				newPass += "j";
				break;
			case 20:
				newPass += "k";
				break;
			case 21:
				newPass += "l";
				break;
			case 22:
				newPass += "n";
				break;
			case 23:
				newPass += "m";
				break;
			case 24:
				newPass += "o";
				break;
			case 25:
				newPass += "p";
				break;
			case 26:
				newPass += "q";
				break;
			case 27:
				newPass += "r";
				break;
			case 28:
				newPass += "s";
				break;
			case 29:
				newPass += "t";
				break;
			case 30:
				newPass += "u";
				break;
			case 31:
				newPass += "v";
				break;
			case 32:
				newPass += "w";
				break;
			case 33:
				newPass += "x";
				break;
			case 34:
				newPass += "y";
				break;
			case 35:
				newPass += "z";
				break;
			case 36:
				newPass += "!";
				break;
			case 37:
				newPass += "@";
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
	private TextField tfId;

	@FXML
	private TextField tfEmail;

	@FXML
	private ComboBox<String> emailComBo;

	@FXML
	private Button btnAdductionSend;

	@FXML
	private Button btnAdductionCheck;

	@FXML
	private TextField tfAdduction;

	@FXML
	private ImageView btnClose;

	@FXML
	private ImageView btnMin;

	@FXML
	private Label lblSendResult;

	@FXML
	private Label lblConfirmResult;

	@FXML
	void btnAdductionCheckClick(ActionEvent event) throws Exception {
		// 난수와 입력란이 맞는지 검사하는 메서드 양쪽이 일치한다면 난수로 비밀번호를 만들어서 해당 아이디 비밀번호를 바꿈
		if ((!passNum.isEmpty() && !tfAdduction.getText().isEmpty()) && passNum.equals(tfAdduction.getText())) {

			// 1. 이메일을 보내고
			getNewPass();
//			System.out.println(newPass);
//			System.out.println(passNum);
			sendMail("woodudfo@naver.com", tfEmail.getText() + "@" + emailComBo.getSelectionModel().getSelectedItem(),
					"[두런두런] 임시 패스워드 입니다.", "임시 패스워드는 [" + newPass + "] 입니다.");

			// 2. 창이 꺼지며
			Stage memFindIDPopUpStage = (Stage) pane.getScene().getWindow();
			memFindIDPopUpStage.close();

			// 3. 팝업창을 띄움
			Stage popUpStage = new Stage();
			popUpStage.initModality(Modality.APPLICATION_MODAL);
			popUpStage.initOwner(memFindIDPopUpStage);

			try {
				FXMLLoader loader = new FXMLLoader(BasicPopUpController.class.getResource("../fxml/BasicPopUp.fxml"));
				Parent basicPopUpRoot = loader.load();

				BasicPopUpController basicPopUpController = loader.getController();
				basicPopUpController.setMemFindPWPopUpController(this);
				basicPopUpController.setLbText("이메일로 임시 패스워드가 전송되었습니다.");

				Scene scene = new Scene(basicPopUpRoot);
				popUpStage.setScene(scene);
				popUpStage.initStyle(StageStyle.UNDECORATED);
				popUpStage.show();

			} catch (Exception e) {
				e.printStackTrace();
			}

			// 4. 데이터베이스에 해당회원 비밀번호를 변경하기
			Map<String, String> params = new HashMap<String, String>();
			params.put("mem_id", tfId.getText());
			String encrytPass = sha256.encrypt(newPass);
			params.put("mem_pw", encrytPass);
			memberService.updateMemPass(params);

		} else {
			lblConfirmResult.setText("인증코드가 일치 하지 않습니다.");
		}
	}

	@FXML
	void btnAdductionSendClick(ActionEvent event) {
		MemberVO mem = memberService.getMemberData(tfId.getText());
		if (!tfId.getText().isEmpty() && !tfEmail.getText().isEmpty() && !emailComBo.getSelectionModel().isEmpty()) { // 입력을 다
																												// 했을
			System.out.println(newPass);
			System.out.println(passNum);		
			System.out.println(11111);// 경우에만
			if (memberService.isExistMemId(tfId.getText()) == false) {
				lblSendResult.setText("존재하지 않는 아이디 입니다.");
			}
			if (!mem.getMem_email()
					.equals(tfEmail.getText() + "@" + emailComBo.getSelectionModel().getSelectedItem())) {
				lblSendResult.setText("아이디와 이메일이 맞지 않습니다.");
			} else {
				lblSendResult.setText("");
				getPassNum();
				sendMail("woodudfo@naver.com",
						tfEmail.getText() + "@" + emailComBo.getSelectionModel().getSelectedItem(),
						"[두런두런] 이메일 인증 코드입니다.", "인증 코드는 [" + passNum + "] 입니다.");

				Stage popUpStage = new Stage();
				popUpStage.initModality(Modality.APPLICATION_MODAL);
				popUpStage.initOwner(memFindIDPopUpStage);

				try {
					FXMLLoader loader = new FXMLLoader(
							BasicPopUpController.class.getResource("../fxml/BasicPopUp.fxml"));
					Parent basicPopUpRoot = loader.load();

					BasicPopUpController basicPopUpController = loader.getController();
					basicPopUpController.setMemFindPWPopUpController(this);
					basicPopUpController.setLbText("이메일로 인증코드가 전송되었습니다.");

					Scene scene = new Scene(basicPopUpRoot);
					popUpStage.setScene(scene);
					popUpStage.initStyle(StageStyle.UNDECORATED);
					popUpStage.show();

				} catch (Exception e) {
					e.printStackTrace();
				}
				tfId.setDisable(true);
				tfEmail.setDisable(true);
				emailComBo.setDisable(true);
			}
		} else { // 입력을 안했을 경우
			lblSendResult.setText("아이디와 이메일을 입력해주세요.");
		}
	}

	@FXML
	void btnCloseClick(MouseEvent event) {
		Stage memFindPWPopUpStage = (Stage) pane.getScene().getWindow();
		memFindPWPopUpStage.close();
	}

	@FXML
	void btnMinClick(MouseEvent event) {
		Stage memFindPWPopUpStage = (Stage)pane.getScene().getWindow();
		memFindPWPopUpStage.setIconified(true);
	}

	@FXML
	void initialize() throws Exception {
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
		sha256 = new Sha256();
	}
}
