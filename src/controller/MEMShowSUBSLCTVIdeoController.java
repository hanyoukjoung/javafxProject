package controller;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MEMShowSUBSLCTVIdeoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane frameVideo;
    
    @FXML
    private MediaView mediaView;

    @FXML
    private Slider slider;

    @FXML
    private ImageView btnpre;

    @FXML
    private ImageView btnplay;

    @FXML
    private ImageView btnnext;
    
    @FXML
    private ImageView btnadv;
    
    @FXML
    private Label lblComment;
    
    @FXML
    private Label lblCmnt;


    @FXML
    private ScrollPane scrollcomment;
    
    @FXML
    private AnchorPane AnchorComment;

    @FXML
    private TextField tfComment;

    @FXML
    private Button btnclose;
    
   private Stage primaryStage;
   
   public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
   

    @FXML
    void btnadvClick(ActionEvent event) {
    try {
		Stage btnadvStage = new Stage(StageStyle.DECORATED);
		btnadvStage.initModality(Modality.APPLICATION_MODAL);
		btnadvStage.initOwner(primaryStage);
		
		FXMLLoader loader = new FXMLLoader(
		MEMShowSUBSLCTVIdeoController.class.getResource("../fxml/MEMShowADV.fxml")	
				);
		Parent btnRoot = loader.load();
		MEMShowADVController memshowadvController = loader.getController();
		memshowadvController.setMemshowcontroller(this);
		
		Scene scene = new Scene(btnRoot);
		btnadvStage.setScene(scene);
		btnadvStage.setTitle("도움말");
		btnadvStage.show();
		
		
		
	} catch (Exception e) {
		// TODO: handle exception
	}
    	
    	
    	

    }

    @FXML
    void btncloseClick(ActionEvent event) {

    }

    @FXML
    void btnnextClick(ActionEvent event) {

    }

    @FXML
    void btnplayClick(ActionEvent event) {

    }

    @FXML
    void btnpreClick(ActionEvent event) {

    }
    public void showContent() {
    	try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    	
    	
    }

    @FXML
    void initialize() {
    	//CSS 폰트 경로 설정
    	Font.loadFont(getClass().getResourceAsStream("../z.source/GODOM.ttf"), 14);

    }

	
}
