package dao;

import java.util.ArrayList;

import models.Post;

public interface PostDAO {
	
	public int addPost(Post post);

	public int updatePost(Post post);

	public Post getPostById(int id);

	public ArrayList<Post> getAllPosts();

	public int deletePost(int id);

}
