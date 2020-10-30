package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.cg.ofd.bean.Address;
import com.cg.ofd.bean.Category;
import com.cg.ofd.bean.Customer;
import com.cg.ofd.bean.FoodCart;
import com.cg.ofd.bean.Item;
import com.cg.ofd.bean.OrderDetails;
import com.cg.ofd.bean.Restaurant;
import com.cg.ofd.service.FoodCartServiceImpl;
import com.cg.ofd.service.FoodCartServiceInterface;
import com.cg.ofd.service.OrderServiceImpl;
import com.cg.ofd.service.OrderServiceInterface;

public class OrderTests {

	@Test
	public void addOrderTest() {
		
		Address hoteladdress = new Address(101, "Pride", "S10Road", "Shivajinagar", "Pune", "Maharashtra", "India",
				412217);

		Address custaddress = new Address(102, "Shashikant", "Lane2", "Swargate", "Pune", "Maharashtra", "India",
				412201);

		Category cat = new Category(103, "FastFood");

		List<Restaurant> restro = new ArrayList<>();

		Restaurant r1 = new Restaurant(101, "Sahara", hoteladdress, "Tejaswi", "9011872311");

		restro.add(r1);

		List<Item> items = new ArrayList<>();
		Item item = new Item(114, "item6", cat, 2, 100, restro);
		items.add(item);

		Customer cust = new Customer(1, "Tejaswi", "Midgule", "female", 22, "9011872311", custaddress,
				"tmidgule98@gmail.com");

		FoodCart cart = new FoodCart(12, cust, items);
		
		OrderDetails orderDetails = new OrderDetails(1, "2019-12-11", "true",cart);
		OrderServiceInterface orderService = mock(OrderServiceImpl.class);
		when(orderService.addOrder(orderDetails)).thenReturn(orderDetails);
		OrderDetails ordDetails2 = orderService.addOrder(orderDetails);
		assertEquals(orderDetails, ordDetails2);
	}
	
	@Test
	public void viewOrderTest() {
		Address hoteladdress = new Address(101, "Pride", "S10Road", "Shivajinagar", "Pune", "Maharashtra", "India",
				412217);

		Address custaddress = new Address(102, "Shashikant", "Lane2", "Swargate", "Pune", "Maharashtra", "India",
				412201);

		Category cat = new Category(103, "FastFood");

		List<Restaurant> restro = new ArrayList<>();

		Restaurant r1 = new Restaurant(101, "Sahara", hoteladdress, "Tejaswi", "9011872311");

		restro.add(r1);

		List<Item> items = new ArrayList<>();
		Item item = new Item(114, "item6", cat, 2, 100, restro);
		items.add(item);

		Customer cust = new Customer(1, "Tejaswi", "Midgule", "female", 22, "9011872311", custaddress,
				"tmidgule98@gmail.com");

		FoodCart cart = new FoodCart(12, cust, items);
		OrderDetails orderDetails = new OrderDetails(1, "2019-12-11", "true",cart);
		OrderServiceInterface orderService = mock(OrderServiceImpl.class);
		when(orderService.findOrder(1)).thenReturn(orderDetails);
		OrderDetails ordDetails2 = orderService.findOrder(1);
		assertEquals("true", orderDetails.getOrderStatus());
	}
	


}
