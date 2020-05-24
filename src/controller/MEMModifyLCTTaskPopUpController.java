package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MEMModifyLCTTaskPopUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane subFrameLCTTaskbtnInsert;

    @FXML
    private Button btnMin;

    @FXML
    private Button btnClose;

    @FXML
    private TextField tfTitle;

    @FXML
    private TextArea tfCNT1;

    @FXML
    private TextArea tfCode;

    @FXML
    private Button btnConfirm;

    @FXML
    private Button btnCancel;

    @FXML
    void btnCancelClick(ActionEvent event) {

    }

    @FXML
    void btnCloseClick(ActionEvent event) {
    	Stage memModifyLCTTaskPopUpStage = (Stage)subFrameLCTTaskbtnInsert.getScene().getWindow();
    	memModifyLCTTaskPopUpStage.close();
    }

    @FXML
    void btnConfirmClick(ActionEvent event) {

    }

    @FXML
    void btnMinClick(ActionEvent event) {
    	Stage memModifyLCTTaskPopUpStage = (Stage)subFrameLCTTaskbtnInsert.getScene().getWindow();
    	memModifyLCTTaskPopUpStage.setIconified(true);
    }

    @FXML
    void initialize() {
        assert subFrameLCTTaskbtnInsert != null : "fx:id=\"subFrameLCTTaskbtnInsert\" was not injected: check your FXML file 'MEMModifyLCTTaskPopUp.fxml'.";
        assert btnMin != null : "fx:id=\"btnMin\" was not injected: check your FXML file 'MEMModifyLCTTaskPopUp.fxml'.";
        assert btnClose != null : "fx:id=\"btnClose\" was not injected: check your FXML file 'MEMModifyLCTTaskPopUp.fxml'.";
        assert tfTitle != null : "fx:id=\"tfTitle\" was not injected: check your FXML file 'MEMModifyLCTTaskPopUp.fxml'.";
        assert tfCNT1 != null : "fx:id=\"tfCNT1\" was not injected: check your FXML file 'MEMModifyLCTTaskPopUp.fxml'.";
        assert tfCode != null : "fx:id=\"tfCode\" was not injected: check your FXML file 'MEMModifyLCTTaskPopUp.fxml'.";
        assert btnConfirm != null : "fx:id=\"btnConfirm\" was not injected: check your FXML file 'MEMModifyLCTTaskPopUp.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'MEMModifyLCTTaskPopUp.fxml'.";

    }
}
