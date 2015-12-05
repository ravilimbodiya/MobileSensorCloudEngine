/**
 * 
 */
package com.cloud.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.cloud.entity.User;
import com.cloud.entity.VirtualSensor;
import com.cloud.entity.VirtualSensorController;
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
	public List<VirtualSensor> getAllSensorByUserId(User validUser) throws DaoException {
		try {
			List<VirtualSensor> allVirtualSensors = (List<VirtualSensor>) hibernateTemplate.find("from VirtualSensor where user_id = ?", validUser.getUserId());
			return allVirtualSensors;
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	@Override
	public List<String> getAllSensorsCity() throws DaoException {
		try {
			List<String> cities = (List<String>) hibernateTemplate.find("select distinct sensorCity from VirtualSensor");
			return cities;
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	@Override
	public List<VirtualSensor> getSensorsByCity(String reqCity) throws DaoException {
		try {
			List<VirtualSensor> sensors = (List<VirtualSensor>) hibernateTemplate.find("from VirtualSensor where sensorCity=?", reqCity);
			return sensors;
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	@Override
	public void addVsControllers(List<VirtualSensorController> vsControllers) throws DaoException {
		try {
			for (VirtualSensorController virtualSensorController : vsControllers) {
				hibernateTemplate.save(virtualSensorController);
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	@Override
	public List<VirtualSensorController> getAllVsc() throws DaoException {
		try {
			List<VirtualSensorController> vscList = (List<VirtualSensorController>) hibernateTemplate.find("from VirtualSensorController");
			return vscList;
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	@Override
	public void updateVscResources(VirtualSensorController vsc) throws DaoException {
		try {
			hibernateTemplate.saveOrUpdate(vsc);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	@Override
	public void updateVirtualSensor(VirtualSensor vs) throws DaoException {
		try {
			hibernateTemplate.update(vs);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

}
