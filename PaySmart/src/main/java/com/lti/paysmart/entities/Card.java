package com.lti.paysmart.entities;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.lti.paysmart.enums.CardStatus;
import com.lti.paysmart.enums.CardTypes;


@Entity
@Table(name = "TBL_PROJ_CARD")
public class Card {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqid-gen")
	@SequenceGenerator(name = "seqid-gen", sequenceName = "RTDS_ADSINPUT_SEQ" )
	@Column(name = "CARD_ID")
	private long card_id;
	private String name;
	@Column(unique = true)
	private long card_no;
	@Enumerated(EnumType.STRING)
	private CardTypes type;
	private double card_balance;
	@Enumerated(EnumType.STRING)
	private CardStatus card_status;
	private double lifetime_credits;
	private double frozen_balance;
	
	public double getFrozen_balance() {
		return frozen_balance;
	}

	public void setFrozen_balance(double frozen_balance) {
		this.frozen_balance = frozen_balance;
	}

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

	public CardStatus getCard_status() {
		return card_status;
	}

	public void setCard_status(CardStatus card_status) {
		this.card_status = card_status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getLifetime_credits() {
		return lifetime_credits;
	}

	public void setLifetime_credits(double lifetime_credits) {
		this.lifetime_credits = lifetime_credits;
	}
	
	
}
