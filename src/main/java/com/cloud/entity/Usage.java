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
	private Integer virtualSensorId;
	private Integer userId;
	private Date allocationDate;
	private Date releaseDate;
	private Double amount;
	
	@Override
	public String toString() {
		return "Usage [virtualSensorId=" + virtualSensorId + ", userId=" + userId + ", allocationDate=" + allocationDate
				+ ", releaseDate=" + releaseDate + ", amount=" + amount + "]";
	}

	public Integer getVirtualSensorId() {
		return virtualSensorId;
	}

	public void setVirtualSensorId(Integer virtualSensorId) {
		this.virtualSensorId = virtualSensorId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	/**
	 * 
	 */
	public Usage() {
	}

}
