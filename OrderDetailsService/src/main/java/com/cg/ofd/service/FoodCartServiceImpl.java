package com.cg.ofd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofd.bean.FoodCart;
import com.cg.ofd.bean.Item;
import com.cg.ofd.dao.FoodCartDao;
import com.cg.ofd.dao.ItemDao;

@Service
public class FoodCartServiceImpl implements FoodCartServiceInterface {

	@Autowired
	private FoodCartDao foodDao;
	
	@Autowired
	private ItemDao itemDao;

	@Override
	public FoodCart addItemToCart(FoodCart cart) {
		return this.foodDao.save(cart);
	}

	@Override
	public FoodCart increaseQuantity(int cartId) {
		return null;
		
	}

	@Override
	public FoodCart reduceQuantity(int cartId) {
		return null;
	}

	/*
	 * @Override public boolean removeItem(int cartId,int itemId) {
	 * this.foodDao.deleteById(cartId,itemId);; }
	 */

	@Override
	public boolean clearCart(int cartId) {
		this.foodDao.deleteById(cartId);
		return true;
	}

	@Override
	public List<Item> getAllItemsByCartIdItemId(int CartId, int itemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FoodCart> viewCart() {
		return this.foodDao.findAll();
	}

	@Override
	public FoodCart getCartById(Integer cartId) {
		return this.foodDao.findAll().stream().filter(x-> cartId.equals(x.getCartId())).findAny().orElse(null);
	}

	@Override
	public FoodCart getCartByItemId(Integer itemId) {
		return this.foodDao.findAll().stream().filter(x-> itemId.equals(x.getItemList())).findAny().orElse(null);
	}

	@Override
	public FoodCart findCart(Integer cartId) {
		return this.foodDao.findAll().stream().filter(x-> cartId.equals(x.getCartId())).findAny().orElse(null);

	}

	@Override
	public void removeItem(int cartId) {
		this.foodDao.deleteById(cartId);
	}

	
//
//	@Override
//	public List<Item> getAllItemsByCartIdItemId(int cartId, int itemId) {
//		Item items = new Item();
//		items.setItem(foodDao.getAllItemsByCartIdItemId(cartId, itemId));
//		if(items.getItems().isEmpty()) {
//			return null;
//		}
//		return (List<Item>) items;
//	}

}
