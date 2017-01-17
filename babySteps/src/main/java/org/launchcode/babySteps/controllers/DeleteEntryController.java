package org.launchcode.babySteps.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class DeleteEntryController extends AbstractController {
	
	@RequestMapping(value = "/{username}/{name}/changinglog/delete/{uid}")
	public String deleteChangingLog(@PathVariable String username, @PathVariable String name, @PathVariable int uid) {
		
		changingLogDao.deleteByUid(uid);
		
		return "redirect:/" + username + "/" + name + "/changinglog";
	}

	@RequestMapping(value = "/{username}/{name}/feedinglog/delete/{uid}")
	public String deleteFeedingLog(@PathVariable String username, @PathVariable String name, @PathVariable int uid) {
		
		feedingLogDao.deleteByUid(uid);
		
		return "redirect:/" + username + "/" + name + "/feedinglog";
	}
	
	@RequestMapping(value = "/{username}/{name}/medicationlog/delete/{uid}")
	public String deleteMedicationLog(@PathVariable String username, @PathVariable String name, @PathVariable int uid) {
		
		medicationLogDao.deleteByUid(uid);
		
		return "redirect:/" + username + "/" + name + "/medicationlog";
	}
	
	@RequestMapping(value = "/{username}/{name}/eventlog/delete/{uid}")
	public String deleteEventLog(@PathVariable String username, @PathVariable String name, @PathVariable int uid) {
		
		eventLogDao.deleteByUid(uid);
		
		return "redirect:/" + username + "/" + name + "/eventlog";
	}
	
	@RequestMapping(value = "/{username}/{name}/measurementslog/delete/{uid}")
	public String deleteMeasurementsLog(@PathVariable String username, @PathVariable String name, @PathVariable int uid) {
		
		measurementsLogDao.deleteByUid(uid);
		
		return "redirect:/" + username + "/" + name + "/measurementslog";
	}
}
