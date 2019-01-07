package com.codeup.codeupblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

	@ResponseBody
	@GetMapping("/add/{num1}/and/{num2}")
	public int Add(@PathVariable int num1, @PathVariable int num2) {
		return (num1 + num2);
	}

	@ResponseBody
	@GetMapping("subtract/{num1}/from/{num2}")
	public int Subtract(@PathVariable int num1, @PathVariable int num2) {
		return (num2 - num1);
	}

	@ResponseBody
	@GetMapping("multiply/{num1}/and/{num2}")
	public int Multiply(@PathVariable int num1, @PathVariable int num2) {
		return (num1 * num2);
	}

	@ResponseBody
	@GetMapping("divide/{num1}/by/{num2}")
	public int Divide(@PathVariable int num1, @PathVariable int num2) {
		return (num1 / num2);
	}




}
