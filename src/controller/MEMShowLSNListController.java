package controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import main.common.ServerConnector;
import main.packet.FileRequestPacket;
import main.packet.ServerPath;
import main.vo.ChatVO;
import main.vo.MemFileVO;
import main.vo.MemberVO;
import service.chat.ChatServiceImpl;
import service.chat.IChatService;
import service.member.IMemberService;
import service.member.MemberServiceImpl;

public class MEMShowLSNListController {
	
	private IChatService chatService;
	private IMemberService memberService;
	
	private MemberVO session;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane popUpFrame;

    @FXML
    private AnchorPane sideFrame;

    @FXML
    private Label lblCate;

    @FXML
    private TextField tfSearch;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox vbox;
    @FXML
    private ImageView btnClose;

    @FXML
    private ImageView btnMin;

    @FXML
    void btnCloseClick(MouseEvent event) {
    	Stage stage = (Stage) popUpFrame.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void btnMinClick(MouseEvent event) {
    	((Stage)btnMin.getScene().getWindow()).setIconified(true);
    }
    private double xOffset, yOffset;
    
    public void starter(MemberVO session) {
    	System.out.println("Call Starter Method");
    	
    	System.out.println("Session Settings..");
    	this.session = session;
    	System.out.println("Session's Id = " + session.getMem_id());
    	
    	RefreshRoomList();
    	System.out.println("Finish Starter Method");
    }
    
    public void RefreshRoomList() {
    	try {
	    	System.out.println("Setting Room Information");
			
	    	List<ChatVO> roomList = chatService.getRoomList(session.getMem_id());
			
			// 각 방 컨트롤러들의 세팅값
			double paneW = 310, paneH = 75;
			double imgSize = 70, imgX = 15, imgY = 3;
			double lblNameX = 110, lblNameY = 19;
			double lblSDateX = 110, lblSDateY = 38;
			double lblLDateX = 110, lblLDateY = 54;
			
			System.out.println("Create Room List");
			
			int index = 0;
			for(ChatVO chatVo : roomList) {
				System.out.println("Pane");
				AnchorPane pane = new AnchorPane();
				pane.setMinSize(paneW, paneH);
				pane.setPrefSize(paneW, paneH);
				pane.setMaxSize(paneW, paneH);
				pane.setStyle("-fx-background-color:#FFFFFF");
				
				System.out.println("Image");
				ImageView img;
					img = new ImageView(new Image(MEMShowLSNListController.class.getResourceAsStream("../z.source/supermario48.png")));
					img.setFitWidth(imgSize);
					img.setFitHeight(imgSize);
					img.setX(imgX);
					img.setY(imgY);
				
				System.out.println("Name Label");
				Label lblName = new Label();
				lblName.setLayoutX(lblNameX);
				lblName.setLayoutY(lblNameY);
				lblName.setLabelFor(pane);
				
				System.out.println("Call ibatis - get targetUser");
				Map<String, String> params = new HashMap<>();
				params.put("MEM_ID", session.getMem_id());
				params.put("CHAT_ROOM_NO", chatVo.getChat_room_no()+"");
				
				MemberVO targetUser = chatService.getUserNameForChatNo(params);
				lblName.setText("With : " + targetUser.getMem_name());
				
				System.out.println("targetUser's Name & ID = " + targetUser.getMem_name() + " & " + targetUser.getMem_id());
				
				System.out.println("Start Date Label");
				Label lblSDate = new Label();
				lblSDate.setLayoutX(lblSDateX);
				lblSDate.setLayoutY(lblSDateY);
				lblSDate.setLabelFor(pane);
				lblSDate.setText("Start : " + chatVo.getChat_start_date());
	
				System.out.println("Last Date Label");
				Label lblLDate = new Label();
				lblLDate.setLayoutX(lblLDateX);
				lblLDate.setLayoutY(lblLDateY);
				lblLDate.setLabelFor(pane);
				lblLDate.setText("Last  : " + chatVo.getChat_end_date());
				
				System.out.println("Add Child to Pane");
				pane.getChildren().add(0, img);
				pane.getChildren().add(1, lblName);
				pane.getChildren().add(2, lblSDate);
				pane.getChildren().add(3, lblLDate);
				
				
				System.out.println("Set Pane's Event Handler");
				pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						try {
							for(Node n : vbox.getChildren()) {
								n.setStyle("-fx-background-color:#FFFFFF");
							}
							pane.setStyle("-fx-background-color:silver");
							if(event.getClickCount()>1) {
								Stage popUpStage = (Stage)pane.getScene().getWindow();
								
								FXMLLoader loader = new FXMLLoader(MEMShowLSNListController.class.getResource("../fxml/MEMShowLSNCHATPopUp.fxml"));
								AnchorPane root = loader.load();
								
								MEMShowLSNCHATPopUpController ctl = loader.getController();
								ctl.starter(session, targetUser.getMem_id(), targetUser.getMem_name(), chatVo.getChat_room_no(), img.getImage());
								
								Scene scene = new Scene(root);
								popUpStage.setScene(scene);
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				});
				vbox.getChildren().add(index++, pane);
				
				// 프로필사진 검색
		    	System.out.println("Call ibatis to Member File VO");
		    	Object temp = memberService.getMemberFile(targetUser.getMem_id());
		    	if(temp != null) {
		    		System.out.println("ibatis's result is not null");
		    		MemFileVO memFileVo = (MemFileVO)temp;
		    		
		    		System.out.println("file searching . . .");
		    		File file = new File(ServerPath.MEM_PROF.getPath() + "client/" + memFileVo.getMem_prof_img_sname());
		    		if(file.isFile()){
		    			System.out.println("found file!");
		    			img.setImage(new Image(new FileInputStream(file)));
			    	} else {
			    		
			    		System.out.println("Not found file");
			    		
			    		FileRequestPacket fileRequestPacket = new FileRequestPacket(
			    				targetUser.getMem_id(), null, ServerPath.MEM_PROF,
			    				memFileVo.getMem_prof_img_name(), memFileVo.getMem_prof_img_sname(), memFileVo.getMem_prof_img_size(), memFileVo.getMem_prof_img_date());
			    		
			    		new ServerConnector().fileRequest(fileRequestPacket, file);
			    		
//			    		System.out.println("Socket(8887) Connecting . . .");
//			    		Socket socket = new Socket("192.168.203.33", 8887);
//			    		
//			    		
//			    		System.out.println("Oos Connecting . . .");
//			    		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
//			    		
//			    		System.out.println("Oos Flushing . . .");
//			    		oos.flush();
//			    		
//			    		System.out.println("Ois Connecting . . .");
//			    		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
//			    		
//			    		System.out.println("File Request Packet Transfer ready . . .");
//			    		FileRequestPacket frPacket = new FileRequestPacket(
//			    				targetUser.getMem_id(), null, ServerPath.MEM_PROF,
//			    				memFileVo.getMem_prof_img_name(), memFileVo.getMem_prof_img_sname(), memFileVo.getMem_prof_img_size(), memFileVo.getMem_prof_img_date());
//			    		
//			    		
//			    		System.out.println("Packet Transfer . . .");
//			    		oos.writeObject(frPacket);
//			    		oos.flush();
//			    		
//			    		System.out.println("Finish Transfer");
//			    		
//			    		
//			    		System.out.println("Make Buffer");
//			    		byte[] buf = new byte[16384];
//						
//			    		System.out.println("Connecting Stream");
//						FileOutputStream fos = new FileOutputStream(file);
//						DataInputStream dis = new DataInputStream(socket.getInputStream());
//						int i = 0;
//						while(( i = dis.read(buf) ) != -1) {
//							fos.write(buf, 0, i);
//							
//							if( i < buf.length ) break;
//						}
//						
//						System.out.println("Finish File Receiving . . . ");
//						
//						dis.close();
//						fos.close();
//						ois.close();
//						oos.close();
//						socket.close();
//						System.out.println("Socket / Stream Close");
			    		
						
						img.setImage(new Image(new FileInputStream(file)));
						System.out.println("User Image Setting");
			    	}
		    	}
			}
    	} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
	void initialize() {
    	//CSS 폰트 설정하기
    	Font.loadFont(getClass().getResourceAsStream("../z.source/GODOM.ttf"), 12);
		
    	System.out.println("Start Initialize");
		chatService = ChatServiceImpl.getInstance();
		memberService = MemberServiceImpl.getInstance();
		
		System.out.println("Set popUpFrams's EventHandler . . .");
		popUpFrame.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				xOffset = event.getSceneX();
				yOffset = event.getSceneY();
			}
		});

		popUpFrame.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Stage primaryStage = (Stage) popUpFrame.getScene().getWindow();
				primaryStage.setX(event.getScreenX() - xOffset);
				primaryStage.setY(event.getScreenY() - yOffset);
			}
		});
		
		
		System.out.println("Finish Initializer");
	}
}
