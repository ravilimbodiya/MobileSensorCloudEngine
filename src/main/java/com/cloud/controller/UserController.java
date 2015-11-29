/**
 * 
 */
package com.cloud.controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.dao.UsageDao;
import com.cloud.dao.UserDao;
import com.cloud.dao.VirtualSensorDao;
import com.cloud.entity.Usage;
import com.cloud.entity.User;
import com.cloud.entity.VirtualSensor;
import com.cloud.exception.DaoException;

/**
 * @author Ravi
 * Controls user requests and responses.
 */
@Controller
public class UserController {
	
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
	
	@RequestMapping(value = "/user.ac", method = RequestMethod.GET)
	public @ResponseBody User getUser(@RequestParam String userName) {		
		User user = null;
		try {
			user = userDao.findByUserName(userName);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return user;
	}

	
	
	@RequestMapping(value="/login.ac", method = RequestMethod.GET)
	public String login(Model model, HttpSession session) {
		User validUser = (User) session.getAttribute("validUser");
		if(validUser != null && validUser.getUserId() != null){
			return validUser.getUserType() + "-home";
		}
		model.addAttribute("user", new User());
		return "login";
	}
	
	@RequestMapping(value="/registration.ac", method = RequestMethod.GET)
	public String register(Model model, HttpSession session) {
		User validUser = (User) session.getAttribute("validUser");
		if(validUser != null && validUser.getUserId() != null){
			return validUser.getUserType() + "-home";
		}
		model.addAttribute("user", new User());
		return "registration";
	}	
	
	@RequestMapping(value="/loginSubmit.ac", method = RequestMethod.POST)
	public String loginSubmit(@ModelAttribute("user") User user, BindingResult errors, HttpSession session, Model model) {
		System.out.println("username -- > "+ user.getEmail());
		
		try {
			User validUser = userDao.getValidUser(user);
			if(validUser != null){
				session.setAttribute("validUser", validUser);
				if(validUser.getUserType().equals("provider")){
					model.addAttribute("virtualSensor", new VirtualSensor());
				}
				return validUser.getUserType() + "-home";
			}
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return "login";
	}
	
	@RequestMapping(value="/logout.ac", method = RequestMethod.GET)
	public String logout(@ModelAttribute("user") User user, BindingResult errors, HttpSession session) {
		System.out.println("logging out -- > "+ user.getEmail());
		session.invalidate();
		return "login";
	}
	
	@RequestMapping(value="/registrationSubmit.ac", method = RequestMethod.POST)
	public String createUser(@ModelAttribute("user") User user, BindingResult errors, HttpSession session) {
		if(errors.hasErrors()){
			return "registration";
		}
		
		System.out.println("user created."+ user.getEmail());
		try {
			userDao.save(user);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		return "login";
	}
	
	/*@RequestMapping(value = "/users.ac", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@RequestParam String userName, @RequestBody User user) {
		System.out.println("user updated.");
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}*/
	
	/*@RequestMapping(value = "/users.ac", method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteUser(@RequestParam String userName) {
		System.out.println("user deleted.");
		return new ResponseEntity<User>(new User(), HttpStatus.NO_CONTENT);
	}*/
	
	@RequestMapping(value = "/sensors.ac", method = RequestMethod.GET)
	public @ResponseBody List<VirtualSensor> getSensors(@RequestParam int userId) {		
		List<VirtualSensor> sensors = null;
		try {
			List<Usage> usages = usageDao.findByUserId(userId);
			for (Usage usage: usages) {
				sensors = sensorDao.findBySensorId(usage.getVirtualSensorId());
				for (VirtualSensor sensor: sensors) {
					//sensor.setUsage(usage.getAmount());
					//sensor.setBilling(usage.getBilling());
				}
			}
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return sensors;
	}
}
