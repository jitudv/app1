package com.sny.app.task;
import java.sql.Date;
import java.util.List;

import com.sny.app.payload.TaskUserDto;
import com.sny.app.user.*;

import javax.persistence.*;


//@SqlResultSetMapping(
//	    name="TaskUserDto",
//	    classes={
//	        @ConstructorResult(
//	        targetClass=TaskUserDto.class,
//	              columns={
//	            		  @ColumnResult(name="task_id",     type = Integer.class),
//	            		  @ColumnResult(name="asign_date",  type = String.class),
//	            		  @ColumnResult(name="at_complete", type = String.class),
//	            		  @ColumnResult(name="remark",      type = String.class),
//	            		  @ColumnResult(name="empid",       type = Integer.class)
//	                    }   
//	           )}
//	) 

@SqlResultSetMapping(
		name = "TaskUserDto", 
		entities = @EntityResult(
			entityClass = Task.class, 
			fields = {
				@FieldResult(name = "taskId", column = "id"),
				@FieldResult(name = "asignDate", column = "asign_date"),
				@FieldResult(name = "atComplete", column = "at_complete"),
				@FieldResult(name = "remark", column = "remark"),
				@FieldResult(name = "employeeId", column = "employee_id")}))
//
//@NamedNativeQuery(
//	    name="getTaskOfPerticularUser", 
//	    query="select t.task_id, t.asign_date, t.at_complete, t.remark  from task_table as t  join employee_task on t.task_id=employee_task.task_id where employee_task.employee_id=?1", 
//	    resultSetMapping="TaskUserDto")
//

@Entity
@Table(name="task_table")
public class Task implements Comparable<Task>  
{
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="task_id")
  int id ;
  
  @Column
  String remark;
  
  @Column
  String asignDate ;
  
  @Column
  String atComplete;
  
//  @Column
//  short  completed;  // true for complete the task and false is  not completed    
//  
   
    @ManyToMany(cascade = CascadeType.DETACH , fetch=FetchType.LAZY)
    @JoinTable(name = "employee_task",
    joinColumns = { @JoinColumn(name = "task_id") },
 	inverseJoinColumns = { @JoinColumn(name = "employee_id")})
    List<Employee> emps ;
   
    @OneToMany(targetEntity = Comment.class,cascade = CascadeType.PERSIST)
    List<Comment> comments ;
  
  public Task(String remark, String atComplete) {
	super();
	this.remark = remark;
	this.atComplete = atComplete;
   }

  
public Task(String remark, String asignDate,  String atComplete) {

	super();
	this.remark = remark;
	this.asignDate = asignDate;
	this.atComplete = atComplete;
}

public Task()
{
	super();
}

public Task(int id, String remark, String asignDate,  String atComplete, List<Employee> emps, List<Comment> comments)

{
	super();
	this.id = id;
	this.remark = remark;
	this.asignDate = asignDate;
	this.atComplete = atComplete;
	this.emps = emps;
	this.comments = comments;
}

public int getId() 
{
	return id;
}

public void setId(int id)
{
	this.id = id;
}

public String getRemark() 
{
	return remark;
}

public void setRemark(String remark)
{
	this.remark = remark;
}

@Override
public int hashCode() 
{
	final int prime = 31;
	int result = 1;
	result = prime * result + ((asignDate == null) ? 0 : asignDate.hashCode());
	result = prime * result + ((atComplete == null) ? 0 : atComplete.hashCode());
	result = prime * result + ((emps == null) ? 0 : emps.hashCode());
	result = prime * result + id;
	result = prime * result + ((remark == null) ? 0 : remark.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Task other = (Task) obj;
	if (asignDate == null) {
		if (other.asignDate != null)
			return false;
	} else if (!asignDate.equals(other.asignDate))
		return false;
	if (atComplete == null) {
		if (other.atComplete != null)
			return false;
	} else if (!atComplete.equals(other.atComplete))
		return false;
	if (emps == null) {
		if (other.emps != null)
			return false;
	} else if (!emps.equals(other.emps))
		return false;
	if (id != other.id)
		return false;
	if (remark == null) {
		if (other.remark != null)
			return false;
	} else if (!remark.equals(other.remark))
		return false;
	return true;
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

public List<Employee> getEmps() {
	return emps;
}

public void setEmps(List<Employee> emps) {
	this.emps = emps;
}

@Override
public String toString() {
	return "Task [id=" + id + ", remark=" + remark + ", asignDate=" + asignDate + ", atComplete=" + atComplete
			+ ", emps=" + emps + "]";
}

public List<Comment> getComments() {
	return comments;
}


public void setComments(List<Comment> comments) {
	this.comments = comments;
}


@Override
public int compareTo(Task o) 
{
    // TODO Auto-generated method stub
	return this.id-o.id;
}
    
}
