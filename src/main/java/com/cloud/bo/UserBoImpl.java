package com.cloud.bo;

import java.util.List;

import com.cloud.bo.UserBo;
import com.cloud.dao.UserDao;
import com.cloud.entity.User;
import com.cloud.exception.DaoException;

public class UserBoImpl implements UserBo {

	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void save(User user) throws BoException {
		try {
			userDao.save(user);
		} catch (Exception e) {
			throw new BoException();
		}
	}

	public void update(User user) throws BoException {
		try {
			userDao.update(user);
		} catch (Exception e) {
			throw new BoException();
		}
	}

	public void delete(User user) throws BoException {
		try {
			userDao.delete(user);
		} catch (Exception e) {
			throw new BoException();
		}
	}

	public User findByUserName(String userName) throws BoException {
		try {
			return userDao.findByUserName(userName);
		} catch (Exception e) {
			throw new BoException();
		}
	}
 
	public List<User> findAll() throws BoException {
		try {
			return userDao.findAll();
		} catch (Exception e) {
			throw new BoException();
		}
	}
}
