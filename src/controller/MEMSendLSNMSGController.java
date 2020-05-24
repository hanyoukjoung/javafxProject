package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MEMSendLSNMSGController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane pane;

    @FXML
    private TextArea taContent;

    @FXML
    private Button btnSend;

    @FXML
    private ImageView btnMin;
    
    @FXML
    private Label lblTo;

    @FXML
    private Label lblReceiver;

    @FXML
    private Label lblCont;

    @FXML
    private ImageView btnClose;

    @FXML
    void btnCloseClick(MouseEvent event) {
    	Stage memSendLSNMSGStage = (Stage)pane.getScene().getWindow();
    	memSendLSNMSGStage.close();
    }

    @FXML
    void btnMinClick(MouseEvent event) {
    	Stage memSendLSNMSGStage = (Stage)pane.getScene().getWindow();
    	memSendLSNMSGStage.setIconified(true);
    }

    @FXML
    void btnSendClick(ActionEvent event) {

    }

    @FXML
    void initialize() {
    	
    	//css 폰트 경로 설정
    	Font.loadFont(getClass().getResourceAsStream("../z.source/GODOM.ttf"), 12);
    	
    	
        assert pane != null : "fx:id=\"pane\" was not injected: check your FXML file 'MEMSendLSNMSG.fxml'.";
        assert lblReceiver != null : "fx:id=\"lblReceiver\" was not injected: check your FXML file 'MEMSendLSNMSG.fxml'.";
        assert taContent != null : "fx:id=\"taContent\" was not injected: check your FXML file 'MEMSendLSNMSG.fxml'.";
        assert btnSend != null : "fx:id=\"btnSend\" was not injected: check your FXML file 'MEMSendLSNMSG.fxml'.";
        assert btnClose != null : "fx:id=\"btnClose\" was not injected: check your FXML file 'MEMSendLSNMSG.fxml'.";
        assert btnMin != null : "fx:id=\"btnMin\" was not injected: check your FXML file 'MEMSendLSNMSG.fxml'.";

    }
}
