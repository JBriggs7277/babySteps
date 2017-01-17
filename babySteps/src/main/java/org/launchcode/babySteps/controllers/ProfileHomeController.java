package org.launchcode.babySteps.controllers;

import java.util.List;

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
public class ProfileHomeController extends AbstractController {
	
	@RequestMapping(value = "/")
	public String homePage(){
		
		return "homepage";
	}
	
	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public String userProfile(@PathVariable String username, Model model) {
		
		User user = userDao.findByUsername(username);
		List<Child> children = user.getChildren();
		
		model.addAttribute("children", children);
		model.addAttribute("user", user);
		
		return "userprofile";
	}
	
	@RequestMapping(value = "/{username}/addchild", method = RequestMethod.GET)
	public String addChildForm(@PathVariable String username, Model model) {
		return "addchildform";
	}
	
	@RequestMapping(value = "/{username}/addchild", method = RequestMethod.POST)
	public String addChanging(@PathVariable String username, HttpServletRequest request, Model model) {
		
		//get request parameters
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		User parent = userDao.findByUsername(username);
		model.addAttribute("username", username);
				
		//validate parameters, resend form if not
		if( name == null || name == "" || sex == null || sex == "" || birthday == null || birthday == "")
		{
			model.addAttribute("error", "Please specify");
			model.addAttribute("name", name);
			model.addAttribute("sex", sex);
			model.addAttribute("birthday", birthday);
			return "addchildform";
		}
		
		//if valid, create new Child
		Child child = new Child(name, sex, birthday, parent);
		childDao.save(child);		
		
		return "redirect:/" + username;
	}
	
	@RequestMapping(value = "/{username}/{name}", method = RequestMethod.GET)
	public String childProfile(@PathVariable String username, @PathVariable String name, Model model) {
		
		User user = userDao.findByUsername(username);
		int userId = user.getUid();
		Child child = childDao.findByNameAndParentUid(name, userId);
		int childId = child.getUid();
		
		model.addAttribute("user", user);
		model.addAttribute("child", child);
		model.addAttribute("username", username);
	
		ChangingLog changinglog = changingLogDao.findFirstByChildUidOrderByCreatedDesc(childId);
		if(changinglog != null)
		{
			model.addAttribute("changinglog", changinglog);
		}
		
		FeedingLog feedinglog = feedingLogDao.findFirstByChildUidOrderByCreatedDesc(childId);
		if(feedinglog != null)
		{
			model.addAttribute("feedinglog", feedinglog);
		}
		
		MedicationLog medicationlog = medicationLogDao.findFirstByChildUidOrderByCreatedDesc(childId);
		if(medicationlog != null)
		{
			model.addAttribute("medicationlog", medicationlog);
		}
		
		EventLog eventlog = eventLogDao.findFirstByChildUidOrderByCreatedDesc(childId);
		if(eventlog != null)
		{
			model.addAttribute("eventlog", eventlog);
		}
		
		MeasurementsLog measurementslog = measurementsLogDao.findFirstByChildUidOrderByCreatedDesc(childId);
		if(measurementslog != null)
		{
			model.addAttribute("measurementslog", measurementslog);
		}
		
		return "childprofile";
	}
	
}
