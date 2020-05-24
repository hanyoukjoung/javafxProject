package controller;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.vo.FboardCmntVO;
import main.vo.MemberVO;
import main.vo.TotalBoardVO;
import service.board.BoardServiceImpl;
import service.board.IBoardService;
import service.comment.CommentServiceImpl;
import service.comment.ICommentService;


public class MEMShowBoardDetailController {
	private int cmntUpdate = 0 ;
	private int cmntcmntInsert = 0 ;
	
	private int cmnt_target;
	private FboardCmntVO updateCmnt;
	
	private MemberVO loginMem;
	private IBoardService serviceBoard;
	private ICommentService serviceComment;
	private TotalBoardVO freeBoardVo;
    public TotalBoardVO getFreeBoardVo() {
		return freeBoardVo;
	}
	public void setFreeBoardVo(TotalBoardVO freeBoardVo) {
		this.freeBoardVo = freeBoardVo;
		fboardMemId.setText(freeBoardVo.getMem_id());
		fboardTitle.setText(freeBoardVo.getBoard_title());
		fboardCont.setText(freeBoardVo.getBoard_cont());
		setCmnt();
	}
	
	public MEMShowBoardDetailController(){
		serviceBoard = BoardServiceImpl.getInstance();
		serviceComment = CommentServiceImpl.getInstance();
	}
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane subFrameBoardShowDetail;

    @FXML
    private Label lblMainTitle;

    @FXML
    private Label lblTitle;

    @FXML
    private TextField fboardMemId;

    @FXML
    private Label lblWriter;

    @FXML
    private TextField fboardTitle;

    @FXML
    private Label lblCont;

    @FXML
    private TextFlow textFlow;

    @FXML
    private Text fboardCont;

    @FXML
    private Label lblComment;

    @FXML
    private VBox ScollPaneComment;

    @FXML
    private Label lblWriteComment;

    @FXML
    private TextArea taCommentContent;

    @FXML
    private Button btnCMNTInsert;

    @FXML
    private Button btnModify;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnReport;

    @FXML
    private Button btnBack;

    @FXML
    void btnBackClick(ActionEvent event) throws IOException {
    	subFrameBoardShowDetail.getChildren().clear();
    	FXMLLoader loader = new FXMLLoader(MEMShowBoardDetailController.class.getResource("../fxml/MEMShowBoardList.fxml"));
    	Parent child = loader.load();
    	subFrameBoardShowDetail.getChildren().add(child);
    }

    @FXML
    void btnCMNTInsertClick(ActionEvent event) throws IOException {
    	if(cmntUpdate ==0 && cmntcmntInsert ==0 ) {                    //게시글의 댓글등록
    		FboardCmntVO fBoardCmntVo = new FboardCmntVO();
    		fBoardCmntVo.setFree_board_no(freeBoardVo.getBoard_no());
    		fBoardCmntVo.setCmnt_reply_yn("N");
    		fBoardCmntVo.setCmnt_cont(taCommentContent.getText());
    		fBoardCmntVo.setMem_id(loginMem.getMem_id());
    		
    		serviceComment.insertComment(fBoardCmntVo);
    		
    		taCommentContent.clear();
    		
    		setCmnt();
    		
    	}else if(cmntUpdate == 1 ) {                                   //댓글 수정
    			updateCmnt.setCmnt_cont(taCommentContent.getText());
    			
    			serviceComment.updateComment(updateCmnt);
    			
    			updateCmnt=null;
    			cmntUpdate=0;
    			
    			setCmnt();
    			
    			taCommentContent.clear();
    		
    	}else if(cmntcmntInsert == 1) {                                //대댓글 등록
    		FboardCmntVO fBoardCmntCmntVo = new FboardCmntVO();
    		fBoardCmntCmntVo.setFree_board_no(freeBoardVo.getBoard_no());
    		fBoardCmntCmntVo.setCmnt_reply_yn("Y");
    		fBoardCmntCmntVo.setCmnt_cont(taCommentContent.getText());
    		fBoardCmntCmntVo.setMem_id(loginMem.getMem_id());
    		fBoardCmntCmntVo.setCmnt_target(cmnt_target);
    		
    		serviceComment.insertCmntCmnt(fBoardCmntCmntVo);
    		
    		taCommentContent.clear();
    		cmntcmntInsert = 0;
    		cmnt_target = 0;
    		
    		setCmnt();
    		
    		taCommentContent.clear();
    	}
    }

