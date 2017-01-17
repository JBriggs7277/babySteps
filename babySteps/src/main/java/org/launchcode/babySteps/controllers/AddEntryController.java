package org.launchcode.babySteps.controllers;

import javax.servlet.http.HttpServletRequest;

import org.launchcode.babySteps.models.ChangingLog;
import org.launchcode.babySteps.models.Child;
import org.launchcode.babySteps.models.EventLog;
import org.launchcode.babySteps.models.FeedingLog;
import org.launchcode.babySteps.models.MeasurementsLog;
import org.launchcode.babySteps.models.MedicationLog;
import org.launchcode.babySteps.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddEntryController extends AbstractController {
	
	@RequestMapping(value = "/{username}/{name}/changinglog/add", method = RequestMethod.GET)
	public String addChangingForm(@PathVariable String username, @PathVariable String name, HttpServletRequest request, Model model) {
		User user = userDao.findByUsername(username);
		int userId = user.getUid();
		Child child = childDao.findByNameAndParentUid(name, userId);
		model.addAttribute("user", user);
		model.addAttribute("child", child);
		return "editchangingentry";
	}
	
	@RequestMapping(value = "/{username}/{name}/changinglog/add", method = RequestMethod.POST)
	public String addChanging(@PathVariable String username, @PathVariable String name, HttpServletRequest request, Model model) {
		
		//get request parameters
		String contents = request.getParameter("contents");
		User user = userDao.findByUsername(username);
		int userId = user.getUid();
		Child child = childDao.findByNameAndParentUid(name, userId);
		model.addAttribute("user", user);
		model.addAttribute("child", child);
				
		//validate parameters, resend form if not
		if(contents == null || contents == "")
		{
			model.addAttribute("error", "Please specify");
			model.addAttribute("contents", contents);
			return "editchangingentry";
		}
		
		//if valid, create new ChangingLog
		ChangingLog changinglog = new ChangingLog(contents, child);
		changingLogDao.save(changinglog);		
		
		return "redirect:/" + username + "/" + name + "/changinglog"; 		
	}
	
	@RequestMapping(value = "/{username}/{name}/feedinglog/add", method = RequestMethod.GET)
	public String addFeedingForm(@PathVariable String username, @PathVariable String name, HttpServletRequest request, Model model) {
		User user = userDao.findByUsername(username);
		int userId = user.getUid();
		Child child = childDao.findByNameAndParentUid(name, userId);
		model.addAttribute("user", user);
		model.addAttribute("child", child);
		return "editfeedingentry";
	}
	
	@RequestMapping(value = "/{username}/{name}/feedinglog/add", method = RequestMethod.POST)
	public String addFeeding(@PathVariable String username, @PathVariable String name, HttpServletRequest request, Model model) {
		
		//get request parameters
		String food = request.getParameter("food");
		String burps = request.getParameter("burps");
		String ounces = request.getParameter("ounces");
		User user = userDao.findByUsername(username);
		int userId = user.getUid();
		Child child = childDao.findByNameAndParentUid(name, userId);
		model.addAttribute("user", user);
		model.addAttribute("child", child);
				
		//validate parameters, resend form if not
		if(food == null || food == "" || burps == null || burps == "" || ounces == null || ounces == "")
		{
			model.addAttribute("error", "Please specify");
			model.addAttribute("food", food);
			model.addAttribute("burps", burps);
			model.addAttribute("ounces", ounces);
			return "editfeedingentry";
		}
		
		//if valid, create new FeedingLog
		FeedingLog feedinglog = new FeedingLog(food, burps, ounces, child);
		feedingLogDao.save(feedinglog);		
		
		return "redirect:/" + username + "/" + name + "/feedinglog"; 		
	}
	
	@RequestMapping(value = "/{username}/{name}/medicationlog/add", method = RequestMethod.GET)
	public String addMedicationForm(@PathVariable String username, @PathVariable String name, HttpServletRequest request, Model model) {
		User user = userDao.findByUsername(username);
		int userId = user.getUid();
		Child child = childDao.findByNameAndParentUid(name, userId);
		model.addAttribute("user", user);
		model.addAttribute("child", child);
		return "editmedicationentry";
	}
	
	@RequestMapping(value = "/{username}/{name}/medicationlog/add", method = RequestMethod.POST)
	public String addMedication(@PathVariable String username, @PathVariable String name, HttpServletRequest request, Model model) {
		
		//get request parameters
		String medicine = request.getParameter("medicine");
		String dose = request.getParameter("dose");
		User user = userDao.findByUsername(username);
		int userId = user.getUid();
		Child child = childDao.findByNameAndParentUid(name, userId);
		model.addAttribute("user", user);
		model.addAttribute("child", child);
				
		//validate parameters, resend form if not
		if(medicine == null || medicine == "" || dose == null || dose == "")
		{
			model.addAttribute("error", "Please specify");
			model.addAttribute("medicine", medicine);
			model.addAttribute("dose", dose);
			return "editmedicationentry";
		}
		
		//if valid, create new MedicationLog
		MedicationLog medicationlog = new MedicationLog(medicine, dose, child);
		medicationLogDao.save(medicationlog);		
		
		return "redirect:/" + username + "/" + name + "/medicationlog"; 		
	}
	
	@RequestMapping(value = "/{username}/{name}/eventlog/add", method = RequestMethod.GET)
	public String addEventForm(@PathVariable String username, @PathVariable String name, HttpServletRequest request, Model model) {
		User user = userDao.findByUsername(username);
		int userId = user.getUid();
		Child child = childDao.findByNameAndParentUid(name, userId);
		model.addAttribute("user", user);
		model.addAttribute("child", child);
		return "editevententry";
	}
	
	@RequestMapping(value = "/{username}/{name}/eventlog/add", method = RequestMethod.POST)
	public String addEvent(@PathVariable String username, @PathVariable String name, HttpServletRequest request, Model model) {
		
		//get request parameters
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		User user = userDao.findByUsername(username);
		int userId = user.getUid();
		Child child = childDao.findByNameAndParentUid(name, userId);
		model.addAttribute("user", user);
		model.addAttribute("child", child);
				
		//validate parameters, resend form if not
		if(title == null || title == "" || body == null || body == "")
		{
			model.addAttribute("error", "Please specify");
			model.addAttribute("title", title);
			model.addAttribute("body", body);
			return "editevententry";
		}
		
		//if valid, create new EventLog
		EventLog eventlog = new EventLog(title, body, child);
		eventLogDao.save(eventlog);		
		
		return "redirect:/" + username + "/" + name + "/eventlog"; 		
	}
	
	@RequestMapping(value = "/{username}/{name}/measurementslog/add", method = RequestMethod.GET)
	public String addMeasurementsForm(@PathVariable String username, @PathVariable String name, HttpServletRequest request, Model model) {
		User user = userDao.findByUsername(username);
		int userId = user.getUid();
		Child child = childDao.findByNameAndParentUid(name, userId);
		model.addAttribute("user", user);
		model.addAttribute("child", child);
		return "editmeasurementsentry";
	}
	
	@RequestMapping(value = "/{username}/{name}/measurementslog/add", method = RequestMethod.POST)
	public String addMeasurements(@PathVariable String username, @PathVariable String name, HttpServletRequest request, Model model) {
		
		//get request parameters
		String height = request.getParameter("height");
		String weight = request.getParameter("weight");
		User user = userDao.findByUsername(username);
		int userId = user.getUid();
		Child child = childDao.findByNameAndParentUid(name, userId);
		model.addAttribute("user", user);
		model.addAttribute("child", child);
				
		//validate parameters, resend form if not
		if(height == null || height == "" || weight == null || weight == "")
		{
			model.addAttribute("error", "Please specify");
			model.addAttribute("height", height);
			model.addAttribute("weight", weight);
			return "editmeasurementsentry";
		}
		
		//if valid, create new MeasurementsLog
		MeasurementsLog measurementslog = new MeasurementsLog(height, weight, child);
		measurementsLogDao.save(measurementslog);		
		
		return "redirect:/" + username + "/" + name + "/measurementslog"; 		
	}
}
