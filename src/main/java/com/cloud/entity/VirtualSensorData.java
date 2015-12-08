package com.cloud.entity;

import java.sql.Timestamp;

public class VirtualSensorData {

	private Integer sensorId;
	private String sensorName;
	private Timestamp captureDateTime;
	private Double uvIndex;
	private String suggestionMessage;
	private String risk;
	private String riskColor;
	
	@Override
	public String toString() {
		return "VirtualSensorData [sensorId=" + sensorId + ", sensorName=" + sensorName + ", captureDateTime="
				+ captureDateTime + ", uvIndex=" + uvIndex + ", suggestionMessage=" + suggestionMessage + ", risk="
				+ risk + ", riskColor=" + riskColor + "]";
	}

	public Integer getSensorId() {
		return sensorId;
	}

	public void setSensorId(Integer sensorId) {
		this.sensorId = sensorId;
	}

	public String getSensorName() {
		return sensorName;
	}

	public void setSensorName(String sensorName) {
		this.sensorName = sensorName;
	}

	public Timestamp getCaptureDateTime() {
		return captureDateTime;
	}

	public void setCaptureDateTime(Timestamp captureDateTime) {
		this.captureDateTime = captureDateTime;
	}

	public Double getUvIndex() {
		return uvIndex;
	}

	public void setUvIndex(Double uvIndex) {
		this.uvIndex = uvIndex;
	}

	public String getSuggestionMessage() {
		return suggestionMessage;
	}

	public void setSuggestionMessage(String suggestionMessage) {
		this.suggestionMessage = suggestionMessage;
	}

	public String getRisk() {
		return risk;
	}

	public void setRisk(String risk) {
		this.risk = risk;
	}

	public String getRiskColor() {
		return riskColor;
	}

	public void setRiskColor(String riskColor) {
		this.riskColor = riskColor;
	}

	public VirtualSensorData() {
	}

}
