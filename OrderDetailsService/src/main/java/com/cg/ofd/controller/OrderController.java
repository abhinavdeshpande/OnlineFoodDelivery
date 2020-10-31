package com.cg.ofd.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofd.bean.Customer;
import com.cg.ofd.bean.FoodCart;
import com.cg.ofd.bean.Item;
import com.cg.ofd.bean.OrderDetails;
import com.cg.ofd.bean.Restaurant;
import com.cg.ofd.exception.OrderNotFoundException;
import com.cg.ofd.service.FoodCartServiceImpl;
import com.cg.ofd.service.OrderServiceImpl;

import io.swagger.annotations.Api;

@Api(value = "CategoryController", description = "REST Apis related to Category Entity!!!!")

@RestController
@RequestMapping(value = "/order")
public class OrderController {

	@Autowired
	private OrderServiceImpl service;

	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	FoodCartServiceImpl foodCartservice;

	@PostMapping("/addOrder")
	public OrderDetails addOrder(@RequestBody OrderDetails order) {
		logger.info("Inside addOrder() method of OrderController");

		return this.service.addOrder(order);
		//System.out.println("Order with Order Id: " + order.getOrderId() + " added succesfully to the database!");
	}

	@PutMapping("/updateOrder")
	public OrderDetails updateOrder(@RequestBody OrderDetails order) {
		logger.info("Inside updateOrder() method of OrderController");
		OrderDetails orderDetails =this.service.findOrder(order.getOrderId());
		if(orderDetails==null)
		{
			throw new OrderNotFoundException("Order with "+order.getOrderId()+" is not not present");
		}else
		{
		return this.service.updateOrder(order);
		}
	}

	@GetMapping("/viewOrder")
	public List<OrderDetails> viewOrder() {
		logger.info("Inside viewOrder() method of OrderController");
		List<OrderDetails> orderDetails = this.service.viewOrder();
		if (orderDetails.isEmpty()) {
			throw new OrderNotFoundException("Order not found");
		} else {
			return orderDetails;
		}
	}

	@GetMapping("/viewOrderOfRestaurant")
	public List<OrderDetails> viewAllOrders(@RequestBody Restaurant res) {
		logger.info("Inside viewAllOrders(res) method of OrderController");
		List<OrderDetails> orderDetails = service.viewAllOrders(res);
		if (orderDetails.isEmpty()) {
			throw new OrderNotFoundException("Order details of restaurant not found");
		} else {
			return orderDetails;
		}

	}

	@GetMapping("/viewOrderOfCustomer")
	public List<OrderDetails> viewAllOrders(@RequestBody Customer customer) {
		logger.info("Inside viewAllOrders(customer) method of OrderController");
		List<OrderDetails> orderDetails = service.viewAllOrders(customer); 
		if (orderDetails.isEmpty()) {
			throw new OrderNotFoundException("Order details of customer not found");
		} else {
			return orderDetails;
		}
	}

	@RequestMapping(value = "/deleteOrder/{orderId}", method = RequestMethod.DELETE)
	public void removeOrder(@PathVariable Integer orderId) {
		logger.info("Inside removeOrder(orderId) method of OrderController");
		OrderDetails orderDetails = this.service.findOrder(orderId);
		if (orderDetails == null)
			throw new OrderNotFoundException("Order with order Id: " + orderId + " does not exist!!");
		else {
			this.service.removeOrder(orderId);
			System.out.println("Order with Order Id: " + orderId + " removed succesfully from the database!");
		}
	}

	// Implementation for cartService

	@PostMapping("/addItemsToCart")
	public void addItemToCart(@RequestBody FoodCart cart) {
		logger.info("Inside addItemToCart() method of OrderController");
		if (cart == null) {
			throw new OrderNotFoundException("cant add empty cart");
		} else {
			this.foodCartservice.addItemToCart(cart);
			System.out.println("Item added to Cart Succefully");
		}

	}

	@DeleteMapping("/deleteCartByid")
	public void clearCart(@RequestParam Integer cartId) {
		logger.info("Inside clearCart(cartId) method of OrderController");
		FoodCart cartDetails = this.foodCartservice.findCart(cartId);
		if (cartDetails == null)
			throw new OrderNotFoundException("Cart with cart Id: " + cartId + " does not exist!!");
		else {
			this.foodCartservice.clearCart(cartId);
			System.out.println("Order with Order Id: " + cartId + " removed succesfully from the database!");
		}
	}


	@GetMapping("/viewCart")
	public List<FoodCart> viewCart() {
		logger.info("Inside viewCart() method of OrderController");
		List<FoodCart> cartDetails = this.foodCartservice.viewCart();
		if (cartDetails.isEmpty()) {
			throw new OrderNotFoundException("Cart not found");
		} else {
			return cartDetails;
		}
	}

	@GetMapping("/cartId/itemId/quantity")
	public FoodCart increaseQuantity(@PathVariable int cartId, int itemId, int quantity) {

		FoodCart cart = foodCartservice.getCartById(cartId);
		List<Item> itList = cart.getItemList();
		for (Item item : itList) {
			if (item.getItemId() == itemId) {
				int temp = item.getQuantity() + quantity;
				item.setQuantity(temp);
			}
		}
		cart.setItemList(itList);
		foodCartservice.addItemToCart(cart);
		return cart;
	}

}
