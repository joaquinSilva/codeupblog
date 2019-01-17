package com.codeup.codeupblog.controllers;

import com.codeup.codeupblog.models.Post;
import com.codeup.codeupblog.repositories.PostRepository;
//import com.codeup.codeupblog.services.PostService;
import com.codeup.codeupblog.models.User;
import com.codeup.codeupblog.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

//	private final PostService postService;

	//	public PostController(PostService postService) {
//		this.postService = postService;
//	}

//	private List<Post> posts;

	private final UserRepository userDao;

	private final PostRepository postDao;


	public PostController(UserRepository userDao, PostRepository postDao) {
		this.userDao = userDao;
		this.postDao = postDao;
	}

	@GetMapping("/posts")
	public String getPosts(Model model) {

		model.addAttribute("posts", postDao.findAll());

//		List<Post> posts = postService.all();
//		model.addAttribute("posts", posts);
		String pageTitle = "Posts Index";
		String headerContent = "Index of All Posts";
		model.addAttribute("pageTitle", pageTitle);
		model.addAttribute("headerContent", headerContent);
		return "posts/index";
	}

	@GetMapping("/posts/{id}")
	public String getPost(@PathVariable long id, Model model) {
//		Post post = postService.one(id);
//		model.addAttribute("post", post);
		model.addAttribute("email", postDao.findOne(id).getUser().getEmail());
		model.addAttribute("post", postDao.findOne(id));
		model.addAttribute("id", id);
		String pageTitle = "Your post";
		String headerContent = "Your post";
		model.addAttribute("pageTitle", pageTitle);
		model.addAttribute("headerContent", headerContent);
		return "posts/show";
	}

	@GetMapping("/posts/{id}/edit")
	public String showEditPost(@PathVariable long id, Model model) {
		boolean create = false;
		model.addAttribute("create", create);

//		Post post = postService.one(id);
//		model.addAttribute("post", post);

		model.addAttribute("id", id);
		model.addAttribute("post", postDao.findOne(id));
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
	public String createPost(@ModelAttribute Post post, User user) {
//		postService.save(post);
		post.setUser(user);
//		post.setUser(UserRepository.findOne(user));
		postDao.save(post);
		return "redirect:/posts";
	}

	@PostMapping("/posts/{id}/edit")
	public String editPost(@PathVariable long id, @ModelAttribute Post post) {
//		postService.edit(post);
		postDao.save(post);
		return "redirect:/posts/" + post.getId();
//		return "redirect:/posts";
	}

	@PostMapping("/posts/{id}/delete")
	public String deletePost(@PathVariable long id, @ModelAttribute Post post) {
//		postDao.delete(post);
		postDao.delete(id);
		return "redirect:/posts";
	}




}
