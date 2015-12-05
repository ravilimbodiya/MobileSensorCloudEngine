/**
 * 
 */
package com.cloud.dao;

import java.util.List;

import com.cloud.entity.Usage;
import com.cloud.entity.User;
import com.cloud.entity.VirtualSensor;
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
	
	public Usage getByUsageId(Integer usageId) throws DaoException;

	public void deactivateSensorByUsageId(Usage usage) throws DaoException;
	
	public boolean findUsageByUserIdVSensorId(Integer userId, Integer vsId) throws DaoException;
	
	public List<Usage> getAllUsageByUserId(Integer userId) throws DaoException;
	
	public List<Usage> getProviderTotalEarning(List<VirtualSensor> thisProviderVS) throws DaoException;
	
	public int getAllUsersUsingThisProvidersSensor(List<VirtualSensor> thisProviderVS) throws DaoException;
	
	public void updateByVSId(Integer vsId) throws DaoException;

}
