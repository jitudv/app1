package com.sny.app.task;
import java.sql.Date;
import java.util.List;
import com.sny.app.user.*;

import javax.persistence.*;
@Entity
@Table(name="task_table")
public class Task implements Comparable<Task>  
{
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="task_id")
  int id ;
  
  @Column
  String remark;
  
  @Column
  String asignDate ;
  
  @Column
  String atComplete;
   
  @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "employee_task",
    joinColumns = { @JoinColumn(name = "task_id") },
 	inverseJoinColumns = { @JoinColumn(name = "employee_id") })
  List<Employee> emps ;
   
  @OneToMany(targetEntity = Comment.class,cascade = CascadeType.ALL)
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

@Override
public int compareTo(Task o) 
{
    // TODO Auto-generated method stub
	return this.id-o.id;
}
    
}
