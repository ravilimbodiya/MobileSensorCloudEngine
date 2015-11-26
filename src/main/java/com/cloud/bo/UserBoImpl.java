package com.cloud.bo;

import java.util.List;

import com.cloud.bo.UserBo;
import com.cloud.dao.UserDao;
import com.cloud.entity.User;

public class UserBoImpl implements UserBo{

	UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void save(User user){
		userDao.save(user);
	}
	
	public void update(User user){
		userDao.update(user);
	}
	
	public void delete(User user){
		userDao.delete(user);
	}
	
	public User findByUserName(String userName){
		return userDao.findByUserName(userName);
	}
	
	public List<User> findAll() {
		return userDao.findAll();
	}
}
