package com.cg.pos.dao;

import javax.persistence.EntityManager;

import com.cg.pos.dto.CustomerDetails;
import com.cg.pos.exceptions.PizzaException;
import com.cg.pos.utility.DBConnection;
import com.cg.pos.utility.ExceptionMessage;

/**
 * Dao class to fetch customer name according to his id
 * 
 * @author PRAKHAR
 *
 */

public class CustomerDaoImpl implements CustomerDao {
	/**
	 * method to fetch from dao
	 */
	private EntityManager manager = null;

	@Override
	public CustomerDetails viewCustomerDetails(CustomerDetails customerDetails) throws PizzaException {
		manager = DBConnection.getEntityManagerFactory().createEntityManager();
		manager.getTransaction().begin();
		CustomerDetails customer = manager.find(CustomerDetails.class, customerDetails.getCustomerId());
		if (customer == null) {
			throw new PizzaException(ExceptionMessage.MESSAGE11);
		}
		manager.close();
		return customer;
	}
}