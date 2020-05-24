package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.vo.ContentsCttGBVO;
import main.vo.LectureVO;
import main.vo.MEMShowMYLCTVO;
import main.vo.SubslctevalVO;
import service.lecture.ILectureService;
import service.lecture.LectureServiceImpl;

public class MEMShowMyLCTController {
	private ILectureService service;
	private List<MEMShowMYLCTVO> data;
	private static SubslctevalVO evalStar;
	private MEMaddLCTController memlist;

	public static SubslctevalVO getEvalStar() {
		return evalStar;
	}

	public static void setEvalStar(SubslctevalVO evalStar) {
		MEMShowMyLCTController.evalStar = evalStar;
	}

	public MEMShowMyLCTController() {
		service = LectureServiceImpl.getInstance();
	}
	
	


	

	public Stage primaryStage;

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@FXML
	private AnchorPane subFrameMyLCT;

	@FXML
	private Label lbl_paid;

	@FXML
	private Label lbl_img;

	@FXML
	private Label lbl_star;

	@FXML
	private Label lbl_info;

	@FXML
	private Label lbl_date;

	@FXML
	private Label lbl_title;

	@FXML
	private ImageView img1;

	@FXML
	private Label title1;

	@FXML
	private Label date1;

	@FXML
	private Label paidfree1;

	@FXML
	private Button btnStar1;

	@FXML
	private Button btnStar2;

	@FXML
	private Button btnStar3;

	@FXML
	private Button btnStar4;

	@FXML
	private Button btnStar5;

	@FXML
	private Text cont1;

	@FXML
	private ImageView img2;

	@FXML
	private Label title2;

	@FXML
	private Label date2;

	@FXML
	private Label paidfree2;

	@FXML
	private Button btnStar6;

	@FXML
	private Button btnStar7;

	@FXML
	private Button btnStar8;

	@FXML
	private Button btnStar9;

	@FXML
	private Button btnStar10;

	@FXML
	private Text cont2;

	@FXML
	private ImageView img3;

	@FXML
	private Label title3;

	@FXML
	private Label date3;

	@FXML
	private Label paidfree3;

	@FXML
	private Button btnStar11;

	@FXML
	private Button btnStar12;

	@FXML
	private Button btnStar13;

	@FXML
	private Button btnStar14;

	@FXML
	private Button btnStar15;

	@FXML
	private Text cont3;

	@FXML
	private Pagination pageLecture;

	@FXML
	private Button btnInsert;
	@FXML
	private ImageView img4;

	@FXML
	private Label title4;

	@FXML
	private Label date4;

	@FXML
	private Label paidfree4;

	@FXML
	private Button btnStar16;

	@FXML
	private Button btnStar17;

	@FXML
	private Button btnStar18;

	@FXML
	private Button btnStar19;

	@FXML
	private Button btnStar20;

