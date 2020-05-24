package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import main.vo.TotalBoardVO;

public class MEMShowFAQBoardDetailController {
	
	private TotalBoardVO faqBoardVo;
    
	public TotalBoardVO getFaqBoardVo() {
		return faqBoardVo;
	}
	
	public void setFaqBoardVo(TotalBoardVO faqBoardVo) {
		this.faqBoardVo = faqBoardVo;
		admin.setText("관리자");
    	faqBoardTitle.setText(faqBoardVo.getBoard_title());
    	taContent.setText(faqBoardVo.getBoard_cont());
	}


	private MEMShowBoardListController boardListCon;
	
	public MEMShowBoardListController getBoardListCon() {
		return boardListCon;
	}
	
	public void setBoardListCon(MEMShowBoardListController boardListCon) {
		this.boardListCon = boardListCon;
	}
	
	
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane subFrameFAQBoardDetail;

    @FXML
    private Label lblSearchBoard;
    
    @FXML
    private Label lblWriter;
    
    @FXML
    private TextField admin;

    @FXML
    private Label lblTitle;
    
    @FXML
    private TextField faqBoardTitle;

    @FXML
    private Button btnBack;
    
    @FXML
    private TextFlow TextFlow;

    @FXML
    private Text taContent;

    @FXML
    void btnBackClick(ActionEvent event) throws IOException {
    	subFrameFAQBoardDetail.getChildren().clear();
    	FXMLLoader loader = new FXMLLoader(MEMShowFAQBoardDetailController.class.getResource("../fxml/MEMShowBoardList.fxml"));
    	Parent child = loader.load();
    	
    	MEMShowBoardListController memShowBoardListController = loader.getController();
    	memShowBoardListController.setTableView("FAQ게시판");
    	subFrameFAQBoardDetail.getChildren().add(child);
    	
    }

    @FXML
    void initialize() {
    	//css 폰트 경로 설정해주기
    	Font.loadFont(getClass().getResourceAsStream("../z.source/GODOM.ttf"), 12);
    }
}
