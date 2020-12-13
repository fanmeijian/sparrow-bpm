package cn.ywsoft.sparrow.bpm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import cn.ywsoft.sparrow.bpm.model.UserTaskInstance;

@RepositoryRestResource
public interface UserTaskInstanceRepository extends MongoRepository<UserTaskInstance, String> {
	
	@RestResource(exported = false)
	Page<UserTaskInstance> findByPotentialGroupsInOrPotentialUsersIn(String[] groups,String[] users,Pageable p);
}
