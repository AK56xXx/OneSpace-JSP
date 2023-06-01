package extra.test;

import models.Comment;

import java.util.ArrayList;

import dao.CommentDAOImpl;

public class Program {

	public static void main(String[] args) {
		
		Comment comment = new Comment();
		CommentDAOImpl cd = new CommentDAOImpl();
		ArrayList<Comment> list = new ArrayList<Comment>();
		
		list = cd.getAllCommentsByPost(1);
		
		for(Comment c : list)
		{
			System.out.println(c.getReply());
		}

	}

}
