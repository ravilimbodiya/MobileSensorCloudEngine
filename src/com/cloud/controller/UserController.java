/**
 * 
 */
package com.cloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.dao.UserDaoImpl;

/**
 * @author Ravi
 * Controls user requests and responses.
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public @ResponseBody UserDaoImpl getUserDetails(@PathVariable String id) {
		UserDaoImpl user = new UserDaoImpl();
		user.setId(id);
		user.setName("Test User");
		return user;
	}
}
