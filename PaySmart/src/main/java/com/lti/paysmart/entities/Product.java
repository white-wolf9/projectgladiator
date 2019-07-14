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
	@Column(name = "PRODUCT_ID")
	private long product_id;
	private String name;
	private String description;
	private byte[] image;
	private double price;
	private int stock;
	
	@OneToMany(mappedBy = "product",fetch =FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<EMI> emi;
	
	@OneToOne
	@JoinColumn(name = "ORDER_ID")
	private Order order;

	public long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Set<EMI> getEmi() {
		return emi;
	}

	public void setEmi(Set<EMI> emi) {
		this.emi = emi;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	

}
