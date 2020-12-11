package cn.ywsoft.sparrow.bpm.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import cn.ywsoft.sparrow.bpm.model.ProcessInstance;

public interface ProcessInstanceRepository extends MongoRepository<ProcessInstance,String> {

}
