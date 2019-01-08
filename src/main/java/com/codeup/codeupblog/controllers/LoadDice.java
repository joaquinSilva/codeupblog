package com.codeup.codeupblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoadDice {

	@GetMapping("/roll-dice/")
	public String homeDicePage(Model model) {
		String pageTitle = "Pick a number!";
		model.addAttribute("pageTitle", pageTitle);
		return "loadDice";
	}


}
