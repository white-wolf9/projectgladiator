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

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(long phone_no) {
		this.phone_no = phone_no;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public BankDetails getBank() {
		return bank;
	}

	public void setBank(BankDetails bank) {
		this.bank = bank;
	}

	public Credential getCredential() {
		return credential;
	}

	public void setCredential(Credential credential) {
		this.credential = credential;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Order> getOrder() {
		return order;
	}

	public void setOrder(Set<Order> order) {
		this.order = order;
	}
	
	

}
