/**
 * 
 */
package com.cloud.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.entity.User;

/**
 * @author Ravi
 * Controls user requests and responses.
 */
@Controller
public class UserController {
	
	@InitBinder
	public void init(WebDataBinder binder){
		SimpleDateFormat sdf = new SimpleDateFormat("d/M/yyyy");
		sdf.setLenient(false);
		CustomDateEditor cde = new CustomDateEditor(sdf, false);
		binder.registerCustomEditor(Date.class, cde);
	}
	
	@RequestMapping(value = "/userForm.action", method = RequestMethod.GET)
	public String getUserDetails(Model model) {
		model.addAttribute("user", new User());
		System.out.println("in user controller 1");
		return "userRegistration";
	}
	
	@RequestMapping(value="/register.action", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user,
			BindingResult errors, HttpSession session){
		System.out.println("in user controller 2");
		return "userRegistration";
	}
}
