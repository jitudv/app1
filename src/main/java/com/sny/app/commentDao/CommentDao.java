package com.sny.app.commentDao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.sny.app.task.*;

public interface CommentDao extends JpaRepository<Comment, Integer> 
{

 public  Comment findByEmployeeId(int userId);
 public  List<Comment> findByTaskId(int taskid);
 	 	
}
