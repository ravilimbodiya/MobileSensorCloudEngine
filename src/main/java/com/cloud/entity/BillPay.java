/**
 * 
 */
package com.cloud.entity;

import java.sql.Timestamp;

/**
 * @author anaha
 *
 */
public class BillPay{
	
	private Integer paymentId;
	private Integer userId;
	private String userName;
	private Long creditCardNumber;
	private Integer expiryMonth;
	private Integer expiryYear;
	private Integer cvv;
	private Timestamp paymentDate;
	private Double amount;
	
	public BillPay() {
	}

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

	public Long getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(Long creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
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

	
	
	@Override
	public String toString() {
		return "BillPay [paymentId=" + paymentId + ", userId=" + userId + ", userName=" + userName
				+ ", creditCardNumber=" + creditCardNumber + ", expiryMonth=" + expiryMonth + ", expiryYear="
				+ expiryYear + ", cvv=" + cvv + ", paymentDate=" + paymentDate + ", amount=" + amount + "]";
	}

	public Integer getCvv() {
		return cvv;
	}

	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}
	


	public Integer getExpiryMonth() {
		return expiryMonth;
	}

	public void setExpiryMonth(Integer expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	public Integer getExpiryYear() {
		return expiryYear;
	}

	public void setExpiryYear(Integer expiryYear) {
		this.expiryYear = expiryYear;
	}
}
