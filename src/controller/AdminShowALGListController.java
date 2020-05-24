package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import main.vo.AlgorithmTableVO;
import service.algorithm.AlgorithmServiceImpl;

public class AdminShowALGListController {
	
	private AlgorithmServiceImpl algService;
	private ObservableList<AlgorithmTableVO> algExData;

	@FXML
    private AnchorPane mainFrame;

    @FXML
    private Label lblMainTitle;
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAlgExerInsert;

    @FXML
    private TableView<AlgorithmTableVO> tableAlgorithmManage;

    @FXML
    private TableColumn<?, ?> colCate;

    @FXML
    private TableColumn<?, ?> colExerNum;

    @FXML
    private TableColumn<?, ?> colSubmitNum;

    @FXML
    private TableColumn<?, ?> colCorrectNum;
    
    @FXML
    private TableColumn<?, ?> colTitle;

    @FXML
    private TableColumn<?, ?> colCorrectPercent;

    @FXML
    private Pagination pageAlgManage;

    @FXML
    void btnAlgExerInsertClick(ActionEvent event) {
    	mainFrame.getChildren().clear();
    	try {
    		AnchorPane anchorPane = FXMLLoader.load(MEMShowALGListController.class.getResource("../fxml/AdminAddALG.fxml"));
    		mainFrame.getChildren().add(anchorPane);
    	} catch (Exception e) {
			e.printStackTrace();
		}
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
			tableAlgorithmManage.setItems(algExData);
		}
	}

    @FXML
    void initialize() {
    	algService = AlgorithmServiceImpl.getInstance();
    	
    	colCate.setCellValueFactory(new PropertyValueFactory<>("alg_cate"));
		colExerNum.setCellValueFactory(new PropertyValueFactory<>("alg_no"));
		colTitle.setCellValueFactory(new PropertyValueFactory<>("alg_title"));
		colSubmitNum.setCellValueFactory(new PropertyValueFactory<>("alg_submit"));
		colCorrectNum.setCellValueFactory(new PropertyValueFactory<>("alg_crct_cnt"));
		colCorrectPercent.setCellValueFactory(new PropertyValueFactory<>("alg_crct_per"));
		
		setTableView("LEVEL 1");
    	
    }
}