    @FXML
    void btnDeleteClick(ActionEvent event) throws IOException {
    	
    	if(! loginMem.getMem_id().equals(freeBoardVo.getMem_id())) {
    		//해당 권한이 없습니다 팝업창
    		Stage popUpStage = new Stage();
    		
    		FXMLLoader loader = new FXMLLoader(MEMShowBoardDetailController.class.getResource("../fxml/BasicPopUp.fxml"));
    		
    		Parent basicPopUpChild = loader.load();
    		
    		BasicPopUpController basicPopUpController = loader.getController();
    		basicPopUpController.setMemShowBoardDetailController(this);
    		basicPopUpController.getBtnCancel().setVisible(false);
			basicPopUpController.getBtnConfirm().setVisible(false);
    		basicPopUpController.setLbText("해당 권한이 없습니다.");
    		
    		Scene scene = new Scene(basicPopUpChild);
    		popUpStage.setScene(scene);
    		popUpStage.initStyle(StageStyle.UNDECORATED);
    		popUpStage.show();
    		
    	}else if(loginMem.getMem_id().equals(freeBoardVo.getMem_id())) {
    		
    		serviceBoard.deleteFBoard(freeBoardVo.getBoard_no());
    		
    		subFrameBoardShowDetail.getChildren().clear();
    		FXMLLoader loader = new FXMLLoader(MEMShowBoardDetailController.class.getResource("../fxml/MEMShowBoardList.fxml"));
    		Parent child = loader.load();
    		subFrameBoardShowDetail.getChildren().add(child);
    	}
    	
    }

    @FXML
    void btnModifyClick(ActionEvent event) throws IOException {
    	if(! loginMem.getMem_id().equals(freeBoardVo.getMem_id())) {
    		//해당 권한이 없습니다 팝업창
    		Stage popUpStage = new Stage();
    		
    		FXMLLoader loader = new FXMLLoader(MEMShowBoardDetailController.class.getResource("../fxml/BasicPopUp.fxml"));
    		
    		Parent basicPopUpChild = loader.load();
    		
    		BasicPopUpController basicPopUpController = loader.getController();
    		basicPopUpController.setMemShowBoardDetailController(this);
    		basicPopUpController.getBtnCancel().setVisible(false);
			basicPopUpController.getBtnConfirm().setVisible(false); 
    		basicPopUpController.setLbText("해당 권한이 없습니다.");
    		
    		Scene scene = new Scene(basicPopUpChild);
    		popUpStage.setScene(scene);
    		popUpStage.initStyle(StageStyle.UNDECORATED);
    		popUpStage.show();
    		
    	}else if(loginMem.getMem_id().equals(freeBoardVo.getMem_id())) {
    		subFrameBoardShowDetail.getChildren().clear();
    		FXMLLoader loader = new FXMLLoader(MEMShowBoardDetailController.class.getResource("../fxml/MEMAddBoard.fxml"));
    		Parent child = loader.load();
    		
    		MEMAddBoardController memAddBoardController = loader.getController();
    		memAddBoardController.setUpdateCheck(1);
    		memAddBoardController.setFreeBoardVo(freeBoardVo);
    		
    		subFrameBoardShowDetail.getChildren().add(child);
    	}
    }

    /**
     * 게시글 신고 버튼 이벤트
     * @param event
     * @throws IOException 
     */
    @FXML
    void btnReportClick(ActionEvent event) throws IOException {
    	Stage popUpStage = new Stage();
		
		FXMLLoader loader = new FXMLLoader(MEMShowBoardDetailController.class.getResource("../fxml/MEMRPTLSNPopUp.fxml"));
		
		Parent reportPopUpChild = loader.load();
		MEMRPTLSNPopUpController memRPTLSNPopUpController = loader.getController();
		memRPTLSNPopUpController.setLblTitle("해당게시글을 신고하시겠습니까?");
		memRPTLSNPopUpController.setfBoardVo(freeBoardVo);
		
		Scene scene = new Scene(reportPopUpChild);
		popUpStage.setScene(scene);
		popUpStage.initStyle(StageStyle.UNDECORATED);
		popUpStage.show();
    }

    @FXML
    void initialize() {
    	Font.loadFont(getClass().getResourceAsStream("../z.source/GODOM.ttf"), 12); // 폰트스타일과 경로 설정
    	loginMem = LoginController.getSession(); // 로그인한 멤버 정보  MemberVO 타입 
    }
    
