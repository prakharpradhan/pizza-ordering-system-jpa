package com.cg.pos.service.impl;

import java.sql.SQLException;

import com.cg.pos.dao.CustomerDao;
import com.cg.pos.dao.CustomerDaoImpl;
import com.cg.pos.dto.CustomerDetails;
import com.cg.pos.exceptions.PizzaException;
import com.cg.pos.service.CustomerService;
import com.cg.pos.utility.CustomerValidator;
import com.cg.pos.utility.ExceptionMessage;
/**
 * Customer service class
 * @author Prakhar
 *
 */


public class CustomerServiceImpl implements CustomerService {
	/**
	 * fetching customer data
	 * 
	 * @throws SQLException
	 */
	@Override
	public CustomerDetails ViewCustomer(CustomerDetails customerDetails) throws PizzaException{
		CustomerValidator customerValidator= new CustomerValidator();
		customerValidator.IdValidation((customerDetails.getCustomerId()));
		CustomerDao customerDao= new CustomerDaoImpl(); 
		CustomerDetails cust =new CustomerDetails();
		cust=customerDao.viewCustomerDetails(customerDetails);
		if(cust.getCustomerId()==null) {
			throw new PizzaException(ExceptionMessage.MESSAGE3);
		}
		return cust;
	}

}
