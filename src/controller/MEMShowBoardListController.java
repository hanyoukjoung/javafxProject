package controller;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.vo.TotalBoardVO;
import service.board.BoardServiceImpl;
import service.board.IBoardService;

public class MEMShowBoardListController {
	private IBoardService service;
	private ObservableList<TotalBoardVO> boardData;
    String boardType ="자유게시판";
//	public String getBoardTypeStr() {
//		return boardTypeStr;
//	}
//	public void setBoardTypeStr(String boardTypeStr) {
//		this.boardTypeStr = boardTypeStr;
//	}
	
	//생성자
	public MEMShowBoardListController() {
		service = BoardServiceImpl.getInstance();
	}
	
	private Stage primaryStage;
	
    public Stage getPrimaryStage() {
		return primaryStage;
	}
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane subFrameBoard;

    @FXML
    private TableView<TotalBoardVO> tableBoard;

    @FXML
    private TableColumn<?, ?> colBoardNum;

    @FXML
    private TableColumn<?, ?> colBoardTitle;

    @FXML
    private TableColumn<?, ?> colBoardWriter;

    @FXML
    private TableColumn<?, ?> colBoardDate;

    @FXML
    private TableColumn<?, ?> colBoardCnt;

    @FXML
    private ComboBox<String> comboBoardList;

    @FXML
    private Pagination pageBoard;

    @FXML
    private Button btnInsert;
    
    @FXML
    void tableBoardClick(MouseEvent event) throws IOException {
//    	if(tableBoard.getSelectionModel().isEmpty()) {
//    		return;
//    	}
    	/**
    	 * 테이블 게시글 더블 클릭시 상세보기 되는 부분 
    	 */
    	if(event.getClickCount() > 1 ) {
    		if(boardType.equals("FAQ게시판")) {
    			subFrameBoard.getChildren().clear();
    			FXMLLoader loader = new FXMLLoader(MEMShowBoardListController.class.getResource("../fxml/MEMShowFAQBoardDetail.fxml"));
    			
    			Parent child = loader.load();
    			
    			TotalBoardVO faqBoardVo = tableBoard.getSelectionModel().getSelectedItem();
    			MEMShowFAQBoardDetailController faqBoardDetailCon = loader.getController();

    			faqBoardDetailCon.setFaqBoardVo(faqBoardVo);
//    			faqBoardDetailCon.setBoardListCon(this);
    			
    			subFrameBoard.getChildren().add(child);
    			
    		}else{
    			subFrameBoard.getChildren().clear();
    			
    			FXMLLoader loader = new FXMLLoader(MEMShowBoardListController.class.getResource("../fxml/MEMShowBoardDetail.fxml"));
    			
    			Parent child = loader.load();
    			
    			TotalBoardVO freeBoardVo = tableBoard.getSelectionModel().getSelectedItem();
    			
    			//해당 게시글 조회수 증가하기 
    			Map<String, Object> cntPlusBoard = new HashMap<>();
    			cntPlusBoard.put("free_board_cnt",freeBoardVo.getBoard_cnt()+1);
    			cntPlusBoard.put("free_board_no",freeBoardVo.getBoard_no());
    			
    			service.cntPlusFBoard(cntPlusBoard);
    			
    			MEMShowBoardDetailController freeBoardDetailCon = loader.getController();
    			
    			freeBoardDetailCon.setFreeBoardVo(freeBoardVo);
    			subFrameBoard.getChildren().add(child);
    		}
    	}

    }
    
    /**
     * 게시글 등록 버튼 이벤트
     * @param event
     * @throws IOException
     */
    @FXML
    void btnInsertClick(ActionEvent event) throws IOException {
    	
    	
    	AnchorPane anchorPane = FXMLLoader.load(MEMShowBoardListController.class.getResource("../fxml/MEMAddBoard.fxml"));
    	subFrameBoard.getChildren().set(0,anchorPane);
    	 
    }
    
    
    /**
     * 게시판 종류 콤보박스 클릭 이벤트
     * @param event
     */
    @FXML
    void comboBoardListClick(ActionEvent event) {
    	boardType = comboBoardList.getSelectionModel().getSelectedItem();
    	
    	setTableView(boardType);
    }
    
    int rowsPerPage = 17; 
    
    @FXML
    void initialize() {
    	//콤보박스 내용 넣기 
    	ObservableList<String> comboList = FXCollections.observableArrayList("자유게시판","FAQ게시판");
    	comboBoardList.setItems(comboList);
    	
    	colBoardNum.setCellValueFactory(new PropertyValueFactory<>("no"));
    	colBoardTitle.setCellValueFactory(new PropertyValueFactory<>("board_title" ));
    	colBoardWriter.setCellValueFactory(new PropertyValueFactory<>("mem_id"));
    	colBoardDate.setCellValueFactory(new PropertyValueFactory<>("board_date"));
    	colBoardCnt.setCellValueFactory(new PropertyValueFactory<>("board_cnt"));
    	
    	//테이블 셋팅 
    	setTableView("자유게시판");
    }
    
