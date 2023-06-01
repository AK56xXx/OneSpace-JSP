package models;

import java.sql.Blob;

public class User {
	
	private int id;
	private String fname;
	private String lname;
	private String email;
	private String tel;
	private String position;
	private String username;
	private String password;
	private Blob picture;
	private String role;
	
	public User() {
		super();
	}

	public User(int id, String fname, String lname, String email, String tel, String position, String username, String password,
			Blob picture, String role) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.tel = tel;
		this.position = position;
		this.username = username;
		this.password = password;
		this.picture = picture;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Blob getPicture() {
		return picture;
	}

	public void setPicture(Blob picture) {
		this.picture = picture;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	

	@Override
	public String toString() {
		return "User [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", tel=" + tel
				+", position= "+ position + ", username=" + username + ", password=" + password + ", picture=" + picture + ", role=" + role + "]";
	}
	
	
	
	
	
	
	

}
