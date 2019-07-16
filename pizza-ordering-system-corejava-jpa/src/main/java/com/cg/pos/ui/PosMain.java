package com.cg.pos.ui;

import java.util.Scanner;

import com.cg.pos.dto.CustomerDetails;
import com.cg.pos.exceptions.PizzaException;
import com.cg.pos.service.CustomerService;
import com.cg.pos.service.impl.CustomerServiceImpl;

/**
 * welcome page of pos
 * 
 * @author prakhar
 *
 */
public class PosMain {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Enter your Customer Id");
			String custId = scanner.next();
			CustomerDetails customerDetails = new CustomerDetails();
			customerDetails.setCustomerId(custId);
			CustomerService customer = new CustomerServiceImpl();
			try {
				customerDetails = customer.ViewCustomer(customerDetails);
				System.out.println("welcome " + customerDetails.getCustomerName());
				StoreUi.Ui();
			} catch (PizzaException e) {
				System.out.println(e.getMessage());
			}
		} while (true);
	}

}
