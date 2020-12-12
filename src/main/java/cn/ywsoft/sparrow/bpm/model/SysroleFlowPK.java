package cn.ywsoft.sparrow.bpm.model;

import java.io.Serializable;

public class SysroleFlowPK implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sysroleId;
	private String flowId;
	
	
	public String getSysroleId() {
		return sysroleId;
	}
	public void setSysroleId(String sysroleId) {
		this.sysroleId = sysroleId;
	}
	public String getFlowId() {
		return flowId;
	}
	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}
}
