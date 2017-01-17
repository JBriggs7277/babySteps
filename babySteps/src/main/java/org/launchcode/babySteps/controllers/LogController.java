package org.launchcode.babySteps.controllers;

import java.util.List;

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

@Controller
public class LogController extends AbstractController {

	@RequestMapping(value = "/{username}/{name}/changinglog")
	public String changingLog(@PathVariable String username, @PathVariable String name, Model model){
		
		User user = userDao.findByUsername(username);
		int userId = user.getUid();
		Child child = childDao.findByNameAndParentUid(name, userId);
		List<ChangingLog> changinglogs = child.getChangingLogs();
		
		model.addAttribute("user", user);
		model.addAttribute("child", child);
		model.addAttribute("changinglogs", changinglogs);
		return "changinglog";
	}
	
	@RequestMapping(value = "/{username}/{name}/feedinglog")
	public String feedingLog(@PathVariable String username, @PathVariable String name, Model model){
		
		User user = userDao.findByUsername(username);
		int userId = user.getUid();
		Child child = childDao.findByNameAndParentUid(name, userId);
		List<FeedingLog> feedinglogs = child.getFeedingLogs();
		
		model.addAttribute("user", user);
		model.addAttribute("child", child);
		model.addAttribute("feedinglogs", feedinglogs);
		return "feedinglog";
	}
	
	@RequestMapping(value = "/{username}/{name}/medicationlog")
	public String medicationLog(@PathVariable String username, @PathVariable String name, Model model){
		
		User user = userDao.findByUsername(username);
		int userId = user.getUid();
		Child child = childDao.findByNameAndParentUid(name, userId);
		List<MedicationLog> medicationlogs = child.getMedicationLogs();
		
		model.addAttribute("user", user);
		model.addAttribute("child", child);
		model.addAttribute("medicationlogs", medicationlogs);
		return "medicationlog";
	}
	
	@RequestMapping(value = "/{username}/{name}/eventlog")
	public String eventLog(@PathVariable String username, @PathVariable String name, Model model){
		
		User user = userDao.findByUsername(username);
		int userId = user.getUid();
		Child child = childDao.findByNameAndParentUid(name, userId);
		List<EventLog> eventlogs = child.getEventLogs();
		
		model.addAttribute("user", user);
		model.addAttribute("child", child);
		model.addAttribute("eventlogs", eventlogs);
		return "eventlog";
	}
	
	@RequestMapping(value = "/{username}/{name}/measurementslog")
	public String measurementsLog(@PathVariable String username, @PathVariable String name, Model model){
		
		User user = userDao.findByUsername(username);
		int userId = user.getUid();
		Child child = childDao.findByNameAndParentUid(name, userId);
		List<MeasurementsLog> measurementslogs = child.getMeasurementsLogs();
		
		model.addAttribute("user", user);
		model.addAttribute("child", child);
		model.addAttribute("measurementslogs", measurementslogs);
		return "measurementslog";
	}
}
