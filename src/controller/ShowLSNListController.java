package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.vo.LboardVO;
import service.board.BoardServiceImpl;
import service.board.IBoardService;

public class ShowLSNListController {
	private IBoardService service;
	private List<LboardVO> data;
	private MEMAddLSNBoardController memAddLSNBoardCon;
	private MEMShowLSNDetailController memShowLSNDetailCon;
	
	public ShowLSNListController() {
		service = BoardServiceImpl.getInstance();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane subFrameLSN;

    @FXML
    private Button btnILang1;

    @FXML
    private Button btnMLang1;

    @FXML
    private Button btnILang2;

    @FXML
    private Button btnMLang2;

    @FXML
    private Button btnILang3;

    @FXML
    private Button btnMLang3;

    @FXML
    private Button btnILang4;

    @FXML
    private Button btnMLang4;

    @FXML
    private Button btnILang5;

    @FXML
    private Button btnMLang5;

    @FXML
    private Button btnILang6;

    @FXML
    private Button btnMLang6;

    @FXML
    private Pagination pagenation;

    @FXML
    private Text taLSN1;

    @FXML
    private Text taLSN2;

    @FXML
    private Text taLSN3;

    @FXML
    private Text taLSN4;

    @FXML
    private Text taLSN5;

    @FXML
    private Text taLSN6;
    
    @FXML
    private TextFlow txtFlowLSN1;
    
    @FXML
    private TextFlow txtFlowLSN2;
    
    @FXML
    private TextFlow txtFlowLSN3;
    
    @FXML
    private TextFlow txtFlowLSN4;
    
    @FXML
    private TextFlow txtFlowLSN5;
    
    @FXML
    private TextFlow txtFlowLSN6;
    
    @FXML
    private Button btnInsert;
    
    @FXML
    void txtFlowLSN1Click(MouseEvent event) throws IOException {
    	if(event.getClickCount()>1) {
    		Stage showLSNDetailPopup = new Stage();
    		
    		FXMLLoader loader = new FXMLLoader(ShowLSNListController.class.getResource("../fxml/MEMShowLSNDetailPopUp.fxml"));
    		
    		Parent showLSNDetailChild = loader.load();
    		
    		memShowLSNDetailCon = loader.getController();
    		memShowLSNDetailCon.setlBoardVo(lBoardThisPageList[0]);
    		
    		Scene scene = new Scene(showLSNDetailChild);
    		showLSNDetailPopup.setScene(scene);
    		showLSNDetailPopup.initStyle(StageStyle.UNDECORATED);
    		showLSNDetailPopup.show();
    	}

    }

    @FXML
    void txtFlowLSN2Click(MouseEvent event) throws IOException {
    	if(event.getClickCount()>1) {
    		Stage showLSNDetailPopup = new Stage();
    		
    		FXMLLoader loader = new FXMLLoader(ShowLSNListController.class.getResource("../fxml/MEMShowLSNDetailPopUp.fxml"));
    		
    		Parent showLSNDetailChild = loader.load();
    		
    		memShowLSNDetailCon = loader.getController();
    		memShowLSNDetailCon.setlBoardVo(lBoardThisPageList[1]);
    		
    		Scene scene = new Scene(showLSNDetailChild);
    		showLSNDetailPopup.setScene(scene);
    		showLSNDetailPopup.initStyle(StageStyle.UNDECORATED);
    		showLSNDetailPopup.show();
    	}

    }

    @FXML
    void txtFlowLSN3Click(MouseEvent event) throws IOException {
    	if(event.getClickCount()>1) {
    		Stage showLSNDetailPopup = new Stage();
    		
    		FXMLLoader loader = new FXMLLoader(ShowLSNListController.class.getResource("../fxml/MEMShowLSNDetailPopUp.fxml"));
    		
    		Parent showLSNDetailChild = loader.load();
    		
    		memShowLSNDetailCon = loader.getController();
    		memShowLSNDetailCon.setlBoardVo(lBoardThisPageList[2]);
    		
    		Scene scene = new Scene(showLSNDetailChild);
    		showLSNDetailPopup.setScene(scene);
    		showLSNDetailPopup.initStyle(StageStyle.UNDECORATED);
    		showLSNDetailPopup.show();
    	}
    }

    @FXML
    void txtFlowLSN4Click(MouseEvent event) throws IOException {
    	if(event.getClickCount()>1) {
    		Stage showLSNDetailPopup = new Stage();
    		
    		FXMLLoader loader = new FXMLLoader(ShowLSNListController.class.getResource("../fxml/MEMShowLSNDetailPopUp.fxml"));
    		
    		Parent showLSNDetailChild = loader.load();
    		
    		memShowLSNDetailCon = loader.getController();
    		memShowLSNDetailCon.setlBoardVo(lBoardThisPageList[3]);
    		
    		Scene scene = new Scene(showLSNDetailChild);
    		showLSNDetailPopup.setScene(scene);
    		showLSNDetailPopup.initStyle(StageStyle.UNDECORATED);
    		showLSNDetailPopup.show();
    	}
    }

    @FXML
    void txtFlowLSN5Click(MouseEvent event) throws IOException {
    	if(event.getClickCount()>1) {
    		Stage showLSNDetailPopup = new Stage();
    		
    		FXMLLoader loader = new FXMLLoader(ShowLSNListController.class.getResource("../fxml/MEMShowLSNDetailPopUp.fxml"));
    		
    		Parent showLSNDetailChild = loader.load();
    		
    		memShowLSNDetailCon = loader.getController();
    		memShowLSNDetailCon.setlBoardVo(lBoardThisPageList[4]);
    		
    		Scene scene = new Scene(showLSNDetailChild);
    		showLSNDetailPopup.setScene(scene);
    		showLSNDetailPopup.initStyle(StageStyle.UNDECORATED);
    		showLSNDetailPopup.show();
    	}
    }

    @FXML
    void txtFlowLSN6Click(MouseEvent event) throws IOException {
    	if(event.getClickCount()>1) {
    		Stage showLSNDetailPopup = new Stage();
    		
    		FXMLLoader loader = new FXMLLoader(ShowLSNListController.class.getResource("../fxml/MEMShowLSNDetailPopUp.fxml"));
    		
    		Parent showLSNDetailChild = loader.load();
    		
    		memShowLSNDetailCon = loader.getController();
    		memShowLSNDetailCon.setlBoardVo(lBoardThisPageList[5]);
    		
    		Scene scene = new Scene(showLSNDetailChild);
    		showLSNDetailPopup.setScene(scene);
    		showLSNDetailPopup.initStyle(StageStyle.UNDECORATED);
    		showLSNDetailPopup.show();
    	}
    }
    
    @FXML
    void btnInsertClick(ActionEvent event) throws IOException {
    	Stage popUpStage = new Stage();
		
		FXMLLoader loader = new FXMLLoader(ShowLSNListController.class.getResource("../fxml/MEMAddLSNBoard.fxml"));
		
		Parent basicPopUpChild = loader.load();
		
		memAddLSNBoardCon = loader.getController();
		memAddLSNBoardCon.setShowLSNListController(this);

		Scene scene = new Scene(basicPopUpChild);
		popUpStage.setScene(scene);
		popUpStage.initStyle(StageStyle.UNDECORATED);
		popUpStage.show();
    }
    

    int rowsPerPage = 6;
    
    private Button[] btnMLangs;
    private Button[] btnILangs;
    private Text[] taLSNs;
    private LboardVO[] lBoardThisPageList;
    
    public void setTextArea() {
    	data = service.selectBoard(); //레슨게시판 게시글 전체 다 가져오기 
    	changeTextArea(0);
    	setPageCount();
    }
    
    public void changeTextArea(int index) {
    	int fromIndex = index * rowsPerPage;
    	int toIndex = Math.min(fromIndex + rowsPerPage, data.size());
    	
    	int cnt = 0;
    	for(int i=fromIndex; i<toIndex; i++) {
    		taLSNs[cnt].setText(data.get(i).getLsn_board_cont());
    		lBoardThisPageList[cnt] = data.get(i);

    		String mLangs = data.get(i).getLang_major() == 1? "JAVA" :
    						data.get(i).getLang_major() == 2? "C++" : 
    						data.get(i).getLang_major() == 3? "PYTHON" : "ORACLE" ;
    		
    		String iLangs = data.get(i).getLang_itrst() == 1? "JAVA" :
							data.get(i).getLang_itrst() == 2? "C++" : 
							data.get(i).getLang_itrst() == 3? "PYTHON" : "ORACLE" ;
    		
    		btnMLangs[cnt].setText("전공 : "+ mLangs);
    		btnILangs[cnt++].setText("관심 : "+ iLangs);
    	}
    	
    }
    
    public void setPageCount() {
    	int pageCount = (int) Math.ceil((double)data.size() / rowsPerPage);
    	pagenation.setPageCount(pageCount);
    	
    	pagenation.currentPageIndexProperty().addListener(
    			new ChangeListener<Number>() {

					@Override
					public void changed(ObservableValue<? extends Number> observable, Number oldValue,
							Number newValue) {
						changeTextArea(newValue.intValue());
					}
		});
    	
    }
    
    @FXML
    void initialize() {
    	
    	Font.loadFont(getClass().getResourceAsStream("../z.source/GODOM.ttf"), 12);
    	//Font.loadFont(getClass().getResourceAsStream("../z.source/DXpro.ttf"), 12);
    	
    	btnMLangs = new Button[] {
    		btnMLang1,
    		btnMLang2,
    		btnMLang3,
    		btnMLang4,
    		btnMLang5,
    		btnMLang6
    	};
    	
    	btnILangs = new Button[] {
			btnILang1,
			btnILang2,
			btnILang3,
			btnILang4,
			btnILang5,
			btnILang6
    	};
    	
    	taLSNs = new Text[] {
			taLSN1,
			taLSN2,
			taLSN3,
			taLSN4,
			taLSN5,
			taLSN6
    	};
    	
    	lBoardThisPageList = new LboardVO[] {
    			new LboardVO(),	
    			new LboardVO(),	
    			new LboardVO(),	
    			new LboardVO(),	
    			new LboardVO(),	
    			new LboardVO(),	
    	};
    	
    	
    	setTextArea();
    	
    }
}