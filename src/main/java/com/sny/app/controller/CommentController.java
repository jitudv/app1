package com.sny.app.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sny.app.commentService.CommentService;
import com.sny.app.employeeService.EmployeeService;
import com.sny.app.payload.ApiResponse;
import com.sny.app.task.Comment;
import com.sny.app.taskServices.TaskService;

@RestController

public class CommentController {

	
 Log log  = LogFactory.getLog(CommentController.class);
 
         @Autowired
         CommentService  cs;
         
         @Autowired
          EmployeeService  es;
         
         @Autowired
         TaskService  ts ;
	
  @GetMapping("/user/comment/{userid}/{taskid}/")
  public ResponseEntity<ApiResponse> addComment(@RequestBody Comment comment  ,@PathVariable("userid") int uid, @PathVariable("taskid") int tid )
  {
	  
	
	log.warn("this is  commenter "+es.getEmployee(uid));
	//comment.setTask(ts.getTaskById(tid));
	log.warn("this is  task comment on  "+ts.getTaskById(tid));
	//comment.setEmp(es.getEmployee(uid));
    ApiResponse response  = new ApiResponse();
	response.setMessage("yes working "+uid+" \t comment is "+comment+"\t taskid is "+tid);
    return ResponseEntity.ok().body(response);
  }
	
}
