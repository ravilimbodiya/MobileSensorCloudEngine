/**
 * 
 */
package com.cloud.entity;

import java.util.Date;

/**
 * @author Ravi
 *
 */
public class VirtualSensor {

	private Integer virtualSensorId;
	private String dimensions;
	private Double signalSpeed;
	private String lowPins;
	private String highPins;
	private String groundPins;
	private String outputSignal;
	private Integer operatingRangeFrom;
	private Integer operatingRangeTo;
	private Date installationDateTime;
	private Date removalDateTime;
	private String status;
	private Double totalEarning;
	private Double usage;
	private Double billing;
	
	/**
	 * 
	 */
	public VirtualSensor() {
	}


	public Integer getVirtualSensorId() {
		return virtualSensorId;
	}


	public void setVirtualSensorId(Integer virtualSensorId) {
		this.virtualSensorId = virtualSensorId;
	}


	public String getDimensions() {
		return dimensions;
	}


	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}


	public Double getSignalSpeed() {
		return signalSpeed;
	}


	public void setSignalSpeed(Double signalSpeed) {
		this.signalSpeed = signalSpeed;
	}


	public String getLowPins() {
		return lowPins;
	}


	public void setLowPins(String lowPins) {
		this.lowPins = lowPins;
	}


	public String getHighPins() {
		return highPins;
	}


	public void setHighPins(String highPins) {
		this.highPins = highPins;
	}


	public String getGroundPins() {
		return groundPins;
	}


	public void setGroundPins(String groundPins) {
		this.groundPins = groundPins;
	}


	public String getOutputSignal() {
		return outputSignal;
	}


	public void setOutputSignal(String outputSignal) {
		this.outputSignal = outputSignal;
	}


	public Integer getOperatingRangeFrom() {
		return operatingRangeFrom;
	}


	public void setOperatingRangeFrom(Integer operatingRangeFrom) {
		this.operatingRangeFrom = operatingRangeFrom;
	}


	public Integer getOperatingRangeTo() {
		return operatingRangeTo;
	}


	public void setOperatingRangeTo(Integer operatingRangeTo) {
		this.operatingRangeTo = operatingRangeTo;
	}


	public Date getInstallationDateTime() {
		return installationDateTime;
	}


	public void setInstallationDateTime(Date installationDateTime) {
		this.installationDateTime = installationDateTime;
	}


	public Date getRemovalDateTime() {
		return removalDateTime;
	}


	public void setRemovalDateTime(Date removalDateTime) {
		this.removalDateTime = removalDateTime;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Double getTotalEarning() {
		return totalEarning;
	}


	public void setTotalEarning(Double totalEarning) {
		this.totalEarning = totalEarning;
	}
	
	public void setUsage(Double usage) {
		this.usage = usage;
	}
	
	public void setBilling(Double billing) {
		this.billing = billing;
	}


	@Override
	public String toString() {
		return "VirtualSensor [virtualSensorId=" + virtualSensorId + ", dimensions=" + dimensions + ", signalSpeed="
				+ signalSpeed + ", lowPins=" + lowPins + ", highPins=" + highPins + ", groundPins=" + groundPins
				+ ", outputSignal=" + outputSignal 
				+ ", operatingRangeFrom=" + operatingRangeFrom + ", operatingRangeTo=" + operatingRangeTo
				+ ", installationDateTime=" + installationDateTime + ", removalDateTime=" + removalDateTime
				+ ", status=" + status + ", totalEarning=" + totalEarning + "]";
	}

	
}
