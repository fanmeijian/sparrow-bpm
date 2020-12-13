package cn.ywsoft.sparrow.bpm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="userflows")
public class UserFlow {
	
	@Id UserFlowPK id;

	public UserFlowPK getId() {
		return id;
	}

	public void setId(UserFlowPK id) {
		this.id = id;
	}
	
	
	
}
