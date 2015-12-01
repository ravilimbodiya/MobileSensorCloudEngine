/**
 * 
 */
package com.cloud.entity;

import java.util.Set;

/**
 * @author Ravi
 *
 */
public class VirtualSensorController {

	private Integer vsControllerId;
	private String vsControllerName;
	private Double cpuUtilization;
	private Double memoryAvailable;
	private Set<VirtualSensor> vsSet;
	
	@Override
	public String toString() {
		return "VirtualSensorController [vsControllerId=" + vsControllerId + ", vsControllerName=" + vsControllerName
				+ ", cpuUtilization=" + cpuUtilization + ", memoryAvailable=" + memoryAvailable + ", vsSet=" + vsSet
				+ "]";
	}
	public Integer getVsControllerId() {
		return vsControllerId;
	}
	public void setVsControllerId(Integer vsControllerId) {
		this.vsControllerId = vsControllerId;
	}
	public String getVsControllerName() {
		return vsControllerName;
	}
	public void setVsControllerName(String vsControllerName) {
		this.vsControllerName = vsControllerName;
	}
	public Double getCpuUtilization() {
		return cpuUtilization;
	}
	public void setCpuUtilization(Double cpuUtilization) {
		this.cpuUtilization = cpuUtilization;
	}
	public Double getMemoryAvailable() {
		return memoryAvailable;
	}
	public void setMemoryAvailable(Double memoryAvailable) {
		this.memoryAvailable = memoryAvailable;
	}
	public Set<VirtualSensor> getVsSet() {
		return vsSet;
	}
	public void setVsSet(Set<VirtualSensor> vsSet) {
		this.vsSet = vsSet;
	}
	/**
	 * 
	 */
	public VirtualSensorController() {
	}

}
