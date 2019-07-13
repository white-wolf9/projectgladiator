package com.lti.paysmart.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_PROJ_PAYMENT")
public class Payment {

	@Id
	@GeneratedValue
	private long payment_id;
	
	@ManyToOne
	private Order order;
}
