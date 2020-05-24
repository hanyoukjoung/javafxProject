package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import main.vo.FAQBoardVO;
import main.vo.NBoardVO;
import main.vo.TotalBoardVO;
import service.board.BoardServiceImpl;
import service.board.IBoardService;

public class AdminAddBoardController {
	private TotalBoardVO freeBoardVo;
	private IBoardService service;
	
	public AdminAddBoardController() {
		service = BoardServiceImpl.getInstance();
	}
	
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane subFrameAdminBoardInsert;

    @FXML
    private ComboBox<String> comboBoardList;

    @FXML
    private Label boardWriter;

    @FXML
    private Label boardWriterManager;

    @FXML
    private Label boardTitle;

    @FXML
    private TextField tfTitle;

    @FXML
    private TextArea taCont;

    @FXML
    private Button btnBoardList;

    @FXML
    private Button btnBoardInsert;

    @FXML
    void btnBoardInsertClick(ActionEvent event) throws IOException {
    	if(comboBoardList.getValue().equals("공지게시판") ) {
    		NBoardVO nBoardVo = new NBoardVO();
    		
    		nBoardVo.setAdmin_id("admin");
    		nBoardVo.setNtc_board_title(tfTitle.getText());
    		nBoardVo.setNtc_board_cont(taCont.getText()); 
    		
//    		service.inser
    		
    	}else {
    		FAQBoardVO faqBoardVo = new FAQBoardVO();
    		
    		faqBoardVo.setAdmin_id("admin");
    		faqBoardVo.setFaq_board_title(tfTitle.getText());
    		faqBoardVo.setFaq_board_cont(taCont.getText());
    		
    		service.insertFAQBoard(faqBoardVo);
    		
    		subFrameAdminBoardInsert.getChildren().clear();

    		FXMLLoader loader = new FXMLLoader(MEMShowBoardListController.class.getResource("../fxml/AdminShowBoardList.fxml"));
    		Parent child = loader.load();
    		AdminShowBoardListController adminShowBoardListController = loader.getController();
    		
//    		adminShowBoardListController.boardType ="FAQ게시판"; 
    		adminShowBoardListController.setTableView("FAQ게시판");
    		
    		subFrameAdminBoardInsert.getChildren().add(child);
    	}
    }

    @FXML
    void btnBoardListClick(ActionEvent event) throws IOException {
    	subFrameAdminBoardInsert.getChildren().clear();
    	AnchorPane anchorPane = FXMLLoader.load(AdminAddBoardController.class.getResource("../fxml/AdminShowBoardList.fxml"));
    	subFrameAdminBoardInsert.getChildren().add(anchorPane);
    }

    @FXML
    void initialize() {
    	ObservableList<String> comboList = FXCollections.observableArrayList("공지게시판","FAQ게시판");
    	comboBoardList.setItems(comboList);
    	

    }
}
