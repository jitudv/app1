package com.sny.app.taskServices;

import java.util.List;

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
public class TaskServiceImpl implements TaskService  {

	@Autowired
	TaskDao  tdao;
	 
	
	@Override
	public List<TaskUserDto> getTaskByUserId(int id)    // get Task for perticular user 
	{
		return tdao.getTaskByUserId(id); // it will return you task of perticula user 
		
	}
	
	
	@Override
	public void addTask(Task task) {
		// TODO Auto-generated method stub
		tdao.save(task);
		
	}

	@Override
	public Task getTaskById(int id) {
		// TODO Auto-generated method stub
		return  tdao.getOne(id);
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

}
