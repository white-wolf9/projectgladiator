package com.lti.paysmart.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.lti.paysmart.enums.EMITypes;

@Entity
@Table(name = "TBL_PROJ_ORDER")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqid-gen")
	@SequenceGenerator(name = "seqid-gen", sequenceName = "RTDS_ADSINPUT_SEQ" )
	@Column(name = "ORDER_ID")
	private long order_id;
	private Date order_date;
	@Enumerated(EnumType.STRING)
	private EMITypes emi_scheme;
	
	@OneToOne
	@JoinColumn(name = "PRODUCT_ID")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;
	
	@OneToOne
	@JoinColumn(name = "PAYMENT_ID")
	private Payment payment;

	public long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public EMITypes getEmi_scheme() {
		return emi_scheme;
	}

	public void setEmi_scheme(EMITypes emi_scheme) {
		this.emi_scheme = emi_scheme;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Date getOrder_date() {
		return order_date;
	}
	
	
}
