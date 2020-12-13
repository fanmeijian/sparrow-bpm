package cn.ywsoft.sparrow.bpm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="sysroleflows")
public class SysroleFlow {
	
	@Id SysroleFlowPK id;

	public SysroleFlowPK getId() {
		return id;
	}

	public void setId(SysroleFlowPK id) {
		this.id = id;
	}
	
	
	
}
