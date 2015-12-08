/**
 * 
 */
package com.cloud.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author anaha
 *
 */
public class BillPay{

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(Integer creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public Timestamp getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Timestamp expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Timestamp getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Timestamp paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	private Integer paymentId;
	private Integer userId;
	private String userName;
	private Integer creditCardNumber;
	private Timestamp expirationDate;
	private Timestamp paymentDate;
	private Double amount;
	
	@Override
	public String toString() {
		return "BillPay [paymentId=" + paymentId + ", userId=" + userId + ", userName=" + userName + ", creditCardNumber="
				+ creditCardNumber + ", expirationDate=" + expirationDate + ", paymentDate=" + paymentDate + ", amount=" + amount + "]";
	}
}
