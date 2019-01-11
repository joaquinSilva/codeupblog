package com.codeup.codeupblog.models;
import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post {

	@Id @GeneratedValue
	private long id;

	@Column(nullable = false, length = 100)
	private String title;

	@Column(nullable = false)
	private String body;


	public Post() {
	}

	public Post(String title, String body) {
		this.title = title;
		this.body = body;
	}

	public Post(int id, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;
	}

	public String getTitle() {
		return title;
	}
	public String getBody() {
		return body;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
