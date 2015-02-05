package com.cart.model;

import java.util.HashSet;
import java.util.Set;

/**
 * This class contains static method for creating Product List. It has two
 * methods simple methods ,one for adding products without any rule, and other
 * with rule
 * 
 * @author ishwor
 *
 */
public class ProductList {

	public static final Set<Product> productList = new HashSet<Product>();

	public static void addProducts(String id, int price) {
		Product p = new Product(id, price);
		productList.add(p);
	}

	public static void addProductsWithRule(String id, int price,
			int numOfSales, int countAsNum) {
		Product p = new Product(id, price, numOfSales, countAsNum);

		productList.add(p);
	}

}
