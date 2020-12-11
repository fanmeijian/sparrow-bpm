package cn.ywsoft.sparrow.bpm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import cn.ywsoft.sparrow.bpm.model.UserTaskInstance;

public interface UserTaskInstanceRepository extends MongoRepository<UserTaskInstance, String> {
	
	Page<UserTaskInstance> findByPotentialGroups(String[] groups,Pageable p);
}
