package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class MEMShowLCTDetailController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane subFrameLCT;

    @FXML
    private Label lblLCTName;
    
    @FXML
    private Button btnRPT;
    
    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> coldiv;

    @FXML
    private TableColumn<?, ?> coltitle;

    @FXML
    private TableColumn<?, ?> colcont;

    @FXML
    private TableColumn<?, ?> colsubs;

    @FXML
    private Button btnModify;

    @FXML
    private Button btnDel;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnStar;

    @FXML
    void btnCancelClick(ActionEvent event) {

    }

    @FXML
    void btnDelAction(ActionEvent event) {

    }

    @FXML
    void btnModifyClick(ActionEvent event) {

    }

    @FXML
    void btnRPTClick(ActionEvent event) {

    }

    @FXML
    void btnStarClick(ActionEvent event) {

    }

    @FXML
    void initialize() {
    	Font.loadFont(getClass().getResourceAsStream("../z.source/GODOM.ttf"), 12);
    }
}
