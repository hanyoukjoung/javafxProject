package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Font;

public class AdminShowRPTLCTListController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<?> tableRptLct;

    @FXML
    private TableColumn<?, ?> lct_name;

    @FXML
    private TableColumn<?, ?> lct_mem_id;

    @FXML
    private TableColumn<?, ?> lct_upload_date;

    @FXML
    private TableColumn<?, ?> rpt_date;

    @FXML
    private TableColumn<?, ?> mem_id;

    @FXML
    private TableColumn<?, ?> lct_atatus;

    @FXML
    private Button btcDel;

    @FXML
    private Button btnCancel;

    @FXML
    void btcDelClick(ActionEvent event) {

    }

    @FXML
    void btnCancelClick(ActionEvent event) {

    }

    @FXML
    void initialize() {
    	Font.loadFont(getClass().getResourceAsStream("../z.source/GODOM.ttf"), 12);
        assert tableRptLct != null : "fx:id=\"tableRptLct\" was not injected: check your FXML file 'AdminShowRPTLCTList.fxml'.";
        assert lct_name != null : "fx:id=\"lct_name\" was not injected: check your FXML file 'AdminShowRPTLCTList.fxml'.";
        assert lct_mem_id != null : "fx:id=\"lct_mem_id\" was not injected: check your FXML file 'AdminShowRPTLCTList.fxml'.";
        assert lct_upload_date != null : "fx:id=\"lct_upload_date\" was not injected: check your FXML file 'AdminShowRPTLCTList.fxml'.";
        assert rpt_date != null : "fx:id=\"rpt_date\" was not injected: check your FXML file 'AdminShowRPTLCTList.fxml'.";
        assert mem_id != null : "fx:id=\"mem_id\" was not injected: check your FXML file 'AdminShowRPTLCTList.fxml'.";
        assert lct_atatus != null : "fx:id=\"lct_atatus\" was not injected: check your FXML file 'AdminShowRPTLCTList.fxml'.";
        assert btcDel != null : "fx:id=\"btcDel\" was not injected: check your FXML file 'AdminShowRPTLCTList.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'AdminShowRPTLCTList.fxml'.";

    }
}
