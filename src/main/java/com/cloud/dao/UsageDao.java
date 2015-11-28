/**
 * 
 */
package com.cloud.dao;

import java.util.List;

import com.cloud.entity.Usage;
import com.cloud.exception.DaoException;

/**
 * @author Abhranil
 *
 */
public interface UsageDao {
	
	public List<Usage> findByUserId(int userId) throws DaoException;	

}
