package controller;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.ResourceBundle;

import org.json.simple.JSONObject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.crypto.Aes256;
import main.crypto.Sha256;
import main.mail.Coolsms;
import main.regEx.RegEx;
import main.vo.MemberVO;
import service.member.MemberServiceImpl;

public class MEMJoinPopUpController {

	private MemberServiceImpl memberService;
	private LoginController logInController;
	private Stage memJoinPopUpStage;
	private Sha256 sha256;
	private Aes256 aes256;
	private String tmpAddr;
	private String tmpPost;

	public String getTmpAddr() {
		return tmpAddr;
	}

	public void setTmpAddr(String tmpAddr) {
		this.tmpAddr = tmpAddr;
	}

	public String getTmpPost() {
		return tmpPost;
	}

	public void setTmpPost(String tmpPost) {
		this.tmpPost = tmpPost;
	}

	public LoginController getLogInController() {
		return logInController;
	}

	public void setLogInController(LoginController logInController) {
		this.logInController = logInController;
	}

	public Stage getMemJoinPopUpStage() {
		return memJoinPopUpStage;
	}

	public void setMemJoinPopUpStage(Stage memJoinPopUpStage) {
		this.memJoinPopUpStage = memJoinPopUpStage;
	}

	boolean id = false;
	boolean pw = false;
	boolean pwCheck = false;
	boolean name = false;
	boolean tel = false;
	boolean regNo = false;
	boolean email = false;
	boolean lang = false;
	boolean confirm = false;
	boolean addr = false;

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
	private TextField tfName;

	@FXML
	private TextField tfPhone;

	@FXML
	private ComboBox<String> phoneCombo;

	@FXML
	private TextField tfRegno1;

	@FXML
	private TextField tfEmail;

	@FXML
	private ComboBox<String> emailComBo;

	@FXML
	private Button btnAdductionSend;

	@FXML
	private TextField tfadduction;

	@FXML
	private Button btnAdductionCheck;

	@FXML
	private Button btnJoin;

	@FXML
	private TextField tfpost;

	@FXML
	private Button btnSearchZip;

	@FXML
	private TextField tfDetailedAddr;

	@FXML
	private TextField tfAddr;

	@FXML
	private PasswordField tfPw;

	@FXML
	private PasswordField tfPwCheck;

	@FXML
	private TextArea taIntrod;

	@FXML
	private Label idLbl;

	@FXML
	private Label pwcheckLbl;

	@FXML
	private Label emailLbl;

	@FXML
	private Label regnoLbl;

	@FXML
	private Label phoneLbl;

	@FXML
	private Label nameLbl;

	@FXML
	private Label pwLbl;

	@FXML
	private ImageView btnClose;

	@FXML
	private RadioButton chkILangJava;

	@FXML
	private ToggleGroup chkILang;

	@FXML
	private RadioButton chkILangCpp;

	@FXML
	private RadioButton chkILangOracle;

	@FXML
	private RadioButton chkILangPython;

	@FXML
	private RadioButton chkMLangJava;

	@FXML
	private ToggleGroup chkMLang;

	@FXML
	private RadioButton chkMLangCpp;

	@FXML
	private RadioButton chkMLangOracle;

	@FXML
	private RadioButton chkMLangPython;

	@FXML
	private ImageView btnMin;

	@FXML
	private PasswordField tfRegno2;

	@FXML
	private Label lblAddr;

	@FXML
	private Label lblLang;

	@FXML
	private Label lblConfirm;

	String passNum = "";

	private void randomPassNum() {
		if (passNum != null) {
			passNum = "";
		}

		for (int i = 0; i < 6; i++) {
			passNum += (int) (Math.random() * 9) + "";
		}
	}

	@FXML
	void btnAdductionCheckClick(ActionEvent event) {
		if ((!passNum.isEmpty() && !tfadduction.getText().isEmpty()) && tfadduction.getText().equals(passNum)) {
			lblConfirm.setText("");
			tfadduction.setDisable(true);
			btnAdductionSend.setDisable(true);
			btnAdductionCheck.setDisable(true);
			confirm = true;
		} else {
			lblConfirm.setText("인증번호가 맞지 않습니다.");
			confirm = false;
		}
	}

