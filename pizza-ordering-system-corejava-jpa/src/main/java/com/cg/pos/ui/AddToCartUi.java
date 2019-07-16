package com.cg.pos.ui;

import java.util.Scanner;

import com.cg.pos.dto.CartDetails;
import com.cg.pos.exceptions.PizzaException;
import com.cg.pos.service.CartService;
import com.cg.pos.service.impl.CartServiceImpl;
import com.cg.pos.utility.ItemValidator;

public class AddToCartUi {
	public static void cart(String storeName) {
		String flag = "";
		int itemId = 0;
		int qty = 0;
		ItemValidator isValid = new ItemValidator();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		CartService cart = null;
		if (null == cart) {
			cart = new CartServiceImpl();
		}
		CartDetails cartDetails = null;
		if (cartDetails == null) {
			cartDetails = new CartDetails();
		}
		System.out.println("Press 1 to Add to Cart");
		System.out.println("Press 2 to Search again");
		flag = scanner.next();

		switch (flag) {

		case "1":

			for (int i = 1; i <= 3; i++) {
				try {
					String tempItemID = "";
					System.out.println("Enter Item Id To Add to Cart");
					tempItemID = scanner.next();
					isValid.itemIdValidation(tempItemID);
					itemId = Integer.parseInt(tempItemID);
					System.out.println("Enter Quantity");
					String tempQty = scanner.next();
					isValid.qtyValidaton(tempQty);
					qty = Integer.parseInt(tempQty);
					cartDetails.setItemId(itemId);
					cartDetails.setQuantity(qty);
					int counter = cart.addToCart(cartDetails, storeName);
					if (counter != 0) {
						System.out.println(
								"Added to your cart with cart Id \n" + counter + "\n" + "Use this id for cart service");
						CartUi.cartUi();
						break;
					}
				} catch (PizzaException e) {
					System.out.println(e.getMessage());
				}
			}

		case "2":
			StoreInputUi.store();
			break;

		default:
			System.out.println("Incorrect Input");

		}
		while (true)
			;

	}
}
