package com.cg.pos.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.cg.pos.dto.StoreDetails;
import com.cg.pos.exceptions.PizzaException;
import com.cg.pos.utility.DBConnection;

/**
 * Dao class to fetch store name according to his user input
 * 
 * @author PRAKHAR
 *
 */

public class StoreDaoImpl implements StoreDao {
	private EntityManager manager = null;

	@Override
	public List<StoreDetails> searchStore(StoreDetails store) throws PizzaException {
		manager = DBConnection.getEntityManagerFactory().createEntityManager();
		List<StoreDetails> stores = new ArrayList<StoreDetails>();
		manager.getTransaction().begin();
		TypedQuery<StoreDetails> query = manager
				.createQuery("select  d from StoreDetails d where d.storeName=:storeName", StoreDetails.class);
		query.setParameter("storeName", store.getStoreName());
		stores = query.getResultList();
		manager.getTransaction().commit();
		manager.close();
		return stores;
//
	}

}
