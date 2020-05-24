package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.Anchor;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import main.common.ServerConnector;
import main.packet.FileRequestPacket;
import main.packet.ServerPath;
import main.vo.MemFileVO;
import main.vo.MemberVO;
import main.vo.MessageMemNameVO;
import service.member.IMemberService;
import service.member.MemberServiceImpl;
import service.message.IMessageService;
import service.message.MessageServiceImpl;

public class MEMShowMSGPopUpController {
	
	private IMessageService msgService;
	private IMemberService memberService;
	
	private MEMShowMainController memShowMainController;
	
    public MEMShowMainController getMemShowMainController() {
		return memShowMainController;
	}

	public void setMemShowMainController(MEMShowMainController memShowMainController) {
		this.memShowMainController = memShowMainController;
	}

	@FXML
    private ResourceBundle resources;
	
	@FXML
    private ImageView btnSend;


    @FXML
    private URL location;

    @FXML
    private AnchorPane msgFrame;
    
    @FXML
    private VBox vbox;

    @FXML
    private ImageView btnMin;

    @FXML
    private ImageView btnClose;

    @FXML
    private Label MSGTitle;

    @FXML
    private ImageView image1;

    @FXML
    private Label name1;

    @FXML
    private TextFlow taMSG1;

    @FXML
    private Text text1;

    @FXML
    private ImageView image2;

    @FXML
    private Label name2;

    @FXML
    private TextFlow taMSG2;

    @FXML
    private Text text2;

    @FXML
    private ImageView image3;

    @FXML
    private Label name3;

    @FXML
    private TextFlow taMSG3;

    @FXML
    private Text text3;

    @FXML
    private ImageView image4;

    @FXML
    private Label name4;

    @FXML
    private TextFlow taMSG4;

    @FXML
    private Text text4;

    @FXML
    private ImageView image5;

    @FXML
    private Label name5;

    @FXML
    private TextFlow taMSG5;

    @FXML
    private Text text5;

    @FXML
    private ImageView image6;

    @FXML
    private Label name6;

    @FXML
    private TextFlow taMSG6;

    @FXML
    private Text text6;

    @FXML
    private Pagination pageMSG;

    private MemberVO session;    
    
    @FXML
    void btnMinClick(MouseEvent event) {
    	((Stage)btnMin.getScene().getWindow()).setIconified(true);
    }
    
    @FXML
    void btnCloseClcik(MouseEvent event) {
    	Stage memShowMainStage = (Stage)msgFrame.getScene().getWindow();
		memShowMainStage.close();
    }
    
    @FXML
    void taMSG1Click(MouseEvent event) {

    }

    @FXML
    void taMSG2Click(MouseEvent event) {

    }

    @FXML
    void taMSG3Click(MouseEvent event) {

    }

    @FXML
    void taMSG4Click(MouseEvent event) {

    }

    @FXML
    void taMSG5Click(MouseEvent event) {

    }

    @FXML
    void taMSG6Click(MouseEvent event) {

    }
    
    @FXML
    void btnSendClick(MouseEvent event) {

    }
    
    
    
    
    private double xOffset, yOffset;
    
    private Label[] names;
    private ImageView[] images;
    private TextFlow[] taMSGs;
    private Text[] texts;
    private ObservableList<MessageMemNameVO> msgList;
    
    private final int rowsPerPage = 6;
    
    public void setPageCount() {
    	
    	int pageCount = (int)Math.ceil(msgList.size()/rowsPerPage);
    	pageMSG.setPageCount(pageCount);
    	
    	changeMSGView(0);
    	
    	
    }
    
