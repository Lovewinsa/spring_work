package com.example.boot008.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	@GetMapping("/user/loginform")
	public String loginform() {
		return "user/loginform";
	}
	
	@GetMapping("/user/required_loginform")
	public String required_loginform() {
		return "user/required_loginform";
	}
	
	@PostMapping("/user/login_success")
	public String loginSuccess() {
		return "user/login_success";
	}
	
	@PostMapping("/user/login_fail")
	public String loginFail() {
		return "/user/login_fail";
	}
	
	@GetMapping("/staff/user/list")
	public String userList() {
		return "user/list";
	}
	
	@GetMapping("/admin/user/manager")
	public String userManager() {
		return "user/manager";
	}
	
	@RequestMapping("/user/denied")
	public String userDenied() {
		return "user/denide";
	}
	
	
	
}
