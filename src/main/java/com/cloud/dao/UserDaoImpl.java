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
	
	public List<User> findAll(){
		List<User> list = (List<User>) hibernateTemplate.find("from User");
		return list;
	}

	@Override
	public User getUser(String userName, String password) throws DaoException {
		User user = (User) hibernateTemplate.find("from User where email=? and password=?",userName, password);
		return user;
	}
}
