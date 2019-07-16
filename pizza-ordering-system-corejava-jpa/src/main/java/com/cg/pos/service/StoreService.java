package com.cg.pos.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.pos.dto.StoreDetails;
import com.cg.pos.exceptions.PizzaException;

public interface StoreService {
	/*
	 * Store Service Methods
	 */
	public ArrayList<StoreDetails> addStoreDetails(StoreDetails storeDetailEntity);

	public String deleteStoreDetails(String storeName);

	public String ModifyStoreName(int storeId, String storeNmae);

	public String ModifyStoreContact(int storeId, String storeContact);

	public String ModifyStoreAddress(int storeId, String storeAddress);

	public String ModifyOwnerName(int storeId, String ownerName);

	public List<?> viewStoreDetails(StoreDetails store) throws PizzaException, SQLException;

}