    public void changeMSGView(int index) {
    	int fromIndex = index * rowsPerPage;
    	int toIndex = Math.min(fromIndex + rowsPerPage, msgList.size());
    	
    	for(int i=0; i<6; i++) {
    		names[i].setText("");
    		images[i].setImage(null);
    		texts[i].setText("");
    	}
    	
    	int cnt = 0;
    	for(MessageMemNameVO msgVo : FXCollections.observableArrayList(msgList.subList(fromIndex, toIndex))) {
    		names[cnt].setText(msgVo.getMem_name());
    		texts[cnt].setText(msgVo.getMsg_cont());
    		
    		MemFileVO memFileVo = memberService.getMemberFile(msgVo.getMem_id());

    		try {
    		
    		if(memFileVo == null) {
    			images[cnt].setImage(new Image(MEMShowLSNListController.class.getResourceAsStream("../z.source/supermario48.png")));
    			return;
    		}
    		
    		File file = new File(ServerPath.MEM_PROF.getPath() + "client/" + memFileVo.getMem_prof_img_name());
    		
	    		if(file.isFile()) {
						images[cnt].setImage(new Image(new FileInputStream(file)));
	    		} else {
	    			FileRequestPacket fileRequestPacket = new FileRequestPacket(
	    					session.getMem_id(), 
	    					"server",
	    					ServerPath.MEM_PROF, 
	    					memFileVo.getMem_prof_img_name(), 
	    					memFileVo.getMem_prof_img_sname(), 
	    					memFileVo.getMem_prof_img_size(),
	    					memFileVo.getMem_prof_img_date()
	    					);
	    			
	    			ServerConnector.fileRequest(fileRequestPacket, file);
	    			images[cnt].setImage(new Image(new FileInputStream(file)));
	    			try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
	    		}
    		} catch (IOException e) {
    			e.printStackTrace();
    			images[cnt].setImage(new Image(MEMShowLSNListController.class.getResourceAsStream("../z.source/supermario48.png")));
    		}
    	}
    }

    @FXML
    void initialize() {
    	
    	//폰트 경로 설정하기
    	Font.loadFont(getClass().getResourceAsStream("../z.source/GODOM.ttf"), 14);
    	Font.loadFont(getClass().getResourceAsStream("../z.source/Cafe24Shiningstar.ttf"), 14);
    	Font.loadFont(getClass().getResourceAsStream("../z.source/tvN 즐거운이야기 Medium.ttf"), 14);
    	Font.loadFont(getClass().getResourceAsStream("../z.source/GODOROUNDED L.ttf"), 14);
    	Font.loadFont(getClass().getResourceAsStream("../z.source/netmarbleB.ttf"), 14);
    	
    	names = new Label[] {name1, name2, name3, name4, name5, name6};
    	images = new ImageView[] {image1, image2, image3, image4, image5, image6};
    	taMSGs = new TextFlow[] {taMSG1, taMSG2, taMSG3, taMSG4, taMSG5, taMSG6};
    	texts = new Text[] {text1, text2, text3, text4, text5, text6};
    	
    	msgService = MessageServiceImpl.getInstance();
    	memberService = MemberServiceImpl.getInstance();
    	
    	session = LoginController.getSession();
    	
    	msgList = FXCollections.observableArrayList(msgService.getAllMSGList(session.getMem_id()));
    	if(msgList == null || msgList.size() == 0) {
    		vbox.getChildren().clear();
    		try {
    		AnchorPane subFrame = FXMLLoader.load(MEMShowMSGPopUpController.class.getResource("../fxml/MEMShowMSGPopUpNoMSG.fxml"));
    		vbox.getChildren().add(subFrame);
    		} catch(Exception e) {}
    	} else { 
    		setPageCount();
    	}
    	
    	
    	
    	//창을 움직이도록 하기
        msgFrame.setOnMousePressed(new EventHandler<MouseEvent>() {
             @Override
             public void handle(MouseEvent event) {
                xOffset = event.getSceneX(); 
                yOffset = event.getSceneY(); 
             }
         });
        
        msgFrame.setOnMouseDragged(new EventHandler<MouseEvent>() { 
             @Override 
             public void handle(MouseEvent event) { 
                   Stage primaryStage = (Stage)msgFrame.getScene().getWindow();
                 primaryStage.setX(event.getScreenX() - xOffset); 
                 primaryStage.setY(event.getScreenY() - yOffset); 
             } 
        });
    	
    }
}




