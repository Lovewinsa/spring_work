package com.example.boot004.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.boot004.dto.MemberDto;

@Controller
public class TestController {
	@GetMapping("/sub/play")
	public String play() {
		return "sub/play";
	}
	
	@GetMapping("/notice")
	public String notice(Model model) {
		List<String> list = new ArrayList<String>();
		list.add("장마철입니다");
		list.add("더위조심");
		list.add("어쩌라고");
		model.addAttribute("list", list);
		return "sub/notice";
	}
	
	@GetMapping("/member")
	public String member(Model model) {
		MemberDto dto = new MemberDto(1, "김구라", "노량진");
		model.addAttribute("dto", dto);
		
		return "sub/member";
	}
	
	@GetMapping("/members")
	public String members(Model model) {
		List<MemberDto> list = new ArrayList<MemberDto>();
		list.add(new MemberDto(1, "김구라", "노량진"));
		list.add(new MemberDto(2, "해골", "행신동"));
		list.add(new MemberDto(3, "원숭이", "동물원"));
		model.addAttribute("list", list);
		return "sub/members";
	}
	
	@GetMapping("/shop/buy")
	public String buy() {
		return"sub/buy";
	}
	
	@GetMapping("/inc")
	public String inc() {
		return"sub/inc";
	}
}
