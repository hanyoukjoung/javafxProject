package controller;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
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
import javafx.scene.text.Font;
import main.vo.TotalBoardVO;
import service.board.BoardServiceImpl;
import service.board.IBoardService;
import service.report.IReportService;
import service.report.ReportServiceImpl;

public class AdminShowBoardListController {
	private IBoardService service;
	private IReportService serviceReport;
	private ObservableList<TotalBoardVO> boardData;
    String boardType ="자유게시판";

    
    public AdminShowBoardListController() {
    	service = BoardServiceImpl.getInstance();
    	serviceReport = ReportServiceImpl.getInstance();
    }
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane subFrameBrd;

    @FXML
    private ComboBox<String> comboBoardList;

    @FXML
    private TableView<TotalBoardVO> tableBoard;

    @FXML
    private TableColumn<?, ?> colBoardNo;

    @FXML
    private TableColumn<?, ?> colBoardTitle;

    @FXML
    private TableColumn<?, ?> colBoardWriter;

    @FXML
    private TableColumn<?, ?> colBoardDate;

    @FXML
    private TableColumn<?, ?> colBoardCnt;

    @FXML
    private Pagination pageBoard;

    @FXML
    private Button btnConfirm;

    @FXML
    void btnConfirmClick(ActionEvent event) throws IOException {
    	subFrameBrd.getChildren().clear();
    	AnchorPane anchorPane = FXMLLoader.load(AdminShowBoardListController.class.getResource("../fxml/AdminAddBoard.fxml"));
    	subFrameBrd.getChildren().add(anchorPane);
    }

    @FXML
    void subFrameBrdOnMouseDrag(MouseEvent event) {

    }
    
    /**
     * 테이블 게시글 더블 클릭시 게시글 상세보기로 창 전환되는 이벤트
     * @param event
     * @throws IOException 
     */
    @FXML
    void tableBoardClick(MouseEvent event) throws IOException {
    	if(event.getClickCount() > 1 ){
    		if(comboBoardList.getValue().equals("자유게시판") || comboBoardList.getValue().equals("신고된 게시글")) {
    			subFrameBrd.getChildren().clear();
    			FXMLLoader loader = new FXMLLoader(AdminShowBoardListController.class.getResource("../fxml/AdminShowBoardDetail.fxml"));
    			
    			Parent child = loader.load();
    			
    			TotalBoardVO freeBoardVo = tableBoard.getSelectionModel().getSelectedItem();
    			
    			AdminShowBoardDetailController adminShowBoardDetailCon = loader.getController();
    			adminShowBoardDetailCon.setfBoardVo(freeBoardVo);
    			
//    			//해당 게시글 조회수 증가하기 
//    			Map<String, Object> cntPlusBoard = new HashMap<>();
//    			cntPlusBoard.put("free_board_cnt",freeBoardVo.getBoard_cnt()+1);
//    			cntPlusBoard.put("free_board_no",freeBoardVo.getBoard_no());
//    			
//    			service.cntPlusFBoard(cntPlusBoard);
    			subFrameBrd.getChildren().add(child);
    			
    		}else if(comboBoardList.getValue().equals("FAQ게시판")){
    			subFrameBrd.getChildren().clear();
    			FXMLLoader loader = new FXMLLoader(MEMShowBoardListController.class.getResource("../fxml/AdminShowFAQBoardDetail.fxml"));
    			
    			Parent child = loader.load();
    			
    			TotalBoardVO faqBoardVo = tableBoard.getSelectionModel().getSelectedItem();
    			AdminShowFAQBoardDetailController adminShowFAQBoardDetailCon = loader.getController();
    			adminShowFAQBoardDetailCon.setFaqBoardVo(faqBoardVo);
    			
    			subFrameBrd.getChildren().add(child);
    		}else{
    			
    		}
    	}
    }
    