    /**
     * 해당 게시글의 댓글 셋팅하는 메서드 
     */
    void setCmnt() {
		ScollPaneComment.getChildren().clear();
    	
    	List<FboardCmntVO> fBoardCmntVo = serviceComment.getAllCommentList(freeBoardVo.getBoard_no());
    	int layOutY = 12;
    	
    	for(FboardCmntVO fbCmnt : fBoardCmntVo) {
    		AnchorPane addAnchorPane = new AnchorPane();
    		addAnchorPane.setPrefHeight(23);
    		
    		Label lblCmntId = new Label(fbCmnt.getMem_id());
    		lblCmntId.setLayoutX(12);
    		
    		Label txtCmntCont = new Label(fbCmnt.getCmnt_cont());
    		txtCmntCont.setLayoutX(100);
    		txtCmntCont.setPrefWidth(310);
    		
    		Label lblCmntDate = new Label(fbCmnt.getCmnt_date());
    		lblCmntDate.setLayoutX(410);
    		
    		Button btnAddCmnt = new Button("댓글");
    		btnAddCmnt.setLayoutX(495); 
    		btnAddCmnt.setId("btnCMNTInsert");
    		btnAddCmnt.setOnAction(event -> {
    			cmntcmntInsert = 1 ;
    			cmnt_target = fbCmnt.getCmnt_no();
    			taCommentContent.setPromptText("댓글을 입력하세요");
    		});
    		
    		
    		Button btnUpdateCmnt = new Button("수정");
    		btnUpdateCmnt.setLayoutX(538);
    		btnUpdateCmnt.setId("btnCMNTInsert");
    		btnUpdateCmnt.setOnAction(event -> {
    			if(!fbCmnt.getMem_id().equals(loginMem.getMem_id())) {
        			Stage popUpStage = new Stage();
            		
            		FXMLLoader loader = new FXMLLoader(MEMShowBoardDetailController.class.getResource("../fxml/BasicPopUp.fxml"));
            		
            		Parent basicPopUpChild;
					try {
						basicPopUpChild = loader.load();
						BasicPopUpController basicPopUpController = loader.getController();
						basicPopUpController.setMemShowBoardDetailController(this);
						basicPopUpController.getBtnMiddleConfirm().setVisible(false);
						basicPopUpController.setLbText("해당 권한이 없습니다.");
						
						Scene scene = new Scene(basicPopUpChild);
						popUpStage.setScene(scene);
						popUpStage.initStyle(StageStyle.UNDECORATED);
						popUpStage.show();
					} catch (IOException e) {
						e.printStackTrace();
					}
        		}else {    			
        			cmntUpdate = 1;
        			updateCmnt = fbCmnt;
        			taCommentContent.setText(txtCmntCont.getText());
        		}
    		});
    		
    		Button btnDeleteCmnt = new Button("삭제");
    		btnDeleteCmnt.setLayoutX(581);
    		btnDeleteCmnt.setId("btnCMNTInsert");
    		btnDeleteCmnt.setOnAction(event -> {
    			if(!fbCmnt.getMem_id().equals(loginMem.getMem_id())) {
        			Stage popUpStage = new Stage();
            		
            		FXMLLoader loader = new FXMLLoader(MEMShowBoardDetailController.class.getResource("../fxml/BasicPopUp.fxml"));
            		
            		Parent basicPopUpChild;
					try {
						basicPopUpChild = loader.load();
						BasicPopUpController basicPopUpController = loader.getController();
						basicPopUpController.setMemShowBoardDetailController(this);
						basicPopUpController.getBtnCancel().setVisible(false);
						basicPopUpController.getBtnConfirm().setVisible(false);
						basicPopUpController.setLbText("해당 권한이 없습니다.");
						
						Scene scene = new Scene(basicPopUpChild);
						popUpStage.setScene(scene);
						popUpStage.initStyle(StageStyle.UNDECORATED);
						popUpStage.show();
					} catch (IOException e) {
						e.printStackTrace();
					}
        		}else { 
        			serviceComment.deleteCommnet(fbCmnt.getCmnt_no());
        			setCmnt();
        		}
    		});
    		
    		Button btnRPTCmnt =new Button("신고");
    		btnRPTCmnt.setLayoutX(624);
    		btnRPTCmnt.setId("btnCMNTInsert");
    		
    		addAnchorPane.getChildren().addAll(lblCmntId, txtCmntCont, lblCmntDate, btnAddCmnt, btnUpdateCmnt, btnDeleteCmnt, btnRPTCmnt);
    		
    		ScollPaneComment.getChildren().add(addAnchorPane);
    		
    		Map<String, Integer> params = new HashMap<>();
    		params.put("free_board_no",freeBoardVo.getBoard_no());
    		params.put("cmnt_target",fbCmnt.getCmnt_no());
    		
    		List<FboardCmntVO> fBoardCmntCmntVo = serviceComment.getAllFBoardCmntCmntList(params);
    		
    		if(fBoardCmntCmntVo != null) {
    			for(FboardCmntVO fbCmntCmnt :  fBoardCmntCmntVo) {
    				AnchorPane addCmntAnchorPane = new AnchorPane();
    				
    				Label lblCmntCmnt = new Label("└");
    				lblCmntCmnt.setLayoutX(32);
    				
    				Label lblCmntCmntId = new Label(fbCmntCmnt.getMem_id());
    				lblCmntCmntId.setLayoutX(52);
    				
    				Label txtCmntCmntCont = new Label(fbCmntCmnt.getCmnt_cont());
    				txtCmntCmntCont.setLayoutX(130);
    				txtCmntCmntCont.setPrefWidth(280);
    				
    				Label lblCmntCmntDate = new Label(fbCmntCmnt.getCmnt_date());
    				lblCmntCmntDate.setLayoutX(410);
    				
    				Button btnUpdateCmntCmnt = new Button("수정");
    				btnUpdateCmntCmnt.setLayoutX(495);
    				btnUpdateCmntCmnt.setId("btnCMNTInsert");
    				btnUpdateCmntCmnt.setOnAction(event -> {
    					if(!fbCmntCmnt.getMem_id().equals(loginMem.getMem_id())) {
    		    			Stage popUpStage = new Stage();
    		        		
    		        		FXMLLoader loader = new FXMLLoader(MEMShowBoardDetailController.class.getResource("../fxml/BasicPopUp.fxml"));
    		        		
    		        		Parent basicPopUpChild;
							try {
								basicPopUpChild = loader.load();
								BasicPopUpController basicPopUpController = loader.getController();
								basicPopUpController.setMemShowBoardDetailController(this);
								basicPopUpController.getBtnCancel().setVisible(false);
    							basicPopUpController.getBtnConfirm().setVisible(false);
								basicPopUpController.setLbText("해당 권한이 없습니다.");
								
								Scene scene = new Scene(basicPopUpChild);
								popUpStage.setScene(scene);
								popUpStage.initStyle(StageStyle.UNDECORATED);
								popUpStage.show();
							} catch (IOException e) {
								e.printStackTrace();
							}
    		        		
    		    		}else {    			
    		    			cmntUpdate = 1;
    		    			updateCmnt = fbCmntCmnt;
    		    			taCommentContent.setText(txtCmntCmntCont.getText());
    		    		}
    	    		});
    				
    				Button btnDeleteCmntCmnt = new Button("삭제");
    				btnDeleteCmntCmnt.setLayoutX(538);
    				btnDeleteCmntCmnt.setId("btnCMNTInsert");
    				btnDeleteCmntCmnt.setOnAction(event -> {
    					if(!fbCmntCmnt.getMem_id().equals(loginMem.getMem_id())) {
    						Stage popUpStage = new Stage();
    						
    						FXMLLoader loader = new FXMLLoader(MEMShowBoardDetailController.class.getResource("../fxml/BasicPopUp.fxml"));
    						
    						Parent basicPopUpChild;
    						try {
    							basicPopUpChild = loader.load();
    							BasicPopUpController basicPopUpController = loader.getController();
    							basicPopUpController.setMemShowBoardDetailController(this);
    							basicPopUpController.getBtnCancel().setVisible(false);
    							basicPopUpController.getBtnConfirm().setVisible(false);
    							basicPopUpController.setLbText("해당 권한이 없습니다.");
    							
    							Scene scene = new Scene(basicPopUpChild);
    							popUpStage.setScene(scene);
    							popUpStage.initStyle(StageStyle.UNDECORATED);
    							popUpStage.show();
    						} catch (IOException e) {
    							e.printStackTrace();
    						}
    					}else { 
    						serviceComment.deleteCommnet(fbCmntCmnt.getCmnt_no());
    						setCmnt();
    						
    					}
    				});
    				
    				Button btnRPTCmntCmnt =new Button("신고");
    				btnRPTCmntCmnt.setLayoutX(581);
    				btnRPTCmntCmnt.setId("btnCMNTInsert");
    				
    				addCmntAnchorPane.getChildren().addAll(lblCmntCmnt, lblCmntCmntId, txtCmntCmntCont, lblCmntCmntDate, btnUpdateCmntCmnt, btnDeleteCmntCmnt, btnRPTCmntCmnt);
    				
    				ScollPaneComment.getChildren().add(addCmntAnchorPane);
    				
    				layOutY = layOutY+ 23;
    				
    			} // 안쪽 for문
    		}// if문
    	}//밖깥쪽 for문 
    } // setCmnt 끝
}
