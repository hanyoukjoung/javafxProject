package controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import main.common.ServerConnector;
import main.packet.FileRequestPacket;
import main.packet.ServerPath;
import main.vo.ChatFileVO;
import service.chat.ChatServiceImpl;
import service.chat.IChatService;

public class MEMShowLSNFileListController {
	
	private IChatService chatService;
	private int roomNum;
	
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane popUpFrame;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox vbox;
    
    public void starter(int roomNum) {
    	
    	List<ChatFileVO> fileList = chatService.getFileList(roomNum);
    	
    	for(ChatFileVO cfVo : fileList) {
    		
    		AnchorPane filePane = new AnchorPane();
    		filePane.setPrefSize(385, 120);
    		
    		ImageView img = new ImageView(new Image(MEMShowLSNListController.class.getResourceAsStream("../z.source/folderList.png")));
    		img.setFitHeight(90);
    		img.setFitWidth(90);
    		img.setX(48);
    		img.setY(26);
    		
    		Label lblDate = new Label(cfVo.getChat_file_date());
    		lblDate.setLayoutX(140);
    		lblDate.setLayoutY(33);
    		
    		Label lblFileName = new Label(cfVo.getChat_file_name());
    		lblFileName.setLayoutX(140);
    		lblFileName.setLayoutY(59);
    		
    		Label lblSave = new Label("저장");
    		lblSave.setLayoutX(140);
    		lblSave.setLayoutY(91);
    		
    		lblSave.setOnMouseClicked(new EventHandler<Event>() {
    			
    			@Override
    			public void handle(Event event) {
    				try {
    					StringBuilder sb = new StringBuilder();
    					sb.append(ServerPath.CHAT_FILE.getPath());
    					sb.append(cfVo.getChat_file_name());
    					
    					File file = new File(sb.toString());
    					
    					FileRequestPacket filePacket = new FileRequestPacket(LoginController.getSession().getMem_id(), "server", ServerPath.CHAT_FILE, cfVo.getChat_file_name(), cfVo.getChat_file_sname(), Long.parseLong(cfVo.getChat_file_size()), cfVo.getChat_file_date());
    					
    					new ServerConnector().fileRequest(filePacket, file);
    					
//    					if(file.isFile()) return;
//    					
//    					Socket socket = new Socket("192.168.203.33", 8887);
//    					ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
//    					oos.flush();
//    					
//    					ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
//    					
//    					
//    					oos.writeObject(frPacket);
//    					oos.flush();
//    					
//    					byte[] buf = new byte[(int)frPacket.getFile_size()];
//    					
//    					InputStream is = socket.getInputStream();
//    					FileOutputStream fos = new FileOutputStream(file);
//    					
//    					int i=0;
//    					while(( i = is.read(buf) ) != -1 ) {
//    						fos.write(buf);
//    					}
//    					fos.flush();
//    					socket.close();
//    					
//    					System.out.println("File Receive Successfully");
    				} catch (Exception e) {
    					e.printStackTrace();
    				}
    			}
			});
    		
    		
    		Label lblAsSave = new Label("다른 이름으로 저장");
    		lblAsSave.setLayoutX(191);
    		lblAsSave.setLayoutY(91);
    		
    		
    		filePane.getChildren().add(0, img);
    		filePane.getChildren().add(1, lblDate);
    		filePane.getChildren().add(2, lblFileName);
    		filePane.getChildren().add(3, lblSave);
    		filePane.getChildren().add(4, lblAsSave);
    		
    		vbox.getChildren().add(filePane);
    		
    	}
    }
    
    @FXML
    void initialize() {
    	chatService = ChatServiceImpl.getInstance();
    	
    }
}




