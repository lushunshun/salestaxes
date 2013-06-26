package com.mindofprogramming.salestaxes;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CheckoutTest {
	private Checkout sut;

	@Before
	public void init(){
		sut = new Checkout();
	}

	@Test
	public void testTotalPriceOfABook(){
		//Setup
		OrderItem book = new OrderItem(ProductCategory.Book, "a book", 12.49, false);

		//Check results - no tax should be added to the book
		assertEquals(book.getTotal(), 12.49);
	}

	public void testTotalPriceOfAFoodProduct(){
		//Setup
		OrderItem chocolate = new Orderitem(ProductCategory.Food, "chocolate bar", 0.85, 1, false);

		//check results - no taxt should be added to food
		assertEquals(chocolate.getTotal()), 0.85);
	}

	public void testTotalPriceOfAMedicalProduct(){
		//Setup
		OrderItem medicine = new OrderItem(ProductCategory.Medical, "headache pills", 9.75, 1, false);

		assertEquals(medicine.getTotal(),9.75);
	}

	public void testTotalPriceOfNonTaxExemptProduct(){
		OrderItem musicCD = new OrderItem(ProductCategory.Other, "music CD", 14.99, 1, false);
		OrderItem perfume = new OrderItem(ProductCategory.Other, "perfume", 18.99, 1, false);

		assertEquals(musicCD.getTotal(),16.49);
		assertEquals(perfume.getTotal(),20.89);
	}
}
