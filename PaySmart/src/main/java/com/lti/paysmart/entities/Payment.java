package com.lti.paysmart.entities;

import java.sql.Date;

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
	private int current_installment;
	private double installment_value;
	private Date due_date;
	
	@OneToOne(mappedBy = "payment", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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

	public int getCurrent_installment() {
		return current_installment;
	}

	public void setCurrent_installment(int current_installment) {
		this.current_installment = current_installment;
	}

	public double getInstallment_value() {
		return installment_value;
	}

	public void setInstallment_value(double installment_value) {
		this.installment_value = installment_value;
	}

	public Date getDue_date() {
		return due_date;
	}

	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}
	
	
}
