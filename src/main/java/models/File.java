package models;

import java.sql.Blob;

public class File {
	
	private int id;
	private String name;
	private Blob path;
	private String addedAt;
	
	public File() {
		super();
	}

	public File(int id, String name, Blob path, String addedAt) {
		super();
		this.id = id;
		this.name = name;
		this.path = path;
		this.addedAt = addedAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Blob getPath() {
		return path;
	}

	public void setPath(Blob path) {
		this.path = path;
	}
	
	public String getAddedAt() {
		return addedAt;
	}

	public void setAddedAt(String addedAt) {
		this.addedAt = addedAt;
	}

	@Override
	public String toString() {
		return "File [id=" + id + ", name=" + name + ", path=" + path + ", Added At=" + addedAt+ "]";
	}
	
	
	
	
	
	

}
