/**
 * 
 */
package com.cloud.dao;

import java.util.List;

import com.cloud.entity.User;

/**
 * @author Ravi
 *
 */
public interface UserDao {
	
	void save(User user);
	
	void update(User user);
	
	void delete(User user);
	
	User findByUserName(String userName);
	
	List<User> findAll();

}
