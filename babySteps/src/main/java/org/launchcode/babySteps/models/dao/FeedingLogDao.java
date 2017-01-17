package org.launchcode.babySteps.models.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.launchcode.babySteps.models.FeedingLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface FeedingLogDao extends CrudRepository<FeedingLog, Integer> {
    
    List<FeedingLog> findByChild(int childId);
    
    // TODO - add method signatures as needed
    
    FeedingLog findByUid(int uid);
    
    List<FeedingLog> findAll();
    
    FeedingLog findFirstByChildUidOrderByCreatedDesc(int childId);
    
	void deleteByUid(int uid);
}
