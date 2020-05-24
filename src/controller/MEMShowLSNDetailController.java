package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.vo.LboardVO;

public class MEMShowLSNDetailController {
	private LboardVO lBoardVo;
    public LboardVO getlBoardVo() {
		return lBoardVo;
	}
	public void setlBoardVo(LboardVO lBoardVo) {
		this.lBoardVo = lBoardVo;
		lblWriter.setText(lBoardVo.getMem_id());
		lblDate.setText(lBoardVo.getLsn_board_date());
		lblTeachLang.setText(lBoardVo.getLang_major() == 1? "JAVA" : 
							 lBoardVo.getLang_major() == 2? "C++"  : 
							 lBoardVo.getLang_major() == 3?	"PYTHON" : "ORACLE" );
		lblLearnLang.setText(lBoardVo.getLang_itrst() == 1? "JAVA" : 
							 lBoardVo.getLang_itrst() == 2? "C++"  : 
							 lBoardVo.getLang_itrst() == 3?	"PYTHON" : "ORACLE" );
		txtContent.setText(lBoardVo.getLsn_board_cont());
	}

	
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane pane;

    @FXML
    private Label lblWriter;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblTeachLang;

    @FXML
    private Label lblLearnLang;

    @FXML
    private Text txtContent;

    @FXML
    private Button btnRequest;

    @FXML
    private ImageView btnMin;

    @FXML
    private ImageView btnClose;

    
    @FXML
    void btnCloseClick(MouseEvent event) {
    	Stage memShowLSNDetailStage = (Stage)pane.getScene().getWindow();
    	memShowLSNDetailStage.close();
    }

    @FXML
    void btnMinClick(MouseEvent event) {
    	Stage memShowLSNDetailStage = (Stage)pane.getScene().getWindow();
    	memShowLSNDetailStage.setIconified(true);
    }

    @FXML
    void btnRequestClick(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }
}
