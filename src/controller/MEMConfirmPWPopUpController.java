package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MEMConfirmPWPopUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane framePW;

    @FXML
    private Label lblPW;

    @FXML
    private PasswordField tfPW;
    
    @FXML
    private Button btnConfirm;

    @FXML
    private Button btnClose;

    @FXML
    private Button btnMin;

    @FXML
    void btnCloseClick(ActionEvent event) {
    	Stage memConfirmPWPopUpStage = (Stage)framePW.getScene().getWindow();
    	memConfirmPWPopUpStage.close();
    }

    @FXML
    void btnConfirmClick(ActionEvent event) {

    }

    @FXML
    void btnMinClick(ActionEvent event) {
    	Stage memConfirmPWPopUpStage = (Stage)framePW.getScene().getWindow();
    	memConfirmPWPopUpStage.setIconified(true);
    }

    @FXML
    void initialize() {
    	//폰트 경로 설정
    	Font.loadFont(getClass().getResourceAsStream("../z.source/GODOM.ttf"), 12);
    	
    	assert framePW != null : "fx:id=\"pane\" was not injected: check your FXML file 'MEMConfirmPWPopUp.fxml'.";
        assert tfPW != null : "fx:id=\"tfPw\" was not injected: check your FXML file 'MEMConfirmPWPopUp.fxml'.";
        assert btnConfirm != null : "fx:id=\"btnConfirm\" was not injected: check your FXML file 'MEMConfirmPWPopUp.fxml'.";
        assert btnClose != null : "fx:id=\"btnCloes\" was not injected: check your FXML file 'MEMConfirmPWPopUp.fxml'.";
        assert btnMin != null : "fx:id=\"btnMin\" was not injected: check your FXML file 'MEMConfirmPWPopUp.fxml'.";

    
    
    }
}
