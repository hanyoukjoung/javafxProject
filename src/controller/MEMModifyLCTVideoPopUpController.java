package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MEMModifyLCTVideoPopUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane subFrameLCTbtnModify;

    @FXML
    private Button btnMin;

    @FXML
    private Button btnClose;

    @FXML
    private Label lblTitle;
    
    @FXML
    private TextField tfTitle;

    @FXML
    private TextField tfFileUpload;

    @FXML
    private Button btnFileUpload;
    
    @FXML
    private Button btnConfirm;

    @FXML
    private Button btnCancel;

    @FXML
    void btnCancelClick(ActionEvent event) {

    }

    @FXML
    void btnCloseClick(MouseEvent event) {
       Stage memModifyLCTVideoPopUpStage = (Stage)subFrameLCTbtnModify.getScene().getWindow();
       memModifyLCTVideoPopUpStage.close();
    }

    @FXML
    void btnConfirmClick(ActionEvent event) {

    }

    @FXML
    void btnFileUploadClick(ActionEvent event) {

    }

    @FXML
    void btnMinClick(MouseEvent event) {
       Stage memModifyLCTVideoPopUpStage = (Stage)subFrameLCTbtnModify.getScene().getWindow();
       memModifyLCTVideoPopUpStage.setIconified(true);
    }

    @FXML
    void initialize() {
        

    }
}