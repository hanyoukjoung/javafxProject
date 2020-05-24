package service.address;

import java.util.List;
import java.util.Map;

import dao.address.AddressDaoImpl;
import main.vo.AddrVO;

public class AddressServiceImpl implements IAddressService {
	private static AddressServiceImpl service;
	private static AddressDaoImpl dao;

	private AddressServiceImpl() {
		dao = AddressDaoImpl.getInstance();
	}

	public static AddressServiceImpl getInstance() {
		if (service == null) {
			service = new AddressServiceImpl();
		}
		return service;
	}

	@Override
	public List<AddrVO> getSearchAddr(Map<String, String> params) {
		return dao.getSearchAddr(params);
	}
}
