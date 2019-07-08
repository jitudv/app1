package com.sny.app.task;
import java.sql.Date;

import  javax.persistence.*;

import com.sny.app.user.Employee;
@Entity
@Table(name="comment_table")
public class Comment  implements Comparable<Comment>
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="comment_id")
    int id ;
    
    @Column
    String commetn;
    
    @Column
    String dateTimeComment;
    
    @ManyToOne()
    @JoinColumn(name = "task_id")
    Task task ;
    
    @OneToOne(cascade = CascadeType.PERSIST)
    Employee emp;

	public Comment(String commetn, String dateTimeComment) {
		super();
		this.commetn = commetn;
		this.dateTimeComment = dateTimeComment;
	}

	public Comment(int id, String commetn, String dateTimeComment, Task task, Employee emp) {
		super();
		this.id = id;
		this.commetn = commetn;
		this.dateTimeComment = dateTimeComment;
		this.task = task;
		this.emp = emp;
	}

	public Comment() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCommetn() {
		return commetn;
	}

	public void setCommetn(String commetn) {
		this.commetn = commetn;
	}

	public String getDateTimeComment() {
		return dateTimeComment;
	}

	public void setDateTimeComment(String dateTimeComment) {
		this.dateTimeComment = dateTimeComment;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commetn == null) ? 0 : commetn.hashCode());
		result = prime * result + ((dateTimeComment == null) ? 0 : dateTimeComment.hashCode());
		result = prime * result + ((emp == null) ? 0 : emp.hashCode());
		result = prime * result + id;
		result = prime * result + ((task == null) ? 0 : task.hashCode());
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
		Comment other = (Comment) obj;
		if (commetn == null) {
			if (other.commetn != null)
				return false;
		} else if (!commetn.equals(other.commetn))
			return false;
		if (dateTimeComment == null) {
			if (other.dateTimeComment != null)
				return false;
		} else if (!dateTimeComment.equals(other.dateTimeComment))
			return false;
		if (emp == null) {
			if (other.emp != null)
				return false;
		} else if (!emp.equals(other.emp))
			return false;
		if (id != other.id)
			return false;
		if (task == null) {
			if (other.task != null)
				return false;
		} else if (!task.equals(other.task))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", commetn=" + commetn + ", dateTimeComment=" + dateTimeComment + ", task=" + task
				+ ", emp=" + emp + "]";
	}

	@Override
	public int compareTo(Comment o) {
		// TODO Auto-generated method stub
		return this.id-o.id;
	}
    
    
    
}
