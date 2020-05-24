package service.trade;

import dao.trade.TradeDaoImpl;

public class TradeServiceImpl implements ITradeService {
	private static TradeServiceImpl service;
	private static TradeDaoImpl dao;

	private TradeServiceImpl() {
		dao = TradeDaoImpl.getInstance();
	}

	public static TradeServiceImpl getInstance() {
		if (service == null) {
			service = new TradeServiceImpl();
		}
		return service;
	}
}
