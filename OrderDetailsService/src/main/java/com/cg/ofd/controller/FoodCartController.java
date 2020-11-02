package com.cg.ofd.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofd.bean.Customer;
import com.cg.ofd.bean.FoodCart;
import com.cg.ofd.bean.Items;
import com.cg.ofd.exception.OrderNotFoundException;
import com.cg.ofd.feignproxy.CustomerServiceProxy;
import com.cg.ofd.feignproxy.ItemServiceProxy;
import com.cg.ofd.service.FoodCartServiceInterface;

@RestController
@RequestMapping("/foodCart")
@RibbonClient(name = "Order-microservice")
public class FoodCartController {

	@Autowired
	FoodCartServiceInterface foodCartservice;
	
	 @Autowired CustomerServiceProxy cProxy;
	

	@Autowired
	ItemServiceProxy iProxy;

	private static final Logger logger = LoggerFactory.getLogger(FoodCartController.class);

	@PostMapping("/addItemsToCart/{customerId}/{itemName}")
	public void addItemToCart(@RequestBody FoodCart cart, @PathVariable int customerId,@PathVariable String itemName) {
		logger.info("Inside addItemToCart() method of OrderController");


		 Customer cust = this.cProxy.getCustomerById(customerId);
		 cart.setCustomer(cust);
		 System.out.println(cart);

		List<Items> itList = this.iProxy.findItemsByName(itemName);

		cart.setItemList(itList);
		
		
		System.out.println(cart);
		this.foodCartservice.addItemToCart(cart);

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

	@DeleteMapping("/deleteCartByItemid/{cartId}/{itemId}")
	public void deleteItemByItemId(@PathVariable int cartId, @PathVariable int itemId) {
		logger.info("Inside deleteCartByItemId(cartId) method of OrderController");
		FoodCart cart = foodCartservice.getCartById(cartId);
		List<Items> itList = cart.getItemList();
		for (Items item : itList) {
			if (item.getItemId() == itemId) {
				foodCartservice.removeItem(cartId);
			}
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

	@GetMapping("/viewCartByCartId/{cartId}")
	public FoodCart viewCartByCartId(@PathVariable int cartId) {
		logger.info("Inside findNearByRestaurant() method of RestaurantController");
		FoodCart fc = this.foodCartservice.getCartById(cartId);
		if (fc == null) {
			throw new OrderNotFoundException("restaurant in area" + cartId + " not found");
		} else
			return fc;
	}

	/*
	 * @GetMapping("/viewCartByCustId/{customerId}") public List<FoodCart>
	 * viewCartByCust(@PathVariable int customerId) {
	 * logger.info("Inside findNearByRestaurant() method of RestaurantController");
	 * Customer cust = this.cProxy.getCustomerById(customerId); List<FoodCart> fc =
	 * this.foodCartservice.viewCartByCustId(customerId); if (fc.isEmpty()) { throw
	 * new OrderNotFoundException("restaurant in area" + customerId + " not found");
	 * } else return fc; }
	 */

	@PutMapping("/increaseQuantity/{cartId}/{itemId}/{quantity}")
	public FoodCart increaseQuantity(@PathVariable int cartId, @PathVariable int itemId, @PathVariable int quantity) {

		FoodCart cart = foodCartservice.getCartById(cartId);
		List<Items> itList = cart.getItemList();
		for (Items item : itList) {
			if (item.getItemId() == itemId) {
				int temp = item.getQuantity() + quantity;
				item.setQuantity(temp);
			}
		}
		cart.setItemList(itList);
		foodCartservice.increaseQuantity(cart);
		return cart;
	}

	@PutMapping("/decreaseQuantity/{cartId}/{itemId}/{quantity}")
	public FoodCart decreaseQuantity(@PathVariable int cartId, @PathVariable int itemId, @PathVariable int quantity) {

		FoodCart cart = foodCartservice.getCartById(cartId);
		List<Items> itList = cart.getItemList();
		for (Items item : itList) {
			if (item.getItemId() == itemId) {
				int temp = item.getQuantity() - quantity;
				item.setQuantity(temp);
			}
		}
		cart.setItemList(itList);
		foodCartservice.reduceQuantity(cart);
		return cart;
	}

}
