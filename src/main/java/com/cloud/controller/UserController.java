/**
 * 
 */
package com.cloud.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.entity.User;

/**
 * @author Ravi
 * Controls user requests and responses.
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@InitBinder
	public void init(WebDataBinder binder){
		SimpleDateFormat sdf = new SimpleDateFormat("d/M/yyyy");
		sdf.setLenient(false);
		CustomDateEditor cde = new CustomDateEditor(sdf, false);
		binder.registerCustomEditor(Date.class, cde);
	}
	
	@RequestMapping(value = "/details/{userId}", method = RequestMethod.GET)
	public @ResponseBody User getUserDetails(@PathVariable String userId) {		
		User user = new User();
		user.setUserId(Integer.parseInt(userId));
		user.setFirstName("Test");
		user.setLastName("User");
		return user;
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user) {
		System.out.println("in user controller");
		return "userRegistration";
	}
}
