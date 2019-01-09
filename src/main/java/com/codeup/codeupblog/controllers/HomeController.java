package com.codeup.codeupblog.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String homePage(Model model) {
		String pageTitle = "Home";
		String headerContent = "Home Page";
		model.addAttribute("pageTitle", pageTitle);
		model.addAttribute("headerContent", headerContent);
		return "home";
	}

}
