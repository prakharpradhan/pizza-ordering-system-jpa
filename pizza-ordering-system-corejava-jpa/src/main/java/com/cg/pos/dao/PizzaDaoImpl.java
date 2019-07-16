package com.cg.pos.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.cg.pos.dto.PizzaDetails;
import com.cg.pos.dto.StoreDetails;
import com.cg.pos.exceptions.PizzaException;
import com.cg.pos.utility.DBConnection;

/**
 * Dao class to fetch PIZZA DETAILS according to his storeid
 * 
 * @author PRAKHAR
 *
 */

public class PizzaDaoImpl implements PizzaDao {
	private EntityManager manager = null;

	@Override
	public List<PizzaDetails> getPizzaDetails(StoreDetails store) throws PizzaException {
		List<PizzaDetails> pizzaList = new ArrayList<PizzaDetails>();
		manager = DBConnection.getEntityManagerFactory().createEntityManager();
		manager.getTransaction().begin();
		TypedQuery<PizzaDetails> query = manager.createQuery(
				"select p from PizzaDetails p inner join StoreDetails s on p.storeID=s.storeId where s.storeName=:storeName",
				PizzaDetails.class);
		query.setParameter("storeName", store.getStoreName());
		pizzaList = query.getResultList();
		manager.close();
		return pizzaList;
	}

}
