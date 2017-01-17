package org.launchcode.babySteps.models.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.launchcode.babySteps.models.ChangingLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface ChangingLogDao extends CrudRepository<ChangingLog, Integer> {
    
    List<ChangingLog> findByChild(int childId);
    
    // TODO - add method signatures as needed
    
    ChangingLog findByUid(int uid);
    
    List<ChangingLog> findAll();
    
    ChangingLog findFirstByChildUidOrderByCreatedDesc(int childId);
    
    void deleteByUid(int uid);
    
}
