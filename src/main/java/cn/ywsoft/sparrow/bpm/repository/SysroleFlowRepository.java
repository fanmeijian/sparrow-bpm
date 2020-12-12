package cn.ywsoft.sparrow.bpm.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import cn.ywsoft.sparrow.bpm.model.SysroleFlow;
import cn.ywsoft.sparrow.bpm.model.SysroleFlowPK;

public interface SysroleFlowRepository extends MongoRepository<SysroleFlow, SysroleFlowPK> {

}
