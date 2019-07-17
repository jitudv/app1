package com.sny.app.taskServices;

import java.util.List;

import com.sny.app.payload.TaskUserDto;
import com.sny.app.task.Task;

public interface TaskService {
 public void addTask(Task task);  // save task 
 public TaskUserDto getTaskById(int id);  // get  a single Task
 public void updateTask(Task task);   // update privious assign Task 
 public List<Task> getAllTask();  // get all Tasks assigned 
 public void removeTask(int id);   // remove Task  from tasks  based on id 
 public List<TaskUserDto> getTaskByUserId(int id); // get Tasks of perticular user 
 public void changeTaskCompleted(int id);
 public Task  getOne(int id);
}

