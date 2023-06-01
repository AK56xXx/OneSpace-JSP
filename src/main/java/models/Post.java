package models;

public class Post {
	
	private int id;
	private String text;
	private int idUser;
	private String postedAt;
	
	public Post() {
		super();
	}

	public Post(int id, String text, int idUser, String postedAt) {
		super();
		this.id = id;
		this.text = text;
		this.idUser = idUser;
		this.postedAt = postedAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getPostedAt() {
		return postedAt;
	}

	public void setPostedAt(String postedAt) {
		this.postedAt = postedAt;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", text=" + text + ", idUser=" + idUser + ", postedAt=" + postedAt + "]";
	}
	
	
	

}
