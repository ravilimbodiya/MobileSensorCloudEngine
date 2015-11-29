/**
 * 
 */
package com.cloud.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.dao.UsageDao;
import com.cloud.dao.UserDao;
import com.cloud.dao.VirtualSensorDao;
import com.cloud.entity.User;
import com.cloud.entity.VirtualSensor;
import com.cloud.exception.DaoException;

/**
 * @author Ravi
 * Controls sensor provider requests and responses.
 */
@Controller
public class SensorProviderController {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private VirtualSensorDao sensorDao;
	
	@Autowired
	private UsageDao usageDao;
	
	@RequestMapping(value="/addSensor.ac", method = RequestMethod.GET)
	public String addSensor(HttpSession session, Model model) {
		model.addAttribute("virtualSensor", new VirtualSensor());
		return "addSensorForm";
	}
	
	@RequestMapping(value="/addSensorSubmit.ac", method = RequestMethod.POST)
	public String addSensorSubmit(@ModelAttribute("virtualSensor") VirtualSensor virtualSensor, BindingResult errors, HttpSession session, Model model) {
		if(errors.hasErrors()){
			model.addAttribute("errMsg", "Error in adding sensor. Please try again.");
			return "provider-home";
		}
		
		try {
			User validUser = (User) session.getAttribute("validUser");
			virtualSensor.setUser(validUser);
			sensorDao.save(virtualSensor);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		model.addAttribute("errMsg", "Sensor Added Successfully.");
		return "provider-home";
	}

	
	@RequestMapping(value = "/removeSensor.ac", method = RequestMethod.GET)
	public @ResponseBody HashMap<String, List<VirtualSensor>> removeSensor(Model model, HttpSession session) {
		HashMap<String, List<VirtualSensor>> sensorsData = new HashMap<String, List<VirtualSensor>>();
		try {
			User validUser = (User) session.getAttribute("validUser");
			List<VirtualSensor> allVirtualSensors = sensorDao.getAllSensorByUserId(validUser.getUserId());
			sensorsData.put("data", allVirtualSensors);
			model.addAttribute("numOfSensors", allVirtualSensors.size());
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return sensorsData;
	}

}
