package com.cg.pos.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cg.pos.dao.StoreDao;
import com.cg.pos.dao.StoreDaoImpl;
import com.cg.pos.dto.StoreDetails;
import com.cg.pos.exceptions.PizzaException;
import com.cg.pos.service.StoreService;
import com.cg.pos.utility.ExceptionMessage;

public class StoreServiceimpl implements StoreService {

	@Override
	public List<StoreDetails> viewStoreDetails(StoreDetails store) throws PizzaException {
		List<StoreDetails> str = new ArrayList<StoreDetails>();
		StoreDao storedao = new StoreDaoImpl();
		str = storedao.searchStore(store);
		if (str.isEmpty()) {
			throw new PizzaException(ExceptionMessage.MESSAGE5);
		}

		return str;
	}

	@Override
	public ArrayList<StoreDetails> addStoreDetails(StoreDetails storeDetailEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteStoreDetails(String storeName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String ModifyStoreName(int storeId, String storeNmae) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String ModifyStoreContact(int storeId, String storeContact) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String ModifyStoreAddress(int storeId, String storeAddress) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String ModifyOwnerName(int storeId, String ownerName) {
		// TODO Auto-generated method stub
		return null;
	}

}
