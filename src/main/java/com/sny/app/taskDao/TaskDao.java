package com.sny.app.taskDao;

import java.util.List;

import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;

import org.hibernate.annotations.NamedNativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sny.app.payload.TaskUserDto;
import com.sny.app.task.Task;

public interface TaskDao extends JpaRepository<Task, Integer> 
{
   
	//@Query(name="getTaskOfPerticularUser" ,nativeQuery = true)
   @Query(value = "select t.task_id, t.asign_date, t.at_complete, t.remark, employee_task.employee_id,t.completed "
   		+ "from task_table as t  join employee_task on t.task_id=employee_task.task_id where employee_task.employee_id=?1" , nativeQuery = true 
   		)
    public  List<Object[]> getTaskByUserId(int id);  // this is for admin  
    
    @Query(value="select *  from task_table where task_id=?1",nativeQuery = true)
    public  List<Object[]>  getTaskById(int id);
    
    @Query(value="update task_table  set completed =1 where task_id=?1",nativeQuery = true)
    @Modifying
    public void changeTaskCompleted(int id );
   
    
   @Query(value = "select t.*  from task_table as t  "
   		+ " left join  employee_task on employee_task.task_id=t.task_id "
   		+ "where  employee_task.employee_id = ?1  and  t.completed < 1 ;" , nativeQuery = true ) 
   public List<Task> getRunningTask(int id);
    
 	
}
