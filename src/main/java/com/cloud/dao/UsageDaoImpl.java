/**
 * 
 */
package com.cloud.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.cloud.entity.Usage;
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
	
}