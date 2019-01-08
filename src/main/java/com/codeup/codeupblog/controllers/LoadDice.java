package com.codeup.codeupblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoadDice {

	@GetMapping("/roll-dice/")
	public String homeDicePage() {
		return "loadDice";
	}


}
