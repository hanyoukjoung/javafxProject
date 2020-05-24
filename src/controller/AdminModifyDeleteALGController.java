package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AdminModifyDeleteALGController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane subFrameAlgInsert;

    @FXML
    private Button btnAlgExerModify;

    @FXML
    private Button btnAlgExerDel;

    @FXML
    private TextField tfAlgExerTitle;

    @FXML
    private ComboBox<?> comboAlgCate;

    @FXML
    private TextArea taAlgExerCont;

    @FXML
    void btnAlgExerDelClick(ActionEvent event) {

    }

    @FXML
    void btnAlgExerModifyClick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert subFrameAlgInsert != null : "fx:id=\"subFrameAlgInsert\" was not injected: check your FXML file 'AdminModifyDeleteALG.fxml'.";
        assert btnAlgExerModify != null : "fx:id=\"btnAlgExerModify\" was not injected: check your FXML file 'AdminModifyDeleteALG.fxml'.";
        assert btnAlgExerDel != null : "fx:id=\"btnAlgExerDel\" was not injected: check your FXML file 'AdminModifyDeleteALG.fxml'.";
        assert tfAlgExerTitle != null : "fx:id=\"tfAlgExerTitle\" was not injected: check your FXML file 'AdminModifyDeleteALG.fxml'.";
        assert comboAlgCate != null : "fx:id=\"comboAlgCate\" was not injected: check your FXML file 'AdminModifyDeleteALG.fxml'.";
        assert taAlgExerCont != null : "fx:id=\"taAlgExerCont\" was not injected: check your FXML file 'AdminModifyDeleteALG.fxml'.";

    }
}
