/**
 * 
 */
package com.cloud.dao;

import java.util.List;

import com.cloud.entity.VirtualSensor;
import com.cloud.exception.DaoException;

/**
 * @author Abhranil
 *
 */
public interface VirtualSensorDao {
	
	public List<VirtualSensor> findBySensorId(int sensorId) throws DaoException;
	
	public void save(VirtualSensor virtualSensor) throws DaoException;

	public List<VirtualSensor> getAllSensorByUserId(Integer userId) throws DaoException;
	
}
