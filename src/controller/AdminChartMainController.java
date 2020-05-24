package controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import main.vo.AdminLineChartVO;
import main.vo.GenderChartVO;
import service.admin.AdminServiceImpl;
import service.admin.IAdminSevice;
import service.member.IMemberService;
import service.member.MemberServiceImpl;

public class AdminChartMainController {
	
	IMemberService memberService;
	IAdminSevice adminService;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane pane;

    @FXML
    private PieChart pieChart;
    
    @FXML
    private LineChart<String,Number> lineChart;
    
    private GenderChartVO gcvVo;
   
    private AdminLineChartVO alcVo;
    
    public AdminLineChartVO getAdminLineChartVO() {
    	return alcVo;
    }
    
    public GenderChartVO getGcvVo() {
		return gcvVo;
	}
  
    
    LocalDate date = LocalDate.now();
    
    String nowMonth = date.getMonthValue() + "월";
    String before1Month = (date.minusMonths(1)).getMonthValue() + "월";
    String before2Month = (date.minusMonths(2)).getMonthValue() + "월";
    String before3Month = (date.minusMonths(3)).getMonthValue() + "월";
    
    @FXML
	public void initialize() {
    	memberService = MemberServiceImpl.getInstance();
    	
    	gcvVo = memberService.getMemStat();    	System.out.println(gcvVo.getMale());
    	System.out.println(gcvVo.getFemale());
		ObservableList<PieChart.Data> data = FXCollections.observableArrayList(
				 new PieChart.Data("남자", gcvVo.getMale()),
				 new PieChart.Data("여자", gcvVo.getFemale())
				);
		
		pieChart.setLegendSide(Side.TOP);
		pieChart.setData(data);
		
		adminService = AdminServiceImpl.getInstance();
		alcVo = adminService.getLctMember();

		// 1번 lineChart		
		XYChart.Series<String,Number> series = new XYChart.Series<String,Number>();
		series.getData().add(new XYChart.Data<String, Number>(before3Month,alcVo.getMem_before_3month()));
		series.getData().add(new XYChart.Data<String, Number>(before2Month,alcVo.getMem_before_2month()));
		series.getData().add(new XYChart.Data<String, Number>(before1Month,alcVo.getMem_before_1month()));
		series.getData().add(new XYChart.Data<String, Number>(nowMonth,alcVo.getMem_before_0month()));
		series.setName("회원 증가률");
		// 2번 lineChart
		XYChart.Series<String,Number> series2 = new XYChart.Series<String,Number>();
		series2.getData().add(new XYChart.Data<String, Number>(before3Month,alcVo.getLct_before_3month()));
		series2.getData().add(new XYChart.Data<String, Number>(before2Month,alcVo.getLct_before_2month()));
		series2.getData().add(new XYChart.Data<String, Number>(before1Month,alcVo.getLct_before_1month()));
		series2.getData().add(new XYChart.Data<String, Number>(nowMonth,alcVo.getLct_before_0month()));
		series2.setName("강의 증가률");
		// 3번 lineChart
		XYChart.Series<String,Number> series3 = new XYChart.Series<String,Number>();
		series3.getData().add(new XYChart.Data<String, Number>(before3Month,alcVo.getLsn_before_3month()));
		series3.getData().add(new XYChart.Data<String, Number>(before2Month,alcVo.getLsn_before_2month()));
		series3.getData().add(new XYChart.Data<String, Number>(before1Month,alcVo.getLsn_before_1month()));
		series3.getData().add(new XYChart.Data<String, Number>(nowMonth,alcVo.getLsn_before_0month()));
		series3.setName("게시판 증가률");
		// line차트에 데이터 넣기
		lineChart.getData().add(series);
		lineChart.getData().add(series2);
		lineChart.getData().add(series3);
	}
}
