package com.lti.paysmart.entities;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	private EMITypes emi_type;
	private double emi_value;
	
	@ManyToOne
	private Product product;
	
	
}
