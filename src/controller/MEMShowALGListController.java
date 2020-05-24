package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.vo.AlgorithmTableVO;
import service.algorithm.AlgorithmServiceImpl;

public class MEMShowALGListController {
	
	private Stage memShowALGListStage;

	public Stage getMemShowALGListStage() {
		return memShowALGListStage;
	}

	public void setMemShowALGListStage(Stage memShowALGListStage) {
		this.memShowALGListStage = memShowALGListStage;
	}

	private ObservableList<AlgorithmTableVO> algExData;

	private AlgorithmServiceImpl algService;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private AnchorPane subFrameQuestionList;

	@FXML
	private VBox frameAlgQuestion;

	@FXML
	private Label lblTitle;

	@FXML
	private ComboBox<String> comBoxLv;

	@FXML
	private TableView<AlgorithmTableVO> tableAlg;

	@FXML
	private TableColumn<?, ?> colSort; // 분류 alg_cate alg_cate algorithmTableVO alg_cate

	@FXML
	private TableColumn<?, ?> colQuestion; // 문제번호 algorithm alg_no algorithmTableVO alg_no

	@FXML
	private TableColumn<?, ?> colTitle; // 제목 algorithm alg_title algorithmTableVO alg_title

	@FXML
	private TableColumn<?, ?> colSubmit; // 제출수 algorithm alg_sbmt_cnt algorithmTableVO alg_submit

	@FXML
	private TableColumn<?, ?> colMem; // 정답수 algorithm alg_crct_cnt algorithmTableVO alg_crct_cnt

	@FXML
	private TableColumn<?, ?> colSuccess; // 정답률 없음 algorithmTableVO alg_crct_per

	@FXML
	private Pagination pageQuestionList;

	@FXML
	void comBomLvClick(ActionEvent event) {
		setTableView(comBoxLv.getSelectionModel().getSelectedItem());
	}

	@FXML
	void tableAlgClick(MouseEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(MEMShowALGDetailController.class.getResource("../fxml/MEMShowALGDetail.fxml"));
		Parent memShowALGDetailRoot = loader.load();
		MEMShowALGDetailController memShowALGDetailController = loader.getController();
		memShowALGDetailController.setSelectALGNum(tableAlg.getSelectionModel().getSelectedItem().getAlg_no());
		subFrameQuestionList.getChildren().clear();
		try {
			AnchorPane anchorPane = FXMLLoader.load(MEMShowALGDetailController.class.getResource("../fxml/MEMShowALGDetail.fxml"));
			subFrameQuestionList.getChildren().add(anchorPane);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
//		
	}

	@FXML
	void initialize() {
		algService = AlgorithmServiceImpl.getInstance();
		Font.loadFont(getClass().getResourceAsStream("../z.source/GODOM.ttf"), 12);
		comBoxLv.setPromptText("LEVEL 1");
		comBoxLv.getItems().addAll("LEVEL 1", "LEVEL 2", "LEVEL 3", "LEVEL 4", "LEVEL 5", "올림피아드", "카카오코딩 테스트");

		colSort.setCellValueFactory(new PropertyValueFactory<>("alg_cate"));
		colQuestion.setCellValueFactory(new PropertyValueFactory<>("alg_no"));
		colTitle.setCellValueFactory(new PropertyValueFactory<>("alg_title"));
		colSubmit.setCellValueFactory(new PropertyValueFactory<>("alg_submit"));
		colMem.setCellValueFactory(new PropertyValueFactory<>("alg_crct_cnt"));
		colSuccess.setCellValueFactory(new PropertyValueFactory<>("alg_crct_per"));
		
		setTableView("LEVEL 1");

	}

	public void setTableView(String comboSelection) {
		List<AlgorithmTableVO> tmpList = algService.getAlgorithmEx(comboSelection);
		List<AlgorithmTableVO> list = new ArrayList<AlgorithmTableVO>();
		if (!tmpList.isEmpty()) {
			for (int i = 0; i < tmpList.size(); i++) {
				if (tmpList.get(i).getAlg_crct_cnt() == 0) {
					tmpList.get(i).setAlg_crct_per("??%");
				} else {
					tmpList.get(i).setAlg_crct_per(
							tmpList.get(i).getAlg_submit() / tmpList.get(i).getAlg_crct_cnt() * 100 + "%");
				}
				list.add(tmpList.get(i));
			}
			algExData = FXCollections.observableArrayList(list);
			tableAlg.setItems(algExData);
		}
	}

	public void setPageCount() {
//		int pageCount = (int) Math.
	}
}
