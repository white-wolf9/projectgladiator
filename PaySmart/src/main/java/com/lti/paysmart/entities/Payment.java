package com.lti.paysmart.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_PROJ_PAYMENT")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqid-gen")
	@SequenceGenerator(name = "seqid-gen", sequenceName = "RTDS_ADSINPUT_SEQ" )
	@Column(name = "PAYMENT_ID")
	private long payment_id;
	private int total_installments;
	private int paid_installments;
	private double installment_value;
	private Date last_paid_date;
	private Date next_pay_date;
	
	public Date getLast_paid_date() {
		return last_paid_date;
	}

	public void setLast_paid_date(Date last_paid_date) {
		this.last_paid_date = last_paid_date;
	}

	public Date getNext_pay_date() {
		return next_pay_date;
	}

	public void setNext_pay_date(Date next_pay_date) {
		this.next_pay_date = next_pay_date;
	}

	@OneToOne(mappedBy = "payment", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "ORDER_ID")
	private Order order;

	public long getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(long payment_id) {
		this.payment_id = payment_id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public int getTotal_installments() {
		return total_installments;
	}

	public void setTotal_installments(int total_installments) {
		this.total_installments = total_installments;
	}

	public double getInstallment_value() {
		return installment_value;
	}

	public void setInstallment_value(double installment_value) {
		this.installment_value = installment_value;
	}

	public int getPaid_installments() {
		return paid_installments;
	}

	public void setPaid_installments(int paid_installments) {
		this.paid_installments = paid_installments;
	}
	
	
}
