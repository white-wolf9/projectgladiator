package com.lti.paysmart.entities;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.lti.paysmart.enums.EMITypes;

@Entity
@Table(name = "TBL_PROJ_EMI")
public class EMI {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqid-gen")
	@SequenceGenerator(name = "seqid-gen", sequenceName = "RTDS_ADSINPUT_SEQ" )
	@Column(name = "emi_id")
	private int emi_id;
	@Enumerated(EnumType.STRING)
	private EMITypes emi_type;
	private double emi_value_gold;
	private double emi_value_titanium;
	
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

	public double getEmi_value_gold() {
		return emi_value_gold;
	}

	public void setEmi_value_gold(double emi_value_gold) {
		this.emi_value_gold = emi_value_gold;
	}

	public double getEmi_value_titanium() {
		return emi_value_titanium;
	}

	public void setEmi_value_titanium(double emi_value_titanium) {
		this.emi_value_titanium = emi_value_titanium;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	
}