    /**
     * 콤보박스 변경시 테이블 다시 셋팅
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
    	//폰트 경로 설정하기
        Font.loadFont(getClass().getResourceAsStream("../z.source/GODOM.ttf"), 12);
        
        ObservableList<String> comboList = FXCollections.observableArrayList("자유게시판","FAQ게시판","신고된 게시글");
    	comboBoardList.setItems(comboList);
    	
//    	colBoardNo.setCellValueFactory(new PropertyValueFactory<>("no"));
//    	colBoardTitle.setCellValueFactory(new PropertyValueFactory<>("board_title"));
//    	colBoardWriter.setCellValueFactory(new PropertyValueFactory<>("mem_id"));
//    	colBoardDate.setCellValueFactory(new PropertyValueFactory<>("board_date"));
//    	colBoardCnt.setCellValueFactory(new PropertyValueFactory<>("board_cnt"));
    	
    	setTableView("자유게시판");
    }
    
    /**
     * 게시판 타입을 받아서 테이블을 셋팅하는 메서드
     * @param boardType
     * @author 정수민 
     */
    public void setTableView(String boardType) {
    	
    	if(boardType.equals("자유게시판")) {
    		comboBoardList.setValue("자유게시판");
    	}else if(boardType.equals("FAQ게시판")) {
    		comboBoardList.setValue("FAQ게시판");
    	}else {
    		comboBoardList.setValue("신고된 게시글");
    	}
    	
    	
    	if(boardType.equals("자유게시판")) {
    		tableBoard.getColumns().clear();
    		
    		TableColumn<TotalBoardVO, String> colBoardNo = new TableColumn("게시글 번호");
    		colBoardNo.setCellValueFactory(new PropertyValueFactory<>("no"));
    		colBoardNo.setPrefWidth(89);
    		
    		TableColumn<TotalBoardVO, String> colBoardTitle = new TableColumn("게시글 제목");
    		colBoardTitle.setCellValueFactory(new PropertyValueFactory<>("board_title"));
    		colBoardTitle.setPrefWidth(375);
    		
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
    		//데이터 가져오기
    		boardData = FXCollections.observableArrayList(service.getAllFBoardList());
    		
    	}else if(boardType.equals("FAQ게시판")){
    		tableBoard.getColumns().clear();

    		TableColumn<TotalBoardVO, String> colBoardNo = new TableColumn("게시글 번호");
    		colBoardNo.setCellValueFactory(new PropertyValueFactory<>("no"));
    		colBoardNo.setPrefWidth(89);
    		
    		TableColumn<TotalBoardVO, String> colBoardTitle = new TableColumn("게시글 제목");
    		colBoardTitle.setCellValueFactory(new PropertyValueFactory<>("board_title"));
    		colBoardTitle.setPrefWidth(460);
    		
    		TableColumn<TotalBoardVO, Integer> colBoardWriter = new TableColumn("작성자");
    		colBoardWriter.setCellValueFactory(new PropertyValueFactory<>("mem_id"));
    		colBoardWriter.setPrefWidth(108);
    		 
    		TableColumn<TotalBoardVO, String> colBoardDate = new TableColumn("작성일자");
    		colBoardDate.setCellValueFactory(new PropertyValueFactory<>("board_date"));
    		colBoardDate.setPrefWidth(113);

    		tableBoard.getColumns().addAll(colBoardNo, colBoardTitle, colBoardWriter, colBoardDate);
    		//데이터 가져오기
    		boardData = FXCollections.observableArrayList(service.getAllFAQBoardList());
    	}else{
    		tableBoard.getColumns().clear();
    		
    		TableColumn<TotalBoardVO, String> colBoardNo = new TableColumn("번호");
    		colBoardNo.setCellValueFactory(new PropertyValueFactory<>("no"));
    		colBoardNo.setPrefWidth(40);
    		
    		TableColumn<TotalBoardVO, String> colBoardTitle = new TableColumn("게시글 제목");
    		colBoardTitle.setCellValueFactory(new PropertyValueFactory<>("board_title"));
    		colBoardTitle.setPrefWidth(220);
    		
    		TableColumn<TotalBoardVO, Integer> colBoardWriter = new TableColumn("작성자");
    		colBoardWriter.setCellValueFactory(new PropertyValueFactory<>("mem_id"));
    		colBoardWriter.setPrefWidth(80);
    		 
    		TableColumn<TotalBoardVO, String> colBoardDate = new TableColumn("작성일자");
    		colBoardDate.setCellValueFactory(new PropertyValueFactory<>("board_date"));
    		colBoardDate.setPrefWidth(76);

    		TableColumn<TotalBoardVO, String> colBoardCnt = new TableColumn("신고사유");
    		colBoardCnt.setCellValueFactory(new PropertyValueFactory<>("rpt_cate"));
    		colBoardCnt.setPrefWidth(155);
    		
    		
//    		colBoardWriter.setPrefWidth(80);
//    		colBoardDate.setPrefWidth(80);
    		
//    		colBoardCnt.setText("신고 사유");
//    		colBoardCnt.setCellValueFactory(new PropertyValueFactory<>("rpt_cate"));
//    		colBoardCnt.setPrefWidth(150);
//    		tableBoard.getColumns().addAll(colBoardNo, colBoardTitle, colBoardWriter, colBoardDate, colBoardCnt);
    		
    		//신고 카테고리, 신고일자,     		
    		TableColumn<TotalBoardVO, String> colRptMemId = new TableColumn("신고한 회원");
    		colRptMemId.setCellValueFactory(new PropertyValueFactory<>("rpt_mem_id"));
    		colRptMemId.setPrefWidth(76);
    		
    		TableColumn<TotalBoardVO, String> colRptDate = new TableColumn("신고일자");
    		colRptDate.setCellValueFactory(new PropertyValueFactory<>("rpt_date"));
    		colRptDate.setPrefWidth(76);
    		
    		TableColumn<TotalBoardVO, Integer> colRptCnt = new TableColumn("신고횟수");
    		colRptCnt.setCellValueFactory(new PropertyValueFactory<>("rpt_cnt"));
    		colRptCnt.setPrefWidth(60);
    		
    		if(btnConfirm.isVisible() == true) btnConfirm.setVisible(false);
    		
    		
    		tableBoard.getColumns().addAll(colBoardNo, colBoardTitle, colBoardWriter, colBoardDate, colBoardCnt,colRptMemId, colRptDate, colRptCnt);
    		
    		boardData = FXCollections.observableArrayList(service.getAllReportFBoard());

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
