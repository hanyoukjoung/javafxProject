package main.vo;

public class TradeRecordVO {
	
	// field
	
	private int trade_rec_no;	// 거래 이력 식별번호
	private int lct_no;			// 강의 식별번호
	private String mem_no;		// 회원 아이디
	private String card_corp;	// 카드사
	private String catd_no;		// 카드번호
	private String card_owner;	// 카드 소유주
	private int trade_amt;		// 거래 금액
	private String trade_date;	// 거래일
	
	// getter & setter
	
	public int getTrade_rec_no() {
		return trade_rec_no;
	}
	
	public void setTrade_rec_no(int trade_rec_no) {
		this.trade_rec_no = trade_rec_no;
	}
	
	public int getLct_no() {
		return lct_no;
	}
	
	public void setLct_no(int lct_no) {
		this.lct_no = lct_no;
	}
	
	public String getMem_no() {
		return mem_no;
	}
	
	public void setMem_no(String mem_no) {
		this.mem_no = mem_no;
	}
	
	public String getCard_corp() {
		return card_corp;
	}
	
	public void setCard_corp(String card_corp) {
		this.card_corp = card_corp;
	}
	
	public String getCatd_no() {
		return catd_no;
	}
	
	public void setCatd_no(String catd_no) {
		this.catd_no = catd_no;
	}
	
	public String getCard_owner() {
		return card_owner;
	}
	
	public void setCard_owner(String card_owner) {
		this.card_owner = card_owner;
	}
	
	public int getTrade_amt() {
		return trade_amt;
	}
	
	public void setTrade_amt(int trade_amt) {
		this.trade_amt = trade_amt;
	}
	
	public String getTrade_date() {
		return trade_date;
	}
	
	public void setTrade_date(String trade_date) {
		this.trade_date = trade_date;
	}
	
	
	//constructor
	
	public TradeRecordVO() {}
	
	public TradeRecordVO(int trade_rec_no, int lct_no, String mem_no, String card_corp, String catd_no,
			String card_owner, int trade_amt, String trade_date) {
		super();
		this.trade_rec_no = trade_rec_no;
		this.lct_no = lct_no;
		this.mem_no = mem_no;
		this.card_corp = card_corp;
		this.catd_no = catd_no;
		this.card_owner = card_owner;
		this.trade_amt = trade_amt;
		this.trade_date = trade_date;
	}
}
