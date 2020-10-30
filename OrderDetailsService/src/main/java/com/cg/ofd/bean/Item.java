package com.cg.ofd.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.ForeignKey;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {

	@Id
	@SequenceGenerator(name = "items_id_sequence", initialValue = 100, allocationSize = 1)
	@GeneratedValue(generator = "items_id_sequence", strategy = GenerationType.SEQUENCE)
	private int itemId;

	@NotNull
	@Size(min = 2, message = "Name should have atleast 2 characters")
	@Column(length = 20)
	private String itemName;

	@OneToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "categoryId")
	private Category category;

	@Min(value = 2, message = "min 2 digit number")
	@Column(length = 20)
	private int quantity;

	@DecimalMax("1000.0")
	@DecimalMin("0.0")
	@Column(length = 20)
	private double cost;

	@ManyToMany( cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
	@JoinTable(name = "Restro_Item", joinColumns = @JoinColumn(name="itemId"),
				inverseJoinColumns = @JoinColumn(name="restaurantId"))
	List<Restaurant> restaurants;

	public Item(int itemId, @Size(min = 2, message = "Name should have atleast 2 characters") String itemName,
			Category category, @Min(value = 2, message = "min 2 digit number") int quantity,
			@DecimalMax("1000.0") @DecimalMin("0.0") double cost) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.category = category;
		this.quantity = quantity;
		this.cost = cost;
	}
}
