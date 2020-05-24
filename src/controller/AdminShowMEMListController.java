package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import main.vo.RepotMemberVO;
import service.admin.AdminServiceImpl;
import service.admin.IAdminSevice;

public class AdminShowMEMListController {
	
	String memberType ="일반회원";
	
	private IAdminSevice service;
	
	private ObservableList<RepotMemberVO> memberData;
   
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane subFrameMEM;

    @FXML
    private ComboBox<String> comboMem;

    @FXML
    private TextField tfSearchMem;

    @FXML
    private Button btnSearch;

    @FXML
    private TableView<RepotMemberVO> tableMem;

    @FXML
    private TableColumn<?, ?> memId;

    @FXML
    private TableColumn<?, ?> memName;

    @FXML
    private TableColumn<?, ?> memAddr;

    @FXML
    private TableColumn<?, ?> langItrst;

    @FXML
    private TableColumn<?, ?> langMajor;

    @FXML
    private TableColumn<?, ?> report;

    @FXML
    private Pagination pagination;

    @FXML
    private Button btnBlkCancel;

    @FXML
    void btnBlkCancelClick(ActionEvent event) {

    }

    @FXML
    void btnSearchClick(ActionEvent event) {

    }
    @FXML
    void tfSearchMemClick(ActionEvent event) {
    	
    }
    

    @FXML
    void memselectCombobox(ActionEvent event) {
    	memberType = comboMem.getSelectionModel().getSelectedItem();
    	
    	setTableView(memberType);
    }

    
    @FXML
    void initialize() {
    	service = AdminServiceImpl.getInstance();
    	Font.loadFont(getClass().getResourceAsStream("../z.source/GODOM.ttf"), 12);

    	ObservableList<String> comboList = FXCollections.observableArrayList("일반회원","블랙리스트 회원");
    	comboMem.setItems(comboList);
    	
    	memId.setCellValueFactory(new PropertyValueFactory<>("mem_id"));
    	memName.setCellValueFactory(new PropertyValueFactory<>("mem_name" ));
    	memAddr.setCellValueFactory(new PropertyValueFactory<>("mem_addr"));
    	langItrst.setCellValueFactory(new PropertyValueFactory<>("lang_itrst"));
    	langMajor.setCellValueFactory(new PropertyValueFactory<>("lang_major"));
    	report.setCellValueFactory(new PropertyValueFactory<>("rpt_cnt"));
    	
    	setTableView("일반회원");
    }
    
    int rowsPerPage = 17; 
    
    /**
     * 게시판 타입을 입력받아 게시판 테이블 셋팅하는 메서드
     */
    public void setTableView(String memberType) {
    	
    	if(memberType.equals("일반회원")) {
    		comboMem.setValue("일반회원");
    	}else {
    		comboMem.setValue("블랙리스트 회원");
    	}
    	
    	if(memberType.equals("일반회원")) {
    		btnBlkCancel.setText("블랙리스트 추가");
    		//데이터 가져오기
    		memberData = FXCollections.observableArrayList(service.getAllmemberlist());
    	}else{
    		btnBlkCancel.setText("블랙리스트 해제");
//    		if(colBoardCnt.isVisible() == false) colBoardCnt.setVisible(true);
//    		if(btnInsert.isVisible() == false) btnInsert.setVisible(true);
//    		//데이터 가져오기
//    		boardData = FXCollections.observableArrayList(service.getAllFBoardList());
    	}
//    	System.out.println("memberData.size()");
    	setPageCount();
    }
    
    
    public void setPageCount() {
    	
    	int pageCount = (int) Math.ceil((double)memberData.size() / rowsPerPage );
    	pagination.setPageCount(pageCount);
    	changeTableView(0);
    	
    	pagination.currentPageIndexProperty().addListener(
			new ChangeListener<Number>() {
				@Override
				public void changed(ObservableValue<? extends Number> observable,
						Number oldValue, Number newValue) {
					changeTableView(newValue.intValue());
				}
			}
    	);
    }

    public void changeTableView(int index) {
    	int fromIndex = index * rowsPerPage;
    	int toIndex = Math.min(fromIndex + rowsPerPage, memberData.size());
    	
    	tableMem.setItems(FXCollections.observableArrayList(memberData.subList(fromIndex, toIndex)));
    }
    
}
