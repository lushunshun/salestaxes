package com.mindofprogramming.salestaxes;

public class OrderItem {
	private static double IMPORT_TAX = 0.05;

	private ProductCategory category;
	private String productName;
	private double unitPrice;
	private int orderedUnits;
	private boolean isImported;

	public OrderItem(ProductCategory category, String name, double unitPrice, int units, boolean isImported){
		this.category = category;
		this.productName = name;
		this.unitPrice = unitPrice;
		this.orderedUnits = units;
		this.isImported = isImported;
	}

	public double getTax(){
		//total has to be rounded to the nearest 0.05
		double preTaxPrice = this.unitPrice * this.orderedUnits;
		System.out.println("Pre-Tax Price: " + preTaxPrice);

		double taxDue = preTaxPrice * 100 * this.getTaxRate();
		System.out.println("Tax due in pence (not rounded): " + taxDue);

		int roundedTax = (int)(Math.round(taxDue));
		System.out.println("Tax in pence (rounded): " + roundedTax);
		if(roundedTax % 5 > 0){
			roundedTax = ((roundedTax / 5) + 1) * 5;
			System.out.println("Tax rounded to nearest 5p: " + roundedTax);
		}

		return (double) roundedTax / 100;
	}

	/**
	 * A much simpler algo to get the number to the nearest 0.05. Thanks to StackOverflow.
	 * Ref: http://stackoverflow.com/questions/6330852/round-off-decimal-value-up-to-nearest-0-05-value
	 */
	public double getTax2(){
		double preTaxPrice = this.unitPrice * this.orderedUnits;
		System.out.println("Pre-Tax Price: " + preTaxPrice);
		double taxDue = preTaxPrice * this.getTaxRate();
		System.out.println("Tax due in pence (not rounded): " + taxDue);

		double roundedTax = Math.ceil(taxDue * 20) / 20;
		System.out.println("Tax in pence (rounded): " + roundedTax);
		return roundedTax;
	}

	private double getTaxRate(){
		return this.isImported ? this.category.getTaxRate() + IMPORT_TAX : this.category.getTaxRate();
	}

	public double getTotal(){
		double tax = getTax2();
		System.out.println("Tax to pay: " + tax);
		double pence = (this.unitPrice * this.orderedUnits + tax) * 100;
		System.out.println("Total in pence: " + pence);
		int roundedPence = (int) Math.round(pence);
		System.out.println("Total in pence (rounded): " + roundedPence);
		return (double) roundedPence / 100;
	}
}