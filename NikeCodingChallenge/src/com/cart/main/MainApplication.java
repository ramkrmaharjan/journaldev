package com.cart.main;

import com.cart.service.Supermarket;
import com.cart.service.impl.SuperMarketImpl;

/**
 * Main Class for testing.
 * @author ishwor
 *
 */
public class MainApplication {

	public static void main(String[] args) {
		Supermarket market = new SuperMarketImpl();

		int totalPrice = market.checkOut("ABBACBBABBBBB");
		// int totalPrice = market.checkOut("ABBACBBAB");
		System.out.println("Total Price is: $" + totalPrice);

	}
}
