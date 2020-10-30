package com.cg.ofd.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "address_id_sequence", initialValue = 529, allocationSize = 1)
	  @GeneratedValue(generator = "address_id_sequence", strategy = GenerationType.SEQUENCE)
	private int addressId;
	
	@Column(length = 20)
	private String buildingName;
	
	
	@Column(length = 20)
	private String streetNo;
	
	
	@Column(length = 20)
	private String area;
	
	
	@Column(length = 20)
	private String city;
	
	
	@Column(length = 20)
	private String state;
	
	
	@Column(length = 20)
	private String country;
	

	@Column(length = 20)
	private int pincode;
	
}
