package cn.ywsoft.sparrow.bpm.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import cn.ywsoft.sparrow.bpm.model.KogitoFlow;

public interface KogitoFlowRepository extends MongoRepository<KogitoFlow, UUID> {
	
	KogitoFlow findByProcessId(String processId);
}
