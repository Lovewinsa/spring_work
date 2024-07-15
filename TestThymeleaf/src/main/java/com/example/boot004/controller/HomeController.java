package com.example.boot004.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("personToday", "김구라");
		
		model.addAttribute("id", 99);
		model.addAttribute("count", 3);
		
		return "home";
	}
}
