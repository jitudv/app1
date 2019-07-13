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
   
	//@Query(name="getTaskOfPerticularUser" ,nativeQuery = true)
   @Query(value = "select t.task_id, t.asign_date, t.at_complete, t.remark ,employee_task.employee_id "
   		+ "from task_table as t  join employee_task on t.task_id=employee_task.task_id where employee_task.employee_id=?1" , nativeQuery = true 
   		)
    public List<Object[]>  getTaskByUserId(int id);
	
}
