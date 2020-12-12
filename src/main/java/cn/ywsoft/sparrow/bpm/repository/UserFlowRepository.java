package cn.ywsoft.sparrow.bpm.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import cn.ywsoft.sparrow.bpm.model.UserFlow;
import cn.ywsoft.sparrow.bpm.model.UserFlowPK;

public interface UserFlowRepository extends MongoRepository<UserFlow, UserFlowPK> {

}
