package com.sny.app.taskDao;

import java.util.List;

import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;

import org.hibernate.annotations.NamedNativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sny.app.payload.TaskUserDto;
import com.sny.app.task.Task;

public interface TaskDao extends JpaRepository<Task, Integer> 
{
   
	@Query(name="getTaskOfPerticularUser" ,)
    public List<TaskUserDto>  tasksofPerticularuser();
	
}
