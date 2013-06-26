package com.mindofprogramming.salestaxes;

public class OrderItem {
	private ProductCategory category;
	private String productName;
	private double unitPrice;
	private int orderedUnits;
	private boolean isImported

	public OrderItem(ProductCategory category, String name, double unitPrice, int units, boolean isImported){
		this.category = category;
		this.productName = name;
		this.unitPrice = unitPrice;
		this.orderedUnits = units;
	}


	
	public double getTotal(){
		//total has to be rounded to the nearest 0.05
		double preTaxPrice = this.unitPrice * this.orderedUnits;

		double taxDue = preTaxPrice * 100 * this.category.getBasicTaxRate;
	}
}