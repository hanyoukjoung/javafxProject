package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import main.vo.AddrTableVO;
import main.vo.AddrVO;
import service.address.AddressServiceImpl;

public class MEMSearchZipPopUpController {

	private MEMJoinPopUpController memJoinPopUpController;
	private MEMShowMyPageController memShowMyPageController;
	private AddressServiceImpl addrService;
	private String tmpAddr;
	private String tmpPost;

	public String getTmpAddr() {
		return tmpAddr;
	}

	public void setTmpAddr(String tmpAddr) {
		this.tmpAddr = tmpAddr;
	}

	public String getTmpPost() {
		return tmpPost;
	}

	public void setTmpPost(String tmpPost) {
		this.tmpPost = tmpPost;
	}

	public MEMJoinPopUpController getMemJoinPopUpController() {
		return memJoinPopUpController;
	}

	public void setMemJoinPopUpController(MEMJoinPopUpController memJoinPopUpController) {
		this.memJoinPopUpController = memJoinPopUpController;
	}
	
	public MEMShowMyPageController getMemShowMyPageController() {
		return memShowMyPageController;
	}

	public void setMemShowMyPageController(MEMShowMyPageController memShowMyPageController) {
		this.memShowMyPageController = memShowMyPageController;
	}

	private ObservableList<AddrTableVO> addrData;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private AnchorPane pane;
	private double xOffset = 0;
	private double yOffset = 0;

	@FXML
	private Button btnSearch;

	@FXML
    private Label lblText;
	
	@FXML
	private Label lblTitle;

	@FXML
	private ImageView btnClose;

	@FXML
	private TableColumn<?, ?> colZip;

	@FXML
	private TableColumn<?, ?> colAddr;

	@FXML
	private TableView<AddrTableVO> tableAddr;

	@FXML
	private TextField tfRna;

	@FXML
	private ComboBox<String> comboSigungooName;

	@FXML
	private ComboBox<String> comboSidoName;

	@FXML
	void btnCloseClick(MouseEvent event) {
		Stage stage = (Stage) pane.getScene().getWindow();
		stage.close();
	}

	@FXML
	void tableAddrClick(MouseEvent event) {
		if (!tableAddr.getSelectionModel().isEmpty()) {

			tmpAddr = tableAddr.getSelectionModel().getSelectedItem().getAddr();
			tmpPost = tableAddr.getSelectionModel().getSelectedItem().getPost_no() + "";

			Stage stage = (Stage) pane.getScene().getWindow();
			stage.close();

		}

	}

	@FXML
	void btnSearchClick(ActionEvent event) {
		if (comboSidoName.getSelectionModel().isEmpty() || comboSigungooName.getSelectionModel().isEmpty()
				|| tfRna.getText().isEmpty()) {
			return;
		}
		Map<String, String> params = new HashMap<String, String>();
		params.put("sido_name", comboSidoName.getSelectionModel().getSelectedItem());
		params.put("sigungoo_name", comboSigungooName.getSelectionModel().getSelectedItem());
		if (!tfRna.getText().trim().contains(" ")) {
			return;
		}
		String[] tmp = tfRna.getText().split(" ");
		params.put("rna", tmp[0]);
		params.put("building_bonbun", tmp[1]);

		setTableView(params);
	}

	@FXML
	void initialize() {
	
		//CSS 폰트 경로 설정하기
		Font.loadFont(getClass().getResourceAsStream("../z.source/GODOM.ttf"), 12);
		
		pane.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				xOffset = event.getSceneX();
				yOffset = event.getSceneY();
			}
		});

		pane.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Stage primaryStage = (Stage) pane.getScene().getWindow();
				primaryStage.setX(event.getScreenX() - xOffset);
				primaryStage.setY(event.getScreenY() - yOffset);
			}
		});

		comboSidoName.setValue("시/도");
		comboSidoName.getItems().addAll("대전광역시");
//		comboSidoName.getItems().addAll("강원도", "경기도", "경상남도", "경상북도", "광주광역시",
//				"대구광역시", "대전광역시", "부산광역시", "서울특별시", "세종특별자치시", "울산광역시",
//				"인천광역시", "전라남도", "전라북도", "제주특별자치도", "충청남도", "충청북도");

		comboSigungooName.setValue("시/군/구");
		comboSigungooName.getItems().addAll("대덕구", "동구", "서구", "유성구", "중구");
		addrService = AddressServiceImpl.getInstance();

		colZip.setCellValueFactory(new PropertyValueFactory<>("post_no"));
		colAddr.setCellValueFactory(new PropertyValueFactory<>("addr"));
	}

	public void setTableView(Map<String, String> params) {
		List<AddrVO> tmp = addrService.getSearchAddr(params);

		List<AddrTableVO> list = new ArrayList<AddrTableVO>();

		for (int i = 0; i < tmp.size(); i++) {
			AddrTableVO addrTableVO = new AddrTableVO();
			addrTableVO.setPost_no(tmp.get(i).getPost_no());
			if (tmp.get(i).getSigungoo_building_name() == null) {
				addrTableVO.setAddr(
						tmp.get(i).getSido_name() + " " + tmp.get(i).getSigungoo_name() +" " +tmp.get(i).getBuilding_bonbun() + " " + tmp.get(i).getRna());
			} else {
				addrTableVO.setAddr(tmp.get(i).getSido_name() + " " + tmp.get(i).getSigungoo_name() + " "
						+ tmp.get(i).getRna() +" " +tmp.get(i).getBuilding_bonbun() + " " + tmp.get(i).getSigungoo_building_name());
			}
			list.add(addrTableVO);
		}
		addrData = FXCollections.observableArrayList(list);
		tableAddr.setItems(addrData);
	}
}
