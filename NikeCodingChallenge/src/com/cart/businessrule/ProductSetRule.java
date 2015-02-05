package com.cart.businessrule;

import com.cart.model.ProductList;

/**
 * This Class is used to set the business rule and add the product items. Any
 * number of items and their correspnding price is defined here.
 * 
 * It can be thought of injecting the dependency of item type(id) and price to
 * the product and maintaining the product list.
 * 
 * @author ishwor
 *
 */
public class ProductSetRule {

	public static void setProductSet() {

		// Adding Product A which has price $20
		ProductList.addProducts("A", 20);

		/*
		 * Adding Product B which has price $50 Special Rule of treating price
		 * of 5 items as price of 3 items for instance.
		 */
		ProductList.addProductsWithRule("B", 50, 5, 3);

		// Adding Product C which has price $30
		ProductList.addProducts("C", 30);
	}

}
