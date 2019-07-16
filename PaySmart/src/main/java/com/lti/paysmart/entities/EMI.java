package com.lti.paysmart.entities;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.lti.paysmart.enums.EMITypes;

@Entity
@Table(name = "TBL_PROJ_EMI")
public class EMI {

	@Id
	@GeneratedValue
	@Column(name = "emi_id")
	private int emi_id;
	@Enumerated(EnumType.STRING)
	private EMITypes emi_type;
	private double emi_value;
	private boolean zero_emi;
	
	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID")
	private Product product;

	public int getEmi_id() {
		return emi_id;
	}

	public void setEmi_id(int emi_id) {
		this.emi_id = emi_id;
	}

	public EMITypes getEmi_type() {
		return emi_type;
	}

	public void setEmi_type(EMITypes emi_type) {
		this.emi_type = emi_type;
	}

	public double getEmi_value() {
		return emi_value;
	}

	public void setEmi_value(double emi_value) {
		this.emi_value = emi_value;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public boolean isZero_emi() {
		return zero_emi;
	}

	public void setZero_emi(boolean zero_emi) {
		this.zero_emi = zero_emi;
	}
	
	
	
}
