package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MEMShowSUBSLCTController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane subFrameMySubsLctView;

    @FXML
    private VBox VBox;

    @FXML
    private Label titleLbl;

    @FXML
    private Button btnstar1;

    @FXML
    private Button btnstar2;

    @FXML
    private Button btnstar3;

    @FXML
    private Button btnstar4;

    @FXML
    private Button btnstar5;

    @FXML
    private Label lblsubstitle1;

    @FXML
    private Label lbllcttime1;

    @FXML
    private Button SubsCancel1;

    @FXML
    private Button btnstar6;

    @FXML
    private Button btnstar7;

    @FXML
    private Button btnstar8;

    @FXML
    private Button btnstar9;

    @FXML
    private Button btnstar10;

    @FXML
    private Label lblsubstitle2;

    @FXML
    private Label lbllcttime2;

    @FXML
    private Button SubsCancel2;

    @FXML
    private Button btnstar11;

    @FXML
    private Button btnstar12;

    @FXML
    private Button btnstar13;

    @FXML
    private Button btnstar14;

    @FXML
    private Button btnstar15;

    @FXML
    private Label lblsubstitle3;

    @FXML
    private Label lbllcttime3;

    @FXML
    private Button SubsCancel3;

    @FXML
    private Button btnstar16;

    @FXML
    private Button btnstar17;

    @FXML
    private Button btnstar18;

    @FXML
    private Button btnstar19;

    @FXML
    private Button btnstar20;

    @FXML
    private Label lblsubstitle4;

    @FXML
    private Label lbllcttime4;

    @FXML
    private Button SubsCancel4;

    @FXML
    private Pagination pagesubsLctView;

    @FXML
    private HBox HBox;

    @FXML
    private Button btnClose;
    
    @FXML
    private Label score1;

    @FXML
    private Label score2;
    
    @FXML
    private Label score3;
    
    @FXML
    private Label score4;

    @FXML
    void SubsCancel1Click(ActionEvent event) {

    }

    @FXML
    void SubsCancel2Click(ActionEvent event) {

    }

    @FXML
    void SubsCancel3Click(ActionEvent event) {

    }

    @FXML
    void SubsCancel4Click(ActionEvent event) {

    }

    @FXML
    void btnCloseClick(ActionEvent event) {
    	Stage memShowSUBSLCTStage = (Stage)subFrameMySubsLctView.getScene().getWindow();
    	memShowSUBSLCTStage.close();
    }

    @FXML
    void btnstar10Click(ActionEvent event) {

    }

    @FXML
    void btnstar11Click(ActionEvent event) {

    }

    @FXML
    void btnstar12Click(ActionEvent event) {

    }

    @FXML
    void btnstar13Click(ActionEvent event) {

    }

    @FXML
    void btnstar14Click(ActionEvent event) {

    }

    @FXML
    void btnstar15Click(ActionEvent event) {

    }

    @FXML
    void btnstar16Click(ActionEvent event) {

    }

    @FXML
    void btnstar17Click(ActionEvent event) {

    }

    @FXML
    void btnstar18Click(ActionEvent event) {

    }

    @FXML
    void btnstar19Click(ActionEvent event) {

    }

    @FXML
    void btnstar1Click(ActionEvent event) {

    }

    @FXML
    void btnstar20Click(ActionEvent event) {

    }

    @FXML
    void btnstar2Click(ActionEvent event) {

    }

    @FXML
    void btnstar3Click(ActionEvent event) {

    }

    @FXML
    void btnstar4Click(ActionEvent event) {

    }

    @FXML
    void btnstar5Click(ActionEvent event) {

    }

    @FXML
    void btnstar6Click(ActionEvent event) {

    }

    @FXML
    void btnstar7Click(ActionEvent event) {

    }

    @FXML
    void btnstar8Click(ActionEvent event) {

    }

    @FXML
    void btnstar9Click(ActionEvent event) {

    }

    @FXML
    void initialize() {
    	 //폰트 경로 설정하기
        Font.loadFont(getClass().getResourceAsStream("../z.source/GODOM.ttf"), 12);
    }
}

