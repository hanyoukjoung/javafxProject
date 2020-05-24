package main.common;

import java.io.File;
import java.lang.reflect.Field;
import java.nio.charset.Charset;

import controller.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.packet.ServerPath;

public class Login extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
						
			/**
			 * @author 정재훈
			 * 
			 * 시스템 인코딩 사용값 세팅
			 * 
			 */
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
			System.setProperty("file.encoding","UTF-8");
			
			Field charset;
	    	charset = Charset.class.getDeclaredField("defaultCharset");
			charset.setAccessible(true);
			charset.set(null,null);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////////////////////////////////
			/**
			 * @author 정재훈
			 * 
			 * 시작 전 사용 폴더의 생성 유무 체크
			 * 
			 */
			for(ServerPath path : ServerPath.values()) {
				File ServerFile = new File(path.getPath());
				File ClientFile = new File(path.getPath() + "/client");
				if(!(ServerFile.isDirectory())) ServerFile.mkdirs(); 
				if(!(ClientFile.isDirectory())) ClientFile.mkdirs(); 
			}
			
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
			long heapSize = Runtime.getRuntime().totalMemory();
			System.out.println("Heap Size(M) : " + heapSize / (1024 * 1024) + " MB");
			
			FXMLLoader loader = new FXMLLoader(Login.class.getResource("../../fxml/Login.fxml"));
			Parent logInRoot = loader.load();
			
			LoginController logInController = loader.getController();
			logInController.setLogInStage(primaryStage);
			
			Scene scene = new Scene(logInRoot);
			primaryStage.setScene(scene);
			primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.show();
			logInController.focusId();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
