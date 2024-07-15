package com.example.boot08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class UserController {
	@GetMapping("/user/loginform")
	public String loginform() {
		// templates/user/loginform.html페이지로 forward 이동해서 응답
		return "user/loginform";
	}
	
	// 로그인이 필요한 요청경로를 로그인하지 않은 상태로 요청하면 리다이렉트되는 요청경로
	@GetMapping("/user/required_loginform")
	public String required_loginform() {
		return "user/required_loginform";
	}
	
	// POST방식 /user/login요청 후 로그인 성공인 경우, forward 이동될 url
	@PostMapping("/user/login_success")
	public String loginSuccess() {
		return "user/login_success";
	}
	// 로그인 폼을 제출(post)한 로그인 프로세스 중에 forward되는 경로기 때문에 @PostMapping임에 주의!
	@PostMapping("/user/login_fail")
	public String loginFail() {
		// 로그인 실패임을 알리는 페이지
		
		return "/user/login_fail";
	}
	
	// ROLL_STAFF, ROLL_ADMIN만 요청 가능
	@GetMapping("/staff/user/list")
	public String userList() {
		return "user/list";
	}
	// ROLE_ADMIN만 요청 가능
	@GetMapping("/admin/user/manager")
	public String userManager() {
		return "user/manager";
	}
	
	// 권한 부족시 또는 403인 경우
	@RequestMapping("/user/denied")
	public String userDenied() {
		return "user/denied";
	}
	
	// 세션 허용 개수 초과시
	@GetMapping("/user/expired")
	public String userExpired() {
		return "user/expired";
	}
	
	
	
}
