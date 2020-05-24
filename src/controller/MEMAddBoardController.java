package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.vo.FboardVO;
import main.vo.TotalBoardVO;
import service.board.BoardServiceImpl;
import service.board.IBoardService;

public class MEMAddBoardController {
	private int updateCheck=0;
	private TotalBoardVO freeBoardVo;
	private IBoardService service;
	
	public MEMAddBoardController() {
		this.service = BoardServiceImpl.getInstance();
	}
	
    public int getUpdateCheck() {
		return updateCheck;
	}
	public void setUpdateCheck(int updateCheck) {
		this.updateCheck = updateCheck;
	}
	public TotalBoardVO getFreeBoardVo() {
		return freeBoardVo;
	}
	public void setFreeBoardVo(TotalBoardVO freeBoardVo) {
		this.freeBoardVo = freeBoardVo;
		tfTitle.setText(freeBoardVo.getBoard_title());
		taContent.setText(freeBoardVo.getBoard_cont());
	}

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane subFrameBoardInsert;

    @FXML
    private Label lblMainTitle;

    @FXML
    private Label lblWriter;

    @FXML
    private Label lblTitle;
    
    @FXML
    private Label lblWriterName;

    @FXML
    private TextField tfTitle;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnInsert;

    @FXML
    private TextArea taContent;
 
    @FXML
    void btnBackClick(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(MEMAddBoardController.class.getResource("../fxml/MEMShowBoardList.fxml"));
    	Parent child = loader.load();
    	subFrameBoardInsert.getChildren().set(0, child);
    }

    @FXML
    void btnInsertClick(ActionEvent event) throws IOException {
    	FboardVO fboardVo = new FboardVO();
    	
    	//추후에 빈칸 입력시 검사 추가할건지 확인해야함 
//    	String boardTitle = tfTitle.getText();
//    	String boardCont = taContent.getText();
    	
    	if(tfTitle.getText().equals("")) {
    		Stage popUpStage = new Stage();
    		
    		FXMLLoader loader = new FXMLLoader(MEMShowBoardDetailController.class.getResource("../fxml/BasicPopUp.fxml"));
    		
    		Parent basicPopUpChild = loader.load();
    		
    		BasicPopUpController basicPopUpController = loader.getController();
    		basicPopUpController.setMemAddBoardController(this);
    		basicPopUpController.getBtnMiddleConfirm().setVisible(true);
    		basicPopUpController.getBtnCancel().setVisible(false);
    		basicPopUpController.getBtnConfirm().setVisible(false);
    		basicPopUpController.setLbText("게시글 제목을 입력하세요");
    		
    		Scene scene = new Scene(basicPopUpChild);
    		popUpStage.setScene(scene);
    		popUpStage.initStyle(StageStyle.UNDECORATED);
    		popUpStage.show();
    	}else if(taContent.getText().equals("")) {
    		Stage popUpStage = new Stage();
    		
    		FXMLLoader loader = new FXMLLoader(MEMShowBoardDetailController.class.getResource("../fxml/BasicPopUp.fxml"));
    		
    		Parent basicPopUpChild = loader.load();
    		
    		BasicPopUpController basicPopUpController = loader.getController();
    		basicPopUpController.setMemAddBoardController(this);
    		basicPopUpController.getBtnMiddleConfirm().setVisible(true);
    		basicPopUpController.getBtnCancel().setVisible(false);
    		basicPopUpController.getBtnConfirm().setVisible(false);
    		basicPopUpController.setLbText("게시글 내용을 입력하세요");
    		
    		Scene scene = new Scene(basicPopUpChild);
    		popUpStage.setScene(scene);
    		popUpStage.initStyle(StageStyle.UNDECORATED);
    		popUpStage.show();
    	}else {
    		fboardVo.setMem_id(LoginController.getSession().getMem_id()); //글쓴이 가져오기 
    		fboardVo.setFree_board_title(tfTitle.getText());
    		fboardVo.setFree_board_cont(taContent.getText());
    		
    		if(updateCheck == 0) {
    			//데이터 추가하기 
    			service.insertFBoard(fboardVo);
    			System.out.println(updateCheck);
    		}else if(updateCheck == 1) {
    			fboardVo.setFree_board_no(freeBoardVo.getBoard_no());
    			
    			service.updateFBoard(fboardVo);
    			System.err.println(updateCheck);
    		}
    		
    		FXMLLoader loader = new FXMLLoader(MEMAddBoardController.class.getResource("../fxml/MEMShowBoardList.fxml"));
    		Parent child = loader.load();
    		subFrameBoardInsert.getChildren().set(0, child);
    	}
    	
    }

    @FXML
    void initialize() {
    	
    	//font 경로 설정하기
    	Font.loadFont(getClass().getResourceAsStream("../z.source/GODOM.ttf"), 12);
    			
    	//작성자에 글쓴이 넣어주기 
    	lblWriterName.setText(LoginController.getSession().getMem_name());
    	
    	tfTitle.setText("");
    	taContent.setText("");
    }
}