    /**
     * 게시판 타입을 입력받아 게시판 테이블 셋팅하는 메서드
     */
    public void setTableView(String boardType) {
    	if(boardType.equals("자유게시판")) {
    		comboBoardList.setValue("자유게시판");
    	}else {
    		comboBoardList.setValue("FAQ게시판");
    	}
    	if(boardType.equals("FAQ게시판")) {
    		tableBoard.getColumns().clear();

    		TableColumn<TotalBoardVO, String> colBoardNo = new TableColumn("게시글 번호");
    		colBoardNo.setCellValueFactory(new PropertyValueFactory<>("no"));
    		colBoardNo.setPrefWidth(89);
    		
    		TableColumn<TotalBoardVO, String> colBoardTitle = new TableColumn("게시글 제목");
    		colBoardTitle.setCellValueFactory(new PropertyValueFactory<>("board_title"));
    		colBoardTitle.setPrefWidth(488);
    		
    		TableColumn<TotalBoardVO, Integer> colBoardWriter = new TableColumn("작성자");
    		colBoardWriter.setCellValueFactory(new PropertyValueFactory<>("mem_id"));
    		colBoardWriter.setPrefWidth(108);
    		 
    		TableColumn<TotalBoardVO, String> colBoardDate = new TableColumn("작성일자");
    		colBoardDate.setCellValueFactory(new PropertyValueFactory<>("board_date"));
    		colBoardDate.setPrefWidth(113);

    		tableBoard.getColumns().addAll(colBoardNo, colBoardTitle, colBoardWriter, colBoardDate);
    		
    		if(btnInsert.isVisible() == true) btnInsert.setVisible(false);
    		//데이터 가져오기
    		boardData = FXCollections.observableArrayList(service.getAllFAQBoardList());
    	}else{
    		tableBoard.getColumns().clear();
    		
    		TableColumn<TotalBoardVO, String> colBoardNo = new TableColumn("게시글 번호");
    		colBoardNo.setCellValueFactory(new PropertyValueFactory<>("no"));
    		colBoardNo.setPrefWidth(89);
    		
    		TableColumn<TotalBoardVO, String> colBoardTitle = new TableColumn("게시글 제목");
    		colBoardTitle.setCellValueFactory(new PropertyValueFactory<>("board_title"));
    		colBoardTitle.setPrefWidth(403);
    		
    		TableColumn<TotalBoardVO, Integer> colBoardWriter = new TableColumn("작성자");
    		colBoardWriter.setCellValueFactory(new PropertyValueFactory<>("mem_id"));
    		colBoardWriter.setPrefWidth(108);
    		 
    		TableColumn<TotalBoardVO, String> colBoardDate = new TableColumn("작성일자");
    		colBoardDate.setCellValueFactory(new PropertyValueFactory<>("board_date"));
    		colBoardDate.setPrefWidth(113);

    		TableColumn<TotalBoardVO, String> colBoardCnt = new TableColumn("조회수");
    		colBoardCnt.setCellValueFactory(new PropertyValueFactory<>("board_cnt"));
    		colBoardCnt.setPrefWidth(85);
    		
    		tableBoard.getColumns().addAll(colBoardNo, colBoardTitle, colBoardWriter, colBoardDate, colBoardCnt);
    		
    		
    		
    		
    		
    		
    		
    		if(colBoardCnt.isVisible() == false) colBoardCnt.setVisible(true);
    		if(btnInsert.isVisible() == false) btnInsert.setVisible(true);
    		//데이터 가져오기
    		boardData = FXCollections.observableArrayList(service.getAllFBoardList());
    	}
    	setPageCount();
    }

    public void setPageCount() {
    	
    	int pageCount = (int) Math.ceil((double)boardData.size() / rowsPerPage );
    	pageBoard.setPageCount(pageCount);
    	changeTableView(0);
    	
    	pageBoard.currentPageIndexProperty().addListener(
			new ChangeListener<Number>() {
				@Override
				public void changed(ObservableValue<? extends Number> observable,
						Number oldValue, Number newValue) {
					changeTableView(newValue.intValue());
				}
			}
    	);
    }

    public void changeTableView(int index) {
    	int fromIndex = index * rowsPerPage;
    	int toIndex = Math.min(fromIndex + rowsPerPage, boardData.size());
    	
    	tableBoard.setItems(FXCollections.observableArrayList(boardData.subList(fromIndex, toIndex)));
    }
}
