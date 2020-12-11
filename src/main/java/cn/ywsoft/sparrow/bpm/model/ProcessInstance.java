package cn.ywsoft.sparrow.bpm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="processinstances")
public class ProcessInstance {
	@Id 
	private String id;
	
	private Object[] nodes;
	private Object[] variables;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Object[] getNodes() {
		return nodes;
	}
	public void setNodes(Object[] nodes) {
		this.nodes = nodes;
	}
	public Object[] getVariables() {
		return variables;
	}
	public void setVariables(Object[] variables) {
		this.variables = variables;
	}
	
	
}
