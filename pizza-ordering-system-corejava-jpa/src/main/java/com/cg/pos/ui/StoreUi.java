package com.cg.pos.ui;

import java.util.Scanner;

/**
 * Store Search Ui
 * 
 * @author Prakhar
 *
 */

public class StoreUi {

	@SuppressWarnings("resource")
	public static void Ui() {
		String flag = "";
		Scanner scanner = new Scanner(System.in);
		System.out.println("Press 1 to Order From a Store");
		System.out.println("Press 2 to Exit");
		do {
			flag = scanner.next();
			switch (flag) {
			case "1":
				System.out.println("PIZZA ORDERING SYSTEM");
				StoreInputUi.store();
				break;
			case "2":
				System.out.println("Succesfully Exited");
				System.exit(0);
			default:
				System.out.println("Incorrect");
				Ui();
				break;
			}

		} while (true);

	}

}
