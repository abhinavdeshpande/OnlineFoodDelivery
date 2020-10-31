package com.cg.ofd.bean;

import java.util.Date;
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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.internal.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderDetails {

	@Id
	@SequenceGenerator(name = "order_id_sequence", initialValue = 2500, allocationSize = 1)
	@GeneratedValue(generator = "order_id_sequence", strategy = GenerationType.SEQUENCE)
	private int orderId;
	
	@JsonFormat(pattern = "yyyy-mm-dd")
	private String orderDate;
	
	@NotNull
	@Column(length = 20)
	private String orderStatus;

	@OneToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "cartId")
	private FoodCart foodCart;

	
	
}
