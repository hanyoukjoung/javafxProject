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
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import main.vo.TotalBoardVO;
import service.board.BoardServiceImpl;
import service.board.IBoardService;

public class AdminShowFAQBoardDetailController {
	private IBoardService service;
	
	private TotalBoardVO faqBoardVo;
    public TotalBoardVO getFaqBoardVo() {
		return faqBoardVo;
	}
	public void setFaqBoardVo(TotalBoardVO faqBoardVo) {
		this.faqBoardVo = faqBoardVo;
		lblBoardTitleTxt.setText(faqBoardVo.getBoard_title());
		taBoardCont.setText(faqBoardVo.getBoard_cont());
	}
	
	public AdminShowFAQBoardDetailController() {
		service = BoardServiceImpl.getInstance();
	}
	

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane subFrameBrdSearch;

    @FXML
    private Label lblMainTitle;

    @FXML
    private Label lblBoardWriter;

    @FXML
    private Label lblBoardWriterName;

    @FXML
    private Label lblBoardTitle;

    @FXML
    private Label lblBoardTitleTxt;

    @FXML
    private TextArea taBoardCont;

    @FXML
    private Button btnBoardModify;

    @FXML
    private Button btnBoardDel;

    @FXML
    private Button btnBoardList;

    @FXML
    void btnBoardDelClick(ActionEvent event) throws IOException {
    	service.deleteFAQBoard(faqBoardVo.getBoard_no());
    	
    	subFrameBrdSearch.getChildren().clear();

		FXMLLoader loader = new FXMLLoader(MEMShowBoardListController.class.getResource("../fxml/AdminShowBoardList.fxml"));
		Parent child = loader.load();
		AdminShowBoardListController adminShowBoardListController = loader.getController();
		
		adminShowBoardListController.setTableView("FAQ게시판");
		
		subFrameBrdSearch.getChildren().add(child);
    }

    @FXML
    void btnBoardListClick(ActionEvent event) throws IOException {
    	subFrameBrdSearch.getChildren().clear();
    	
    	FXMLLoader loader = new FXMLLoader(MEMShowBoardListController.class.getResource("../fxml/AdminShowBoardList.fxml"));
    	Parent child = loader.load();
    	AdminShowBoardListController adminShowBoardListController = loader.getController();
    	
    	adminShowBoardListController.setTableView("FAQ게시판");
    	
    	subFrameBrdSearch.getChildren().add(child);
    }

    @FXML
    void btnBoardModifyClick(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }
}
