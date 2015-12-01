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
	private User user;
	private VirtualSensorController vsController;
	private String dimensions;
	private Double signalSpeed;
	private String signalType;
	private Integer numOfPins;
	private String outputSignal;
	private Integer operatingRangeFrom;
	private Integer operatingRangeTo;
	private Date installationDateTime;
	private Date removalDateTime;
	private String status;
	private Double totalEarning;
	private Double latitude;
	private Double longitude;
	private String sensorCity;
	
	public Double getLatitude() {
		return latitude;
	}


	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}


	public Double getLongitude() {
		return longitude;
	}


	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}


	public String getSensorCity() {
		return sensorCity;
	}


	public void setSensorCity(String sensorCity) {
		this.sensorCity = sensorCity;
	}


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

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
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



	public VirtualSensorController getVsController() {
		return vsController;
	}


	public void setVsController(VirtualSensorController vsController) {
		this.vsController = vsController;
	}


	public String getSignalType() {
		return signalType;
	}


	public void setSignalType(String signalType) {
		this.signalType = signalType;
	}


	public Integer getNumOfPins() {
		return numOfPins;
	}


	public void setNumOfPins(Integer numOfPins) {
		this.numOfPins = numOfPins;
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

	@Override
	public String toString() {
		return "VirtualSensor [virtualSensorId=" + virtualSensorId + ", user=" + user + ", vsController=" + vsController
				+ ", dimensions=" + dimensions + ", signalSpeed=" + signalSpeed + ", signalType=" + signalType
				+ ", numOfPins=" + numOfPins + ", outputSignal=" + outputSignal + ", operatingRangeFrom="
				+ operatingRangeFrom + ", operatingRangeTo=" + operatingRangeTo + ", installationDateTime="
				+ installationDateTime + ", removalDateTime=" + removalDateTime + ", status=" + status
				+ ", totalEarning=" + totalEarning + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", sensorCity=" + sensorCity + "]";
	}

	
}
