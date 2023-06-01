package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import models.Post;

public class PostDAOImpl implements PostDAO {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public PostDAOImpl() {
		con = extra.db.DataBaseConnection.getConnected();
	}

	@Override
	public int addPost(Post post) {
		try {
			ps = con.prepareStatement("INSERT INTO post (text,posted_by) Values (?,?)");
			
			ps.setString(1, post.getText());
			ps.setInt(2, post.getIdUser());

			int i = ps.executeUpdate();
			if (i > 0)
				return 1;
			else
				return 0;
		} catch (Exception e) {
			System.out.println("Connection error : addPost " + e);
		}
		return -1;
	}

	@Override
	public int updatePost(Post post) {
		try {
			ps = con.prepareStatement("update post set text=?" + "where id=?");

			ps.setString(1, post.getText());

			ps.setInt(2, post.getId());

			int i = ps.executeUpdate();
			if (i > 0)
				return 1;
			else
				return 0;
		} catch (Exception e) {
			System.out.println("Connection error : updatePost " + e);
		}
		return -1;
	}

	@Override
	public Post getPostById(int id) {
		try {
			Post post = new Post();
			ps = con.prepareStatement("select * from post where id=?");

			ps.setInt(1, id);

			rs = ps.executeQuery();

			if (rs.next()) {

				post.setId(rs.getInt(1));
				post.setText(rs.getString(2));
				post.setIdUser(rs.getInt(3));
				post.setPostedAt(rs.getString(4));

			}
			return post;

		} catch (Exception e) {
			System.out.println("Connection error : getAnnouncementById");
		}

		return null;
	}

	@Override
	public ArrayList<Post> getAllPosts() {
		try {
			ArrayList<Post> list = new ArrayList<Post>();
			ps = con.prepareStatement("select * from post order by posted_at desc");


			rs = ps.executeQuery();

			while (rs.next()) {
				Post post = new Post();

				post.setId(rs.getInt(1));
				post.setText(rs.getString(2));
				post.setIdUser(rs.getInt(3));
				post.setPostedAt(rs.getString(4));
				
				list.add(post);

			}
			return list;

		} catch (Exception e) {
			System.out.println("Connection error : getAnnouncementById");
		}

		return null;
	}

	@Override
	public int deletePost(int id) {
		try {
			ps = con.prepareStatement("DELETE from post where id=?");
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if (i > 0)
				return 1;
			else
				return 0;
		} catch (Exception e) {
			System.out.println("Connection error : deletePost " + e);
		}
		return -1;
	}

}
