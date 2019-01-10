package com.codeup.codeupblog.controllers;

import com.codeup.codeupblog.models.Post;
import com.codeup.codeupblog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

	@GetMapping("/posts/{id}/edit")
	public String showEditPost(@PathVariable int id, Model model) {
		boolean create = false;
		model.addAttribute("create", create);

		Post post = postService.one(id);
		model.addAttribute("id", id);
		model.addAttribute("post", post);
		String pageTitle = "Edit Post";
		String headerContent = "Edit Post";
		model.addAttribute("pageTitle", pageTitle);
		model.addAttribute("headerContent", headerContent);
		return "posts/create";
	}

	@GetMapping("/posts/create")
	public String showCreatePost(Model model) {
		boolean create = true;
		model.addAttribute("create", create);
		model.addAttribute("post", new Post());
		return "posts/create";
	}

	@PostMapping("/posts/create")
	public String createPost(@ModelAttribute Post post) {
		postService.save(post);
		return "redirect:/posts";
	}

	@PostMapping("/posts/edit")
	public String editPost(@ModelAttribute Post post) {
		postService.edit(post);
		return "redirect:/posts";
	}




}
