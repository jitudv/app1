package com.sny.app.commentDao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.sny.app.task.*;

public interface CommentDao extends JpaRepository<Comment, Integer> 
{

 public  Comment findByEmployeeId(int userId);

 	 	
}
