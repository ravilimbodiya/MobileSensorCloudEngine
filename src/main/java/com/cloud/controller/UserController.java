/**
 * 
 */
package com.cloud.controller;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

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
import com.cloud.entity.VirtualSensorController;
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
				validUser.setLastLogin(new Date());
				userDao.save(validUser);
				session.setAttribute("validUser", validUser);
				if(validUser.getUserType().equals("provider")){
					model.addAttribute("virtualSensor", new VirtualSensor());
				}
				// Loading virtual sensor controllers manually for the first time when you run this application
				// and then comment this method call.
				//loadVsControllersToDatabase();
				return validUser.getUserType() + "-home";
			}
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return "login";
	}

	private void loadVsControllersToDatabase() {
		List<VirtualSensorController> list = new ArrayList<VirtualSensorController>();
		list.add(new VirtualSensorController("VSC1", 50.0, 100.0));
		list.add(new VirtualSensorController("VSC2", 20.0, 100.0));
		list.add(new VirtualSensorController("VSC3", 90.0, 100.0));
		list.add(new VirtualSensorController("VSC4", 10.0, 100.0));
		list.add(new VirtualSensorController("VSC5", 40.0, 100.0));
		try {
			sensorDao.addVsControllers(list);
		} catch (DaoException e) {
			e.printStackTrace();
		}
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
			user.setLastLogin(new Date());
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
	
	@RequestMapping(value="/reqSensor.ac", method = RequestMethod.POST)
	public String reqSensor(HttpSession session, Model model) {
		
		try {
			User validUser = (User) session.getAttribute("validUser");
			List<String> cities = sensorDao.getAllSensorsCity();
			model.addAttribute("cityList", cities);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return "reqSensorForm";
	}
	
	@RequestMapping(value="/reqSensorSubmit.ac", method = RequestMethod.POST)
	public String reqSensorSubmit(HttpSession session, Model model, @RequestParam String reqCity) {
		
		try {
			User validUser = (User) session.getAttribute("validUser");
			List<VirtualSensor> virtualSensorsOfCity = sensorDao.getSensorsByCity(reqCity);
			Random rand = new Random();
			VirtualSensor vs = virtualSensorsOfCity.get(rand.nextInt(virtualSensorsOfCity.size()));
			
			// Attaching this sensor to controller based on some algorithm for further management.
			// Getting lowest load VSC
			VirtualSensorController vsc = getLowestLoadVsc();
			System.out.println("VSC - > "+vsc.getVsControllerId());
			Usage usage = new Usage();
			usage.setUserId(validUser.getUserId());
			usage.setVirtualSensorId(vs.getVirtualSensorId());
			usage.setVscId(vsc.getVsControllerId());
			usage.setAllocationDate(new Date());
			usage.setAmount(0.0);
			usage.setBilling(0.0);
			usage.setReleaseDate(null);
			
			usageDao.save(usage);
			
			// update controller cpu utilization and memory.
			Double currentCpu = vsc.getCpuUtilization();
			Double currentMemory = vsc.getMemoryAvailable();
			vsc.setCpuUtilization(currentCpu+12.0);
			vsc.setMemoryAvailable(currentMemory+10.0);
			sensorDao.updateVscResources(vsc);
			
			model.addAttribute("errMsg", "Congratulations! You have got your Sensor.");
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return "user-home";
	}

	private VirtualSensorController getLowestLoadVsc() {
		try {
			List<VirtualSensorController> allVsc = sensorDao.getAllVsc();
			Collections.sort(allVsc);
			return allVsc.get(0);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/getUserSensors.ac", method = RequestMethod.GET)
	public @ResponseBody HashMap<String, List<Usage>> getUserSensors(Model model, HttpSession session) {
		HashMap<String, List<Usage>> sensorsData = new HashMap<String, List<Usage>>();
		try {
			User validUser = (User) session.getAttribute("validUser");
			List<Usage> userSensors = usageDao.getUsageByUserId(validUser);
			int diff = 0;
			for (Usage usage : userSensors) {
				if(usage.getReleaseDate() == null){
					Date todayDate = new Date();
					diff=(int) ((todayDate.getTime() - usage.getAllocationDate().getTime())/(60*60 * 1000));
				} else {
					diff=(int) ((usage.getReleaseDate().getTime() - usage.getAllocationDate().getTime())/(60*60 * 1000));
				}
				usage.setBilling((double) diff);
				Double amt = (double) (diff * 5);
				usage.setAmount(amt);
				usageDao.updateAmountAndBillingHours(usage);
			}
			List<Usage> userSensorsUpdated = usageDao.getUsageByUserId(validUser);
			sensorsData.put("data", userSensorsUpdated);
			model.addAttribute("numOfUserSensors", userSensorsUpdated.size());
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return sensorsData;
	}
}
