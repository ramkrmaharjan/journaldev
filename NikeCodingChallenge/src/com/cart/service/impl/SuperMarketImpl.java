package com.cart.service.impl;

/**
 *  Service Class for business operation.
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

import com.cart.businessrule.ProductSetRule;
import com.cart.model.Product;
import com.cart.model.ProductList;
import com.cart.service.Supermarket;

public class SuperMarketImpl implements Supermarket {

	private Set<String> itemsSet = new HashSet<String>();

	private HashMap<Product, Integer> productList = new HashMap<Product, Integer>();

	public SuperMarketImpl() {
		// Initialization of Product Set/Stock.
		ProductSetRule.setProductSet();
	}

	@Override
	public int checkOut(String items) {
		int totalVal = 0;
		char[] charArray = items.toCharArray();
		/*
		 * Logic A: Logic for counting the number of particular items and
		 * storing in hashmap
		 */
		for (char c : charArray) {
			boolean isAdded = itemsSet.add(String.valueOf(c));
			if (!isAdded) {
				// If already exists in Map then increment count */
				Product p = getProduct(c);
				int count = productList.get(p);
				productList.put(p, ++count);

			} else {
				// Adding product to Map for the first time.
				productList.put(getProduct(c), 1);
			}
		}
		/* End of Logic A: */

		/* Logic B: Logic for calculating Price */
		for (Entry<Product, Integer> entry : productList.entrySet()) {
			if (!entry.getKey().isHasSpecialRule()) {
				/*
				 * If no special rule then Just Getting Product Price and
				 * multiplying it with Total count
				 */

				totalVal = totalVal + entry.getKey().getPrice()
						* entry.getValue();
			} else {
				/*If Special rule, then let's consider following scenario 
				 * Treat 5 units of sales as same as 3 units of sales. 
				 * so if price of single unit is 50, then 
				 * 5units = 3units = $150.
				 * but, 4 units = 4*50 = $200
				 * 
				 */
				int numOfSales = entry.getKey().getNumOfUnits(); // = 5
				int countAsNum = entry.getKey().getCountAsNum(); // =3
				if (entry.getValue() < numOfSales) { 
					//For instance : total count < 5, (1...4),then simply multiply
					totalVal = totalVal + entry.getKey().getPrice()
							* entry.getValue();
				} else {
					/* But if total count > 5, suppose total count = 11;
					 * then, price would be (3+3+1)*50, since 5 units is treated same as 3 unit. 
					 */
					
					int divisor = entry.getValue() / numOfSales; // Divisor = 11/5 = 2
					int remainder = entry.getValue() % numOfSales; //Remainder = 11/5 = 1

					totalVal = totalVal + entry.getKey().getPrice() * divisor
							* countAsNum + entry.getKey().getPrice()
							* remainder;
					/* Price = totalVal+  50*2divisor*3units + 50*1remainder. */
				}
			}
		}
		/* End of Logic B */
		return totalVal;
	}

	private Product getProduct(char c) {
		/* Checks whether the ProductList contain product or not */
		for (Product p : ProductList.productList) {
			if (p.toString().equals(String.valueOf(c))) {
				return p;
			}
		}
		return null; // If product not found
	}

}
