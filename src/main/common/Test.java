package main.common;

import java.io.IOException;

import controller.MEMShowLSNCHATPopUpController;
import controller.MEMShowLSNListController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.vo.MemberVO;

public class Test extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
//		FXMLLoader loader = new FXMLLoader(Test.class.getResource("../../fxml/MEMShowLSNCHATPopUp.fxml"));
//		
//		AnchorPane root = loader.load();
//		MEMShowLSNCHATPopUpController ctr = loader.getController();
//		
//		ctr.starter(new MemberVO("jjangjjh97", "정재훈", "wogns1", null, null, null, null, null, null, null, 0, null, null, null, 0, 0), "wyr123", 0);
//		Scene scene = new Scene(root);
//		
//		primaryStage.initStyle(StageStyle.UNDECORATED);
//		primaryStage.setScene(scene);
//		primaryStage.show();
		FXMLLoader loader = new FXMLLoader(Test.class.getResource("../../fxml/MEMShowLSNList.fxml"));
		
		Parent root = loader.load();
		Scene scene = new Scene(root);
		
		MEMShowLSNListController ctr = loader.getController();
		ctr.starter(new MemberVO("jjangjjh97", "정재훈", "wogns1", null, null, null, null, null, null, null, 0, null, null, null, 0, 0));
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
