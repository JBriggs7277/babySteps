package org.launchcode.babySteps.models.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.launchcode.babySteps.models.EventLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface EventLogDao extends CrudRepository<EventLog, Integer> {
    
    List<EventLog> findByChild(int childId);
    
    // TODO - add method signatures as needed
    
    EventLog findByUid(int uid);
    
    List<EventLog> findAll();
    
    EventLog findFirstByChildUidOrderByCreatedDesc(int childId);  
    
    void deleteByUid(int uid);
	
}
