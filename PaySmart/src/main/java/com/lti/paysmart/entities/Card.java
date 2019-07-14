package com.lti.paysmart.entities;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.lti.paysmart.enums.CardTypes;


@Entity
@Table(name = "TBL_PROJ_CARD")
public class Card {
	
	@Id
	@GeneratedValue
	@Column(name = "CARD_ID")
	private long card_id;
	private String name;
	private long card_no;
	@Enumerated(EnumType.STRING)
	private CardTypes type;
	private double card_balance;
	private boolean card_status;
	
	@OneToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	public long getCard_id() {
		return card_id;
	}

	public void setCard_id(long card_id) {
		this.card_id = card_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCard_no() {
		return card_no;
	}

	public void setCard_no(long card_no) {
		this.card_no = card_no;
	}

	public CardTypes getType() {
		return type;
	}

	public void setType(CardTypes type) {
		this.type = type;
	}

	public double getCard_balance() {
		return card_balance;
	}

	public void setCard_balance(double card_balance) {
		this.card_balance = card_balance;
	}

	public boolean isCard_status() {
		return card_status;
	}

	public void setCard_status(boolean card_status) {
		this.card_status = card_status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
