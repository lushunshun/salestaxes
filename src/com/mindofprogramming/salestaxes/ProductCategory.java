package com.mindofprogramming.salestaxes;

public enum ProductCategory {
	Book(0.0),
	Food(0.0),
	Medical(0.0),
	Other(0.1);

	private double taxRate;

	private ProductCategory(double taxRate){
		this.taxRate = taxRate;
	}

	public double getTaxRate(){
		return this.taxRate;
	}
}