package com.cg.ofd.service;

import java.util.List;

import com.cg.ofd.bean.FoodCart;

import com.cg.ofd.bean.Item;
import com.cg.ofd.bean.OrderDetails;


public interface FoodCartServiceInterface {
	public FoodCart addItemToCart(FoodCart cart);
	public FoodCart increaseQuantity(int cartId);
	public FoodCart reduceQuantity(FoodCart cart,Item item,int quantity);
	public boolean removeItem(int cartId,int itemId);
	public void clearCart(int cartId);
	public List<Item> getAllItemsByCartIdItemId(int CartId, int itemId);
	public List<FoodCart> viewCart();
	public FoodCart getCartById(Integer cartId);
	public FoodCart getCartByItemId(Integer itemId);
	public FoodCart findCart(Integer cartId);
}
