/**
 * 
 */
package com.cloud.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cloud.entity.User;

/**
 * @author Ravi
 *
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {	
	public void save(User user){
		getHibernateTemplate().save(user);
	}
	
	public void update(User user){
		getHibernateTemplate().update(user);
	}
	
	public void delete(User user){
		getHibernateTemplate().delete(user);
	}
	
	public User findByUserName(String userName){
		List list = getHibernateTemplate().find("from User where userName=?",userName);
		return (User)list.get(0);
	}
	
	public List<User> findAll(){
		List<User> list = (List<User>) getHibernateTemplate().find("from User");
		return list;
	}
}
