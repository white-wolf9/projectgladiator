package com.lti.paysmart.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_PROJ_PRODUCT")
public class Product {
	
	@Id
	@GeneratedValue
	private long product_id;
	private String name;
	private String description;
	private byte[] image;
	private double price;
	private int stock;
	
	@OneToMany(mappedBy = "product",fetch =FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<EMI> emi;
	
	@OneToOne
	private Order order;

}
