package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MEMPayPopUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane pane;

    @FXML
    private TextField tfCardNum1;

    @FXML
    private TextField tfCardNum4;

    @FXML
    private TextField tfMonth;

    @FXML
    private TextField tfYear;

    @FXML
    private TextField tfPass;

    @FXML
    private ToggleGroup cardGu;

    @FXML
    private Button btnConfirm;

    @FXML
    private PasswordField tfAdduction;

    @FXML
    private PasswordField tfCardNum2;

    @FXML
    private PasswordField tfCardNum3;

    @FXML
    private ImageView btnClose;

    @FXML
    private ImageView btnMin;

    @FXML
    void btnCloseClick(MouseEvent event) {
    	Stage memPayPopUpStage = (Stage)pane.getScene().getWindow();
    	memPayPopUpStage.close();
    }

    @FXML
    void btnConfirmClick(ActionEvent event) {

    }

    @FXML
    void btnMinClick(MouseEvent event) {
    	Stage memPayPopUpStage = (Stage)pane.getScene().getWindow();
    	memPayPopUpStage.setIconified(true);
    }

    @FXML
    void initialize() {
        assert pane != null : "fx:id=\"pane\" was not injected: check your FXML file 'MEMPayPopUp.fxml'.";
        assert tfCardNum1 != null : "fx:id=\"tfCardNum1\" was not injected: check your FXML file 'MEMPayPopUp.fxml'.";
        assert tfCardNum4 != null : "fx:id=\"tfCardNum4\" was not injected: check your FXML file 'MEMPayPopUp.fxml'.";
        assert tfMonth != null : "fx:id=\"tfMonth\" was not injected: check your FXML file 'MEMPayPopUp.fxml'.";
        assert tfYear != null : "fx:id=\"tfYear\" was not injected: check your FXML file 'MEMPayPopUp.fxml'.";
        assert tfPass != null : "fx:id=\"tfPass\" was not injected: check your FXML file 'MEMPayPopUp.fxml'.";
        assert cardGu != null : "fx:id=\"cardGu\" was not injected: check your FXML file 'MEMPayPopUp.fxml'.";
        assert btnConfirm != null : "fx:id=\"btnConfirm\" was not injected: check your FXML file 'MEMPayPopUp.fxml'.";
        assert tfAdduction != null : "fx:id=\"tfAdduction\" was not injected: check your FXML file 'MEMPayPopUp.fxml'.";
        assert tfCardNum2 != null : "fx:id=\"tfCardNum2\" was not injected: check your FXML file 'MEMPayPopUp.fxml'.";
        assert tfCardNum3 != null : "fx:id=\"tfCardNum3\" was not injected: check your FXML file 'MEMPayPopUp.fxml'.";
        assert btnClose != null : "fx:id=\"btnClose\" was not injected: check your FXML file 'MEMPayPopUp.fxml'.";
        assert btnMin != null : "fx:id=\"btnMin\" was not injected: check your FXML file 'MEMPayPopUp.fxml'.";

    }
}
