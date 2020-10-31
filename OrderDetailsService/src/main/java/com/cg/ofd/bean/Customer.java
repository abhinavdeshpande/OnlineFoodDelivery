package com.cg.ofd.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.sun.istack.internal.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {

	@Id
	@SequenceGenerator(name = "customer_id_sequence", initialValue = 1500, allocationSize = 1)
	@GeneratedValue(generator = "customer_id_sequence", strategy = GenerationType.SEQUENCE)
	private int customerId;
	
	@NotNull
	@Column(length = 20)
	private String firstName;
	
	@NotNull
	@Column(length = 20)
	private String lastName;

	@NotNull
	@Column(length = 10)
	private String gender;

	@NotNull
	@Column(length = 3)
	private int age;

	@NotNull
	@Column(length = 10)
	private String mobileNumber;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "addressId")
	private Address address;
	
	@NotNull
	@Column(length = 20)
	private String email;
	
}
