package controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.vo.ChatContVO;
import main.vo.MemberVO;
import service.chat.ChatServiceImpl;
import service.chat.IChatService;
import service.code.CodeServiceImpl;
import service.code.ICodeService;
import main.common.ServerConnector;
import main.packet.*;
/**
 * 
 * @author JeongJaeHoon
 * 
 * !! 로드시 Setter를 통한 roomNum, session, destinationId 세팅 필수 
 * 
 * socket : 서버와 연결된 소켓
 * oos, ois : 서버와 연결된 객체 입/출력 스트림
 * roomNum : 현재 방번호(roon_no - pk)
 * session : 메인 클래스에 정적 변수로 저장되어 있는 현재 로그인 정보 MemberVO 객체
 * destinationId : 현재 클래스에 인스턴스 변수로 저장되어 있는 채팅 상대 아이디
 *
 */
public class MEMShowLSNCHATPopUpController {
    
    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    
    // Starter()에서 세팅
    private MemberVO session;
    private String destinationId;
    private String destinationName;
    private int roomNum;
    private Image userImg;
    
    private IChatService chatService;
    private ICodeService codeService;
    
    public MemberVO getSession() {
		return session;
	}

	public void setSession(MemberVO session) {
		this.session = session;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	
	public String getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(String destinationId) {
		this.destinationId = destinationId;
	}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane mainFrame;
    private double xOffset=0;
    private double yOffset=0;

    @FXML
    private TextArea taChat;

    @FXML
    private TextArea taCode;

    @FXML
    private TextArea taResult;

    @FXML
    private TextField tfChat;

    @FXML
    private ImageView btnClose;

    @FXML
    private ImageView btnMin;

    @FXML
    private ImageView btnBack;

    @FXML
    private ImageView imgUser;

    @FXML
    private Label lblUserName;

    @FXML
    private Button btnCodeRun;

    @FXML
    private ComboBox<String> comboCodeLang;

    @FXML
    private ImageView imgSCH;

    @FXML
    private ImageView imgFileAdd;

    @FXML
    private ImageView imgFileList;

    @FXML
    private ImageView imgRPT;

    @FXML
    private ImageView imgBack;

    /**
     * 	CSS용 아이디
     *////////////////////////////////////////////////////////
    @FXML
    private Label lblConsole;

    @FXML
    private Label lblChat;

    @FXML
    private Label lblEditor;
    
    //////////////////////////////////////////////////////////
    public void closing() {
    	try {
    		oos.writeObject(new LogOutPacket(session.getMem_id()));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {if(ois != null)ois.close();}catch(IOException ee) {}
			try {if(oos != null)oos.close();}catch(IOException ee) {}
			try {if(socket != null)socket.close();}catch(IOException ee) {}
			saver();
			((Stage)(mainFrame.getScene().getWindow())).close();
		}
    }
    
    public void saver() {
    	Map<String, String> params = new HashMap<>();
    	
    	params.put("CHAT", taChat.getText());
    	params.put("CODE", taCode.getText());
    	params.put("CHAT_ROOM_NO", roomNum + "");
    	
    	chatService.saveData(params);
    }
    
    @FXML
    void btnBackClick(MouseEvent event) {
    	closing();
    	try {
    		
			FXMLLoader loader = new FXMLLoader(MEMShowLSNCHATPopUpController.class.getResource("MEMShowLSNList.fxml"));
			
			AnchorPane root = loader.load();
			
			MEMShowLSNListController ctl = loader.getController();
			
			ctl.starter(session);
			Stage popUpStage = (Stage)btnBack.getScene().getWindow();
			
			Scene scene = new Scene(root);
			
			popUpStage.setScene(scene);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }

    @FXML
    void btnCloseClick(MouseEvent event) {
    	closing();
    	((Stage)btnClose.getScene().getWindow()).close();
    }
   
    @FXML
    void btnCodeRunClick(ActionEvent event) {
    	String msg = taCode.getText();
    	String codeType = comboCodeLang.getSelectionModel().getSelectedItem();
    	CodeRunPacket runPacket = new CodeRunPacket(session.getMem_id(), destinationId, msg, roomNum, codeType);
    	
    	try {
			oos.writeObject(runPacket);
			oos.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    


    @FXML
    void btnMinClick(MouseEvent event) {
    	((Stage)btnMin.getScene().getWindow()).setIconified(true);
    }

    @FXML
    void imgBackClick(MouseEvent event) {
    	System.out.println("Back Clicked");
    }

    @FXML
    void imgFileAddClick(MouseEvent event) {
    	
    	System.out.println("file add clicked");
    	
    	FileChooser fileChooser = new FileChooser();
    	File file = fileChooser.showOpenDialog(((Stage)imgFileAdd.getScene().getWindow()));
    	System.out.println("File Selected");
    	
    	FilePacket filePacket = new FilePacket(session.getMem_id(), session.getMem_name(), destinationId, file.getName(), roomNum, file.length());
    	
    	try {
			new ServerConnector().fileTransfer(filePacket, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
//    	try {
//    		Socket socket = new Socket("192.168.203.33", 8887);
//    		
//    		ObjectOutputStream fOos = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
//    		fOos.flush();
//    		
//    		ObjectInputStream fOis = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
//    		
//    		// 파일 전송 시작을 알리는 패킷 전송
//    		fOos.writeObject(new FilePacket(session.getMem_id(), session.getMem_name(), destinationId, file.getName(), roomNum, file.length()));
//    		System.out.println(session.getMem_id());
//    		System.out.println(session.getMem_name());
//    		System.out.println(session.getMem_pw());
//    		fOos.flush();
//    		System.out.println("File Packet Transfer");
//    		
//    		System.out.println("Make Buffer");
//    		byte[] buf = new byte[(int)file.length()];
//    		System.out.println(buf.length);
//    		
//    		System.out.println("Make new Socket(8887)");
//
//    		System.out.println("Make I/O Stream");
//    		
//    		FileInputStream fis = new FileInputStream(file);
//    		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
//    		
//    		System.out.print("전송중");
//    		int i = 0;
//    		int cnt = 0;
//    		while((i = fis.read(buf)) != -1) {
//    			dos.write(buf);
//    			System.out.println("flush " + cnt++);
//    		}
//			dos.flush();
//			System.out.println("파일 전송 완료");
//			
//			fis.close();
//			dos.close();
//			System.out.println("File Input Stream Closed");
//			String msg = ("\n※※" + session.getMem_name() + "님께서 " + file.getName() + " 파일을 보내셨습니다.  ※※\n");
//			oos.writeObject(new ChatPacket(session.getMem_id(), destinationId, msg, roomNum));
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
    }

    @FXML
    void imgFileListClick(MouseEvent event) {
    	
    	try {
    		System.out.println("file list clicked");
    		FXMLLoader loader = new FXMLLoader(MEMShowLSNCHATPopUpController.class.getResource("../fxml/MEMShowLSNFileList.fxml"));
			Parent root = loader.load();
			
			MEMShowLSNFileListController ctl = loader.getController();
			
			ctl.starter(roomNum);
			
			Stage popUpStage = new Stage();
			
			Scene scene = new Scene(root);
			popUpStage.initStyle(StageStyle.UNDECORATED);
			popUpStage.setScene(scene);
			
			popUpStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	
    }

    @FXML
    void imgRPTClick(MouseEvent event) {
    	System.out.println("RPT clicked");
    }

    @FXML
    void imgSCHClick(MouseEvent event) {
    	
    	try {
    		System.out.println("SCH clicked");
    		FXMLLoader loader = new FXMLLoader(MEMShowLSNCHATPopUpController.class.getResource("../fxml/MEMShowLSNCalPopUp.fxml"));
			Parent root = loader.load();
			
			MEMShowLSNCalPopUpController ctl = loader.getController();
			
			ctl.starter(session, destinationId, roomNum);
			
			Stage calStage = new Stage();
			
			calStage.setScene(new Scene(root));
			calStage.initStyle(StageStyle.UNDECORATED);
			calStage.setTitle("DLDL 채팅창 달력");
			calStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void taCodeAltEnterPress(KeyEvent event) {
    	if(event.isAltDown() && event.getCode() == KeyCode.ENTER) {
    		 
    		String msg = taCode.getText();
    		CodePacket codePacket = new CodePacket(session.getMem_id(), destinationId, msg, roomNum);
    		
    		codePacket.setMsg(msg);
    		codePacket.setRoomNum(roomNum);
    		try {
				oos.writeObject((Packet)codePacket);
				oos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
    		
    	}
    }

    @FXML
    void tfChatEnterPress(KeyEvent event) {
    	if(!(event.getCode() == KeyCode.ENTER)) return;
    	if(tfChat.getText().isEmpty()) return;
    	
    	String msg = tfChat.getText();
    	ChatPacket chatPacket = new ChatPacket(session.getMem_id(), destinationId, msg, roomNum);
    	tfChat.clear();
    	
    	// 홍길동 >> 내용 형식으로 변경
    	chatPacket.setMsg(session.getMem_name() + "\n  >>  " + msg + "\n");
    	chatPacket.setRoomNum(getRoomNum());
    	
    	try {
			oos.writeObject((Packet)chatPacket);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public void starter(MemberVO session, String destinationId, String destinationName, int roomNum, Image userImg) {
    	System.out.println("Starter Method start");
//  -----------------------------------------------초기값 세팅--------------------------------------------------
    	System.out.println("Setting - session");
		this.session = session;
		
		System.out.println("Setting - destination Info");
		this.destinationId = destinationId;
		this.destinationName = destinationName;
		this.userImg = userImg;
		imgUser.setImage(userImg);
		
		System.out.println("Setting room Info");
		this.roomNum = roomNum;
		
//		lblUserName = memberService.getMemName(destinationId);
		
//		popUpStage = (Stage)mainFrame.getScene().getWindow();
		
//  -----------------------------------------------서버 커넥팅--------------------------------------------------
//  -----------------------------------------창 켜자마자 수행되어야 할 부분-----------------------------------------
//  --------------------------------------------------------------------------------------------------------
    	// 소켓 객체와 그를 통한 입/출력 스트림 객체 생성
    	try {
    		socket = new Socket("192.168.203.33", 8888);
    		System.out.println("Ctrl --- Server Connected");
    		OutputStream os = socket.getOutputStream();
    		oos = new ObjectOutputStream(new BufferedOutputStream(os));
    		oos.flush();
    		System.out.println("Ctrl --- OutputStream Connected");
    		
    		InputStream is = socket.getInputStream();
    		ois = new ObjectInputStream(new BufferedInputStream(is));
    		System.out.println("Ctrl --- InputStream Connected");
    		
    		LogInPacket logInPacket = new LogInPacket(session.getMem_id(), destinationId, roomNum);
    		oos.writeObject(logInPacket);
    		oos.flush();
    		System.out.println(logInPacket.getForwardId());
    		System.out.println("Ctrl --- Send LogInPacket Success");
//   -------------------------------------------------------------------------------------------------------
    		
    		
    		
//    	-----------------------------------------------채팅방 접속 시------------------------------------------------
//  --------------------------------------------------------------------------------------------------------
    		// 채팅 패킷을 받아줄 데몬 쓰레드 생성
    		System.out.println("Ctrl --- Make Receive Thread");
    		Thread receiveThread = new ChatReceiver(socket, ois);
    		receiveThread.setDaemon(true);
    		receiveThread.start();
    		System.out.println("Ctrl --- Finished Starter Method");
//  --------------------------------------------------------------------------------------------------------
    		
//    	-----------------------------------------------채팅방 세팅------------------------------------------------
//  --------------------------------------------------------------------------------------------------------
    		ChatContVO roomCont = null;
    		if((roomCont = chatService.getRoomInfo(roomNum))==null) {
    			System.out.println("방 정보를 찾을 수 없습니다.");
    			return;
    		}
        	
        	if(roomCont.getChat_cont() != null) {
        		taChat.setText(roomCont.getChat_cont());
        	} else {
        		System.out.println(roomCont.getCode_cont());
        		System.out.println(roomCont.getChat_cont());
        	}
        	
        	if(roomCont.getCode_cont() != null || !roomCont.getCode_cont().isEmpty()) {
        		taCode.setText(roomCont.getCode_cont());
        	} else {
        		System.out.println(roomCont.getCode_cont());
        		System.out.println(roomCont.getChat_cont());
        	}
        	
        	lblUserName.setText(destinationName);
        	
        	taChat.appendText("");
    		
    	} catch (IOException e) {	// Server closed / I/O Stream Exception
    		e.printStackTrace();
    	}
    }

    @FXML
    void initialize() {
    	//CSS 폰트 경로 설정하기
        Font.loadFont(getClass().getResourceAsStream("../z.source/GODOM.ttf"), 12);
        
        
        //////////////////////////////////////////////////////////////////////////
        
        //창 움직이기 
        
        mainFrame.setOnMousePressed(new EventHandler<MouseEvent>() {
	         @Override
	         public void handle(MouseEvent event) {
	            xOffset = event.getSceneX(); 
	            yOffset = event.getSceneY(); 
	         }
	     });
	    
	    mainFrame.setOnMouseDragged(new EventHandler<MouseEvent>() { 
	         @Override 
	         public void handle(MouseEvent event) { 
	               Stage primaryStage = (Stage)mainFrame.getScene().getWindow();
	             primaryStage.setX(event.getScreenX() - xOffset); 
	             primaryStage.setY(event.getScreenY() - yOffset); 
	         } 
	    });
        
	    ////////////////////////////////////////////////////////////////////////////
	    
    	chatService = ChatServiceImpl.getInstance();
    	codeService = CodeServiceImpl.getInstance();
    	
    	String javaBasicCode =	  "public class HelloWorld{\n"
								+ "	public static void main(String[] Args){\n"
								+ "		\n"
								+ "		System.out.println(\"Hello java World!\");\n"
								+ "		\n"
								+ "	}\n"
								+ "}\n";
    	
    	String cppBasicCode =	  "#include <iostream>\n"
								+ "using namespace std;\n"
								+ "int main()\n"
								+ "{\n"
								+ "	cout << \"Hello c++ World!\"\n"
								+ "	return 0\n"
								+ "}\n"
								+ "";
    	
    	String pythonBasicCode =  "\n"
								+ "print('Hello python World!')\n"
								+ "";
    	
		System.out.println("Ctrl --- javaFx initialize");
		
		taCode.setText(javaBasicCode);
		
		ObservableList<String> langList = FXCollections.observableArrayList();
		langList.addAll("java", "c++", "python");
		comboCodeLang.setValue("java");
		comboCodeLang.getItems().addAll(langList);
		
		comboCodeLang.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if(comboCodeLang.getSelectionModel().getSelectedItem().equals("java")) {
					if(taCode.getText().isEmpty()
							||taCode.getText().equals(cppBasicCode)
							||taCode.getText().equals(pythonBasicCode)) {
						taCode.setText(javaBasicCode);
					}
				} else if(comboCodeLang.getSelectionModel().getSelectedItem().equals("c++")) {
					if(taCode.getText().isEmpty()
							||taCode.getText().equals(javaBasicCode)
							||taCode.getText().equals(pythonBasicCode)) {
						taCode.setText(cppBasicCode);
					}
				} else if(comboCodeLang.getSelectionModel().getSelectedItem().equals("python")) {
					if(taCode.getText().isEmpty()
							||taCode.getText().equals(javaBasicCode)
							||taCode.getText().equals(cppBasicCode)) {
						taCode.setText(pythonBasicCode);
					}
				}
			}
		});
		
		System.out.println("initialize finished");
    }
    class ChatReceiver extends Thread{
    	
    	private Socket socket;
    	private ObjectInputStream ois;
    	
    	public ChatReceiver(Socket socket, ObjectInputStream ois) throws IOException {
    		this.ois = ois;
    		
    		System.out.println("Ctrl --- start ChatReceiver constructor");
    		
    		this.socket = socket;
    		System.out.println("Ctrl --- Socket Field");
    	}
    	
    	@Override
    	public void run() {
    		try {
    			while(!socket.isClosed()) {
    				try {
    					
    					System.out.println("Ctrl --- Chat Receiver run");
    					// 채팅 패킷을 받으면
    					Packet packet = (Packet)ois.readObject();
    					
    					if (packet == null) continue;
    					if (packet.getPurpose() == Purpose.CHAT) {							// 채팅 패킷
//    					형변환 하고
    						ChatPacket chatPacket = (ChatPacket)packet;
    						
    						String msg = chatPacket.getMsg() + "\n";
    						
    						System.out.println(msg);
    						
//				 	Platform.runLater 메서드를 이용하여 FX객체의 값을 변경한다.
    						Platform.runLater(new Runnable() {
    							@Override
    							public void run() {
//								채팅창에 받은 채팅 패킷의 내용을 추가한다.
    								taChat.appendText(msg);
    							}
    						});
    					} else if (packet.getPurpose() == Purpose.CHAT_FAIL){					// 채팅 실패 패킷
    						saver();
    						
    					} else if (packet.getPurpose() == Purpose.CODE) {						// 코드 패킷
    						CodePacket codePacket = (CodePacket)packet;
    						
    						String msg = codePacket.getMsg();
    						
    						System.out.println("msg");
    						
    						Platform.runLater(new Runnable() {
    							@Override
    							public void run() {
    								taCode.setText(msg);
    							}
    						});
    					} else if (packet.getPurpose() == Purpose.CODE_FAIL) {					// 코드 실패 패킷
    						saver();
    						
    					} else if (packet.getPurpose() == Purpose.CODE_RESULT) {				// 코드 결과 패킷
    						CodeResultPacket crPacket = (CodeResultPacket)packet;
    						
    						taResult.setText(crPacket.getResultMsg());
    					}
    					
    				} catch (ClassNotFoundException|IOException e) {
    					closing();
    				}
    			}
			} catch (Exception e) {
			} finally {
				try {socket.close();}catch(Exception e) {}
				try {oos.close();}catch(Exception e) {}
				try {ois.close();}catch(Exception e) {}
			}
    	}
    }
}
