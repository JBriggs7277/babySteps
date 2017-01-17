package org.launchcode.babySteps.models.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.launchcode.babySteps.models.Child;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface ChildDao extends CrudRepository<Child, Integer> {
	
	List<Child> findByParent(int parentId);

    Child findByUid(int uid);
    
    List<Child> findAll();
    
    // TODO - add method signatures as needed
    
    Child findByName(String name);
    
    Child findByNameAndParentUid(String name, int parentId);
}