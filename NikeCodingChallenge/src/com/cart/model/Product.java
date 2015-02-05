package com.cart.model;

/**
 * Product Pojo Class
 * 
 * @author ishwor
 *
 */
public class Product {

	private String id;

	private int price;

	/*
	 * numOfUnits and countAsNum works together, It is for identifying how the
	 * numofUnits be considered while calculating price. For instance. if 5 num
	 * of units is sold, then it is equal to price of 3 items for encouraging
	 * mass selling. So. in that case, numofUnits = 5 and countAsNum = 3;
	 */
	private int numOfUnits;

	private int countAsNum;

	/*
	 * True if special rule exists . Rule applies to numOfUnits and coutAsNum
	 * field
	 */
	private boolean hasSpecialRule;

	public Product() {

	}

	public Product(String id, int price) {
		this.id = id;
		this.price = price;
	}

	public Product(String id, int price, int numOfUnits, int countAsNum) {
		this.id = id;
		this.price = price;
		this.numOfUnits = numOfUnits;
		this.countAsNum = countAsNum;
		this.hasSpecialRule = true;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return id;
	}

	public int getNumOfUnits() {
		return numOfUnits;
	}

	public void setNumOfUnits(int numOfUnits) {
		this.numOfUnits = numOfUnits;
	}

	public int getCountAsNum() {
		return countAsNum;
	}

	public void setCountAsNum(int countAsNum) {
		this.countAsNum = countAsNum;
	}

	public boolean isHasSpecialRule() {
		return hasSpecialRule;
	}

	public void setHasSpecialRule(boolean hasSpecialRule) {
		this.hasSpecialRule = hasSpecialRule;
	}
}
