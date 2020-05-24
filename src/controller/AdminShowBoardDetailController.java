package controller;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
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

public class AdminShowBoardDetailController {
	private int cmntUpdate = 0 ;
	private int cmntcmntInsert = 0 ;
	private int cmnt_target;
	private FboardCmntVO updateCmnt;
	
	private IBoardService serviceBoard;
	private ICommentService serviceComment;
	private MemberVO loginMem;
	
	private TotalBoardVO fBoardVo;
    public TotalBoardVO getfBoardVo() {
		return fBoardVo;
	}
	public void setfBoardVo(TotalBoardVO fBoardVo) {
		this.fBoardVo = fBoardVo;
		lblBoardWriterName.setText(fBoardVo.getMem_id());
		lblBoardTitleTxt.setText(fBoardVo.getBoard_title());
		taBoardContText.setText(fBoardVo.getBoard_cont());
		setCmnt();
		
	}
	
	public AdminShowBoardDetailController() {
		serviceBoard = BoardServiceImpl.getInstance();
		serviceComment = CommentServiceImpl.getInstance();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane subFrameBrdSearch;

    @FXML
    private Label lblBoardWriter;

    @FXML
    private Label lblBoardWriterName;

    @FXML
    private Label lblBoardTitle;

    @FXML
    private Label lblBoardTitleTxt;

    @FXML
    private TextFlow taBoardCont;

    @FXML
    private Text taBoardContText;

    @FXML
    private VBox vboxComment;

    @FXML
    private TextField tfCommentWrite;

    @FXML
    private Button btnBoardCommentInsert;

    @FXML
    private Button btnBoardModify;

    @FXML
    private Button btnBoardDel;

    @FXML
    private Button btnBoardList;

    @FXML
    void btnBoardCommentInsertClick(ActionEvent event) {
    	
    }

    @FXML
    void btnBoardDelClick(ActionEvent event) {
    	

    }

    @FXML
    void btnBoardListClick(ActionEvent event) throws IOException {
    	subFrameBrdSearch.getChildren().clear();
    	FXMLLoader loader = new FXMLLoader(AdminShowBoardDetailController.class.getResource("../fxml/AdminShowBoardList.fxml"));
    	Parent child = loader.load();
    	subFrameBrdSearch.getChildren().add(child);
    }

    @FXML
    void btnBoardModifyClick(ActionEvent event) {

    }

    @FXML
    void initialize() {
    	Font.loadFont(getClass().getResourceAsStream("../z.source/GODOM.ttf"), 12); // 폰트스타일과 경로 설정
    	loginMem = LoginController.getSession();
    }
    
    void setCmnt() {
    	vboxComment.getChildren().clear();
    	
    	List<FboardCmntVO> fBoardCmntVo = serviceComment.getAllCommentList(fBoardVo.getBoard_no());
    	int layOutY = 12;
    	
    	for(FboardCmntVO fbCmnt : fBoardCmntVo) {
    		AnchorPane addAnchorPane = new AnchorPane();
    		addAnchorPane.setPrefHeight(23);
    		
    		Label lblCmntId = new Label(fbCmnt.getMem_id());
    		lblCmntId.setLayoutX(12);
    		
    		Label txtCmntCont = new Label(fbCmnt.getCmnt_cont());
    		txtCmntCont.setLayoutX(100);
    		txtCmntCont.setPrefWidth(400);
    		
    		Label lblCmntDate = new Label(fbCmnt.getCmnt_date());
    		lblCmntDate.setLayoutX(500);
    		
    		Button btnAddCmnt = new Button("댓글");
    		btnAddCmnt.setLayoutX(585); 
    		btnAddCmnt.setId("btnBoardDel");
    		btnAddCmnt.setOnAction(event -> {
    			cmntcmntInsert = 1 ;
    			cmnt_target = fbCmnt.getCmnt_no();
    			tfCommentWrite.setPromptText("댓글을 입력하세요");
    		});
    		
    		
    		Button btnUpdateCmnt = new Button("수정");
    		btnUpdateCmnt.setLayoutX(631);
    		btnUpdateCmnt.setId("btnBoardDel");
    		btnUpdateCmnt.setOnAction(event -> {
    			if(!fbCmnt.getMem_id().equals(loginMem.getMem_id())) {
        			Stage popUpStage = new Stage();
            		
            		FXMLLoader loader = new FXMLLoader(MEMShowBoardDetailController.class.getResource("../fxml/BasicPopUp.fxml"));
            		
            		Parent basicPopUpChild;
					try {
						basicPopUpChild = loader.load();
						BasicPopUpController basicPopUpController = loader.getController();
						basicPopUpController.setAdminShowBoardDetailController(this);
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
        			tfCommentWrite.setText(txtCmntCont.getText());
        		}
    		});
    		
    		Button btnDeleteCmnt = new Button("삭제");
    		btnDeleteCmnt.setLayoutX(677);
    		btnDeleteCmnt.setId("btnBoardDel");
    		btnDeleteCmnt.setOnAction(event -> {
    			if(!fbCmnt.getMem_id().equals(loginMem.getMem_id())) {
        			Stage popUpStage = new Stage();
            		
            		FXMLLoader loader = new FXMLLoader(MEMShowBoardDetailController.class.getResource("../fxml/BasicPopUp.fxml"));
            		
            		Parent basicPopUpChild;
					try {
						basicPopUpChild = loader.load();
						BasicPopUpController basicPopUpController = loader.getController();
						basicPopUpController.setAdminShowBoardDetailController(this);
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
    		btnRPTCmnt.setLayoutX(723);
    		btnRPTCmnt.setId("btnBoardDel");
    		
    		addAnchorPane.getChildren().addAll(lblCmntId, txtCmntCont, lblCmntDate, btnAddCmnt, btnUpdateCmnt, btnDeleteCmnt, btnRPTCmnt);
    		
    		vboxComment.getChildren().add(addAnchorPane);
    		
    		Map<String, Integer> params = new HashMap<>();
    		params.put("free_board_no",fBoardVo.getBoard_no());
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
    				lblCmntCmntDate.setLayoutX(500);
    				
    				Button btnUpdateCmntCmnt = new Button("수정");
    				btnUpdateCmntCmnt.setLayoutX(631);
    				btnUpdateCmntCmnt.setId("btnBoardDel");
    				btnUpdateCmntCmnt.setOnAction(event -> {
    					if(!fbCmntCmnt.getMem_id().equals(loginMem.getMem_id())) {
    		    			Stage popUpStage = new Stage();
    		        		
    		        		FXMLLoader loader = new FXMLLoader(MEMShowBoardDetailController.class.getResource("../fxml/BasicPopUp.fxml"));
    		        		
    		        		Parent basicPopUpChild;
							try {
								basicPopUpChild = loader.load();
								BasicPopUpController basicPopUpController = loader.getController();
								basicPopUpController.setAdminShowBoardDetailController(this);
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
    		    			tfCommentWrite.setText(txtCmntCmntCont.getText());
    		    		}
    	    		});
    				
    				Button btnDeleteCmntCmnt = new Button("삭제");
    				btnDeleteCmntCmnt.setLayoutX(677);
    				btnDeleteCmntCmnt.setId("btnBoardDel");
    				btnDeleteCmntCmnt.setOnAction(event -> {
    					if(!fbCmntCmnt.getMem_id().equals(loginMem.getMem_id())) {
    						Stage popUpStage = new Stage();
    						
    						FXMLLoader loader = new FXMLLoader(MEMShowBoardDetailController.class.getResource("../fxml/BasicPopUp.fxml"));
    						
    						Parent basicPopUpChild;
    						try {
    							basicPopUpChild = loader.load();
    							BasicPopUpController basicPopUpController = loader.getController();
    							basicPopUpController.setAdminShowBoardDetailController(this);
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
    				btnRPTCmntCmnt.setLayoutX(723);
    				btnRPTCmntCmnt.setId("btnBoardDel");
    				
    				addCmntAnchorPane.getChildren().addAll(lblCmntCmnt, lblCmntCmntId, txtCmntCmntCont, lblCmntCmntDate, btnUpdateCmntCmnt, btnDeleteCmntCmnt, btnRPTCmntCmnt);
    				
    				vboxComment.getChildren().add(addCmntAnchorPane);
    				
    				layOutY = layOutY+ 23;
    				
    			} // 안쪽 for문
    		}// if문
    	}//밖깥쪽 for문 
    } // setCmnt 끝
}
