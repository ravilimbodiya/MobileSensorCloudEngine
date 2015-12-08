/**
 * 
 */
package com.cloud.controller;

import java.util.Date;
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
			virtualSensor.setStatus("Activated");
			sensorDao.save(virtualSensor);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		model.addAttribute("sucMsg", "Sensor Added Successfully.");
		return "provider-home";
	}

	
	@RequestMapping(value = "/removeSensor.ac", method = RequestMethod.GET)
	public @ResponseBody HashMap<String, List<VirtualSensor>> removeSensor(Model model, HttpSession session) {
		HashMap<String, List<VirtualSensor>> sensorsData = new HashMap<String, List<VirtualSensor>>();
		List<VirtualSensor> allVirtualSensors = (List<VirtualSensor>) session.getAttribute("allSensorsForThisUser");
		sensorsData.put("data", allVirtualSensors);
		return sensorsData;
	}
	
	
	@RequestMapping(value="/removeSensorSubmit.ac", method = RequestMethod.GET)
	public String removeSensor(HttpSession session, Model model, @RequestParam Integer vsId) {
		
		try {
			List<VirtualSensor> vsList = sensorDao.findBySensorId(vsId);
			if(vsList.size() != 0){
				VirtualSensor vs = vsList.get(0);
				vs.setRemovalDateTime(new Date());
				vs.setStatus("Deactivated");
				sensorDao.updateVirtualSensor(vs);
				usageDao.updateByVSId(vs.getVirtualSensorId());
			}
			model.addAttribute("sucMsg", "Sensor removed successfully.");
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return "provider-home";
	}

	@RequestMapping(value = "/getThisProviderUsage.ac", method = RequestMethod.GET)
	public @ResponseBody HashMap<String, List<Usage>> getThisProviderUsage(Model model, HttpSession session) {
		HashMap<String, List<Usage>> sensorsData = new HashMap<String, List<Usage>>();
		List<Usage> thisProviderUsageList = (List<Usage>) session.getAttribute("thisProviderUsageList");
		sensorsData.put("data", thisProviderUsageList);
		return sensorsData;
	}
	
}
