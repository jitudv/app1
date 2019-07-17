package com.sny.app.taskServices;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sny.app.payload.TaskUserDto;
import com.sny.app.task.Task;
import com.sny.app.taskDao.TaskDao;

@Service
@Transactional
@EnableJpaRepositories("com.sny.app.taskDao")
public class TaskServiceImpl implements TaskService {
   
	Log  log  = LogFactory.getLog(TaskServiceImpl.class);
    
	
	@Autowired
	TaskDao  tdao;
	
	
	private List<TaskUserDto> list =  null;
	
    @Override
	public List<TaskUserDto> getTaskByUserId(int id)    // get Task for perticular user 
	{ 
         list = new ArrayList<>();
		 List<Object[]> res = tdao.getTaskByUserId(id); // it will return you task of perticula user
		 res.stream().forEach((record) -> {
			    Integer tid = ((Integer) record[0]);
		        String asindate = (String) record[1];
		        String atcomplite = (String) record[2];
		        String remark = (String) record[3];
		        Integer empid = (Integer) record[4];
		        Short completed=(Short)record[5];
		        //log.warn(" yes we are in stream task is  "+tid );
		       list.add(new TaskUserDto(tid, asindate, atcomplite, remark,empid,completed));       
		 });
		 log.warn("no of task of perticular user is  \t\t"+list.size());
		
		// list.add(new TaskUserDto(101,"20-20-2012","2012-12-12","dumy for test ",10245));
	   	return list;
	}
	
	@Override
	public void addTask(Task task) {
		// TODO Auto-generated method stub
		tdao.save(task);
		
	}

	@Override
	public TaskUserDto getTaskById(int id) {
		// TODO Auto-generated method stub
		
		  TaskUserDto dto =  new TaskUserDto();
		
		log.warn("task fatch by task id is  = \t  "+tdao.getOne(id));
		List<Object[]> res = tdao.getTaskById(id);
		res.stream().forEach((record) ->{
			log.warn(" this is the record of the object \t\t\t\t "+record[0]);
			Integer taskid = (Integer) record[0];
		    String  assdate= (String) record[1];
		    String compdate = (String)record[2];
		    String remark = (String )record[3];
		    Short status =(Short) record[4];
		    dto.setTaskId(taskid);
		    dto.setAsignDate(assdate);
		    dto.setAtComplete(compdate);
		    dto.setRemark(remark);
		    dto.setCompleted(status);
		    
		   
		});
		
		  return dto; //  getTaskById() taskDao method  
	}

	@Override
	public void updateTask(Task task) {
		// TODO Auto-generated method stub
		tdao.save(task);
	}

	@Override
	public List<Task> getAllTask() {
		// TODO Auto-generated method stub
		return  tdao.findAll();
	}

	@Override
	public void removeTask(int id) {
		// TODO Auto-generated method stub
		tdao.deleteById(id);
	}

	@Override
	public void changeTaskCompleted(int id) {
	  tdao.changeTaskCompleted(id);  // changeTaskCompleted this is the method is from TaskDao repository 
	  log.warn("task status is changed  no completed task id is  =\t"+id);
	  //return ob;
	}

	@Override
	public Task getOne(int id) {
		// TODO Auto-generated method stub
		return tdao.getOne(id);
	}


	
}
