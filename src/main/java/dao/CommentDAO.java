package dao;

import java.util.ArrayList;

import models.Comment;

public interface CommentDAO {
	
	public int addComment(Comment comment);

	public int updateComment(Comment comment);

	public Comment getCommentById(int id);

	public ArrayList<Comment> getAllComments();
	
	public ArrayList<Comment> getAllCommentsByPost(int id);

	public int deleteComment(int id);

}
