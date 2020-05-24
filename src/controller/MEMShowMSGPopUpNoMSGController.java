package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class MEMShowMSGPopUpNoMSGController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private AnchorPane frame;
    
    @FXML
    private  ImageView btnSend;

    @FXML
    private Label lblText;
    
    @FXML
    void btnSendClick(MouseEvent event) {

    }
    

    @FXML
    void initialize() {
    	
    	//폰트 경로 설정하기
    	Font.loadFont(getClass().getResourceAsStream("../z.source/GODOM.ttf"), 14);
    	Font.loadFont(getClass().getResourceAsStream("../z.source/Cafe24Shiningstar.ttf"), 14);
    	Font.loadFont(getClass().getResourceAsStream("../z.source/tvN 즐거운이야기 Medium.ttf"), 14);
    	
    }
}
