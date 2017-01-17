package org.launchcode.babySteps.models.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.launchcode.babySteps.models.MeasurementsLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface MeasurementsLogDao extends CrudRepository<MeasurementsLog, Integer> {
    
    List<MeasurementsLog> findByChild(int childId);
    
    // TODO - add method signatures as needed
    
    MeasurementsLog findByUid(int uid);
    
    List<MeasurementsLog> findAll();
    
    MeasurementsLog findFirstByChildUidOrderByCreatedDesc(int childId);
    
    void deleteByUid(int uid);
	
}
