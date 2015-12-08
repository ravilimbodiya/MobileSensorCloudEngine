/**
 * 
 */
package com.cloud.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.cloud.entity.BillPay;
import com.cloud.exception.DaoException;

/**
 * @author anaha
 *
 */
public class BillPayDaoImpl implements BillPayDao {	
	
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}	
	

	@Override
	public void payBill(BillPay billPay) throws DaoException {
		try {
			hibernateTemplate.saveOrUpdate(billPay);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}	
}
