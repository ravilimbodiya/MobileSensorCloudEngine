/**
 * 
 */
package com.cloud.entity;

import java.util.Set;

/**
 * @author Ravi
 *
 */
public class VirtualSensorController implements Comparable<VirtualSensorController> {

	private Integer vsControllerId;
	private String vsControllerName;
	private Double cpuUtilization;
	private Double memoryAvailable;
	
	@Override
	public String toString() {
		return "VirtualSensorController [vsControllerId=" + vsControllerId + ", vsControllerName=" + vsControllerName
				+ ", cpuUtilization=" + cpuUtilization + ", memoryAvailable=" + memoryAvailable + "]";
	}
	public VirtualSensorController(String vsControllerName, Double cpuUtilization, Double memoryAvailable) {
		super();
		this.vsControllerName = vsControllerName;
		this.cpuUtilization = cpuUtilization;
		this.memoryAvailable = memoryAvailable;
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

	/**
	 * 
	 */
	public VirtualSensorController() {
	}
	@Override
	public int compareTo(VirtualSensorController o) {
		return this.getCpuUtilization().compareTo(o.getCpuUtilization());
	}

}
