package com.cg.ofd.bill.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
//@Table(name = "Bill")
public class Bill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int billId;
	
	@Column
	private int orderId;
	
	@Column
	@NotNull
	@Min(value = 1)
	private int totalItem;
	
	@Column
	@NotNull
	private double totalCost;
	
	@Column
	@NotNull
	private int custId;
	
	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	@Column(name = "billDate")
	@NotNull
	private LocalDate billDate;

	/**
	 * 
	 */
	public Bill() {
		
	}

	/**
	 * @param billId
	 * @param orderId
	 * @param totalItem
	 * @param totalCost
	 * @param billDate
	 */
	public Bill(int billId, int orderId, int totalItem, double totalCost, LocalDate billDate) {
		super();
		this.billId = billId;
		this.orderId = orderId;
		this.totalItem = totalItem;
		this.totalCost = totalCost;
		this.billDate = billDate;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(int totalItem) {
		this.totalItem = totalItem;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public LocalDate getBillDate() {
		return billDate;
	}

	public void setBillDate(LocalDate billDate) {
		this.billDate = billDate;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", orderId=" + orderId + ", totalItem=" + totalItem + ", totalCost="
				+ totalCost + ", custId=" + custId + ", billDate=" + billDate + "]";
	}
	
		
}
