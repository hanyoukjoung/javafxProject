package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Font;

public class AdminShowPLCTListController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<?> tablePLct;

    @FXML
    private TableColumn<?, ?> lct_name;

    @FXML
    private TableColumn<?, ?> lct_mem_id;

    @FXML
    private TableColumn<?, ?> permit;

    @FXML
    private TableColumn<?, ?> companion;

    @FXML
    void initialize() {
    	Font.loadFont(getClass().getResourceAsStream("../z.source/GODOM.ttf"), 12);
        assert tablePLct != null : "fx:id=\"tablePLct\" was not injected: check your FXML file 'AdminShowPLCTList.fxml'.";
        assert lct_name != null : "fx:id=\"lct_name\" was not injected: check your FXML file 'AdminShowPLCTList.fxml'.";
        assert lct_mem_id != null : "fx:id=\"lct_mem_id\" was not injected: check your FXML file 'AdminShowPLCTList.fxml'.";
        assert permit != null : "fx:id=\"permit\" was not injected: check your FXML file 'AdminShowPLCTList.fxml'.";
        assert companion != null : "fx:id=\"companion\" was not injected: check your FXML file 'AdminShowPLCTList.fxml'.";

    }
}
