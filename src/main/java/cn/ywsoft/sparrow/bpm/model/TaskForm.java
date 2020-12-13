package cn.ywsoft.sparrow.bpm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="taskforms")
public class TaskForm {
	@Id
	private TaskFormPK id;
	
	private String form;

	public TaskFormPK getId() {
		return id;
	}

	public void setId(TaskFormPK id) {
		this.id = id;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}
	
	
}
