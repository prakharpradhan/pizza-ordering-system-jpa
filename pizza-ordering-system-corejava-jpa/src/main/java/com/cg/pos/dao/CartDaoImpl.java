package com.cg.pos.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.cg.pos.dto.CartDetails;
import com.cg.pos.dto.CustomerDetails;
import com.cg.pos.dto.OrderDetails;
import com.cg.pos.dto.PizzaDetails;
import com.cg.pos.exceptions.PizzaException;
import com.cg.pos.utility.DBConnection;

/**
 * Cart database access class
 * 
 * @author Prakhar
 *
 */

public class CartDaoImpl implements CartDao {
	private EntityManager manager = null;

	@Override
	public int addToCart(CartDetails cart) throws PizzaException {
		manager = DBConnection.getEntityManagerFactory().createEntityManager();
		int item = cart.getItemId();
		manager.getTransaction().begin();
		PizzaDetails details = manager.find(PizzaDetails.class, item);
		cart.setRestCharges(details.getPrice());
		cart.setDelievryCharges(50);
		cart.setTotal((details.getPrice() + 50) * cart.getQuantity());
		manager.persist(cart);
		int id = cart.getCartId();
		manager.getTransaction().commit();
		return id;
	}

	@Override
	public int checkDb(int itemId, String storeName) throws PizzaException {
		List<PizzaDetails> pizza = new ArrayList<PizzaDetails>();
		manager = DBConnection.getEntityManagerFactory().createEntityManager();
		manager.getTransaction().begin();
		javax.persistence.Query query = manager.createNamedQuery("getPizza");
		query.setParameter(1, storeName);
		pizza = query.getResultList();
		int result = pizza.get(0).getItemId();
		return result;
	}

	@Override
	public CartDetails viewCart(int cartId) throws PizzaException {

		manager = DBConnection.getEntityManagerFactory().createEntityManager();
		manager.getTransaction().begin();
		CartDetails details = manager.find(CartDetails.class, cartId);
		return details;
	}

	@Override
	public int deleteCart(int cartId) throws PizzaException {
		manager = DBConnection.getEntityManagerFactory().createEntityManager();
		manager.getTransaction().begin();
		CartDetails details = manager.find(CartDetails.class, cartId);
		if (details == null) {
			return 1;
		}
		manager.remove(details);
		manager.getTransaction().commit();
		return 0;
	}

	@Override
	public int updateCart(int cartId, int qty) throws PizzaException {
		manager = DBConnection.getEntityManagerFactory().createEntityManager();
		manager.getTransaction().begin();
		CartDetails details = manager.find(CartDetails.class, cartId);
		if (details == null) {
			return 0;
		}
		double price = details.getRestCharges();
		details.setRestCharges(price * qty);
		details.setQuantity(qty);
		details.setTotal(details.getDelievryCharges() + details.getRestCharges());
		manager.getTransaction().commit();
		return 1;
	}

	@Override
	public int addOrder(OrderDetails orderDetails) throws PizzaException {
		manager = DBConnection.getEntityManagerFactory().createEntityManager();
		manager.getTransaction().begin();
		CustomerDetails customerDetails = manager.find(CustomerDetails.class, orderDetails.getCustId());
		CartDetails cartDetails = manager.find(CartDetails.class, orderDetails.getCartId());
		if (customerDetails != null && cartDetails != null) {
			manager.persist(orderDetails);
			manager.getTransaction().commit();
			return orderDetails.getOrderId();

		}
		return 0;

	}

}