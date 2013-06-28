package com.mindofprogramming.salestaxes;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterizedOrderItemTest {
	private ProductCategory category;
	private String productName;
	private double unitPrice;
	private int orderedUnits;
	private boolean isImported;
	private double expectedPrice;

	@Parameters
	public static Collection<Object[]> testData(){
		return Arrays.asList(new Object[][]{
			{ProductCategory.Book, "a book", 12.49, 1, false,12.49},
			{ProductCategory.Food, "chocolate bar", 0.85, 1, false,0.85},
			{ProductCategory.Medical, "headache pills", 9.75, 1, false,9.75},
			{ProductCategory.Other, "music CD", 14.99, 1, false,16.49},
			{ProductCategory.Other, "perfume", 18.99, 1, false,20.89},
			{ProductCategory.Food, "a box of imported chocolates", 10.00, 1, true,10.50},
			{ProductCategory.Food, "another box of imported chocolates", 11.25, 1, true,11.85},
			{ProductCategory.Other, "imported perfume", 27.99, 1, true,32.19},
			{ProductCategory.Other, "aother imported perfume", 47.50, 1, true,54.65}
		});
	}

	public ParameterizedOrderItemTest(ProductCategory category, String productName, double unitPrice, int units, boolean imported, double expectedPrice){
		this.category = category;
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.orderedUnits = units;
		this.isImported = imported;
		this.expectedPrice = expectedPrice;
	}

	@Test
	public void testItemPrice(){
		//Setup
		OrderItem book = new OrderItem(this.category, this.productName, this.unitPrice, this.orderedUnits, this.isImported);
		System.out.print("===========");
		System.out.print(this.category + ": " + this.productName + " unitPrice: " + this.unitPrice + " units: " + this.orderedUnits + " import: " + this.isImported);
		System.out.println("============");

		//Check results - no tax should be added to the book
		assertEquals(expectedPrice, book.getTotal(), 0.009);
	}

}