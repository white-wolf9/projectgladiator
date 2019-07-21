package com.lti.paysmart.dto;

import java.util.Date;

import com.lti.paysmart.enums.EMITypes;
import com.lti.paysmart.enums.PaymentStatus;

public class ViewAllOrderResopnseDTO {
	private String productname;
	private Date orderdate;
	private EMITypes emischeme;
	
	private long paymentid;
	private int totalinstallments;
	private int paidinstallments;
	private double installmentvalue;
	private Date last_paiddate;
	private Date next_paydate;
	private PaymentStatus paymentstatus;
	
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	public EMITypes getEmischeme() {
		return emischeme;
	}
	public void setEmischeme(EMITypes emischeme) {
		this.emischeme = emischeme;
	}
	public long getPaymentid() {
		return paymentid;
	}
	public void setPaymentid(long paymentid) {
		this.paymentid = paymentid;
	}
	public int getTotalinstallments() {
		return totalinstallments;
	}
	public void setTotalinstallments(int totalinstallments) {
		this.totalinstallments = totalinstallments;
	}
	public int getPaidinstallments() {
		return paidinstallments;
	}
	public void setPaidinstallments(int paidinstallments) {
		this.paidinstallments = paidinstallments;
	}
	public double getInstallmentvalue() {
		return installmentvalue;
	}
	public void setInstallmentvalue(double installmentvalue) {
		this.installmentvalue = installmentvalue;
	}
	public Date getLast_paiddate() {
		return last_paiddate;
	}
	public void setLast_paiddate(Date last_paiddate) {
		this.last_paiddate = last_paiddate;
	}
	public Date getNext_paydate() {
		return next_paydate;
	}
	public void setNext_paydate(Date next_paydate) {
		this.next_paydate = next_paydate;
	}
	public PaymentStatus getPaymentstatus() {
		return paymentstatus;
	}
	public void setPaymentstatus(PaymentStatus paymentstatus) {
		this.paymentstatus = paymentstatus;
	}
	
	
	

}
