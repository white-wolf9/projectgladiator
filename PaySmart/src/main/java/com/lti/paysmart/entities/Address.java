package com.lti.paysmart.entities;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_PROJ_ADDRESS")
public class Address {

	@Id
	@GeneratedValue
	@Column(name = "ADDRESS_ID")
	private long address_id;
	private String city;
	private long pincode;
	private String street;
	private String doorNo;

	@OneToOne
	@JoinColumn(name = "U_ID")
	private User user;
	
}
