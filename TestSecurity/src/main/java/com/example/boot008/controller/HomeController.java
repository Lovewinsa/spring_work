package com.example.boot008.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HomeController {
	@GetMapping("/")
	public String home() {
		return "home";
	}
	@ResponseBody
	@GetMapping("/play")
	public String play() {
		return "놀아요!!!";
	}
	
	@ResponseBody
	@GetMapping("/study")
	public String study() {
		return "공부해요!!!";
	}
	
	
	
}
