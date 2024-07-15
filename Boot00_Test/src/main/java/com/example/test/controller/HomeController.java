package com.example.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	@ResponseBody
	@GetMapping("/hello")
	public String hello() {
		return "Nice to meet you";
	}
	
	@ResponseBody
	@GetMapping("/fortune")
	public String fortune() {
		return "Tommorow will be the best day for you";
	}
}
