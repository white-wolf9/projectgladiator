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
@Table(name = "TBL_PROJ_USER")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name = "U_ID")
	private long user_id;
	private String name;
	@Column(unique = true)
	private String email;
	@Column(unique = true)
	private long phone_no;
	
	@OneToOne(mappedBy = "user",fetch =FetchType.EAGER,  cascade = CascadeType.ALL)
	private Card card;
	
	@OneToOne(mappedBy = "user",fetch =FetchType.EAGER,  cascade = CascadeType.ALL)
	private BankDetails bank;
	
	@OneToOne(mappedBy = "user",fetch =FetchType.EAGER,  cascade = CascadeType.ALL)
	private Credential credential;
	
	@OneToOne(mappedBy = "user",fetch =FetchType.EAGER,  cascade = CascadeType.ALL)
	private Address address;
	
	@OneToMany(mappedBy = "user",fetch =FetchType.EAGER,  cascade = CascadeType.ALL)
	private Set<Order> order;

}
