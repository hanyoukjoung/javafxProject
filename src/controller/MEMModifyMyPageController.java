package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class MEMModifyMyPageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane subFrameMypage;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfPhone;

    @FXML
    private ComboBox<?> phoneCombo;

    @FXML
    private TextField tfEmail;

    @FXML
    private ComboBox<?> emailComBo;

    @FXML
    private Button btnAdductionSend;

    @FXML
    private CheckBox chkILangJava;

    @FXML
    private CheckBox chkILangCpp;

    @FXML
    private CheckBox chkILangOracle;

    @FXML
    private CheckBox chkILangPython;

    @FXML
    private CheckBox chkMLangJava;

    @FXML
    private CheckBox chkMLangCpp;

    @FXML
    private CheckBox chkMLangOracle;

    @FXML
    private CheckBox chkMLangPython;

    @FXML
    private TextField tfAdduction;

    @FXML
    private Button btnAdductionCheck;

    @FXML
    private TextField tfPost;

    @FXML
    private TextField tfDetailedAddr;

    @FXML
    private TextField tfAddr;

    @FXML
    private TextArea taIntroduce;

    @FXML
    private Button btnConfirm;

    @FXML
    private Button btnPaymentDetails;

    @FXML
    private Button btnMemOut;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnInsert;

    @FXML
    private TextField tfFile;

    @FXML
    private PasswordField tfPw;

    @FXML
    private PasswordField tfPwCheck;

    @FXML
    private Button btnCash;

    @FXML
    void adductionCheck(ActionEvent event) {

    }

    @FXML
    void adductionSend(ActionEvent event) {

    }

    @FXML
    void btnCancelClick(ActionEvent event) {

    }

    @FXML
    void btnCashClick(ActionEvent event) {

    }

    @FXML
    void btnConfirmClick(ActionEvent event) {

    }

    @FXML
    void btnInsertFile(ActionEvent event) {

    }

    @FXML
    void btnMemOutClick(ActionEvent event) {

    }

    @FXML
    void btnPaymentDetailsClick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert subFrameMypage != null : "fx:id=\"subFrameMypage\" was not injected: check your FXML file 'MEMModifyMyPage.fxml'.";
        assert tfName != null : "fx:id=\"tfName\" was not injected: check your FXML file 'MEMModifyMyPage.fxml'.";
        assert tfPhone != null : "fx:id=\"tfPhone\" was not injected: check your FXML file 'MEMModifyMyPage.fxml'.";
        assert phoneCombo != null : "fx:id=\"phoneCombo\" was not injected: check your FXML file 'MEMModifyMyPage.fxml'.";
        assert tfEmail != null : "fx:id=\"tfEmail\" was not injected: check your FXML file 'MEMModifyMyPage.fxml'.";
        assert emailComBo != null : "fx:id=\"emailComBo\" was not injected: check your FXML file 'MEMModifyMyPage.fxml'.";
        assert btnAdductionSend != null : "fx:id=\"btnAdductionSend\" was not injected: check your FXML file 'MEMModifyMyPage.fxml'.";
        assert chkILangJava != null : "fx:id=\"chkILangJava\" was not injected: check your FXML file 'MEMModifyMyPage.fxml'.";
        assert chkILangCpp != null : "fx:id=\"chkILangCpp\" was not injected: check your FXML file 'MEMModifyMyPage.fxml'.";
        assert chkILangOracle != null : "fx:id=\"chkILangOracle\" was not injected: check your FXML file 'MEMModifyMyPage.fxml'.";
        assert chkILangPython != null : "fx:id=\"chkILangPython\" was not injected: check your FXML file 'MEMModifyMyPage.fxml'.";
        assert chkMLangJava != null : "fx:id=\"chkMLangJava\" was not injected: check your FXML file 'MEMModifyMyPage.fxml'.";
        assert chkMLangCpp != null : "fx:id=\"chkMLangCpp\" was not injected: check your FXML file 'MEMModifyMyPage.fxml'.";
        assert chkMLangOracle != null : "fx:id=\"chkMLangOracle\" was not injected: check your FXML file 'MEMModifyMyPage.fxml'.";
        assert chkMLangPython != null : "fx:id=\"chkMLangPython\" was not injected: check your FXML file 'MEMModifyMyPage.fxml'.";
        assert tfAdduction != null : "fx:id=\"tfAdduction\" was not injected: check your FXML file 'MEMModifyMyPage.fxml'.";
        assert btnAdductionCheck != null : "fx:id=\"btnAdductionCheck\" was not injected: check your FXML file 'MEMModifyMyPage.fxml'.";
        assert tfPost != null : "fx:id=\"tfPost\" was not injected: check your FXML file 'MEMModifyMyPage.fxml'.";
        assert tfDetailedAddr != null : "fx:id=\"tfDetailedAddr\" was not injected: check your FXML file 'MEMModifyMyPage.fxml'.";
        assert tfAddr != null : "fx:id=\"tfAddr\" was not injected: check your FXML file 'MEMModifyMyPage.fxml'.";
        assert taIntroduce != null : "fx:id=\"taIntroduce\" was not injected: check your FXML file 'MEMModifyMyPage.fxml'.";
        assert btnConfirm != null : "fx:id=\"btnConfirm\" was not injected: check your FXML file 'MEMModifyMyPage.fxml'.";
        assert btnPaymentDetails != null : "fx:id=\"btnPaymentDetails\" was not injected: check your FXML file 'MEMModifyMyPage.fxml'.";
        assert btnMemOut != null : "fx:id=\"btnMemOut\" was not injected: check your FXML file 'MEMModifyMyPage.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'MEMModifyMyPage.fxml'.";
        assert btnInsert != null : "fx:id=\"btnInsert\" was not injected: check your FXML file 'MEMModifyMyPage.fxml'.";
        assert tfFile != null : "fx:id=\"tfFile\" was not injected: check your FXML file 'MEMModifyMyPage.fxml'.";
        assert tfPw != null : "fx:id=\"tfPw\" was not injected: check your FXML file 'MEMModifyMyPage.fxml'.";
        assert tfPwCheck != null : "fx:id=\"tfPwCheck\" was not injected: check your FXML file 'MEMModifyMyPage.fxml'.";
        assert btnCash != null : "fx:id=\"btnCash\" was not injected: check your FXML file 'MEMModifyMyPage.fxml'.";

    }
}
