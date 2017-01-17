package org.launchcode.babySteps.models.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.launchcode.babySteps.models.MedicationLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface MedicationLogDao extends CrudRepository<MedicationLog, Integer> {
    
    List<MedicationLog> findByChild(int childId);
    
    // TODO - add method signatures as needed
    
    MedicationLog findByUid(int uid);
    
    List<MedicationLog> findAll();
    
    MedicationLog findFirstByChildUidOrderByCreatedDesc(int childId);
    
	void deleteByUid(int uid);
}
