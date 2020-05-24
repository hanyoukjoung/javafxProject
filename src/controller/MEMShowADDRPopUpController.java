package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MEMShowADDRPopUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane pane;

    @FXML
    private Label lblTitle;

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> colZipCode;

    @FXML
    private TableColumn<?, ?> colAddr;

    @FXML
    private TableColumn<?, ?> colBunJi;

    @FXML
    private ImageView btnClose;

    @FXML
    private Pagination pagination;

    @FXML
    void btnCloseClick(MouseEvent event) {
    	Stage stage = (Stage) pane.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void initialize() {
        assert pane != null : "fx:id=\"pane\" was not injected: check your FXML file 'MEMShowADDRPopUp.fxml'.";
        assert lblTitle != null : "fx:id=\"lblTitle\" was not injected: check your FXML file 'MEMShowADDRPopUp.fxml'.";
        assert table != null : "fx:id=\"table\" was not injected: check your FXML file 'MEMShowADDRPopUp.fxml'.";
        assert colZipCode != null : "fx:id=\"colZipCode\" was not injected: check your FXML file 'MEMShowADDRPopUp.fxml'.";
        assert colAddr != null : "fx:id=\"colAddr\" was not injected: check your FXML file 'MEMShowADDRPopUp.fxml'.";
        assert colBunJi != null : "fx:id=\"colBunJi\" was not injected: check your FXML file 'MEMShowADDRPopUp.fxml'.";
        assert btnClose != null : "fx:id=\"btnClose\" was not injected: check your FXML file 'MEMShowADDRPopUp.fxml'.";
        assert pagination != null : "fx:id=\"pagination\" was not injected: check your FXML file 'MEMShowADDRPopUp.fxml'.";

    }
}
