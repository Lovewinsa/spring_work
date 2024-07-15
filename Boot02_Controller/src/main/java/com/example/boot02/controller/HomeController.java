package com.example.boot02.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.boot02.dto.MemberDto;
/*
 * 	클라이언트의 요청을 처리할 컨트롤러를 정의해 bean으로 만들기
 */
@Controller
public class HomeController {
	
	@ResponseBody
	@GetMapping("/hello") // 클라이언트가 "/hello" 경로로 요청을 하면 이 메소드가 실행된다.
	public String hello() {
		
		// String type을 리턴하면서 메소드에 @ResponseBody 어노테이션을 붙여놓으면
		// 여기서 리턴한 문자열이 클라이언트에게 그대로 출력된다.
		return "Nice to meet you";
	}
	
	@ResponseBody
	@GetMapping("/fortune")
	public String fortune() {
		
		return "Tomorrow will be the best day";
	}
	/*
	 * 	@ResponseBody 어노테이션이 붙어있는 메소드에서 Map객체를 리턴하 면
	 * 	Map에 담긴 정보가 JSON문자열로 변환되어 클라이언트에게 응답된다.
	 */
	@ResponseBody
	@GetMapping("/member")
	public Map<String, Object> member(){
		Map<String, Object> map = new HashMap<>();
		map.put("num", 1);
		map.put("name", "김구라");
		map.put("isMan", true);
		
		return map;
	}
	
	@ResponseBody
	@GetMapping("/member2")
	public MemberDto member2() {
		MemberDto dto = new MemberDto();
		dto.setNum(1);
		dto.setName("김구라");
		dto.setAddr("노량진");
		return dto;
	}
	
	@ResponseBody
	@GetMapping("/friends")
	public List<String> friends(){
		List<String> names = new ArrayList<>();
		names.add("김구라");
		names.add("해골");
		names.add("원숭이");
		return names;
	}
	
	@ResponseBody
	@GetMapping("/members")
	public List<MemberDto> members(){
		List<MemberDto> members = new ArrayList<>();
		members.add(new MemberDto(1, "김구라", "노량진"));
		members.add(new MemberDto(2, "해골", "행신동"));
		members.add(new MemberDto(3, "원숭이", "동물원"));
		// List<MemberDto> 객체를 리턴하면 [{}, {}, {} ] 형식으 JSON문자열이 응답된다.
		return members;
	}
	
	
}
