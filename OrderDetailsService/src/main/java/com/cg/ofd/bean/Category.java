package com.cg.ofd.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
public class Category {

	@Id
	@SequenceGenerator(name = "category_id_sequence", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "category_id_sequence", strategy = GenerationType.SEQUENCE)
	private int catId;

	@NotNull
	@Size(min=2, message="Name should have atleast 2 characters")
	@Column(length=20)
	private String categoryName;

}
