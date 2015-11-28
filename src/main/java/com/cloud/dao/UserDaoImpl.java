/**
 * 
 */
package com.cloud.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

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

	public void save(User user){
		hibernateTemplate.save(user);
	}
	
	public void update(User user){
		hibernateTemplate.update(user);
	}
	
	public void delete(User user){
		hibernateTemplate.delete(user);
	}
	
	public User findByUserName(String userName){
		List list = hibernateTemplate.find("from User where userName=?",userName);
		return (User)list.get(0);
	}
	
	public List<User> findAllUsers(){
		List<User> list = (List<User>) hibernateTemplate.find("from User where userType='user'");
		return list;
	}

	@Override
	public User getValidUser(User user) throws DaoException {
		List<User> users = (List<User>) hibernateTemplate.find("from User where email=? and password=?",user.getEmail(), user.getPassword());
		if(users.size() > 0){
			return users.get(0);
		}
		return null;
	}

	@Override
	public List<User> findAllProviders() throws DaoException {
		List<User> list = (List<User>) hibernateTemplate.find("from User where userType='provider'");
		return list;
	}
}
