package controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import main.vo.MemberVO;
import main.vo.ScheduleVO;
import service.chat.ChatServiceImpl;
import service.chat.IChatService;

public class MEMShowLSNCalPopUpController {
	
	private IChatService chatService;
	private MemberVO session;
	private String targetUser;
	private int roomNum;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane mainFrame;

    @FXML
    private GridPane calGridPane;

    @FXML
    private Button btnSun;
    @FXML
    private Button btnMon;
    @FXML
    private Button btnTue;
    @FXML
    private Button btnWed;
    @FXML
    private Button btnThu;
    @FXML
    private Button btnFri;
    @FXML
    private Button btnSat;
    @FXML
    private Button btnCal1;
    @FXML
    private Button btnCal2;
    @FXML
    private Button btnCal3;
    @FXML
    private Button btnCal4;
    @FXML
    private Button btnCal5;
    @FXML
    private Button btnCal6;
    @FXML
    private Button btnCal7;
    @FXML
    private Button btnCal8;
    @FXML
    private Button btnCal9;
    @FXML
    private Button btnCal10;
    @FXML
    private Button btnCal11;
    @FXML
    private Button btnCal12;
    @FXML
    private Button btnCal13;
    @FXML
    private Button btnCal14;
    @FXML
    private Button btnCal15;
    @FXML
    private Button btnCal16;
    @FXML
    private Button btnCal17;
    @FXML
    private Button btnCal18;
    @FXML
    private Button btnCal19;
    @FXML
    private Button btnCal20;
    @FXML
    private Button btnCal21;
    @FXML
    private Button btnCal22;
    @FXML
    private Button btnCal23;
    @FXML
    private Button btnCal24;
    @FXML
    private Button btnCal25;
    @FXML
    private Button btnCal26;
    @FXML
    private Button btnCal27;
    @FXML
    private Button btnCal28;
    @FXML
    private Button btnCal29;
    @FXML
    private Button btnCal30;
    @FXML
    private Button btnCal31;
    @FXML
    private Button btnCal32;
    @FXML
    private Button btnCal33;
    @FXML
    private Button btnCal34;
    @FXML
    private Button btnCal35;
    @FXML
    private Button btnCal36;
    @FXML
    private Button btnCal37;
    @FXML
    private Button btnCal38;
    @FXML
    private Button btnCal39;
    @FXML
    private Button btnCal40;
    @FXML
    private Button btnCal41;
    @FXML
    private Button btnCal42;
    
    @FXML
    private Label lblCalYM;
    
    @FXML
    private Button btnCalBeforeMonth;
    
    @FXML
    private Button btnCalAfterMonth;
    
    @FXML
    private Label lblToday;
    
    @FXML
    private TextArea taSCH;
    
    @FXML
    private Button btnSave;
    
    @FXML
    private Button btnClear;
    
    @FXML
    private Label lblDate;
    
    @FXML
    private ImageView btnClose;

    @FXML
    private ImageView btnMin;
    
    private Button[] btnCals;
    
    private LocalDate calSTDDate;
    private LocalDate nowDate;
    private double xOffset, yOffset;
    
    private ScheduleVO selectedSCH;
    private int selectedDay;
    
    public void starter(MemberVO session, String targetUser, int roomNum) {
    	System.out.println("Start Schedule Starter");
    	this.session = session;
    	this.targetUser = targetUser;
    	this.roomNum = roomNum;
    	
    	calcCalDay();
    }
    
    /**
     *  @author 정재훈
     *  
     *  달력의 날짜값을 지우는 메서드
     *  
     */
    public void clearCal() {
    	for(Button btn : btnCals) {
    		btn.setText("");
    	}
    }
    
    /**
     * @author 정재훈
     * 
     * 달력의 날짜값을 현재 연/월 기준으로 재 할당하는 메서드
     * 
     */
    public void calcCalDay() {
    	
    	clearCal();
    	
    	
    	
    	lblCalYM.setText(calSTDDate.getYear() + "/" + calSTDDate.getMonthValue());
    	
    	LocalDate date = LocalDate.of(calSTDDate.getYear(), calSTDDate.getMonthValue(), 1);
    	
    	int startDay = date.getDayOfWeek().getValue();
    	int endDay = date.lengthOfMonth();
    	
    	int cnt = 0;
    	
    	for(int i=0; i<endDay; i++) {
    		btnCals[i+startDay].setText(++cnt + "");
    	}
    	calStyleSet();
    }
     
