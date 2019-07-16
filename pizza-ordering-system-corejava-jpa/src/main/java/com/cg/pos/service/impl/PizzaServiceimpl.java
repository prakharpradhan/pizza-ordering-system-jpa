package com.cg.pos.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cg.pos.dao.PizzaDao;
import com.cg.pos.dao.PizzaDaoImpl;
import com.cg.pos.dto.PizzaDetails;
import com.cg.pos.dto.StoreDetails;
import com.cg.pos.exceptions.PizzaException;
import com.cg.pos.service.PizzaService;;;

/**
 * class to View pizza in a store
 * 
 * @author prakhar
 *
 */
public class PizzaServiceimpl implements PizzaService {

	@Override
	/*
	 * method to show pizza details of a store
	 * 
	 */
	public List<PizzaDetails> viewPizza(StoreDetails store) throws PizzaException {

		PizzaDao pizza = new PizzaDaoImpl();
		List<PizzaDetails> pizzalist = null;
		pizzalist = new ArrayList<PizzaDetails>();
		pizzalist = pizza.getPizzaDetails(store);
		return pizzalist;

	}

	@Override
	public ArrayList<PizzaDetails> modifyName(int id, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PizzaDetails> modifyQuantity(int id, int quantity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PizzaDetails> modifyCost(int id, double cost) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String modifyAddOns(int id, String addOns) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PizzaDetails> deletePizzaDetails(int pizzaId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String add(PizzaDetails pizza) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<StoreDetails> initStore() {
		// TODO Auto-generated method stub
		return null;
	}

}
