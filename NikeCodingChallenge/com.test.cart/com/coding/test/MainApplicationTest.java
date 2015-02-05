package com.coding.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.cart.checkout.RuleFactory;
import com.cart.checkout.Supermarket;

/**
 * The Class PriceRuleTest.
 */
public class MainApplicationTest {
	
	/** The market. */
	private Supermarket market;

	/**
	 * Instantiates a new price rule test.
	 */
	public MainApplicationTest() {
		market = RuleFactory.getCheckOut("priceRule");

	}

	/**
	 * Test price for total products
	 */
	@Test
	public void testPrice() {
		if (market != null)
			assertEquals("Total Price for Product", 240,
					market.checkOut("ABBACBBAB"));
	}
}
