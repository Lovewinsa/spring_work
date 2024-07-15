package com.example.boot00.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * 	클라이언트의 요청을 처리할 컨트롤러를 정의해 bean으로 만들기
 */
@Controller
public class HomeController {
	@ResponseBody
	@GetMapping("/hello")
	public String hello() {
		return "Nice to meet you!";
	}
	
	@ResponseBody
	@GetMapping("/member")
	public Map<String, Object> member(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("num", 1);
		map.put("name", "김구라");
		map.put("isMan", true);
		
		return map;
	}
}
