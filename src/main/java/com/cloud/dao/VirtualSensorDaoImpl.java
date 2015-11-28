/**
 * 
 */
package com.cloud.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.cloud.entity.VirtualSensor;
import com.cloud.exception.DaoException;

/**
 * @author Abhranil
 *
 */
public class VirtualSensorDaoImpl implements VirtualSensorDao {	
	
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}	
	
	@Override
	public List<VirtualSensor> findBySensorId(int sensorId) throws DaoException {
		List<VirtualSensor> list = (List<VirtualSensor>) hibernateTemplate.find("from VirtualSensor where virtualSensorId=?", sensorId);
		return list;
	}
	
}
