package dao;

import java.util.ArrayList;

import models.User;

public interface UserDAO {
	
	public int verifyLogin(String email, String password);

	public int exist(String email);

	public int addUser(User user);

	public User getUserById(int id);

	public User getUserByUsername(String email);

	public int updateUser(User user);
	
	// public int editUser(User user);

	public ArrayList<User> getAllUsers();
	
	public ArrayList<User> getAllOtherUsers(int id);

	public int deleteUser(int id);

	public int verifyRole(String email, String password);

}
