package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class MEMShowALGDetailController {
	
	private int selectALGNum;

    public int getSelectALGNum() {
		return selectALGNum;
	}

	public void setSelectALGNum(int selectALGNum) {
		this.selectALGNum = selectALGNum;
	}

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane subFrameQuestion;

    @FXML
    private Label lbTitle;

    @FXML
    private TextArea taExercise;

    @FXML
    private TextArea taCode;

    @FXML
    private TextArea taResult;

    @FXML
    private Button btnSubmit;

    @FXML
    private Button btnHelp;

    @FXML
    private Button btnQuestion;

    @FXML
    void btnHelpClick(ActionEvent event) {
    	
    }

    @FXML
    void btnQuestionClick(ActionEvent event) {
    	
    }

    @FXML
    void btnSubmitClick(ActionEvent event) {
    	
    }

    @FXML
    void initialize() {
    	
    	//CSS 폰트 경로 설정
    	Font.loadFont(getClass().getResourceAsStream("../z.source/GODOM.ttf"), 12);
    }
}
