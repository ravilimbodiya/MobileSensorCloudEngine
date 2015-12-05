/**
 * 
 */
package com.cloud.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author Ravi
 *
 */
public class Usage{

	/**
	 * 
	 */
	private Integer usageId;
	private Integer virtualSensorId;
	private Integer userId;
	private Integer vscId;
	private Timestamp allocationDate;
	private Timestamp releaseDate;
	private Double amount;
	private Double billing;
	
	
	public Integer getUsageId() {
		return usageId;
	}


	public void setUsageId(Integer usageId) {
		this.usageId = usageId;
	}


	
	public Timestamp getAllocationDate() {
		return allocationDate;
	}


	public void setAllocationDate(Timestamp allocationDate) {
		this.allocationDate = allocationDate;
	}


	public Timestamp getReleaseDate() {
		return releaseDate;
	}


	@Override
	public String toString() {
		return "Usage [usageId=" + usageId + ", virtualSensorId=" + virtualSensorId + ", userId=" + userId + ", vscId="
				+ vscId + ", allocationDate=" + allocationDate + ", releaseDate=" + releaseDate + ", amount=" + amount
				+ ", billing=" + billing + "]";
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


	public void setReleaseDate(Timestamp releaseDate) {
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


	public Integer getVscId() {
		return vscId;
	}


	public void setVscId(Integer vscId) {
		this.vscId = vscId;
	}

}
