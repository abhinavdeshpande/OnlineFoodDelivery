package com.cg.ofd.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ofd.bean.FoodCart;
import com.cg.ofd.bean.Item;
import com.cg.ofd.bean.OrderDetails;

@Repository
public interface OrderDao extends JpaRepository<OrderDetails, Integer> {


}
