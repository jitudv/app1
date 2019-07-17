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
	short     completed ;
	
	public TaskUserDto() {
		super();
	}
	
	public TaskUserDto(int taskId, String asignDate, String atComplete, String remark, int employeeId ,short completed ) {
		super();
		this.taskId = taskId;
		this.asignDate = asignDate;
		this.atComplete = atComplete;
		this.remark = remark;
		this.employeeId = employeeId;
		this.completed=completed;
	}
	public TaskUserDto(int taskId, String asignDate, String atComplete, String remark) {
		super();
		this.taskId = taskId;
		this.asignDate = asignDate;
		this.atComplete = atComplete;
		this.remark = remark;
	}
	public short getCompleted() {
		return completed;
	}

	public void setCompleted(short completed) {
		this.completed = completed;
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
