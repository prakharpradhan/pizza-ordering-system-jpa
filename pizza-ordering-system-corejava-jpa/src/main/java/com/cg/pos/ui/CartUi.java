package com.cg.pos.ui;

import java.util.Scanner;

import com.cg.pos.dto.CartDetails;
import com.cg.pos.dto.OrderDetails;
import com.cg.pos.exceptions.PizzaException;
import com.cg.pos.service.CartService;
import com.cg.pos.service.impl.CartServiceImpl;
import com.cg.pos.utility.CartValidator;
import com.cg.pos.utility.CustomerValidator;

public class CartUi {

	public static void cartUi() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		OrderDetails orderDetails = null;
		do {
			String counter = "";
			System.out.println("******************Cart Opertaion*****************");
			System.out.println("Enter 1 to view your cart");
			System.out.println("Enter 2 to Delete Cart");
			System.out.println("Enter 3 to add More");
			System.out.println("Enter 4 to confirm order");
			System.out.println("Enter 5 to Go back to Login");
			counter = scanner.next();
			String tempCartID = "";

			boolean valid = false;
			CartValidator cartValidator = null;
			if (null == cartValidator) {
				cartValidator = new CartValidator();
			}
			CartService cart = null;
			if (null == cart) {
				cart = new CartServiceImpl();
			}
			switch (counter) {
			case "1":
				System.out.println("Enter your Cart id");
				try {
					tempCartID = scanner.next();

					valid = cartValidator.isCartIdValid(tempCartID);
				} catch (PizzaException e) {

					System.out.println(e.getMessage());
				}
				if (valid) {
					int cartId = Integer.parseInt(tempCartID);
					try {
						CartDetails cartDetails = null;
						cartDetails = cart.viewCart(cartId);
						System.out.println("Your Cart is \n" + cartDetails);
					} catch (PizzaException e) {
						System.out.println(e.getMessage());
					}

				}
				break;
			case "2":
				System.out.println("Enter your Cart id");
				try {
					tempCartID = scanner.next();

					valid = cartValidator.isCartIdValid(tempCartID);
				} catch (PizzaException e) {

					System.out.println(e.getMessage());
				}
				if (valid) {
					int cartId = Integer.parseInt(tempCartID);
					try {
						cart.deleteCart(cartId);
						System.out.println("Suceesfully done");
					} catch (PizzaException e) {

						System.out.println(e.getMessage());
					}

				}
				break;

			case "3":
				System.out.println("Enter your Cart id");
				try {
					tempCartID = scanner.next();

					valid = cartValidator.isCartIdValid(tempCartID);
				} catch (PizzaException e) {

					System.out.println(e.getMessage());
				}
				if (valid) {
					int cartId = Integer.parseInt(tempCartID);
					try {
						System.out.println("Enter Quantity");
						String tempQty = scanner.next();
						int qty = Integer.parseInt(tempQty);

						cart.addMore(cartId, qty);
						System.out.println("Suceesfully done");
					} catch (PizzaException e) {
						System.out.println(e.getMessage());
					}
				}
				break;

			case "4":
				if (orderDetails == null) {
					orderDetails = new OrderDetails();
				}
				System.out.println("Enter your Cart id");
				try {
					tempCartID = scanner.next();

					valid = cartValidator.isCartIdValid(tempCartID);
				} catch (PizzaException e) {

					System.out.println(e.getMessage());
				}
				if (valid) {
					int cartId = Integer.parseInt(tempCartID);
					try {
						System.out.println("Please enter your customer id to confirm ");
						String custId = scanner.next();
						CustomerValidator customerValidator = new CustomerValidator();
						customerValidator.IdValidation(custId);
						int orderId = 0;
						orderDetails.setCartId(cartId);
						orderDetails.setCustId(custId);
						orderId = cart.confirmOrder(orderDetails);
						System.out.println("YOUR ORDER IS PLACED WITH ORDER ID" + orderId);
						System.exit(0);
					} catch (PizzaException e) {

						System.out.println(e.getMessage());
					}
				}
				break;
			case "5": {
				PosMain.main(null);
				break;
			}

			default:

				System.out.println("invalid input ");

			}

		} while (true);
	}
}
