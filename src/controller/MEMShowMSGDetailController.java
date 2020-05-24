package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class MEMShowMSGDetailController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private GridPane pane;

    @FXML
    private Pagination pageLessonEval;

    @FXML
    private Label lblLessonStar;

    @FXML
    private Button btnStar1;

    @FXML
    private Button btnStar2;

    @FXML
    private Button btnStar3;

    @FXML
    private Button btnStar4;

    @FXML
    private Button btnStar5;

    @FXML
    private TableView<?> tableLessonEvalContent;

    @FXML
    private TableColumn<?, ?> colContent;

    @FXML
    private Label lblSender;

    @FXML
    private Button btnLessonRequest;

    @FXML
    private Button btnDeleteMessage;

    @FXML
    private TextArea taContent;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfId;

    @FXML
    private TextField tfILang;

    @FXML
    private TextField tfMLang;

    @FXML
    private TextArea taIntro;

    @FXML
    private ImageView imgProfile;

    @FXML
    void btnDeleteMessageClick(ActionEvent event) {

    }

    @FXML
    void btnLessonRequestClick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert pane != null : "fx:id=\"pane\" was not injected: check your FXML file 'MEMShowMSGDetail.fxml'.";
        assert pageLessonEval != null : "fx:id=\"pageLessonEval\" was not injected: check your FXML file 'MEMShowMSGDetail.fxml'.";
        assert lblLessonStar != null : "fx:id=\"lblLessonStar\" was not injected: check your FXML file 'MEMShowMSGDetail.fxml'.";
        assert btnStar1 != null : "fx:id=\"btnStar1\" was not injected: check your FXML file 'MEMShowMSGDetail.fxml'.";
        assert btnStar2 != null : "fx:id=\"btnStar2\" was not injected: check your FXML file 'MEMShowMSGDetail.fxml'.";
        assert btnStar3 != null : "fx:id=\"btnStar3\" was not injected: check your FXML file 'MEMShowMSGDetail.fxml'.";
        assert btnStar4 != null : "fx:id=\"btnStar4\" was not injected: check your FXML file 'MEMShowMSGDetail.fxml'.";
        assert btnStar5 != null : "fx:id=\"btnStar5\" was not injected: check your FXML file 'MEMShowMSGDetail.fxml'.";
        assert tableLessonEvalContent != null : "fx:id=\"tableLessonEvalContent\" was not injected: check your FXML file 'MEMShowMSGDetail.fxml'.";
        assert colContent != null : "fx:id=\"colContent\" was not injected: check your FXML file 'MEMShowMSGDetail.fxml'.";
        assert lblSender != null : "fx:id=\"lblSender\" was not injected: check your FXML file 'MEMShowMSGDetail.fxml'.";
        assert btnLessonRequest != null : "fx:id=\"btnLessonRequest\" was not injected: check your FXML file 'MEMShowMSGDetail.fxml'.";
        assert btnDeleteMessage != null : "fx:id=\"btnDeleteMessage\" was not injected: check your FXML file 'MEMShowMSGDetail.fxml'.";
        assert taContent != null : "fx:id=\"taContent\" was not injected: check your FXML file 'MEMShowMSGDetail.fxml'.";
        assert tfName != null : "fx:id=\"tfName\" was not injected: check your FXML file 'MEMShowMSGDetail.fxml'.";
        assert tfId != null : "fx:id=\"tfId\" was not injected: check your FXML file 'MEMShowMSGDetail.fxml'.";
        assert tfILang != null : "fx:id=\"tfILang\" was not injected: check your FXML file 'MEMShowMSGDetail.fxml'.";
        assert tfMLang != null : "fx:id=\"tfMLang\" was not injected: check your FXML file 'MEMShowMSGDetail.fxml'.";
        assert taIntro != null : "fx:id=\"taIntro\" was not injected: check your FXML file 'MEMShowMSGDetail.fxml'.";
        assert imgProfile != null : "fx:id=\"imgProfile\" was not injected: check your FXML file 'MEMShowMSGDetail.fxml'.";

    }
}
