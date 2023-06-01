package models;

public class Comment {
	
	private int id;
	private String reply;
	private int idUser;
	private String postedAt;
	private int idPost;
	
	public Comment() {
		super();
	}

	public Comment(int id, String reply, int idUser, String postedAt, int idPost) {
		super();
		this.id = id;
		this.reply = reply;
		this.idUser = idUser;
		this.postedAt = postedAt;
		this.idPost = idPost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
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

	public int getIdPost() {
		return idPost;
	}

	public void setIdPost(int idPost) {
		this.idPost = idPost;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", reply=" + reply + ", idUser=" + idUser + ", postedAt=" + postedAt + ", idPost="
				+ idPost + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
