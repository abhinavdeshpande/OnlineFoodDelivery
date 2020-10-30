package com.cg.ofd.service;

import java.util.List;
import java.util.Optional;

import com.cg.ofd.bean.Customer;
import com.cg.ofd.bean.OrderDetails;
import com.cg.ofd.bean.Restaurant;

public interface OrderServiceInterface {
	public OrderDetails addOrder(OrderDetails order);
	public OrderDetails updateOrder(OrderDetails order);
	public void removeOrder(int order);
	public List<OrderDetails> viewOrder();
	public List<OrderDetails> viewAllOrders(Restaurant res);
	public List<OrderDetails> viewAllOrders(Customer customer);
	public OrderDetails findOrder(Integer orderId);
}
