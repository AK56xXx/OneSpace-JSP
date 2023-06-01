package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import models.User;

public class UserDAOImpl implements UserDAO {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public UserDAOImpl() {
		con = extra.db.DataBaseConnection.getConnected();
	}

	@Override
	public int verifyLogin(String username, String password) {
		try {
			ps = con.prepareStatement("SELECT * from user where username=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next())
				return 1;
			else
				return 0;
		} catch (Exception e) {
			System.out.println("Connection error : verifyLogin");
		}

		return -1;
	}

	@Override
	public int exist(String username) {
		try {
			ps = con.prepareStatement("SELECT * from user where username=?");
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next())
				return 1;
			else
				return 0;
		} catch (Exception e) {
			System.out.println("Connection error : exist");
		}

		return -1;
	}

	@Override
	public int addUser(User user) {
		try {
			ps = con.prepareStatement("INSERT INTO user (fname,lname,email,tel,position,username,password,role) Values (?, ?, ?, ?, ?, ?, ?, ?, ?)");

			ps.setString(1, user.getFname());
			ps.setString(2, user.getLname());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getTel());
			ps.setString(5, user.getPosition());
			ps.setString(6, user.getUsername());
			ps.setString(7, user.getPassword());
			ps.setString(8, user.getRole());
		
			int i = ps.executeUpdate();
			if (i > 0)
				return 1;
			else
				return 0;
		} catch (Exception e) {
			System.out.println("Connection error : addUser " + e);
		}
		return -1;
	}

	@Override
	public User getUserById(int id) {
		try {
			User user = new User();
			ps = con.prepareStatement("SELECT * from user where id=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {

				user.setId(rs.getInt(1));
				user.setFname(rs.getString(2));
				user.setLname(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setTel(rs.getString(5));
				user.setPosition(rs.getString(6));
				user.setUsername(rs.getString(7));
				user.setPassword(rs.getString(8));
				user.setPicture(rs.getBlob(9));
				user.setRole(rs.getString(10));
				
			}
			return user;

		} catch (Exception e) {
			System.out.println("Connection error : getUserById");
		}

		return null;
	}

	@Override
	public User getUserByUsername(String username) {
		try {
			User user = new User();
			ps = con.prepareStatement("SELECT * from user where username=?");
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				
				user.setId(rs.getInt(1));
				user.setFname(rs.getString(2));
				user.setLname(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setTel(rs.getString(5));
				user.setPosition(rs.getString(6));
				user.setUsername(rs.getString(7));
				user.setPassword(rs.getString(8));
				user.setPicture(rs.getBlob(9));
				user.setRole(rs.getString(10));
	
			}
			
		return user;
		
		} catch (Exception e) {
			System.out.println("Connection error : getUserByUsername");
		}

		return null;
	}

	@Override
	public int updateUser(User user) {
		try {
			ps = con.prepareStatement("UPDATE user SET fname=?, lname=?, email=?, tel=?, position=?, username=?, password=?, picture=?, role=? WHERE id=?");


			// Set the values of the prepared statement
	        ps.setString(1, user.getFname());
	        ps.setString(2, user.getLname());
	        ps.setString(3, user.getEmail());
	        ps.setString(4, user.getTel());
	        ps.setString(5, user.getPosition());
	        ps.setString(6, user.getUsername());
	        ps.setString(7, user.getPassword());
	        ps.setBlob(8, user.getPicture());
	        ps.setString(9, user.getRole());
	        ps.setInt(10, user.getId());

			int i = ps.executeUpdate();
			if (i > 0)
				return 1;
			else
				return 0;
		} catch (Exception e) {
			System.out.println("Connection error : updateUser " + e);
		}
		return -1;
	}

	@Override
	public ArrayList<User> getAllUsers() {
		try {

			ArrayList<User> list = new ArrayList<User>();
			ps = con.prepareStatement("SELECT * from user");
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				
				user.setId(rs.getInt(1));
				user.setFname(rs.getString(2));
				user.setLname(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setTel(rs.getString(5));
				user.setPosition(rs.getString(6));
				user.setUsername(rs.getString(7));
				user.setPassword(rs.getString(8));
				user.setPicture(rs.getBlob(9));
				user.setRole(rs.getString(10));

				list.add(user);
			}
			return list;

		} catch (Exception e) {
			System.out.println("Connection error : getAllUsers");
		}

		return null;
	}

	@Override
	public int deleteUser(int id) {
		try {
			ps = con.prepareStatement("DELETE from user where id=?");
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if (i > 0)
				return 1;
			else
				return 0;
		} catch (Exception e) {
			System.out.println("Connection error : deleteUser " + e);
		}
		return -1;
	}

	@Override
	public int verifyRole(String username, String password) {
		try {
			ps = con.prepareStatement("SELECT * from user where username=? and password=? and role=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, "admin");
			rs = ps.executeQuery();
			if (rs.next())
				return 1;
			else
				return 0;
		} catch (Exception e) {
			System.out.println("Connection error : verifyRole " + e.getMessage());
		}

		return -1;
	}

	@Override
	public ArrayList<User> getAllOtherUsers(int id) {
		try {

			ArrayList<User> list = new ArrayList<User>();
			ps = con.prepareStatement("SELECT * from user where id <> ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				User user = new User();
				
				user.setId(rs.getInt(1));
				user.setFname(rs.getString(2));
				user.setLname(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setTel(rs.getString(5));
				user.setPosition(rs.getString(6));
				user.setUsername(rs.getString(7));
				user.setPassword(rs.getString(8));
				user.setPicture(rs.getBlob(9));
				user.setRole(rs.getString(10));

				list.add(user);
			}
			return list;

		} catch (Exception e) {
			System.out.println("Connection error : getAllUsers");
		}

		return null;
	}

}
