package com.lti.paysmart.entities;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.lti.paysmart.enums.EMITypes;

@Entity
@Table(name = "TBL_PROJ_ORDER")
public class Order {

	@Id
	@GeneratedValue
	private long order_id;
	private Date order_date;
	private EMITypes emi_scheme;
	
	@OneToOne(mappedBy = "order",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Product product;
	
	@ManyToOne
	private User user;
	
	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Payment> payment;
	
	
}
