package com.codeup.codeupblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {


	@ResponseBody
	@GetMapping("/posts")
	public String getPosts() {
		return "This page is the posts index page which will display all posts!";
	}

	@ResponseBody
	@GetMapping("/posts/{id}")
	public String getPost(@PathVariable int id) {
		return "This page will display the info of a post with the id of " + id + "!";
	}

	@ResponseBody
	@GetMapping("/posts/create")
	public String createPost() {
		return "This page will display the form to create a new post!";
	}

	@ResponseBody
	@PostMapping("/posts/create")
	public String savePost() {
		return "This page method will save a new post to the database!";
	}


}