    public void calStyleSet() {
    	int toDay = nowDate.getDayOfMonth();
    	StringBuilder calcDate = new StringBuilder();
    	calcDate.append(calSTDDate.getYear());
    	calcDate.append(calSTDDate.getMonthValue()<10?"0"+calSTDDate.getMonthValue():calSTDDate.getMonthValue());
    	
    	System.out.println("이번달 : " + calcDate.toString());
    	
    	Map<String, String> params = new HashMap<>();
    	params.put("SCHE_DATE", calcDate.toString());
    	params.put("MEM_ID", session.getMem_id());
    	List<Integer> mySCHList = chatService.getMonthSCH(params);
    	
    	System.out.println("내 스케줄" + mySCHList);
    	
    	params.put("MEM_ID", targetUser);
    	List<Integer> targetSCHList = chatService.getMonthSCH(params);
    	System.out.println("상대방 스케줄" + targetSCHList);
    	
    	
    	for(Button btn : btnCals) {
    		btn.setStyle("-fx-background-color : #FFFFFF");
    		
    		// 해당 일에 상대방 스케줄이 있는지 체크하여 색상 변경
    		if(targetSCHList != null) {
    			for(int day : targetSCHList) {
    				try {
    					if(Integer.parseInt(btn.getText()) == day) {
    						btn.setStyle("-fx-background-color : #bfd0ff");
    					}
    				} catch (NumberFormatException e) {}
    			}
    		}
    		
    		// 해당 일에 내 스케줄이 있는지 / 양쪽 다 있는지 체크하여 색상 변경
    		if(mySCHList != null) {
    			for(int day : mySCHList) {
    				try {
    					if(Integer.parseInt(btn.getText()) == day) {
    						if(btn.getStyle().equals("-fx-background-color : #bfd0ff")) {
    							btn.setStyle("-fx-background-color : #ffa5c0");
    						} else {
    							btn.setStyle("-fx-background-color : #cda8ff");
    						}
    					}
    				} catch (NumberFormatException e) {}
    			}
    		}
    		
    		try {
	    		if(Integer.parseInt(btn.getText()) == toDay) {
	    			if(calSTDDate.getMonthValue() == nowDate.getMonthValue() && calSTDDate.getYear() == nowDate.getYear()) {
	    				//오늘 날짜 버튼 색상 변경
	    				btn.setStyle("-fx-background-color : #b7ffb8");
	    			}
	    		}
    		} catch (NumberFormatException e) {}
    	}
    }
    
    @FXML
    void btnCloseClick(MouseEvent event) {
    	Stage popUpStage = (Stage)btnClose.getScene().getWindow();
    	popUpStage.close();
    }

    @FXML
    void btnMinClick(MouseEvent event) {
    	Stage popUpStage = (Stage)btnMin.getScene().getWindow();
    	popUpStage.setIconified(true);
    }
    
    @FXML
    void btnCalAfterMonthClick(ActionEvent event) {
    	calSTDDate = calSTDDate.plusMonths(1);
    	calcCalDay();
    }

    @FXML
    void btnCalBeforeMonthClick(ActionEvent event) {
    	calSTDDate = calSTDDate.minusMonths(1);
    	calcCalDay();
    }
    
    @FXML
    void btnCalAfterYearClick(ActionEvent event) {
    	calSTDDate = calSTDDate.plusYears(1);
    	calcCalDay();
    }

    @FXML
    void btnCalBeforeYearClicl(ActionEvent event) {
    	calSTDDate = calSTDDate.minusYears(1);
    	calcCalDay();
    }

    @FXML
    void btnClearClick(ActionEvent event) {
    	taSCH.setText("");
    }

