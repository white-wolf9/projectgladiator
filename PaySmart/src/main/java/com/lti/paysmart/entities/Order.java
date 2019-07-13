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

	public long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}

	public Date getOrder_date() {
		return order_date;
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

	public Set<Payment> getPayment() {
		return payment;
	}

	public void setPayment(Set<Payment> payment) {
		this.payment = payment;
	}
	
	
	
}
