package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.vo.AdviceVO;
import service.advice.AdviceServiceImpl;
import service.advice.IAdviceService;

public class MEMShowADVController {
	
	public  MEMShowADVController() {
		service = AdviceServiceImpl.getInstance();
	}
	
	private Stage primaryStage;
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	private MEMShowSUBSLCTVIdeoController memshowcontroller;
	
	public MEMShowSUBSLCTVIdeoController getMemshowcontroller() {
		return memshowcontroller;
	}

	public void setMemshowcontroller(MEMShowSUBSLCTVIdeoController memShowSUBSLCTVIdeoController) {
		this.memshowcontroller = memShowSUBSLCTVIdeoController;
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane subFrameAdv;
    
    @FXML
    private Label lblTitleHelp;

    @FXML
    private TextField tfTitle;

    @FXML
    private Button btnSearch;

    

    @FXML
    private TableView<AdviceVO> tableADV;

    @FXML
    private TableColumn<?, ?> coladvtitle;

    @FXML
    private Button btnclose;
    
    @FXML
    private ComboBox<String> ADVcombo;

    
  
    
    @FXML
    private Pagination pageadv;
    
    @FXML
    void ADVcomboClick(ActionEvent event) {
    	if(ADVcombo.getSelectionModel().getSelectedItem().equals("자바")) {
       	    
           	setTableView();
           	
        }else{
           		
            setTableView1();
        }
    	
    }
    
    @FXML
    void tableADVClick(MouseEvent event) {
    	if(tableADV.getSelectionModel().isEmpty())
    		return;
    	try {
			Stage contentStage = new Stage();
			contentStage.initModality(Modality.APPLICATION_MODAL);
			
			FXMLLoader loader = new FXMLLoader(
					MEMShowLCTListController.class.getResource("../fxml/MEMShowADVDetailPopUp.fxml")
					);
			Parent contentRoot = loader.load();
			AdviceVO adVo = tableADV.getSelectionModel().getSelectedItem();
			
			MEMShowADVDetailPopUpController MEMShowADVDetailPopUpController =loader.getController();
			MEMShowADVDetailPopUpController.setAdVo(adVo);
			
			Scene scene = new Scene(contentRoot);
			contentStage.setScene(scene);
			contentStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

    }

    

    private ObservableList<AdviceVO> advlist1;
    @FXML
    void btnSearchClick(ActionEvent event) {
    	String searchData = tfTitle.getText();
    	if(searchData.isEmpty()) {
    		tfTitle.requestFocus();
    		return;
    	}
    	try {
			List<AdviceVO> resultList = null;
			
			if(ADVcombo.getValue().equals("자바")) {
				resultList = service.getsearchjava(searchData);	
			}else {
				
				resultList=service.getsearchoracle(searchData);
			}
			if(resultList==null) {
				advlist1 =FXCollections.observableArrayList();
			}else {
				advlist1=FXCollections.observableArrayList(resultList);
			}
			tableADV.setItems(advlist1);
		} catch (Exception e) {
			e.printStackTrace();
		}
 
    }
    
   

    @FXML
    void btncloseClick(ActionEvent event) {
    	Stage thisStage = (Stage) btnclose.getScene().getWindow();
    	thisStage.close();

    }
    private IAdviceService service;
   

    @FXML
    void initialize() {
    	
    	//css font 경로 설정
    	Font.loadFont(getClass().getResourceAsStream("../z.source/GODOM.ttf"), 12);
    	
    	ADVcombo.getItems().addAll("자바","오라클");
    	ADVcombo.setValue("자바");
     	coladvtitle.setCellValueFactory(new PropertyValueFactory<>("adv_title"));
    	
     	setTableView();

   }
    private int rowsPerPage =15;
 
    
    public void setTableView() {
    	advlist1 =FXCollections.observableArrayList(
    			service.getjavaadviceList()
    			
    			);
    	tableADV.setItems(advlist1);
    	
    	int pageCount = (int) Math.ceil(advlist1.size()/rowsPerPage);
        //	pageid.setMaxPageIndicatorCount(pageCount+1);
    	pageadv.setPageCount(pageCount+1);
    	pageadv.setCurrentPageIndex(0);
        	chageTableView(0);
        	pageadv.currentPageIndexProperty().addListener(
        			new ChangeListener<Number>() {

    					@Override
    					public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
    						chageTableView(newValue.intValue());
    					}		
    				});
    
	
    }
    
    public void chageTableView(int index) {
    	int fromIndex = index*rowsPerPage;//시작위치
    	int toIndex = Math.min(fromIndex+rowsPerPage,advlist1.size() );
    	
    	tableADV.setItems(FXCollections.observableArrayList(
    			advlist1.subList(fromIndex, toIndex)
    	));
    	
    	
    }
    
    public void setTableView1() {
    	
    	advlist1 =FXCollections.observableArrayList(
    			service.getoracleList()
    			);
    	tableADV.setItems(advlist1);
	
    }

	
	
    
    
   

    
}
