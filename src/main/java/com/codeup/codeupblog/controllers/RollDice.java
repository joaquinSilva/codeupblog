package com.codeup.codeupblog.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.lang.Math;


@Controller
public class RollDice {

	public Integer DiceRoll() {
		int max = 6;
		int min = 1;
		int range = max - min + 1;
		return ((int) (Math.random() * range) + min);

	}

	@GetMapping("/roll-dice/{num}")
	public String GuessNumber(@PathVariable int num, Model model) {
		int diceRolled = DiceRoll();
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
		return "dice";
	}


}
