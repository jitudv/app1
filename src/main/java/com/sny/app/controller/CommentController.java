package com.sny.app.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
         CommentService  cs;  // commment service 
         
         @Autowired
          EmployeeService  es;  // employee service 
           
         @Autowired
         TaskService  ts ;     // task service 
         
         
         
	
  @PostMapping("/user/comment/{userid}/{taskid}/")
  public ResponseEntity<ApiResponse> addComment(@RequestBody Comment comment  ,@PathVariable("userid") int uid, @PathVariable("taskid") int tid )
  {
	log.warn(" \t \t \t \t \t this is  commenter "+es.getEmployee(uid));
	comment.setTask(ts.getOne(tid));
	log.warn(" \\t\\t\\t\\t\\t    this is  task comment on  "+ts.getTaskById(tid));
	comment.setEmp(es.getEmployee(uid));
	cs.addcomment(comment);
    ApiResponse response  = new ApiResponse();
	response.setMessage("yes working "+uid+" \t comment is "+comment.getEmp().getName()+comment.getTask().getRemark()+comment.getCommentRemark()+"\t taskid is "+tid);
    return ResponseEntity.ok().body(response);
  }   //  add a comment on the perticular task 
  
   
  
  @GetMapping("/user/comment/{commentId}")
  public ResponseEntity<Comment> getComment(@PathVariable("commentId") int id)
  {
	 return  ResponseEntity.ok(cs.getComment(id));  
  }
  
  
  
	
}
