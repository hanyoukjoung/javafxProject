package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.crypto.Sha256;
import main.regEx.RegEx;
import main.vo.MemberVO;
import service.member.MemberServiceImpl;

public class MEMShowMyPageController {

	private Label lblUserName;
	private MEMShowMainController memShowMainController;
	private boolean iscorrectPW;
	private MemberServiceImpl memberService;
	private Sha256 sha256;
	private Stage memShowMyPageStage;

	public MEMShowMainController getMemShowMainController() {
		return memShowMainController;
	}

	public void setMemShowMainController(MEMShowMainController memShowMainController) {
		this.memShowMainController = memShowMainController;
	}

	public boolean isIscorrectPW() {
		return iscorrectPW;
	}

	public void setIscorrectPW(boolean iscorrectPW) {
		this.iscorrectPW = iscorrectPW;
	}

	public Stage getMemShowMyPageStage() {
		return memShowMyPageStage;
	}

	public void setMemShowMyPageStage(Stage memShowMyPageStage) {
		this.memShowMyPageStage = memShowMyPageStage;
	}

	public Label getLblUserName() {
		return lblUserName;
	}

	public void setLblUserName(Label lblUserName) {
		this.lblUserName = lblUserName;
	}

	boolean deleteMemOk = false;

	public boolean isDeleteMemOk() {
		return deleteMemOk;
	}

	public void setDeleteMemOk(boolean deleteMemOk) {
		this.deleteMemOk = deleteMemOk;
	}

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private AnchorPane subFrameMyPage;

	@FXML
	private Label lbl_ID;

	@FXML
	private Label lbl_name;

	@FXML
	private Label lbl_email;

	@FXML
	private Label lbl_phone;

	@FXML
	private Label lbl_zipcode;

	@FXML
	private Label lbl_introduce;

	@FXML
	private Label lbl_interest;

	@FXML
	private Label lbl_major;

	@FXML
	private Label lbl_addr1;

	@FXML
	private Label lbl_addr2;

	@FXML
	private TextField tfId;

	@FXML
	private TextField tfName;

	@FXML
	private TextField tfFirstMail;

	@FXML
	private TextField tfLastPhoneNum;

	@FXML
	private TextField tfpost;

	@FXML
	private TextField tfAddr;

	@FXML
	private TextField tfDetailedAddr1;

	@FXML
	private TextArea taIntro;

	@FXML
	private Label lblMyPage;

	@FXML
	private ComboBox<String> comboEmail;

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
	private Button btnModify;

	@FXML
	private Button btnConfirm;

	@FXML
	private Label lblNameResult;

	@FXML
	private Button btnSearchZip;

	@FXML
	private ComboBox<String> comboFirstPhoneNum;

	@FXML
	private Label lblEmailResult;

	@FXML
	private Label lblPhoneResult;

	@FXML
	private Label lblModifyResult;

	@FXML
	private Label lbl_PW;

	@FXML
	private PasswordField tfPW;

	@FXML
	private Label lbl_checkPW;

	@FXML
	private PasswordField tfPWCheck;

	@FXML
	private Label lblPWCheckResult;

	@FXML
	private Label lblPWResult;

	@FXML
	private Button btnDeleteMem;

	@FXML
	private Button btnPaymentDetails;

	@FXML
	private Button btnCash;

	@FXML
	private Button btnChangeProfile;

	@FXML
	private TextField tfFile;

	@FXML
	void btnCashClick(ActionEvent event) {

	}

	@FXML
	void btnChangeProfileClick(ActionEvent event) {

	}

