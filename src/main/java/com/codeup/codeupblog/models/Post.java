package com.codeup.codeupblog.models;

public class Post {

	private String title;
	private String body;
	private int id;

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
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}