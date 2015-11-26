/**
 * 
 */
package com.cloud.dao;

import java.util.List;

import com.cloud.entity.User;
import com.cloud.exception.DaoException;

/**
 * @author Ravi
 *
 */
public interface UserDao {
	
	public void save(User user) throws DaoException;
	
	public void update(User user) throws DaoException;
	
	public void delete(User user) throws DaoException;
	
	public User findByUserName(String userName) throws DaoException;
	
	public List<User> findAll() throws DaoException;

}
