/**
 * 
 */
package com.cloud.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.bo.UserBo;
import com.cloud.dao.UserDaoImpl;
import com.cloud.entity.User;

/**
 * @author Ravi
 * Controls user requests and responses.
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public @ResponseBody UserDaoImpl getUserDetails(@PathVariable String id) {
		loadData();
		UserDaoImpl user = new UserDaoImpl();
		user.setId(id);
		user.setName("Test User");
		return user;
	}
	
	public void loadData() {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("app-context.xml");
		
	    UserBo userBo = (UserBo) appContext.getBean("userBo");
	    
    	/** insert **/
    	User user = new User();
    	user.setUserName("Test1");
    	userBo.save(user);
    	
    	/** select **/
    	User user2 = userBo.findByUserName("Test1");
    	System.out.println(user2);
    	
    	/** update **/
    	user2.setUserName("Test2");
    	userBo.update(user2);
    	
    	/** delete **/
    	userBo.delete(user2);
    	
    	System.out.println("Done");	    
	}
}
