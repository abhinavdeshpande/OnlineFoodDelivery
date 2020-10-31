package com.cg.ofd.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;

import com.sun.istack.internal.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {

	@Id
	@SequenceGenerator(name = "address_id_sequence", initialValue = 529, allocationSize = 1)
	@GeneratedValue(generator = "address_id_sequence", strategy = GenerationType.SEQUENCE)
	private int addressId;
	
	@NotNull
	@Size(min=2, message="Building Name should have atleast 2 characters")
	private String buildingName;
	
	@NotNull
	@Column(length = 20)
	private String area;
	
	@NotNull
	@Column(length = 20)
	private String streetNo;
	
	@NotNull
	@Column(length = 20)
	private String city;

	@NotNull
	@Column(length = 20)
	private String state;

	@NotNull
	@Column(length = 20)
	private String country;

	@NotNull
	@Column(length = 20)
	private int pincode;
}
