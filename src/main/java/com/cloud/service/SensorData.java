package com.cloud.service;

import com.cloud.entity.VirtualSensorData;

public interface SensorData {
	public VirtualSensorData getSensorDataFromWebService(Integer vsId) throws Exception;
}
