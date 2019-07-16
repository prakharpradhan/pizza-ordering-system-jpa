package com.cg.pos.ui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cg.pos.dto.PizzaDetails;
import com.cg.pos.dto.StoreDetails;
import com.cg.pos.exceptions.PizzaException;
import com.cg.pos.service.PizzaService;
import com.cg.pos.service.StoreService;
import com.cg.pos.service.impl.PizzaServiceimpl;
import com.cg.pos.service.impl.StoreServiceimpl;

/**
 * Ui for Store Selection
 * 
 * @author Prakhar
 *
 */
public class StoreInputUi {
	@SuppressWarnings("resource")
	public static void store() {
		String flag = "";
		String storeName = "";
		Scanner scanner = new Scanner(System.in);
		StoreService storeService = null;
		PizzaService pizzaService = null;

		do {
			System.out.println("Press 1 To Search Store By Name");

			System.out.println("Press 2 To Exit");
			flag = scanner.next();
			switch (flag) {

			case "1":
				for (int i = 1; i <= 3; i++) {
					System.out.println("Please Enter The Store Name");
					storeName = scanner.next();
					StoreDetails store = new StoreDetails();
					store.setStoreName(storeName);
					List<?> str = new ArrayList<StoreDetails>();
					try {
						try {
							if (null == storeService) {
								storeService = new StoreServiceimpl();
							}
							str = storeService.viewStoreDetails(store);
						} catch (SQLException e1) {

							System.out.println(e1.getMessage());
						}
						System.out.println(str.toString());

						System.out.println("********AVAILABLE PIZZA IN THIS STORE ARE*********");
						List<?> pizzalist = null;
						pizzalist = new ArrayList<PizzaDetails>();
						if (null == pizzaService) {
							pizzaService = new PizzaServiceimpl();
						}
						pizzalist = pizzaService.viewPizza(store);
						pizzalist.forEach(value -> System.out.print(value));
						AddToCartUi.cart(storeName);
					} catch (PizzaException e) {
						System.out.println(e.getMessage());
					}

				}
				break;

			case "2":
				System.exit(0);
			default:
				System.out.println("Incorrect Input");

				break;
			}

		} while (true);
	}
}
