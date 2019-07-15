package com.sny.app.commentDao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sny.app.task.*;

public interface CommentDao extends JpaRepository<Comment, Integer> 
{
 //  comment dao
 	 	
}
