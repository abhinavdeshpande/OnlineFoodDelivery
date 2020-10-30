package com.cg.ofd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofd.bean.Customer;
import com.cg.ofd.bean.OrderDetails;
import com.cg.ofd.bean.Restaurant;
import com.cg.ofd.dao.OrderDao;

@Service
public class OrderServiceImpl implements OrderServiceInterface {

	@Autowired
	private OrderDao orderDao;

	@Override
	public OrderDetails addOrder(OrderDetails order) {
		return this.orderDao.save(order);
		
	}

	@Override
	public OrderDetails updateOrder(OrderDetails order) {
		return this.orderDao.save(order);
	}

	@Override
	public List<OrderDetails> viewOrder() {
		return this.orderDao.findAll();
	}

	@Override
	public List<OrderDetails> viewAllOrders(Restaurant res) {
		return this.orderDao.findAll();
	}

	@Override
	public List<OrderDetails> viewAllOrders(Customer customer) {
		return this.orderDao.findAll();
	}

	@Override
	public void removeOrder(int orderId) {
		this.orderDao.deleteById(orderId);
	}

	@Override
	public OrderDetails findOrder(Integer orderId) {
		return this.orderDao.findAll().stream().filter(x-> orderId.equals(x.getOrderId())).findAny().orElse(null);
	}

}
