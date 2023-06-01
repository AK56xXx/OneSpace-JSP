package models;

import java.sql.Blob;

public class Announcement {
	
	private int id;
	private String title;
	private String description;
	private Blob image;
	private String postedAt;
	
	public Announcement() {
		super();
	}

	public Announcement(int id, String title, String description, Blob image, String postedAt) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.image = image;
		this.postedAt = postedAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public String getPostedAt() {
		return postedAt;
	}

	public void setPostedAt(String postedAt) {
		this.postedAt = postedAt;
	}

	@Override
	public String toString() {
		return "Announcement [id=" + id + ", title=" + title + ", description=" + description + ", image=" + image
				+ ", postedAt=" + postedAt + "]";
	}
	
	
	
	
	
	
	
	
	
	

}
