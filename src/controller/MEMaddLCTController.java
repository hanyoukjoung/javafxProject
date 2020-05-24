package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import main.vo.ContentsCttGBVO;
import main.vo.MEMShowMYLCTVO;
import service.lecture.LectureServiceImpl;

public class MEMaddLCTController {
	//
	private MEMShowMyLCTController memshowMyLctController;

	public MEMShowMyLCTController getMemshowMyLctController() {
		return memshowMyLctController;
	}

	public void setMemshowMyLctController(MEMShowMyLCTController memshowMyLctController) {
		this.memshowMyLctController = memshowMyLctController;
	}

	private List<MEMShowMYLCTVO> data;
//	private List<ContentsCttGBVO> data2;
	

	private ContentsCttGBVO contentsctt;
	private MEMShowMYLCTVO memShowMYLCTVO;
	
	
	

	public MEMShowMYLCTVO getMemShowMYLCTVO() {
		return memShowMYLCTVO;
	}

	public void setMemShowMYLCTVO(MEMShowMYLCTVO memShowMYLCTVO) {
		this.memShowMYLCTVO = memShowMYLCTVO;
	}

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private AnchorPane subFrameAddLCT;

	@FXML
	private TableView<ContentsCttGBVO> tableAddLCT;

	@FXML
	private TableColumn<?, ?> colCate;

	@FXML
	private TableColumn<?, ?> colTitle;

	@FXML
	private TableColumn<?, ?> colCont;

	@FXML
	private Button btnInsert;

	@FXML
	private Button btnModify;

	@FXML
	private Button btnDel;

	@FXML
	void btnDelClick(ActionEvent event) {

	}

	@FXML
	void btnInsertClick(ActionEvent event) {

	}

	@FXML
	void btnModifyClick(ActionEvent event) {

	}

	@FXML
	void stdTableClicked(MouseEvent event) {

	}

	private LectureServiceImpl service;
	private ObservableList<ContentsCttGBVO> contentsList;

	public MEMaddLCTController() {
		service = LectureServiceImpl.getInstance();
	}

	ContentsCttGBVO cttg = new ContentsCttGBVO();

	@FXML
	void initialize() {
		colCate.setCellValueFactory(new PropertyValueFactory<>("ctt_gb_name"));
		colTitle.setCellValueFactory(new PropertyValueFactory<>("ctt_title"));
		colCont.setCellValueFactory(new PropertyValueFactory<>("ctt_cont"));
//		settableView();
	}

	public void settableView() {
		data = service.getALLlectureList(LoginController.getSession().getMem_id());
		System.out.println("memShowMYLCTVO.getLct_no() : "+memShowMYLCTVO.getLct_no());
		contentsList = FXCollections.observableArrayList(service.getallvideolist(memShowMYLCTVO.getLct_no()));

		tableAddLCT.setItems(contentsList);
//		System.out.println("memShowMYLCTVO.getLct_no()"+memShowMYLCTVO.getLct_no());
		
//		data2 = service.getallvideolist(lctDate.getLct_no());
//		System.out.println();
//		tableAddLCT.setItems((ObservableList<ContentsCttGBVO>) data2);

	}

	public ContentsCttGBVO getContentsctt() {
		return contentsctt;
	}

	public void setContentsctt(ContentsCttGBVO contentsctt) {
		this.contentsctt = contentsctt;
	}
}
