package com.cg.ofd.bill.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.ofd.bill.entities.OrderDetails;

@FeignClient(name = "OrderDetails-Microservice")
public interface OrderServiceProxy {
	
	@GetMapping("/findOrdersByOrderId/{orderId}")
	public OrderDetails findOrdersById(@PathVariable int orderId);
	
	@GetMapping("/findOrderByCust/{customerId}")
	public List<OrderDetails> findOrdersByCustomer(@PathVariable int customerId);

}
