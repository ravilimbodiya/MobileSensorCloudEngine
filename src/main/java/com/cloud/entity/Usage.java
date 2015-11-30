/**
 * 
 */
package com.cloud.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Ravi
 *
 */
public class Usage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VirtualSensor virtualSensor;
	private User user;
	private Date allocationDate;
	private Date releaseDate;
	private Double amount;
	private Double billing;
	
	
	@Override
	public String toString() {
		return "Usage [virtualSensor=" + virtualSensor + ", user=" + user + ", allocationDate=" + allocationDate
				+ ", releaseDate=" + releaseDate + ", amount=" + amount + ", billing=" + billing + "]";
	}


	public VirtualSensor getVirtualSensor() {
		return virtualSensor;
	}


	public void setVirtualSensor(VirtualSensor virtualSensor) {
		this.virtualSensor = virtualSensor;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Date getAllocationDate() {
		return allocationDate;
	}


	public void setAllocationDate(Date allocationDate) {
		this.allocationDate = allocationDate;
	}


	public Date getReleaseDate() {
		return releaseDate;
	}


	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}


	public Double getAmount() {
		return amount;
	}


	public void setAmount(Double amount) {
		this.amount = amount;
	}


	public Double getBilling() {
		return billing;
	}


	public void setBilling(Double billing) {
		this.billing = billing;
	}


	/**
	 * 
	 */
	public Usage() {
	}

}
