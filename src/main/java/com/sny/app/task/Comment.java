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
    String commentRemark;
    
    @Column
    String dateTimeComment;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    Task task ;
    
    
    
    @OneToOne(cascade = CascadeType.PERSIST , orphanRemoval=true)
    Employee employee;

	public Comment(String commentRemark, String dateTimeComment) {
		super();
		this.commentRemark = commentRemark;
		this.dateTimeComment = dateTimeComment;
	}

	public Comment(int id, String commentRemark, String dateTimeComment, Task task, Employee employee) {
		super();
		this.id = id;
		this.commentRemark = commentRemark;
		this.dateTimeComment = dateTimeComment;
		this.task = task;
		this.employee = employee;
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
		return commentRemark;
	}

	public void setCommetn(String commentRemark) {
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
		return employee;
	}

	public void setEmp(Employee employee) {
		this.employee = employee;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commentRemark == null) ? 0 : commentRemark.hashCode());
		result = prime * result + ((dateTimeComment == null) ? 0 : dateTimeComment.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
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
		if (commentRemark == null) {
			if (other.commentRemark != null)
				return false;
		} else if (!commentRemark.equals(other.commentRemark))
			return false;
		if (dateTimeComment == null) {
			if (other.dateTimeComment != null)
				return false;
		} else if (!dateTimeComment.equals(other.dateTimeComment))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
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
		return "Comment [id=" + id + ", commetn=" + commentRemark + ", dateTimeComment=" + dateTimeComment + ", task=" + task
				+ ", emp=" + employee + "]";
	}

	@Override
	public int compareTo(Comment o) {
		// TODO Auto-generated method stub
		return this.id-o.id;
	}
    
    
    
}
