package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.AudioFormat;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import com.ibm.watson.developer_cloud.text_to_speech.v1.util.WaveUtils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.vo.AdviceVO;

public class MEMShowADVDetailPopUpController {
	   private String USER_NAME = "f2ca0e6b-75f2-4b1c-8b42-b2cafe7e8f7d";
	   private String PASSWORD = "XSELj8h7gPIY";
	   
	   // TextToSpeech 서비스 객체 변수 선언
	   private TextToSpeech service;
	   
	   
	   // 서비스를 설정하는 메서드
	   public void setService() {
	      service = new TextToSpeech();
	      service.setUsernameAndPassword(USER_NAME, PASSWORD);
	   }
	   
	   // 서비스 헤더 설정 메서드 - 로그를 남길지 여부 설정한다.
	   public void setHeader() {
	      Map<String, String> headers = new HashMap<String, String>();
	      
	      headers.put("X-Watson-Learning-Opt-Out", "false");
	      
	      service.setDefaultHeaders(headers);
	   }
	   
	// 음성타입 검색하는 메서드
	   public void getVoice() {
	      ServiceCall<List<Voice>> serviceCall = service.getVoices();
	      
	      List<Voice> voiceList = serviceCall.execute();
	      
	      // 왓슨에서 제공하는 음성타입출력
	      for(Voice voice : voiceList) {
	         System.out.println(voice);
	      }
	   }
	   
	private AdviceVO adVo;
	public AdviceVO getAdVo() {
		return adVo;
	}

	public void setAdVo(AdviceVO adVo) {
		this.adVo = adVo;
		showContent();
	}
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane subFrameADVComment;

    @FXML
    private ImageView btnMin;

    @FXML
    private ImageView btnClose;

    @FXML
    private ScrollPane ScrollPane;

    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private Text taContent;
    
    private MediaPlayer mp;
  	private Media me;
   
  	@FXML
    private ImageView btnspeech;

    public void showContent() {
    	 taContent.setText(adVo.getAdv_cont());
		
	}

    @FXML
    void btnCloseClick(MouseEvent event) {
    	Stage thisStage = (Stage) btnClose.getScene().getWindow();
    	thisStage.close();
    }

    @FXML
    void btnMinClick(MouseEvent event) {
    	

    }
    
    @FXML
    void btnspeechClick(MouseEvent event) {
    	//TspeechController test = new TspeechController();
    	
   	 setService();
        setHeader();
        
    System.out.println(service);
      
       InputStream stream = service.synthesize(
     taContent.getText(), // 변경할 문자열
       	Voice.EN_LISA,  // voice 선택
       	AudioFormat.WAV  // 출력할 오디오 포멧 형식   
       ).execute();
    // 음성데이터를 저장하기
       try {
          InputStream in = WaveUtils.reWriteWaveHeader(stream);
          //WaveUtils.
          
          OutputStream os = new FileOutputStream("d:/d_other/AIData/test12.wav");
          
          byte[] tmp = new byte[1024];
          int len = 0;
          
          while((len = in.read(tmp)) != -1) {
             os.write(tmp, 0, len);
          }
          os.flush();
          
          os.close();
          in.close();
          stream.close();
          
       } catch (Exception e) {
          e.printStackTrace();
       }
      
   music();

    }
    
    public void music() {
		  //파일을 읽어다가 소리로 출력 
		         
		         String path = "d:/d_other/AIData/test12.wav";  
		         
		         //Instantiating Media class  
		         Media media = new Media(new File(path).toURI().toString());
		         
		           
		         //Instantiating MediaPlayer class   
		         MediaPlayer mediaPlayer = new MediaPlayer(media);  
		           
		         //by setting this property to true, the audio will be played   
	         mediaPlayer.setAutoPlay(true);  
}

    @FXML
    void initialize() {
    	
    	//폰트 경로 설정하기
    	Font.loadFont(getClass().getResourceAsStream("../z.source/GODOM.ttf"), 12);
    	
    }


}
