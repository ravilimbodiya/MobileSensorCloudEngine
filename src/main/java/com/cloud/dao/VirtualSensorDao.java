/**
 * 
 */
package com.cloud.dao;

import java.util.List;

import com.cloud.entity.User;
import com.cloud.entity.VirtualSensor;
import com.cloud.entity.VirtualSensorController;
import com.cloud.exception.DaoException;

/**
 * @author Abhranil
 *
 */
public interface VirtualSensorDao {
	
	public List<VirtualSensor> findBySensorId(int sensorId) throws DaoException;
	
	public void save(VirtualSensor virtualSensor) throws DaoException;

	public List<VirtualSensor> getAllSensorByUserId(User validUser) throws DaoException;
	
	public List<String> getAllSensorsCity() throws DaoException;

	public List<VirtualSensor> getSensorsByCity(String reqCity)throws DaoException;

	public void addVsControllers(List<VirtualSensorController> vsControllers) throws DaoException;
	
	public List<VirtualSensorController> getAllVsc() throws DaoException;
	
	public void updateVscResources(VirtualSensorController vsc) throws DaoException;
	
	public void updateVirtualSensor(VirtualSensor vs) throws DaoException;
}