	@FXML
	private Text cont4;
	@FXML
	private Button btndelete1;
	@FXML
	private Button btndelete2;
	@FXML
	private Button btndelete3;
	@FXML
	private Button btndelete4;
	@FXML
    private Button btnModify1;
	@FXML
    private Button btnModify2;
	@FXML
    private Button btnModify3;
    @FXML
    private Button btnModify4;
    
    
    @FXML
    void btnModify1Click(ActionEvent event) {
    	try {
			Stage modifyStage = new Stage(StageStyle.DECORATED);
			modifyStage.initModality(Modality.APPLICATION_MODAL);
			modifyStage.initOwner(primaryStage);
			FXMLLoader loader = new FXMLLoader(
					MEMShowMyLCTController.class.getResource("../fxml/MEMModifyMyLCTPopUp.fxml")	
					);
			Parent addRoot = loader.load();
			
			MEMModifyMyLCTPopUpController memmodifypopup=loader.getController();
			memmodifypopup.setMainController(this);
			Scene scene = new Scene(addRoot);
			memmodifypopup.setMemShowMYLCTVO(memshowmylist[0]);
			memmodifypopup.showModify();
			modifyStage.setScene(scene);
			modifyStage.setTitle("수정");

			primaryStage=(Stage) btnModify1.getScene().getWindow();
			
			modifyStage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btnModify2Click(ActionEvent event) {
    	try {
			Stage modifyStage = new Stage(StageStyle.DECORATED);
			modifyStage.initModality(Modality.APPLICATION_MODAL);
			modifyStage.initOwner(primaryStage);
			FXMLLoader loader = new FXMLLoader(
					MEMShowMyLCTController.class.getResource("../fxml/MEMModifyMyLCTPopUp.fxml")	
					);
			Parent addRoot = loader.load();
			
			MEMModifyMyLCTPopUpController memmodifypopup=loader.getController();
			memmodifypopup.setMainController(this);
			
			Scene scene = new Scene(addRoot);
			
			modifyStage.setScene(scene);
			modifyStage.setTitle("수정");
			
			primaryStage=(Stage) btnModify1.getScene().getWindow();
			
			modifyStage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

    }

    @FXML
    void btnModify3Click(ActionEvent event) {

    }

    @FXML
    void btnModify4Click(ActionEvent event) {

    }
	
	@FXML
	void btndelete2Click(ActionEvent event) {
	
		data.remove(memshowmylist[1]);

		int cnt = service.deletelecture(memshowmylist[1].getLct_no());
		lctNo[1] = 0;
		label1[1].setText("");
		label2[1].setText("");
		label3[1].setText("");
		taLSNs[1].setText("");
		btndelete[1].setVisible(false);
		btnmodify[1].setVisible(false);
		for (int i = 0; i < label1.length; i++) {
			for (int j = 0; j < 5; j++) {
				btnStars[i * 5 + j].setVisible(false);
			}
		}
		imgview[1].setImage(null);
		
	}

	@FXML
	void btndelete3Click(ActionEvent event) {
		
		data.remove(memshowmylist[2]);

		int cnt = service.deletelecture(memshowmylist[2].getLct_no());
		lctNo[2] = 0;
		label1[2].setText("");
		label2[2].setText("");
		label3[2].setText("");
		taLSNs[2].setText("");
		btndelete[2].setVisible(false);
		btnmodify[2].setVisible(false);
		for (int i = 0; i < label1.length; i++) {
			for (int j = 0; j < 5; j++) {
				btnStars[i * 5 + j].setVisible(false);
			}
		}
		imgview[2].setImage(null);
		
	}

	@FXML
	void btndelete4Click(ActionEvent event) {
		
		data.remove(memshowmylist[3]);

		int cnt = service.deletelecture(memshowmylist[3].getLct_no());
		lctNo[3] = 0;
		label1[3].setText("");
		label2[3].setText("");
		label3[3].setText("");
		taLSNs[3].setText("");
		btndelete[3].setVisible(false);
		btnmodify[3].setVisible(false);
		for (int i = 0; i < label1.length; i++) {
			for (int j = 0; j < 5; j++) {
				btnStars[i * 5 + j].setVisible(false);
			}
		}
		imgview[3].setImage(null);
		
	}

	@FXML
	void btndelete1Click(ActionEvent event) {
	
		data.remove(memshowmylist[0]);

		int cnt = service.deletelecture(memshowmylist[0].getLct_no());
		lctNo[0] = 0;
		label1[0].setText("");
		label2[0].setText("");
		label3[0].setText("");
		taLSNs[0].setText("");
		btndelete[0].setVisible(false);
		btnmodify[0].setVisible(false);
		for (int i = 0; i < label1.length; i++) {
			for (int j = 0; j < 5; j++) {
				btnStars[i * 5 + j].setVisible(false);
			}
		}
		imgview[0].setImage(null);
		

	}

	

	@FXML
	void img1Click(MouseEvent event) {
		try {

			System.out.println("memshowmylist[2].getLct_no()" + memshowmylist[2].getLct_no());
			System.out.println("Lct NO => " + lctNo[2]);
			// 새창
			Stage contentStage = new Stage();

			// 현재 여기 있는 창
			Stage thisStage = (Stage) img3.getScene().getWindow();

			contentStage.initModality(Modality.APPLICATION_MODAL);

			// 새창이랑 initOwner 현재창
			contentStage.initOwner(thisStage);

			FXMLLoader loader = new FXMLLoader(MEMShowMainController.class.getResource("../fxml/MEMaddLCT.fxml"));
			Parent contentRoot = loader.load();

			// 자식 컨트롤러
			MEMaddLCTController meMaddLCTController = loader.getController();
			meMaddLCTController = loader.getController();
			meMaddLCTController.setMemShowMYLCTVO(memshowmylist[0]);
			meMaddLCTController.settableView();

			// 자식 컨트롤러.부모꺼(자식꺼)
			meMaddLCTController.setMemshowMyLctController(this);

//			meMaddLCTController.setMhVo(data.);

			Scene scene = new Scene(contentRoot);
			contentStage.setScene(scene);
			contentStage.setTitle("aasdfg");
			contentStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@FXML
	void img2Click(MouseEvent event) {
		try {

			System.out.println("memshowmylist[2].getLct_no()" + memshowmylist[2].getLct_no());
			System.out.println("Lct NO => " + lctNo[2]);
			// 새창
			Stage contentStage = new Stage();

			// 현재 여기 있는 창
			Stage thisStage = (Stage) img3.getScene().getWindow();

			contentStage.initModality(Modality.APPLICATION_MODAL);

			// 새창이랑 initOwner 현재창
			contentStage.initOwner(thisStage);

			FXMLLoader loader = new FXMLLoader(MEMShowMainController.class.getResource("../fxml/MEMaddLCT.fxml"));
			Parent contentRoot = loader.load();

			// 자식 컨트롤러
			MEMaddLCTController meMaddLCTController = loader.getController();
			meMaddLCTController = loader.getController();
			meMaddLCTController.setMemShowMYLCTVO(memshowmylist[1]);
			meMaddLCTController.settableView();

			// 자식 컨트롤러.부모꺼(자식꺼)
			meMaddLCTController.setMemshowMyLctController(this);

//			meMaddLCTController.setMhVo(data.);

			Scene scene = new Scene(contentRoot);
			contentStage.setScene(scene);
			contentStage.setTitle("aasdfg");
			contentStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@FXML
	void img3Click(MouseEvent event) {
		try {

			System.out.println("memshowmylist[2].getLct_no()" + memshowmylist[2].getLct_no());
			System.out.println("Lct NO => " + lctNo[2]);
			// 새창
			Stage contentStage = new Stage();

			// 현재 여기 있는 창
			Stage thisStage = (Stage) img3.getScene().getWindow();

			contentStage.initModality(Modality.APPLICATION_MODAL);

			// 새창이랑 initOwner 현재창
			contentStage.initOwner(thisStage);

			FXMLLoader loader = new FXMLLoader(MEMShowMainController.class.getResource("../fxml/MEMaddLCT.fxml"));
			Parent contentRoot = loader.load();

			// 자식 컨트롤러
			MEMaddLCTController meMaddLCTController = loader.getController();
			meMaddLCTController = loader.getController();
			meMaddLCTController.setMemShowMYLCTVO(memshowmylist[2]);
			meMaddLCTController.settableView();

			// 자식 컨트롤러.부모꺼(자식꺼)
			meMaddLCTController.setMemshowMyLctController(this);

//			meMaddLCTController.setMhVo(data.);

			Scene scene = new Scene(contentRoot);
			contentStage.setScene(scene);
			contentStage.setTitle("aasdfg");
			contentStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@FXML
	void img4Click(MouseEvent event) {
		try {

			System.out.println("memshowmylist[2].getLct_no()" + memshowmylist[2].getLct_no());
			System.out.println("Lct NO => " + lctNo[2]);
			// 새창
			Stage contentStage = new Stage();

			// 현재 여기 있는 창
			Stage thisStage = (Stage) img3.getScene().getWindow();

			contentStage.initModality(Modality.APPLICATION_MODAL);

			// 새창이랑 initOwner 현재창
			contentStage.initOwner(thisStage);

			FXMLLoader loader = new FXMLLoader(MEMShowMainController.class.getResource("../fxml/MEMaddLCT.fxml"));
			Parent contentRoot = loader.load();

			// 자식 컨트롤러
			MEMaddLCTController meMaddLCTController = loader.getController();
			meMaddLCTController = loader.getController();
			meMaddLCTController.setMemShowMYLCTVO(memshowmylist[3]);
			meMaddLCTController.settableView();

			// 자식 컨트롤러.부모꺼(자식꺼)
			meMaddLCTController.setMemshowMyLctController(this);

//				meMaddLCTController.setMhVo(data.);

			Scene scene = new Scene(contentRoot);
			contentStage.setScene(scene);
			contentStage.setTitle("aasdfg");
			contentStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@FXML
	void btnInsertClick(ActionEvent event) {
		try {
			Stage btnStage = new Stage(StageStyle.DECORATED);
			btnStage.initModality(Modality.APPLICATION_MODAL);
			btnStage.initOwner(primaryStage);

			FXMLLoader loader = new FXMLLoader(
					MEMShowMyLCTController.class.getResource("../fxml/MEMAddMyLCTPopUp.fxml"));
			Parent btnRoot = loader.load();
			MEMAddMyLCTPopUpController lctpopUpController = loader.getController();
			lctpopUpController.setLctpopUpmainController(this);

			Scene scene = new Scene(btnRoot);
			btnStage.setScene(scene);
			btnStage.setTitle("추가");
			btnStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	

	private int rowsPerPage = 4;

	private Button[] btnStars;
	private Label[] label1;
	private Label[] label2;
	private Text[] taLSNs;
	private Label[] label3;
	private ImageView[] imgview;
	private int[] lctNo;
	private Button[] btndelete;
	private Button[] btnmodify;

	private MEMShowMYLCTVO[] memshowmylist;


	public void setTextArea() {

		data = service.getALLlectureList(LoginController.getSession().getMem_id());
		changeTextArea(0);
		setPageCount();
	}

	public void changeTextArea(int index) {
		int fromIndex = index * rowsPerPage;
		int toIndex = Math.min(fromIndex + rowsPerPage, data.size());

		for (int i = 0; i < label1.length; i++) {
			lctNo[i] = 0;
			label1[i].setText("");
			label2[i].setText("");
			label3[i].setText("");
			taLSNs[i].setText("");
			imgview[i].setImage(null);
			btndelete[i].setVisible(false);
			btnmodify[i].setVisible(false);
			
		
			for (int j = 0; j < 5; j++) {
			
				btnStars[i * 5 + j].setVisible(false);
			}
		}

		int cnt = 0;
		// if(data.size())
		for (int i = fromIndex; i < toIndex; i++) {
			label1[cnt].setText(data.get(i).getLct_name());
			label2[cnt].setText(data.get(i).getLct_upload_date());
			taLSNs[cnt].setText(data.get(i).getLct_cont());
			// lctNo[cnt] = data.get(i).getLct_no();
//			service.getallvideolist(data.get(i).getLct_no());
			memshowmylist[cnt] = data.get(i);
			btndelete[cnt].setVisible(true);
			btnmodify[cnt].setVisible(true);
			try {
				System.out.println("이야ㅛ" + data.get(i).getLct_no() + "====> " + data.get(i).getLct_img_sname());
				FileInputStream input = new FileInputStream(data.get(i).getLct_img_sname());
				Image image = new Image(input);
				imgview[cnt].setImage(image);
//				imgview[cnt].get

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			for (int j = 0; j < 5; j++) {
				// btnStars[cnt*5+j].setDisable(false);
				btnStars[cnt * 5 + j].setVisible(true);
			}
			

			if (data.get(i).getLct_price() == 0) {
				label3[cnt].setText("무료");
			} else {
				label3[cnt].setText("유료" + data.get(i).getLct_price());
			}
			if(data.get(i).getLct_price() >0) {
				btndelete[cnt].setDisable(true);
				btnmodify[cnt].setDisable(true);
			}else {
				btndelete[cnt].setDisable(false);
				btnmodify[cnt].setDisable(false);
			}

			cnt++;
		}
	}

	public void setPageCount() {
		int pageCount = (int) Math.ceil((double) data.size() / rowsPerPage) - 1;
		System.out.println(data.size());
		pageLecture.setPageCount(pageCount + 1);
		pageLecture.setCurrentPageIndex(0);

		pageLecture.currentPageIndexProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				changeTextArea(newValue.intValue());
			}
		});

	}

	@FXML
	void initialize() {

		btnStars = new Button[] { btnStar1, btnStar2, btnStar3, btnStar4, btnStar5, btnStar6, btnStar7, btnStar8,
				btnStar9, btnStar10, btnStar11, btnStar12, btnStar13, btnStar14, btnStar15, btnStar16, btnStar17,
				btnStar18, btnStar19, btnStar20, };
		label1 = new Label[] { title1, title2, title3, title4 };
		label2 = new Label[] { date1, date2, date3, date4 };
		taLSNs = new Text[] { cont1, cont2, cont3, cont4 };

		label3 = new Label[] { paidfree1, paidfree2, paidfree3, paidfree4 };

		imgview = new ImageView[] { img1, img2, img3, img4

		};
		btndelete = new Button[] { btndelete1, btndelete2, btndelete3, btndelete4 };
		btnmodify = new Button[] {btnModify1,btnModify2,btnModify3,btnModify4};
		
		
		lctNo = new int[imgview.length];

		memshowmylist = new MEMShowMYLCTVO[] { new MEMShowMYLCTVO(), new MEMShowMYLCTVO(), new MEMShowMYLCTVO(),
				new MEMShowMYLCTVO() };

		System.out.println("list===>" + memshowmylist);
		setTextArea();

	}

	@FXML
	void title1Click(MouseEvent event) {
		try {
			System.out.println("Lct NO => " + lctNo[2]);
			// 새창
			Stage contentStage = new Stage();

			// 현재 여기 있는 창
			Stage thisStage = (Stage) img3.getScene().getWindow();

			contentStage.initModality(Modality.APPLICATION_MODAL);

			// 새창이랑 initOwner 현재창
			contentStage.initOwner(thisStage);

			FXMLLoader loader = new FXMLLoader(MEMShowMainController.class.getResource("../fxml/MEMaddLCT.fxml"));
			Parent contentRoot = loader.load();

			// 자식 컨트롤러
			MEMaddLCTController meMaddLCTController = loader.getController();

			// 자식 컨트롤러.부모꺼(자식꺼)
			meMaddLCTController.setMemshowMyLctController(this);

//			meMaddLCTController.setMhVo(data.);

			Scene scene = new Scene(contentRoot);
			contentStage.setScene(scene);
			contentStage.setTitle("aasdfg");
			contentStage.show();
//			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void title3Click(MouseEvent event) throws IOException {
		System.out.println("memshowmylist[2].getLct_no()" + memshowmylist[2].getLct_no());
		System.out.println("Lct NO => " + lctNo[2]);
		// 새창
		Stage contentStage = new Stage();

		// 현재 여기 있는 창
		Stage thisStage = (Stage) img3.getScene().getWindow();

		contentStage.initModality(Modality.APPLICATION_MODAL);

		// 새창이랑 initOwner 현재창
		contentStage.initOwner(thisStage);

		FXMLLoader loader = new FXMLLoader(MEMShowMainController.class.getResource("../fxml/MEMaddLCT.fxml"));
		Parent contentRoot = loader.load();

		// 자식 컨트롤러
		MEMaddLCTController meMaddLCTController = loader.getController();
		meMaddLCTController = loader.getController();
		meMaddLCTController.setMemShowMYLCTVO(memshowmylist[2]);
		meMaddLCTController.settableView();

		// 자식 컨트롤러.부모꺼(자식꺼)
		meMaddLCTController.setMemshowMyLctController(this);

//		meMaddLCTController.setMhVo(data.);

		Scene scene = new Scene(contentRoot);
		contentStage.setScene(scene);
		contentStage.setTitle("aasdfg");
		contentStage.show();
//		

	}

	

}