	@FXML
	void btnAdductionSendClick(ActionEvent event) {

		if (phoneCombo.getSelectionModel().isEmpty() && tfPhone.getText().isEmpty()) {
			phoneLbl.setText("필수 입력 사항입니다.");
			tel = false;
		} else if (!RegEx.checkMemTel(tfPhone.getText())) {
			phoneLbl.setText("(-)를 제외하여 입력해주세요.");
			tel = false;
		}

		if (!(phoneCombo.getSelectionModel().isEmpty() && tfPhone.getText().isEmpty())
				&& (RegEx.checkMemTel(tfPhone.getText()))) {
			phoneLbl.setText("");

			randomPassNum();

			System.out.println(passNum);

			// 이부분은 진짜로 문자를 보내느 부분임

			/*
			String userPhoneNumber = tfPhone.getText();

			String api_key = "NCSCSBUAEXBTTNWQ";
			String api_secret = "TS32CPOK2VPJVGIFENNOPV8PQAAWERS1";

			Coolsms coolsms = new Coolsms(api_key, api_secret);
			HashMap<String, String> params = new HashMap<String, String>();
			params.put("to", userPhoneNumber);
			params.put("from", "01048612847");
			params.put("type", "SMS");
			params.put("text", "[두런두런인증번호]고객님의 인증번호는 (" + passNum + ")입니다.");
			params.put("app_version", "test app 1.2");

			try {
				JSONObject obj = (JSONObject) coolsms.send(params);
			} catch (Exception e) {
				e.printStackTrace();
			}
			*/

			Stage popUpStage = new Stage();
			popUpStage.initModality(Modality.APPLICATION_MODAL);
			popUpStage.initOwner(memJoinPopUpStage);

			try {
				FXMLLoader loader = new FXMLLoader(BasicPopUpController.class.getResource("../fxml/BasicPopUp.fxml"));
				Parent basicPopUpRoot = loader.load();

				BasicPopUpController basicPopUpController = loader.getController();
				basicPopUpController.setMemJoinPopUpController(this);
				basicPopUpController.getBtnCancel().setVisible(false);
				basicPopUpController.getBtnConfirm().setVisible(false);
				basicPopUpController.setLbText("인증번호가 발송되었습니다.");

				Scene scene = new Scene(basicPopUpRoot);
				popUpStage.setScene(scene);
				popUpStage.initStyle(StageStyle.UNDECORATED);
				popUpStage.show();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@FXML
	void btnCloseClick(MouseEvent event) {
		Stage memJoinPopUpStage = (Stage) pane.getScene().getWindow();
		memJoinPopUpStage.close();
	}

	@FXML
	void btnJoinClick(ActionEvent event) throws UnsupportedEncodingException, GeneralSecurityException {
		System.out.println(tfpost.getText());
		// 아이디
		if (tfId.getText().isEmpty()) { // 비어있다면
			idLbl.setText("필수 입력 사항입니다.");
			id = false;
		} else if (!RegEx.checkMemId(tfId.getText())) { // 정규식에 맞지 않다면
			idLbl.setText("5~20자의 영문 소문자, 대문자, 숫자, 특수기호(_), (_) 만 사용 가능합니다.");
			id = false;
		} else if (memberService.isExistMemId(tfId.getText())) { // 중복된 아이디라면
			idLbl.setText("이미 존재하는 ID입니다.");
			id = false;
		}
		if (!tfId.getText().isEmpty() && RegEx.checkMemId(tfId.getText())
				&& !memberService.isExistMemId(tfId.getText())) {
			idLbl.setText("");
			id = true;
		}

		// 비밀번호
		if (tfPw.getText().isEmpty()) {
			pwLbl.setText("필수 입력 사항입니다.");
			pw = false;
		} else if (!RegEx.checkMemPw(tfPw.getText())) {
			pwLbl.setText("8~16자 영문 대 소문자, 숫자, 특수문자를 사용해주세요.");
			pw = false;
		}
		if (!tfPw.getText().isEmpty() && RegEx.checkMemPw(tfPw.getText())) {
			pwLbl.setText("");
			pw = true;
		}

		// 비밀번호 확인
		if (tfPwCheck.getText().isEmpty()) {
			pwcheckLbl.setText("필수 입력 사항입니다");
			pwCheck = false;
		} else if (!tfPw.getText().equals(tfPwCheck.getText())) {
			pwcheckLbl.setText("비밀번호가 일치하지 않습니다.");
			pwCheck = false;
		}
		if (!tfPwCheck.getText().isEmpty() && tfPw.getText().equals(tfPwCheck.getText())) {
			pwcheckLbl.setText("");
			pwCheck = true;
		}

		// 이름
		if (tfName.getText().isEmpty()) {
			nameLbl.setText("필수 입력 사항입니다.");
			name = false;
		} else if (!RegEx.checkMemName(tfName.getText())) {
			nameLbl.setText("2~5자 한글만 입력 가능합니다.");
			name = false;
		}
		if (!tfName.getText().isEmpty() && RegEx.checkMemName(tfName.getText())) {
			nameLbl.setText("");
			name = true;
		}

		// 전화번호
		if (phoneCombo.getSelectionModel().isEmpty() && tfPhone.getText().isEmpty()) {
			phoneLbl.setText("필수 입력 사항입니다.");
			tel = false;
		} else if (!RegEx.checkMemTel(tfPhone.getText())) {
			phoneLbl.setText("(-)를 제외하여 입력해주세요.");
			tel = false;
		}
		if (!(phoneCombo.getSelectionModel().isEmpty() || tfPhone.getText().isEmpty())
				&& RegEx.checkMemTel(tfPhone.getText())) {
			phoneLbl.setText("");
			tel = true;
		}

		// 주민등록번호
		if (tfRegno1.getText().isEmpty() || tfRegno2.getText().isEmpty()) {
			regnoLbl.setText("필수 입력 사항입니다.");
			regNo = false;
		}
		String memRegNo = tfRegno1.getText().concat(tfRegno2.getText());
		int tmp = 2;
		int stepOne = 0;
		int stepTwo = 0;
		int stepThree = 0;
		int stepFour = 0;
		for (int i = 0; i < memRegNo.length() - 1; i++) {
			stepOne += Character.getNumericValue(memRegNo.charAt(i)) * tmp;
			tmp++;
			if (i == 7) {
				tmp = 2;
			}
		}
		stepTwo = stepOne % 11;
		stepThree = 11 - stepTwo;
		if (stepThree >= 0 && stepThree <= 9) {
			stepFour = stepThree;
		} else if (stepThree == 10) {
			stepFour = 0;
		} else if (stepThree == 11) {
			stepFour = 1;
		}
		if (!memRegNo.isEmpty()) {
			if (stepFour == Character.getNumericValue(memRegNo.charAt(12))) {
				regnoLbl.setText("");
				regNo = true;
			} else {
				regnoLbl.setText("주민번호를 다시 확인해주세요.");
				regNo = false;
			}
		}

		// 이메일
		if (tfEmail.getText().isEmpty()) {
			emailLbl.setText("필수 입력 사항입니다.");
			email = false;
		} else if (!RegEx.checkMemMail(tfEmail.getText())) {
			emailLbl.setText("이메일 형식에 맞지 않습니다.");
			email = false;
		}
		if (!tfEmail.getText().isEmpty() && RegEx.checkMemMail(tfEmail.getText())) {
			emailLbl.setText("");
			email = true;
		}

		// 주소
		boolean addr = false;
		if (tfpost.getText().isEmpty() || tfAddr.getText().isEmpty() || tfDetailedAddr.getText().isEmpty()) {
			lblAddr.setText("주소를 입력해주세요.");
			addr = false;
		} else {
			lblAddr.setText("");
			addr = true;
		}

		// 언어1
		if (chkILang.getSelectedToggle() == null || chkMLang.getSelectedToggle() == null) { // 선택안했을때
			lblLang.setText("언어를 최소 한개씩 선택해주세요.");
			lang = false;
		} else if (chkILang.getSelectedToggle() != null && chkMLang.getSelectedToggle() != null) {
			lblLang.setText("");
			lang = true;
		}

		// 최종적으로 모두 패스할경우에만 회원정보가 데이터베이스에 저장됨
		if (id && pw && pwCheck && name && tel && regNo && email && addr && lang && confirm) {
			MemberVO mem = new MemberVO();
			mem.setMem_id(tfId.getText());
			mem.setMem_name(tfName.getText());
			mem.setMem_pw(sha256.encrypt(tfPw.getText()));
			mem.setMem_regno1(tfRegno1.getText());
			String tmpRegno2 = tfRegno2.getText().substring(0, 1);
			mem.setMem_regno2(tmpRegno2 + aes256.encrypt(tfRegno2.getText().substring(1, 6)));
			mem.setMem_tel(phoneCombo.getSelectionModel().getSelectedItem() + tfPhone.getText());
			mem.setMem_email(tfEmail.getText() + "@" + emailComBo.getSelectionModel().getSelectedItem());
			mem.setMem_addr(tfAddr.getText());
			mem.setMem_zip(tfpost.getText());
			mem.setMem_dtladdr(tfDetailedAddr.getText());
			mem.setMem_point(0);
			mem.setMem_grade("BRONZE");
			if (taIntrod.getText().isEmpty()) {
				taIntrod.setText("안녕하세요! 잘부탁드립니다.");
			}
			mem.setMem_introd(taIntrod.getText());
			mem.setMem_act_yn("Y");
			mem.setLang_itrst((int) chkILang.getSelectedToggle().getUserData());
			mem.setLang_major((int) chkMLang.getSelectedToggle().getUserData());
			memberService.memberJoin(mem);

			Stage memJoinPopUpStage = (Stage) pane.getScene().getWindow();
			memJoinPopUpStage.close();

			Stage popUpStage = new Stage();
			popUpStage.initModality(Modality.APPLICATION_MODAL);
			popUpStage.initOwner(memJoinPopUpStage);

			try {
				FXMLLoader loader = new FXMLLoader(BasicPopUpController.class.getResource("../fxml/BasicPopUp.fxml"));
				Parent basicPopUpRoot = loader.load();

				BasicPopUpController basicPopUpController = loader.getController();
				basicPopUpController.setMemJoinPopUpController(this);
				basicPopUpController.getBtnCancel().setVisible(false);
				basicPopUpController.getBtnConfirm().setVisible(false);
				basicPopUpController.setLbText(tfName.getText() + "님 회원가입에 성공하셨습니다!");

				Scene scene = new Scene(basicPopUpRoot);
				popUpStage.setScene(scene);
				popUpStage.initStyle(StageStyle.UNDECORATED);
				popUpStage.show();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@FXML
	void btnMinClick(MouseEvent event) {
		Stage memJoinPopUpStage = (Stage) pane.getScene().getWindow();
		memJoinPopUpStage.setIconified(true);
	}

	@FXML
	void btnSearchZipClick(ActionEvent event) {
		Stage memSearchZipPopUpStage = new Stage();
		memSearchZipPopUpStage.initModality(Modality.APPLICATION_MODAL);
		memSearchZipPopUpStage.initOwner(memJoinPopUpStage);

		try {
			FXMLLoader loader = new FXMLLoader(
					MEMSearchZipPopUpController.class.getResource("../fxml/MEMSearchZipPopUp.fxml"));
			Parent memSearchZipPopUpRoot = loader.load();

			MEMSearchZipPopUpController memSearchZipPopUpController = loader.getController();
			memSearchZipPopUpController.setMemJoinPopUpController(this);

			Scene scene = new Scene(memSearchZipPopUpRoot);
			memSearchZipPopUpStage.setScene(scene);
			memSearchZipPopUpStage.initStyle(StageStyle.UNDECORATED);
			memSearchZipPopUpStage.showAndWait();

			tfAddr.setText(memSearchZipPopUpController.getTmpAddr());
			tfpost.setText(memSearchZipPopUpController.getTmpPost());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void initialize() throws UnsupportedEncodingException {
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

		memberService = MemberServiceImpl.getInstance();
		emailComBo.getItems().addAll("gmail.com", "naver.com", "daum.net");
		phoneCombo.getItems().addAll("010", "011", "013");
		sha256 = new Sha256();
		aes256 = new Aes256();

		chkILangJava.setUserData(1);
		chkILangCpp.setUserData(2);
		chkILangPython.setUserData(3);
		chkILangOracle.setUserData(4);

		chkMLangJava.setUserData(1);
		chkMLangCpp.setUserData(2);
		chkMLangPython.setUserData(3);
		chkMLangOracle.setUserData(4);
	}
}
