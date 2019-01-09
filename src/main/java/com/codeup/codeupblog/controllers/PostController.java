package com.codeup.codeupblog.controllers;

import com.codeup.codeupblog.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

	private final PostService postService;
	private List<Post> posts;

	public PostController(PostService postService) {
		this.postService = postService;
	}

	@GetMapping("/posts")
	public String getPosts(Model model) {

		List<Post> posts = postService.all();
		model.addAttribute("posts", posts);
		String pageTitle = "Posts Index";
		String headerContent = "Index of All Posts";
		model.addAttribute("pageTitle", pageTitle);
		model.addAttribute("headerContent", headerContent);
		return "posts/index";
	}

	@GetMapping("/posts/{id}")
	public String getPost(@PathVariable int id, Model model) {
		Post post = postService.one(id);
		model.addAttribute("id", id);
		model.addAttribute("post", post);
		String pageTitle = "Your post";
		String headerContent = "Your post";
		model.addAttribute("pageTitle", pageTitle);
		model.addAttribute("headerContent", headerContent);
		return "posts/show";
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
