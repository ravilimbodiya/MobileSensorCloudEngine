/**
 * 
 */
package com.cloud.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.cloud.entity.Usage;
import com.cloud.entity.User;
import com.cloud.entity.VirtualSensor;
import com.cloud.exception.DaoException;

/**
 * @author Abhranil
 *
 */
public class UsageDaoImpl implements UsageDao {	
	
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}	
	
	@Override
	public List<Usage> findByUserId(int userId) throws DaoException {
		try {
			List<Usage> list = (List<Usage>) hibernateTemplate.find("from Usage where userId=?",userId);
			return list;
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	@Override
	public void save(Usage usage) throws DaoException {
		try {
			hibernateTemplate.saveOrUpdate(usage);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	@Override
	public List<Usage> getUsageByUserId(User validUser) throws DaoException {
		try {
			return (List<Usage>) hibernateTemplate.find("from Usage where userId=?", validUser.getUserId());
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	@Override
	public void updateAmountAndBillingHours(Usage usage) throws DaoException {
		try {
			hibernateTemplate.saveOrUpdate(usage);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	@Override
	public void deactivateSensorByUsageId(Usage usage) throws DaoException {
		try {
			hibernateTemplate.delete(usage);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	@Override
	public Usage getByUsageId(Integer usageId) throws DaoException {
		try {
			return hibernateTemplate.get(Usage.class, usageId);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	@Override
	public boolean findUsageByUserIdVSensorId(Integer userId, Integer vsId) throws DaoException {
		try {
			List<Usage> usageObj = hibernateTemplate.find("from Usage where userId=? and virtualSensorId=?", userId, vsId);
			if(usageObj.size() == 0){
				return true;
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
		return false;
	}

	@Override
	public List<Usage> getAllUsageByUserId(Integer userId) throws DaoException {
		try {
			List<Usage> usageObj = hibernateTemplate.find("from Usage where userId=?", userId);
			return usageObj;
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	@Override
	public Double getProviderTotalEarning(List<VirtualSensor> thisProviderVS) throws DaoException {
		try {
			Double totalAmount = 0.0;
			for (VirtualSensor virtualSensor : thisProviderVS) {
				List<Usage> amtList = hibernateTemplate.find("from Usage where virtualSensorId = ?", virtualSensor.getVirtualSensorId());
				for (Usage us : amtList) {
					totalAmount = totalAmount + us.getAmount();
				}
			}
			return totalAmount;
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	@Override
	public int getAllUsersUsingThisProvidersSensor(List<VirtualSensor> thisProviderVS) throws DaoException {
		try {
			int noOfUsers = 0;
			for (VirtualSensor virtualSensor : thisProviderVS) {
				List<Usage> users = hibernateTemplate.find("from Usage where virtualSensorId = ?", virtualSensor.getVirtualSensorId());
				noOfUsers = noOfUsers + users.size();
			}
			return noOfUsers;
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	@Override
	public void updateByVSId(Integer vsId) throws DaoException {
		try {
			List<Usage> usages = hibernateTemplate.find("from Usage where virtualSensorId = ?", vsId);
			for (Usage usage : usages) {
				Date dt = new Date();
				Timestamp ts = new Timestamp(dt.getTime());
				usage.setReleaseDate(ts);
				hibernateTemplate.update(usage);
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}
	
}