    @FXML
    void btnSaveClick(ActionEvent event) {
    	System.out.println(selectedDay);
    	if(selectedSCH != null) {
    		System.out.println(selectedSCH.getSche_date());
    		System.out.println(selectedSCH.getSche_cont());
    		Map<String, String> params = new HashMap<>();
    		
    		params.put("SCHE_NO", String.valueOf(selectedSCH.getSche_no()));
    		params.put("SCHE_CONT", taSCH.getText());
    		params.put("SCHE_CONT", taSCH.getText());
    		
    		if(chatService.updateSCHECont(params)>0) { System.out.println("스케줄 저장 성공");}
    		else {System.out.println("실패");}
    	} else {
    		if(selectedDay != 0) {
    			System.out.println("selected Day is not zero");
    			
    			StringBuilder yyyymmdd = new StringBuilder();
    			yyyymmdd.append(calSTDDate.getYear());
    			yyyymmdd.append(calSTDDate.getMonthValue()<10?"0"+calSTDDate.getMonthValue():calSTDDate);
    			yyyymmdd.append(selectedDay<10?"0"+selectedDay:selectedDay);
    			ScheduleVO params = new ScheduleVO();
    			
    			params.setMem_id(session.getMem_id());
    			params.setTarget_id(targetUser);
    			params.setSche_date(yyyymmdd.toString());
    			params.setSche_cont(taSCH.getText());
    			
    			System.out.println("User : " + session.getMem_id());
    			System.out.println("Target : " + targetUser);
    			System.out.println("Cont : " + taSCH.getText());
    			
    			if(chatService.insertSCHECont(params)>0) {System.out.println("스케줄 저장 성공");}
    			else { System.out.println("스케줄 저장 실패");}
    			
    		} else {
    			Alert alert = new Alert(AlertType.NONE);
    			alert.setHeaderText("선택한 날짜가 없습니다.");
    			alert.setContentText("선택한 날짜가 없습니다. \n날짜를 선택 해 주세요.");
    			alert.show();
    		}
    	}
    }
    
    @FXML
    void initialize() {
    	chatService = ChatServiceImpl.getInstance();
    	
    	btnCals = new Button[]{
	    	btnCal1, btnCal2, btnCal3, btnCal4, btnCal5, btnCal6, btnCal7, btnCal8, btnCal9,	
	    	btnCal10, btnCal11, btnCal12, btnCal13,	btnCal14, btnCal15, btnCal16, btnCal17, btnCal18, btnCal19,	
	    	btnCal20, btnCal21, btnCal22, btnCal23, btnCal24, btnCal25, btnCal26, btnCal27, btnCal28, btnCal29,
	    	btnCal30, btnCal31, btnCal32, btnCal33, btnCal34, btnCal35, btnCal36, btnCal37, btnCal38, btnCal39,
	    	btnCal40, btnCal41, btnCal42
    	};
    	
    	calSTDDate = LocalDate.now();
    	nowDate = LocalDate.now();
    	
    	lblToday.setText(calSTDDate.getYear() + " / " + calSTDDate.getMonthValue() + " / " + calSTDDate.getDayOfMonth());
    	lblDate.setText("");
    	lblCalYM.setText(calSTDDate.getYear() + "/" + calSTDDate.getMonthValue());
    
	    for(Button btn : btnCals) {
	    	btn.setOnMouseClicked(new EventHandler<Event>() {
	
				@Override
				public void handle(Event event) {
					String selDate = btn.getText();
					if(selDate.isEmpty()) {
						selectedDay = 0;
						return;
					}
					
					selectedDay = Integer.parseInt(selDate);
					lblDate.setText(calSTDDate.getYear() + " / " + calSTDDate.getMonthValue() + " / " + selDate);
					
					calStyleSet();
					btn.setStyle("-fx-background-color : #EFEC9B");
					
					StringBuilder calcDay = new StringBuilder();
					calcDay.append( calSTDDate.getYear() );
					calcDay.append( calSTDDate.getMonthValue()<10?"0"+calSTDDate.getMonthValue():calSTDDate.getMonthValue() );
					calcDay.append( selDate.length()==1?"0"+selDate:selDate );
					
					System.out.println("Search Sche : " + calcDay.toString());
					
					Map<String, String> params = new HashMap<>();
					params.put("MEM_ID", session.getMem_id());
					params.put("SCHE_DATE", calcDay.toString());
					
					selectedSCH = chatService.getDaySCH(params);
					
					if(selectedSCH != null) {
						taSCH.setText(selectedSCH.getSche_cont());
						System.out.println(selectedSCH.getSche_cont());
					} else {
						taSCH.setText("");
					}
					System.out.println(selectedDay);
				}
			});
	    }
	    
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
	      
	}
}
