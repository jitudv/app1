package com.sny.app.payload;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;

import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;


public class TaskUserDto 
{
	int     taskId;
	String  asignDate;
	String  atComplete; 
	String  remark;
	int     employeeId;
	
	public TaskUserDto() {
		super();
	}
	
	public TaskUserDto(int taskId, String asignDate, String atComplete, String remark, int employeeId) {
		super();
		this.taskId = taskId;
		this.asignDate = asignDate;
		this.atComplete = atComplete;
		this.remark = remark;
		this.employeeId = employeeId;
	}
	public TaskUserDto(int taskId, String asignDate, String atComplete, String remark) {
		super();
		this.taskId = taskId;
		this.asignDate = asignDate;
		this.atComplete = atComplete;
		this.remark = remark;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getAsignDate() {
		return asignDate;
	}
	public void setAsignDate(String asignDate) {
		this.asignDate = asignDate;
	}
	public String getAtComplete() {
		return atComplete;
	}
	public void setAtComplete(String atComplete) {
		this.atComplete = atComplete;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}	
	
}
