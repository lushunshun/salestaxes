package com.mindofprogramming.salestaxes;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class OrderItemTest {
	
	@Test
	public void testTotalPriceOfABook(){
		//Setup
		OrderItem book = new OrderItem(ProductCategory.Book, "a book", 12.49, 1, false);
		System.out.print("===========");
		System.out.print(ProductCategory.Book+ " unitPrice: " + 12.49 + " units: " + 1);
		System.out.println("============");

		//Check results - no tax should be added to the book
		assertEquals(12.49, book.getTotal(), 0.009);
	}

	@Test
	public void testTotalPriceOfAFoodProduct(){
		//Setup
		OrderItem chocolate = new OrderItem(ProductCategory.Food, "chocolate bar", 0.85, 1, false);
		System.out.print("===========");
		System.out.print(ProductCategory.Food+ " unitPrice: " + 0.85 + " units: " + 1);
		System.out.println("============");

		//check results - no taxt should be added to food
		assertEquals(0.85, chocolate.getTotal(), 0.009);
	}

	@Test
	public void testTotalPriceOfAMedicalProduct(){
		//Setup
		OrderItem medicine = new OrderItem(ProductCategory.Medical, "headache pills", 9.75, 1, false);
		System.out.print("===========");
		System.out.print(ProductCategory.Medical+ " unitPrice: " + 9.75 + " units: " + 1);
		System.out.println("============");

		assertEquals(9.75, medicine.getTotal(), 0.009);
	}

	@Test
	public void testTotalPriceOfNonTaxExemptProduct(){
		OrderItem musicCD = new OrderItem(ProductCategory.Other, "music CD", 14.99, 1, false);
		System.out.print("===========");
		System.out.print(ProductCategory.Other + " name: music CD" + "unitPrice: " + 14.99 + " units: " + 1);
		System.out.println("============");
		assertEquals(16.49, musicCD.getTotal(), 0.009);

		OrderItem perfume = new OrderItem(ProductCategory.Other, "perfume", 18.99, 1, false);
		System.out.print("===========");
		System.out.print(ProductCategory.Other + " name: perfume" + "unitPrice: " + 18.99 + " units: " + 1);
		System.out.println("============");
		assertEquals(20.89, perfume.getTotal(), 0.009);
	}
}
