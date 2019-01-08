package com.codeup.codeupblog.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String homePage(Model model) {
		String pageTitle = "Home";
		model.addAttribute("pageTitle", pageTitle);
		return "home";
	}

}
