package com.sny.app.commentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import com.sny.app.commentDao.CommentDao;
import com.sny.app.task.Comment;

@Service
@EnableJpaRepositories("com.sny.app.commentDao")
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentDao cd;

	@Override
	public void addcomment(Comment comment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletComment(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateComment(Comment comment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getComment(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Comment> getcomments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comment getCommentByUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> getCommentOfPerticularEmployee(int userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
