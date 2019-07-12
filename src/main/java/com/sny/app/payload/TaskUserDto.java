package com.sny.app.payload;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;

import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

@SqlResultSetMapping(
	    name="TaskUserDto",
	    classes={
	        @ConstructorResult(
	           targetClass=TaskUserDto.class,
	              columns={
	            		  @ColumnResult(name="task_id", type = Integer.class),
	            		  @ColumnResult(name="asign_date", type = String.class),
	            		  @ColumnResult(name="at_complete", type = String.class),
	            		  @ColumnResult(name="remark", type = String.class),
	            		  @ColumnResult(name="employee_id", type = Integer.class)
	                    }   
	           )
	    }
	) 
@NamedNativeQuery(
	    name="getTaskOfPerticularUser", 
	    query="select t.task_id, t.asign_date, t.at_complete, t.remark  from task_table as t  join employee_task on t.task_id=employee_task.task_id where employee_task.employee_id=6", 
	    resultSetMapping="TaskUserDto")
public class TaskUserDto 
{
	int     task_id;
	String  asign_date;
	String  at_complete; 
	String  remark;
	int     employee_id;
	
	
	
	public TaskUserDto() {
		super();
	}
	
	public TaskUserDto(int task_id, String asign_date, String at_complete, String remark, int employee_id) {
		super();
		this.task_id = task_id;
		this.asign_date = asign_date;
		this.at_complete = at_complete;
		this.remark = remark;
		this.employee_id = employee_id;
	}
	
	public int getTask_id() {
		return task_id;
	}
	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}
	public String getAsign_date() {
		return asign_date;
	}
	public void setAsign_date(String asign_date) {
		this.asign_date = asign_date;
	}
	public String getAt_complete() {
		return at_complete;
	}
	public void setAt_complete(String at_complete) {
		this.at_complete = at_complete;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	
	
	
	
}
