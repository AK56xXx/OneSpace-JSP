package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import models.Comment;

public class CommentDAOImpl implements CommentDAO {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public CommentDAOImpl() {
		con = extra.db.DataBaseConnection.getConnected();
	}

	@Override
	public int addComment(Comment comment) {
		try {
			ps = con.prepareStatement("INSERT INTO comment (reply,posted_by,post_id) Values (?,?,?)");
			
			ps.setString(1, comment.getReply());
			ps.setInt(2, comment.getIdUser());
			ps.setInt(3, comment.getIdPost());

			int i = ps.executeUpdate();
			if (i > 0)
				return 1;
			else
				return 0;
		} catch (Exception e) {
			System.out.println("Connection error : addComment " + e);
		}
		return -1;
	}

	@Override
	public int updateComment(Comment comment) {
		try {
			ps = con.prepareStatement("update comment set reply=?" + "where id=? ");

			ps.setString(1, comment.getReply());

			ps.setInt(2, comment.getId());

			int i = ps.executeUpdate();
			if (i > 0)
				return 1;
			else
				return 0;
		} catch (Exception e) {
			System.out.println("Connection error : updateComment " + e);
		}
		return -1;
	}

	@Override
	public Comment getCommentById(int id) {
		try {
			Comment comment = new Comment();
			ps = con.prepareStatement("select * from comment where id=?");

			ps.setInt(1, id);

			rs = ps.executeQuery();

			if (rs.next()) {
				
				ps.setInt(1, comment.getId());
				ps.setString(2, comment.getReply());
				ps.setInt(3, comment.getIdUser());
				ps.setString(4, comment.getPostedAt());
				ps.setInt(5, comment.getIdPost());
				
			}
			return comment;

		} catch (Exception e) {
			System.out.println("Connection error : getCommentById");
		}

		return null;
	}

	@Override
	public ArrayList<Comment> getAllComments() {
		try {
			
			ArrayList<Comment> list = new ArrayList<Comment>();
			ps = con.prepareStatement("select * from comment");


			rs = ps.executeQuery();

			if (rs.next()) {
				Comment comment = new Comment();
				ps.setInt(1, comment.getId());
				ps.setString(2, comment.getReply());
				ps.setInt(3, comment.getIdUser());
				ps.setString(4, comment.getPostedAt());
				ps.setInt(5, comment.getIdPost());
				
				list.add(comment);
				
			}
			return list;

		} catch (Exception e) {
			System.out.println("Connection error : getAllComments");
		}

		return null;
	}

	@Override
	public int deleteComment(int id) {
		try {
			ps = con.prepareStatement("DELETE from comment where id=?");
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if (i > 0)
				return 1;
			else
				return 0;
		} catch (Exception e) {
			System.out.println("Connection error : deleteComment " + e);
		}
		return -1;
	}

	@Override
	public ArrayList<Comment> getAllCommentsByPost(int id) {
		try {
	        ArrayList<Comment> list = new ArrayList<Comment>();
	        ps = con.prepareStatement("SELECT * FROM comment WHERE post_id=?");
	        ps.setInt(1, id);
	        rs = ps.executeQuery();

	        while (rs.next()) {
	            Comment comment = new Comment();
	            comment.setId(rs.getInt("id"));
	            comment.setReply(rs.getString("reply"));
	            comment.setIdUser(rs.getInt("posted_by"));
	            comment.setPostedAt(rs.getString("posted_at"));
	            comment.setIdPost(rs.getInt("post_id"));

	            list.add(comment);
	        }

	        return list;
	    } catch (Exception e) {
	        System.out.println("Connection error: getAllCommentsByPost");
	        e.printStackTrace();
	    }

	    return null;
	}

}
