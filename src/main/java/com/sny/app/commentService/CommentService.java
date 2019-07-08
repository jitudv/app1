package com.sny.app.commentService;
import java.util.List;

import com.sny.app.task.*;

public interface CommentService 
{
 public void addcomment(Comment comment);
 public void deletComment(int id);
 public void updateComment(Comment comment);
 public void getComment(int id );
 public List<Comment> getcomments();
 public Comment getCommentByUser(int userId);
 public List<Comment> getCommentOfPerticularEmployee(int userId);
}
