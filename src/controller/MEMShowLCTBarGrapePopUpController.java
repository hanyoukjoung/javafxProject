package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MEMShowLCTBarGrapePopUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane subFrameBarGrape;

    @FXML
    private Button btnMin;

    @FXML
    private Button btnClose;

    @FXML
    private BarChart<?, ?> BarChart;

    @FXML
    void btnCloseClick(ActionEvent event) {
    	Stage memShowLCTBarGrapePopUpStage = (Stage)subFrameBarGrape.getScene().getWindow();
    	memShowLCTBarGrapePopUpStage.close();
    }

    @FXML
    void btnMinClick(ActionEvent event) {
    	Stage memShowLCTBarGrapePopUpStage = (Stage)subFrameBarGrape.getScene().getWindow();
    	memShowLCTBarGrapePopUpStage.setIconified(true);
    }

    @FXML
    void initialize() {
        assert subFrameBarGrape != null : "fx:id=\"subFrameBarGrape\" was not injected: check your FXML file 'MEMShowLCTBarGrapePopUp.fxml'.";
        assert btnMin != null : "fx:id=\"btnMin\" was not injected: check your FXML file 'MEMShowLCTBarGrapePopUp.fxml'.";
        assert btnClose != null : "fx:id=\"btnClose\" was not injected: check your FXML file 'MEMShowLCTBarGrapePopUp.fxml'.";
        assert BarChart != null : "fx:id=\"BarChart\" was not injected: check your FXML file 'MEMShowLCTBarGrapePopUp.fxml'.";

    }
}