	@FXML
	void btnConfirmClick(ActionEvent event) {
		boolean name = false;
		boolean email = false;
		boolean tel = false;
		boolean pw = false;
		boolean pwCheck = false;
		if (tfName.getText().isEmpty() || comboFirstPhoneNum.getSelectionModel().isEmpty() // 하나라도 입력하지 않은 컬럼이 존재한다면
				|| tfLastPhoneNum.getText().isEmpty() || tfFirstMail.getText().isEmpty()
				|| comboEmail.getSelectionModel().isEmpty() || tfpost.getText().isEmpty() || tfAddr.getText().isEmpty()
				|| tfDetailedAddr1.getText().isEmpty() || chkILang.getSelectedToggle() == null
				|| chkMLang.getSelectedToggle() == null || tfPW.getText().isEmpty() || tfPWCheck.getText().isEmpty()) {
			lblModifyResult.setText("입력하지 않은 컬럼이 있습니다.");
		} else { // 전부 입력했다면
			if (!RegEx.checkMemName(tfName.getText())) {
				lblEmailResult.setText("2~5자 한글만 입력 가능합니다.");
			} else {
				name = true;
				lblEmailResult.setText("");
			}
			if (!RegEx.checkMemMail(tfFirstMail.getText())) {
				lblEmailResult.setText("이메일 형식에 맞지 않습니다.");
			} else {
				email = true;
				lblEmailResult.setText("");
			}
			if (!RegEx.checkMemTel(tfLastPhoneNum.getText())) {
				lblPhoneResult.setText("(-)를 제외하여 입력해주세요.");
			} else {
				tel = true;
				lblPhoneResult.setText("");
			}
			if (!RegEx.checkMemPw(tfPW.getText())) {
				lblPWResult.setText("8~16자 영문 대 소문자, 숫자, 특수문자를 사용해주세요.");
			} else {
				pw = true;
				lblPWResult.setText("");
			}
			if (!tfPW.getText().equals(tfPWCheck.getText())) {
				lblPWCheckResult.setText("비밀번호가 일치 하지 않습니다.");
			} else {
				pwCheck = true;
				lblPWCheckResult.setText("");
			}
			try {
				if (name && email && tel && pw && pwCheck) {
					MemberVO mem = new MemberVO();
					mem.setMem_id(tfId.getText());
					mem.setMem_name(tfName.getText());
					mem.setMem_pw(sha256.encrypt(tfPW.getText()));
					mem.setMem_tel(comboFirstPhoneNum.getSelectionModel().getSelectedItem() + tfLastPhoneNum.getText());
					mem.setMem_email(tfFirstMail.getText() + "@" + comboEmail.getSelectionModel().getSelectedItem());
					mem.setMem_addr(tfAddr.getText());
					mem.setMem_zip(tfpost.getText());
					mem.setMem_dtladdr(tfDetailedAddr1.getText());
					if (taIntro.getText().isEmpty()) {
						taIntro.setText("안녕하세요! 잘부탁드립니다.");
					}
					mem.setMem_introd(taIntro.getText());
					mem.setLang_itrst((int) chkILang.getSelectedToggle().getUserData());
					mem.setLang_major((int) chkMLang.getSelectedToggle().getUserData());

					boolean updateResult = memberService.updateMember(mem);

					if (updateResult) {
						Stage subFrameMyPageStage = (Stage) subFrameMyPage.getScene().getWindow();

						Stage popUpStage = new Stage();
						popUpStage.initModality(Modality.APPLICATION_MODAL);
						popUpStage.initOwner(subFrameMyPageStage);

						try {
							FXMLLoader loader = new FXMLLoader(
									BasicPopUpController.class.getResource("../fxml/BasicPopUp.fxml"));
							Parent basicPopUpRoot = loader.load();

							BasicPopUpController basicPopUpController = loader.getController();
							basicPopUpController.setMemShowMyPageController(this);
							basicPopUpController.getBtnCancel().setVisible(false);
							basicPopUpController.getBtnConfirm().setVisible(false);
							basicPopUpController.setLbText("수정에 성공했습니다.");

							Scene scene = new Scene(basicPopUpRoot);
							popUpStage.setScene(scene);
							popUpStage.initStyle(StageStyle.UNDECORATED);
							popUpStage.show();

						} catch (Exception e) {
							e.printStackTrace();
						}
						lblUserName.setText(tfName.getText());
						changeStanceModify(1);

					} else {
						Stage subFrameMyPageStage = (Stage) subFrameMyPage.getScene().getWindow();

						Stage popUpStage = new Stage();
						popUpStage.initModality(Modality.APPLICATION_MODAL);
						popUpStage.initOwner(subFrameMyPageStage);

						try {
							FXMLLoader loader = new FXMLLoader(
									BasicPopUpController.class.getResource("../fxml/BasicPopUp.fxml"));
							Parent basicPopUpRoot = loader.load();

							BasicPopUpController basicPopUpController = loader.getController();
							basicPopUpController.setMemShowMyPageController(this);
							basicPopUpController.getBtnCancel().setVisible(false);
							basicPopUpController.getBtnConfirm().setVisible(false);
							basicPopUpController.setLbText("수정에 실패했습니다.");

							Scene scene = new Scene(basicPopUpRoot);
							popUpStage.setScene(scene);
							popUpStage.initStyle(StageStyle.UNDECORATED);
							popUpStage.show();

						} catch (Exception e) {
							e.printStackTrace();
						}
						changeStanceModify(1);
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@FXML
	void btnDeleteMemClick(ActionEvent event) {
		Stage subFrameMyPageStage = (Stage) subFrameMyPage.getScene().getWindow();

		Stage popUpStage = new Stage();
		popUpStage.initModality(Modality.APPLICATION_MODAL);
		popUpStage.initOwner(subFrameMyPageStage);

		try {
			FXMLLoader loader = new FXMLLoader(BasicPopUpController.class.getResource("../fxml/BasicPopUp.fxml"));
			Parent basicPopUpRoot = loader.load();

			BasicPopUpController basicPopUpController = loader.getController();
			basicPopUpController.setBtnDeleteMem(this);
			basicPopUpController.getBtnMiddleConfirm().setVisible(false);
			basicPopUpController.setLbText("정말로 탈퇴하시겠습니까 ?");

			Scene scene = new Scene(basicPopUpRoot);
			popUpStage.setScene(scene);
			popUpStage.initStyle(StageStyle.UNDECORATED);
			popUpStage.showAndWait();

			if (deleteMemOk) {
				memberService.deleteMemAccount(LoginController.getSession().getMem_id());

				LoginController.setSession(null);
				AnchorPane mainfAnchorPane = FXMLLoader
						.load(ShowLSNListController.class.getResource("../fxml/Login.fxml"));
				memShowMainController.getMainFrame().getChildren().add(mainfAnchorPane);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void btnModifyClick(ActionEvent event) {
		Stage subFrameMyPageStage = (Stage) subFrameMyPage.getScene().getWindow();

		Stage popUpStage = new Stage();
		popUpStage.initModality(Modality.APPLICATION_MODAL);
		popUpStage.initOwner(subFrameMyPageStage);

		try {
			FXMLLoader loader = new FXMLLoader(BasicPopUpController.class.getResource("../fxml/BasicPopUp.fxml"));
			Parent basicPopUpRoot = loader.load();

			BasicPopUpController basicPopUpController = loader.getController();
			basicPopUpController.setMemShowMyPageController(this);
			basicPopUpController.getTfText().setVisible(true);
			basicPopUpController.getBtnMiddleConfirm().setVisible(false);
			basicPopUpController.setLbText("비밀번호를 입력해주세요.");

			Scene scene = new Scene(basicPopUpRoot);
			popUpStage.setScene(scene);
			popUpStage.initStyle(StageStyle.UNDECORATED);
			popUpStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void btnPaymentDetailsClick(ActionEvent event) {

	}

	@FXML
	void btnSearchZipClick(ActionEvent event) {
		Stage memSearchZipPopUpStage = new Stage();
		memSearchZipPopUpStage.initModality(Modality.APPLICATION_MODAL);
		memSearchZipPopUpStage.initOwner(memShowMyPageStage);

		try {
			FXMLLoader loader = new FXMLLoader(
					MEMSearchZipPopUpController.class.getResource("../fxml/MEMSearchZipPopUp.fxml"));
			Parent memSearchZipPopUpRoot = loader.load();

			MEMSearchZipPopUpController memSearchZipPopUpController = loader.getController();
			memSearchZipPopUpController.setMemShowMyPageController(this);

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

	public void changeStanceModify() {
		if (iscorrectPW) {
			btnConfirm.setVisible(true);
			btnModify.setVisible(false);
			tfName.setDisable(false);
			comboFirstPhoneNum.setDisable(false);
			tfLastPhoneNum.setDisable(false);
			tfFirstMail.setDisable(false);
			comboEmail.setDisable(false);
			chkILangCpp.setDisable(false);
			chkILangJava.setDisable(false);
			chkILangOracle.setDisable(false);
			chkILangPython.setDisable(false);
			chkMLangCpp.setDisable(false);
			chkMLangJava.setDisable(false);
			chkMLangOracle.setDisable(false);
			chkMLangPython.setDisable(false);
			taIntro.setDisable(false);
			btnChangeProfile.setVisible(true);
			tfAddr.setDisable(false);
			tfAddr.setEditable(false);
			tfDetailedAddr1.setDisable(false);
			tfpost.setDisable(false);
			tfpost.setEditable(false);
			btnSearchZip.setDisable(false);
			tfPW.setDisable(false);
			tfPWCheck.setDisable(false);
			btnDeleteMem.setDisable(false);
		}
	}

	public void changeStanceModify(int a) {
		btnConfirm.setVisible(false);
		btnModify.setVisible(true);
		tfName.setDisable(true);
		comboFirstPhoneNum.setDisable(true);
		tfLastPhoneNum.setDisable(true);
		tfFirstMail.setDisable(true);
		comboEmail.setDisable(true);
		chkILangCpp.setDisable(true);
		chkILangJava.setDisable(true);
		chkILangOracle.setDisable(true);
		chkILangPython.setDisable(true);
		chkMLangCpp.setDisable(true);
		chkMLangJava.setDisable(true);
		chkMLangOracle.setDisable(true);
		chkMLangPython.setDisable(true);
		taIntro.setDisable(true);
		btnChangeProfile.setVisible(false);
		tfAddr.setDisable(true);
		tfAddr.setEditable(true);
		tfDetailedAddr1.setDisable(true);
		tfpost.setDisable(true);
		tfpost.setEditable(true);
		btnSearchZip.setDisable(true);
		tfPW.setDisable(true);
		tfPWCheck.setDisable(true);
		btnDeleteMem.setDisable(true);
	}

	@FXML
	void initialize() {
		btnDeleteMem.setDisable(true);
		chkILangCpp.setDisable(true);
		chkILangJava.setDisable(true);
		chkILangOracle.setDisable(true);
		chkILangPython.setDisable(true);
		chkMLangCpp.setDisable(true);
		chkMLangJava.setDisable(true);
		chkMLangOracle.setDisable(true);
		chkMLangPython.setDisable(true);
		Font.loadFont(getClass().getResourceAsStream("../z.source/GODOM.ttf"), 12);

		btnConfirm.setVisible(false);
		comboFirstPhoneNum.getItems().addAll("010", "011", "013");
		chkILangJava.setUserData(1);
		chkILangCpp.setUserData(2);
		chkILangOracle.setUserData(3);
		chkILangPython.setUserData(4);

		chkMLangJava.setUserData(1);
		chkMLangCpp.setUserData(2);
		chkMLangOracle.setUserData(3);
		chkMLangPython.setUserData(4);

		tfId.setText(LoginController.getSession().getMem_id());
		tfName.setText(LoginController.getSession().getMem_name());
		comboFirstPhoneNum.setValue(LoginController.getSession().getMem_tel().substring(0, 3));
		tfLastPhoneNum.setText(LoginController.getSession().getMem_tel().substring(3, 11));
		String[] mail = LoginController.getSession().getMem_email().split("@");
		tfFirstMail.setText(mail[0]);
		tfpost.setText(LoginController.getSession().getMem_zip());
		sha256 = new Sha256();

		switch (mail[1]) {
		case "gmail.com":
			comboEmail.setValue("gmail.com");
			break;
		case "naver.com":
			comboEmail.setValue("naver.com");
			break;
		case "daum.net":
			comboEmail.setValue("gmail.com");
			break;
		}
		tfAddr.setText(LoginController.getSession().getMem_addr());
		tfDetailedAddr1.setText(LoginController.getSession().getMem_dtladdr());

		switch (LoginController.getSession().getLang_itrst()) {
		case 1:
			chkILangJava.setSelected(true);
			break;
		case 2:
			chkILangCpp.setSelected(true);
			break;
		case 3:
			chkILangOracle.setSelected(true);
			break;
		case 4:
			chkILangPython.setSelected(true);
		}

		switch (LoginController.getSession().getLang_major()) {
		case 1:
			chkMLangJava.setSelected(true);
			break;
		case 2:
			chkMLangCpp.setSelected(true);
			break;
		case 3:
			chkMLangOracle.setSelected(true);
			break;
		case 4:
			chkMLangPython.setSelected(true);
			break;
		}

		comboEmail.getItems().addAll("gmail.com", "naver.com", "daum.net");
		taIntro.setText(LoginController.getSession().getMem_introd());
		memberService = MemberServiceImpl.getInstance(); 
	}
}
