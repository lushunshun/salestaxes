package com.mindofprogramming.marsrover;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class checkoutTest {
	private Checkout sut;

	@Before
	public void init(){
		sut = new Checkout();
	}

	public void testCheckoutOuputCorrectInvoice(List<OrderItem> items){
		Invoice invoice = sut.checkout(items);

		assertEquals(items.size(), invoice.getOrderItems().size());
		// ... to be continued ...

	}
}
