package cn.ywsoft.sparrow.bpm.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="usertaskinstances")
public class UserTaskInstance{
	@Id
	private String id;
	private String[] adminGroups;
	private String[] adminUsers;
	private Date completed;
	private String description;
	private String endpoint;
	private String[] excludedUsers;
	private Object inputs;
	private Date lastUpdate;
	private String name;
	private Object outputs;
	private String[] potentialGroups;
	private String[] potentialUsers;
	private String priority;
	private String processId;
	private String processInstanceId;
	private String referenceName;
	private Date started;
	private String state;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String[] getAdminGroups() {
		return adminGroups;
	}
	public void setAdminGroups(String[] adminGroups) {
		this.adminGroups = adminGroups;
	}
	public String[] getAdminUsers() {
		return adminUsers;
	}
	public void setAdminUsers(String[] adminUsers) {
		this.adminUsers = adminUsers;
	}
	public Date getCompleted() {
		return completed;
	}
	public void setCompleted(Date completed) {
		this.completed = completed;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	public String[] getExcludedUsers() {
		return excludedUsers;
	}
	public void setExcludedUsers(String[] excludedUsers) {
		this.excludedUsers = excludedUsers;
	}
	public Object getInputs() {
		return inputs;
	}
	public void setInputs(Object inputs) {
		this.inputs = inputs;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Object getOutputs() {
		return outputs;
	}
	public void setOutputs(Object outputs) {
		this.outputs = outputs;
	}
	public String[] getPotentialGroups() {
		return potentialGroups;
	}
	public void setPotentialGroups(String[] potentialGroups) {
		this.potentialGroups = potentialGroups;
	}
	public String[] getPotentialUsers() {
		return potentialUsers;
	}
	public void setPotentialUsers(String[] potentialUsers) {
		this.potentialUsers = potentialUsers;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
	}
	public String getProcessInstanceId() {
		return processInstanceId;
	}
	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}
	public String getReferenceName() {
		return referenceName;
	}
	public void setReferenceName(String referenceName) {
		this.referenceName = referenceName;
	}
	public Date getStarted() {
		return started;
	}
	public void setStarted(Date started) {
		this.started = started;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	

}
