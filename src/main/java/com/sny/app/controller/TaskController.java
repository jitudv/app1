package com.sny.app.controller;

//import java.util.Date;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sny.app.employeeService.EmployeeService;
import com.sny.app.task.Task;
import com.sny.app.taskServices.TaskService;
import com.sny.app.user.Employee;


@CrossOrigin(origins = {"http://localhost:4200","http://localhost:4100"})
@RestController
//@RequestMapping("task/")
public class TaskController {
   
	Log  log = LogFactory.getLog(TaskController.class);
	// to get the log output 
	
	@Autowired
	TaskService ts ;
	
	@Autowired
	EmployeeService es ;
	
	@GetMapping(value="/user/task/{userid)"  , produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<Task>> getTaksByUserId(@PathVariable("userid") int id)
	{    log.warn(" task of perticular user =\t  "+ts.getTaskByUserId(id));
		// get task of perticular  employee  some times it may be  more then one  
		return ResponseEntity.ok(ts.getTaskByUserId(id));
	}
	
	@GetMapping("/task/{id}")
	public ResponseEntity<Task> getTask(@PathVariable("id") int id )
	{   
		
		return ResponseEntity.ok(ts.getTaskById(id));
		// it will return the  task  based on   id  given by  end user 
	}
	
	@GetMapping("/user/task/")
	public ResponseEntity<List<Task>> getAllTasks()
	{ 
		//  it will return  all the task   and url should be   http://localhost:8001/task/tasks
		return ResponseEntity.ok(ts.getAllTask());
	}
	
	@PostMapping(value="/admin/task/{id}" , produces =MediaType.APPLICATION_JSON_VALUE)
	@JsonIgnore
	public ResponseEntity<String> addTask(@RequestBody Task task ,@PathVariable("id")  int []ids )
	{ 
		 // url must be  http://localhost:8001/task?ids=2,3,5
        // log.info(task.getAtComplete().toString());
	     String assignDate  = new Date(System.currentTimeMillis()).toString();
		
		List<Employee> list = new ArrayList<Employee>();
        
        for(int i=(ids.length-1);i> -1;i--)
		{
		  //log.info("ar"+ar[i]);
		  list.add(es.getEmployee(ids[i])); 
		}
		task.setEmps(list);
		task.setAsignDate(assignDate);
	    ts.addTask(task);
		return  ResponseEntity.ok("your Task is added ");
	}
	
	@PutMapping("/admin/task/{id}")
	public ResponseEntity<String> updateTask(@RequestBody Task task, @PathVariable int id )
	{ 
		Task t = ts.getTaskById(id);
		t.setAsignDate(task.getAsignDate());
		t.setAtComplete(task.getAtComplete());
		t.setEmps(task.getEmps());
		t.setRemark(task.getRemark());
		ts.addTask(t);
        return  ResponseEntity.ok("your task update "+t.getId());
	}
	
	@DeleteMapping("/admin/task/{id}")
	public ResponseEntity<String> removeTask(@PathVariable("id") int id )
	{
	   ts.removeTask(id);
	   return ResponseEntity.ok("your entity deleted ");
	}
	
	@GetMapping("/user/task/users")
	public ResponseEntity<List<Employee>> taskAssignedUsers(@RequestParam("id") int ar[])
	{ 
		List<Employee> list = new ArrayList<Employee>();
        log.info("this is array length"+ar.length);
    
		for(int i=(ar.length-1);i> -1;i--)
		{
		  //log.info("ar"+ar[i]);
		  list.add(es.getEmployee(ar[i])); 
		}
         
		return ResponseEntity.ok(list);
		}
	
	
}
