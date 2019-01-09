package com.codeup.codeupblog.controllers;
import com.codeup.codeupblog.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
	private List<Post> posts;

	public PostService() {
		posts = new ArrayList<>();
		createPosts();
	}

	public List<Post> all() {
		return posts;
	}

	public Post create(Post post) {
		post.setId(posts.size() + 1);
		posts.add(post);
		return post;
	}

	public Post one(int id) {
		return posts.get(id - 1);
	}

	private void createPosts() {
		// create some ad objects and add them to the ads list
		// using the create method
		posts.add(new Post(1, "New Post 1", "Text of body goes here."));
		posts.add(new Post(2,"New Post 2", "Text of body goes here."));
		posts.add(new Post(3,"New Post 3", "Text of body goes here."));
		posts.add(new Post(4,"New Post 4", "Text of body goes here."));
		posts.add(new Post(5,"New Post 5", "Text of body goes here."));
	}

}
