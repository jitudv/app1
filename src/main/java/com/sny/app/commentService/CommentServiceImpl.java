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
	   cd.save(comment);	
	}

	@Override
	public void deletComment(int id) {
		cd.delete(cd.getOne(id));
		
	}

	@Override
	public void updateComment(Comment comment) {
		 Comment cm =   new Comment();
		 cm.setCommentRemark(comment.getCommentRemark());
		 cm.setDateTimeComment(comment.getDateTimeComment());
		 cm.setEmp(comment.getEmp());
		 cm.setId(comment.getId());
		 cm.setTask(comment.getTask());
		 cd.save(cm);
		}

	@Override
	public Comment getComment(int id) {
		 return  cd.findById(id).get();
				 
	}

	@Override
	public List<Comment> getcomments() {
		
		return cd.findAll();
	}

	@Override
	public Comment getCommentByUser(int userId) {
		// TODO Auto-generated method stub
		return  cd.findByEmployeeId(userId);
	}

	@Override
	public List<Comment> getCommentOfPerticularEmployee(int userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
