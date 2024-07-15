package com.example.boot11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.boot11.dto.UserDto;
import com.example.boot11.service.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class UserController {
	
	@Autowired private UserService service;
	

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
	
	@GetMapping("/user/signup_form")
	public String signupForm() {
		return("user/signup_form");
	}
	
	// 회원가입 요청 처리
	@PostMapping("/user/signup")
	public String signup(UserDto dto) {
		// dto에는 userName, password, email이 들어있다. role은 서비스에서 넣어주기...
		service.addUser(dto);
		return "user/signup";
	}
	
	// 개인정보 보기 요청 처리
	@GetMapping("/user/info")
	public String info(Model model) {
		// service 객체에 Model을 전달해서 Model에 UserDto를 담기
		service.getInfo(model);
		return "user/info";
	}
	
	@GetMapping("/user/pwd_updateform")
	public String pwdUpdateForm() {
		return "user/pwd_updateform";
	}
	
	@PostMapping("/user/pwd_update")
	public String pwdUpdate(UserDto dto, HttpSession session) {
		// 비밀번호 수정 이후
		service.updatePassword(dto);
		// 강제 로그아웃 처리
		session.invalidate();
		return "user/pwd_update";
	}
	
	@GetMapping("/user/updateform")
	public String updateForm(Model model) {
		// Model에 UserDto가 담기도록 서비스 메소드에 전달한다.
		service.getInfo(model);
		return "user/updateform";
	}
	
	@PostMapping("/user/update")
	public String update(UserDto dto) {
		service.updateUser(dto);
		// 개인정보 보기로 다시 리다이렉트
		return "redirect:/user/info";
	}
		
}
