package com.cg.ofd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofd.bean.Category;
import com.cg.ofd.bean.Items;
import com.cg.ofd.bean.Restaurant;
import com.cg.ofd.dao.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemrepo;
	
	@Override
	public Items addItem(Items item) {
		return this.itemrepo.save(item);
	}

	@Override
	public Items updateItem(Items item) {
		return this.itemrepo.save(item);
	}

	@Override
	public void removeItem(int itemId) {
		
		Items i = itemrepo.findAll().stream().filter(id->id.getItemId() == itemId).findAny().get();
		for(Restaurant r : i.getRestaurant()) {
			r.item.remove(i);
		}
		itemrepo.deleteById(itemId);
	}

	@Override
	public Optional<Items> findItem(int itemId) {
		return itemrepo.findById(itemId);
	}
	
	@Override
	public Items findOneItem(int itemId) {
		return itemrepo.findAll().stream().filter(id->id.getItemId() == itemId).findAny().get();
	}


	@Override
	public List<Items> findAllItems() {
		return itemrepo.findAll();
	}

	@Override
	public List<Items> findAllItemByName(String itemName) {
		return itemrepo.findByItemName(itemName);
	}

	@Override
	public List<Items> findAllItems(Category c) {
		return itemrepo.findAllItemsByCategory(c);
	}

	@Override
	public List<Items> findAllItems(Restaurant r) {
		return itemrepo.findAllItemsByRestaurant(r);
	}

	
}
