package org.launchcode.babySteps.controllers;

import javax.servlet.http.HttpSession;

import org.launchcode.babySteps.models.User;
import org.launchcode.babySteps.models.dao.ChangingLogDao;
import org.launchcode.babySteps.models.dao.ChildDao;
import org.launchcode.babySteps.models.dao.EventLogDao;
import org.launchcode.babySteps.models.dao.FeedingLogDao;
import org.launchcode.babySteps.models.dao.MeasurementsLogDao;
import org.launchcode.babySteps.models.dao.MedicationLogDao;
import org.launchcode.babySteps.models.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractController {

	@Autowired
    protected UserDao userDao;
	
	@Autowired
	protected ChildDao childDao;
	
	@Autowired
	protected ChangingLogDao changingLogDao;
	
	@Autowired
	protected FeedingLogDao feedingLogDao;
	
	@Autowired
	protected MedicationLogDao medicationLogDao;
	
	@Autowired
	protected EventLogDao eventLogDao;
	
	@Autowired
	protected MeasurementsLogDao measurementsLogDao;

    public static final String userSessionKey = "user_id";

    protected User getUserFromSession(HttpSession session) {
    	
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        return userId == null ? null : userDao.findByUid(userId);
    }
    
    protected void setUserInSession(HttpSession session, User user) {
    	session.setAttribute(userSessionKey, user.getUid());
    }
	
}
