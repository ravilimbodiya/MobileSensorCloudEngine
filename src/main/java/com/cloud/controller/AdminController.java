/**
 * 
 */
package com.cloud.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.dao.UsageDao;
import com.cloud.dao.UserDao;
import com.cloud.dao.VirtualSensorDao;
import com.cloud.entity.User;
import com.cloud.exception.DaoException;

/**
 * @author Ravi
 * Controls Admin requests and responses.
 */ 
@Controller
public class AdminController {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private VirtualSensorDao sensorDao;
	
	@Autowired
	private UsageDao usageDao;
	
	@InitBinder
	public void init(WebDataBinder binder){
		SimpleDateFormat sdf = new SimpleDateFormat("d/M/yyyy");
		sdf.setLenient(false);
		CustomDateEditor cde = new CustomDateEditor(sdf, false);
		binder.registerCustomEditor(Date.class, cde);
	}
	
	@RequestMapping(value = "/users.ac", method = RequestMethod.GET)
	public @ResponseBody HashMap<String, List<User>> getUsers(Model model) {
		HashMap<String, List<User>> userData = new HashMap<String, List<User>>();
		List<User> users = null;
		try {
			users = userDao.findAllUsers();
			userData.put("data", users);
			model.addAttribute("numOfUsers", users.size());
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return userData;
	}
	
	@RequestMapping(value = "/providers.ac", method = RequestMethod.GET)
	public @ResponseBody HashMap<String, List<User>> getProviders(Model model) {
		HashMap<String, List<User>> userData = new HashMap<String, List<User>>();
		List<User> users = null;
		try {
			users = userDao.findAllProviders();
			userData.put("data", users);
			model.addAttribute("numOfProviders", users.size());
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return userData;
	}

}
