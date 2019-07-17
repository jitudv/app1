package com.sny.app.task;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

//@SqlResultSetMapping(
//		name = "TaskUserDto", 
//		entities = @EntityResult(
//			entityClass = Task.class, 
//			fields = {
//				@FieldResult(name = "taskId", column = "id"),
//				@FieldResult(name = "asignDate", column = "asign_date"),
//				@FieldResult(name = "atComplete", column = "at_complete"),
//				@FieldResult(name = "remark", column = "remark"),
//				@FieldResult(name = "employeeId", column = "employee_id")}))
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
  
  @Column
  short  completed;  // 1  for complete the task and  0  is  not completed  default value is 0     
  
   
    @ManyToMany(cascade = CascadeType.DETACH , fetch=FetchType.LAZY)
    @JoinTable(name = "employee_task",
    joinColumns = { @JoinColumn(name = "task_id") },
 	inverseJoinColumns = { @JoinColumn(name = "employee_id")})
    Set<Employee> employees ;
   
    @OneToMany(targetEntity = Comment.class,cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    Set<Comment> comments ;
  
    public Task(String remark, String atComplete) {
	super();
	this.remark = remark;
	this.atComplete = atComplete;
   }

  
public Task(String remark, String asignDate,  String atComplete, short completed) {

	super();
	this.remark = remark;
	this.asignDate = asignDate;
	this.atComplete = atComplete;
	this.completed=completed;
}

public Task()
{
	super();
}

public Task(int id, String remark, String asignDate,  String atComplete, Set<Employee> employees, Set<Comment> comments)

{
	super();
	this.id = id;
	this.remark = remark;
	this.asignDate = asignDate;
	this.atComplete = atComplete;
	this.employees = employees;
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

//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public Set<Employee> getEmps() {
	return employees;
}

public void setEmps(Set<Employee> employees) {
	this.employees = employees;
}

//@Override
//public String toString() {
//	return "Task [id=" + id + ", remark=" + remark + ", asignDate=" + asignDate + ", atComplete=" + atComplete
//			+ ", emps=" + employees + "]";
//}


public Set<Comment> getComments() {
	return comments;
}


public short getCompleted() {
	return completed;
}


public void setCompleted(short completed) {
	this.completed = completed;
}


public Set<Employee> getEmployees() {
	return employees;
}


public void setEmployees(Set<Employee> employees) {
	this.employees = employees;
}


public void setComments(Set<Comment> comments) {
	this.comments = comments;
}


@Override
public int compareTo(Task o) 
{
    // TODO Auto-generated method stub
	return this.id-o.id;
}
    
}
