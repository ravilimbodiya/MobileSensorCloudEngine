/**
 * 
 */
package com.cloud.dao;

import java.util.List;

import com.cloud.entity.Usage;
import com.cloud.entity.User;
import com.cloud.exception.DaoException;

/**
 * @author Abhranil
 *
 */
public interface UsageDao {
	
	public List<Usage> findByUserId(int userId) throws DaoException;
	
	public void save(Usage usage) throws DaoException;

	public List<Usage> getUsageByUserId(User validUser) throws DaoException;
	
	public void updateAmountAndBillingHours(Usage usage) throws DaoException;

}
