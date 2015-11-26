package com.cloud.bo;

import com.cloud.entity.User;

public interface UserBo {
	
	public void save(User user) throws BoException;
	
	public void update(User user) throws BoException;
	
	public void delete(User user) throws BoException;
	
	public User findByUserName(String userName) throws BoException;

}
