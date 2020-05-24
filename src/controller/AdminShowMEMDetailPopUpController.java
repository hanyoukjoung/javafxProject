package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class AdminShowMEMDetailPopUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnMin;

    @FXML
    private Button btnClose;

    @FXML
    private Label lblMemId;

    @FXML
    private Label lblMemName;

    @FXML
    private Label lblMemTel;

    @FXML
    private Label lblMemEmail;

    @FXML
    private Label lblMemRptCnt;

    @FXML
    private ListView<?> lblMemRptCont;

    @FXML
    void btnCloseClick(ActionEvent event) {
    	Stage adminShowMEMDetailPopUpStage = (Stage)btnMin.getScene().getWindow();
    	adminShowMEMDetailPopUpStage.close();
    }

    @FXML
    void btnMinClick(ActionEvent event) {
    	Stage adminShowMEMDetailPopUpStage = (Stage)btnMin.getScene().getWindow();
    	adminShowMEMDetailPopUpStage.setIconified(true);
    }

    @FXML
    void initialize() {
        assert btnMin != null : "fx:id=\"btnMin\" was not injected: check your FXML file 'AdminShowMEMDetailPopUp.fxml'.";
        assert btnClose != null : "fx:id=\"btnClose\" was not injected: check your FXML file 'AdminShowMEMDetailPopUp.fxml'.";
        assert lblMemId != null : "fx:id=\"lblMemId\" was not injected: check your FXML file 'AdminShowMEMDetailPopUp.fxml'.";
        assert lblMemName != null : "fx:id=\"lblMemName\" was not injected: check your FXML file 'AdminShowMEMDetailPopUp.fxml'.";
        assert lblMemTel != null : "fx:id=\"lblMemTel\" was not injected: check your FXML file 'AdminShowMEMDetailPopUp.fxml'.";
        assert lblMemEmail != null : "fx:id=\"lblMemEmail\" was not injected: check your FXML file 'AdminShowMEMDetailPopUp.fxml'.";
        assert lblMemRptCnt != null : "fx:id=\"lblMemRptCnt\" was not injected: check your FXML file 'AdminShowMEMDetailPopUp.fxml'.";
        assert lblMemRptCont != null : "fx:id=\"lblMemRptCont\" was not injected: check your FXML file 'AdminShowMEMDetailPopUp.fxml'.";

    }
}
