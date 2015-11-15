/**
 * 
 */
package com.cloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.dao.UserDaoImpl;

/**
 * @author Ravi
 * Controls user requests and responses.
 */
@Controller
public class UserController {
	
	@RequestMapping(method = RequestMethod.GET, value="/user.action")
	public @ResponseBody UserDaoImpl getUserDetails() {
		UserDaoImpl user = new UserDaoImpl();
		user.setId("1");
		user.setName("Test User");
		return user;
	}
}
