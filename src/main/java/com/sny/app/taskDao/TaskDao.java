package com.sny.app.taskDao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sny.app.task.Task;

public interface TaskDao extends JpaRepository<Task, Integer> 
{
  //
	@Query( value = "select * from  Task where user id=?1", nativeQuery = true)
	public List<Task> getTaskByUserId(int id);
}
