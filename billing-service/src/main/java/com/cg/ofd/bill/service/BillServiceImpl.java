/**
 * 
 */
package com.cg.ofd.bill.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofd.bill.dao.BillRepository;
import com.cg.ofd.bill.entities.Bill;

/**
 * @author abhin
 * BillService Implementation
 * 
 */
@Service
public class BillServiceImpl implements BillService {
	
	@Autowired
	private BillRepository billRepository;

	@Override
	public Bill addBill(Bill bill) {
		System.out.println("Inside addBill() method");
		return this.billRepository.save(bill);
	}

	@Override
	public Bill updateBill(Bill bill) {
		System.out.println("Inside updateBill() method");
		return this.billRepository.save(bill);
	}

	@Override
	public void removeBill(int billId) {
		System.out.println("Inside removeBill() method");
		billRepository.deleteById(billId);
	}

	/*
	 * @Override public Bill viewBill(Bill bill) {
	 * System.out.println("Inside viewBill() method"); return null; }
	 * 
	 * @Override public List<Bill> viewBills(LocalDate startDate, LocalDate endDate)
	 * { // TODO Auto-generated method stub return null; }
	 * 
	 * @Override public List<Bill> viewBills(String custId) { // TODO Auto-generated
	 * method stub return null; }
	 */

	@Override
	public List<Bill> viewAllBills() {
		System.out.println("Inside ViewAllBills() method");
		return billRepository.findAll();
	}

	@Override
	public double calculateTotalCost() {
		return 0;
	}

}
