/**
 * 
 */
package com.cloud.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
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
		try {
			List<VirtualSensor> list = (List<VirtualSensor>) hibernateTemplate.find("from VirtualSensor where virtualSensorId=?", sensorId);
			return list;
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	@Override
	public void save(VirtualSensor virtualSensor) throws DaoException {
		try {
			hibernateTemplate.save(virtualSensor);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	@Override
	public List<VirtualSensor> getAllSensorByUserId(Integer userId) throws DaoException {
		try {
			List<VirtualSensor> allVirtualSensors = (List<VirtualSensor>) hibernateTemplate.find("from VirtualSensor where user.userId = ?", userId);
			return allVirtualSensors;
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

}
