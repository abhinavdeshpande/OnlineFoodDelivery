package com.cg.ofd.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FoodCart {
	
	@Id
	@SequenceGenerator(name = "cart_id_sequence", initialValue = 2000, allocationSize = 1)
	@GeneratedValue(generator = "cart_id_sequence", strategy = GenerationType.SEQUENCE)
	private int cartId;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "customerID")
	private Customer customer;

	
	@OneToMany(targetEntity = Item.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "cartId_FK",referencedColumnName = "cartId")
	private List<Item> itemList;
	
	
}
