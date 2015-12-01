/**
 * 
 */
package com.cloud.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.cloud.entity.Usage;
import com.cloud.entity.User;
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
	public void deactivateSensorByUsageId(Integer usageId) throws DaoException {
		try {
			hibernateTemplate.delete("from Usage where usageId=?", usageId);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}
	
}
