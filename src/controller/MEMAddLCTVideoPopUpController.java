package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MEMAddLCTVideoPopUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane subFrameLCTbtnInsert;

    @FXML
    private Button btnMin;

    @FXML
    private Button btnClose;

    @FXML
    private Button btnFileUpload;

    @FXML
    private TextField tfTitle;

    @FXML
    private TextField tfFileUpload;

    @FXML
    private Button btnConfirm;

    @FXML
    private Button btnCancel;

    @FXML
    void btnCancelClick(ActionEvent event) {

    }

    @FXML
    void btnCloseClick(ActionEvent event) {
    	Stage memAddLCTVideoPopUpStage = (Stage)subFrameLCTbtnInsert.getScene().getWindow();
    	memAddLCTVideoPopUpStage.close();
    }

    @FXML
    void btnConfirmClick(ActionEvent event) {

    }

    @FXML
    void btnFileUploadClick(ActionEvent event) {

    }

    @FXML
    void btnMinClick(ActionEvent event) {
    	Stage memAddLCTVideoPopUpStage = (Stage)subFrameLCTbtnInsert.getScene().getWindow();
    	memAddLCTVideoPopUpStage.setIconified(true);
    }

    @FXML
    void initialize() {
        assert subFrameLCTbtnInsert != null : "fx:id=\"subFrameLCTbtnInsert\" was not injected: check your FXML file 'MEMAddLCTVideoPopUp.fxml'.";
        assert btnMin != null : "fx:id=\"btnMin\" was not injected: check your FXML file 'MEMAddLCTVideoPopUp.fxml'.";
        assert btnClose != null : "fx:id=\"btnClose\" was not injected: check your FXML file 'MEMAddLCTVideoPopUp.fxml'.";
        assert btnFileUpload != null : "fx:id=\"btnFileUpload\" was not injected: check your FXML file 'MEMAddLCTVideoPopUp.fxml'.";
        assert tfTitle != null : "fx:id=\"tfTitle\" was not injected: check your FXML file 'MEMAddLCTVideoPopUp.fxml'.";
        assert tfFileUpload != null : "fx:id=\"tfFileUpload\" was not injected: check your FXML file 'MEMAddLCTVideoPopUp.fxml'.";
        assert btnConfirm != null : "fx:id=\"btnConfirm\" was not injected: check your FXML file 'MEMAddLCTVideoPopUp.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'MEMAddLCTVideoPopUp.fxml'.";

    }
}
