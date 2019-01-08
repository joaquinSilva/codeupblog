package com.codeup.codeupblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Dice {

	@GetMapping("/roll-dice/")
	public String homeDicePage(Model model) {
		String pageTitle = "Pick a number!";
		model.addAttribute("pageTitle", pageTitle);
		return "loadDice";
	}

	public Integer DiceRoll() {
		int max = 6;
		int min = 1;
		int range = max - min + 1;
		return ((int) (Math.random() * range) + min);

	}

	@GetMapping("/roll-dice/{num}")
	public String GuessNumber(@PathVariable int num, Model model) {
		int diceRolled = DiceRoll();
		String pageTitle = "Results";
		boolean win = false;
		boolean lose = false;

		if (num == diceRolled) {
			win = true;
		} else {
			lose = true;
		}
		model.addAttribute("num", num);
		model.addAttribute("win", win);
		model.addAttribute("lose", lose);
		model.addAttribute("diceRolled", diceRolled);
		model.addAttribute("pageTitle", pageTitle);
		return "dice";
	}

}
