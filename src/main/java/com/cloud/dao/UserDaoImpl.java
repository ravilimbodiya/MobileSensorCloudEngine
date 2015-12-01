/**
 * 
 */
package com.cloud.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.cloud.entity.User;
import com.cloud.exception.DaoException;

/**
 * @author Ravi
 *
 */
public class UserDaoImpl implements UserDao {	
	
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void save(User user) throws DaoException{
		try {
			hibernateTemplate.saveOrUpdate(user);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}
	
	public void update(User user) throws DaoException{
		try {
			hibernateTemplate.update(user);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}
	
	public void delete(User user) throws DaoException{
		try {
			hibernateTemplate.delete(user);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}
	
	public User findByUserName(String userName) throws DaoException{
		try {
			List list = hibernateTemplate.find("from User where userName=?",userName);
			return (User)list.get(0);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}
	
	public List<User> findAllUsers() throws DaoException{
		try {
			List<User> list = (List<User>) hibernateTemplate.find("from User where userType='user'");
			return list;
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	@Override
	public User getValidUser(User user) throws DaoException {
		try {
			List<User> users = (List<User>) hibernateTemplate.find("from User where email=? and password=?",user.getEmail(), user.getPassword());
			if(users.size() > 0){
				return users.get(0);
			}
			return null;
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	@Override
	public List<User> findAllProviders() throws DaoException {
		try {
			List<User> list = (List<User>) hibernateTemplate.find("from User where userType='provider'");
			return list;
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}
}
