/**
 * 
 */
package com.cloud.controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.dao.UserDao;
import com.cloud.bo.BoException;
import com.cloud.bo.UserBoImpl;
import com.cloud.entity.User;
import com.cloud.exception.DaoException;

/**
 * @author Ravi
 * Controls user requests and responses.
 */
@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	@InitBinder
	public void init(WebDataBinder binder){
		SimpleDateFormat sdf = new SimpleDateFormat("d/M/yyyy");
		sdf.setLenient(false);
		CustomDateEditor cde = new CustomDateEditor(sdf, false);
		binder.registerCustomEditor(Date.class, cde);
	}
	
	@RequestMapping(value = "{userName}", method = RequestMethod.GET)
	public @ResponseBody User getUser(@PathVariable String userName) {		
		User user = null;
		try {
			user = userDao.findByUserName(userName);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return user;
	}
	

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<User> getUsers() {		
		List<User> users = null;
		try {
			users = userDao.findAll();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ResponseEntity<User> createUser(@RequestBody User user) {
		System.out.println("user created."+ user.getEmail());
		try {
			userDao.save(user);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User user) {
		System.out.println("user updated.");
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteUser(@PathVariable String id) {
		System.out.println("user deleted.");
		return new ResponseEntity<User>(new User(), HttpStatus.NO_CONTENT);
	}
}
