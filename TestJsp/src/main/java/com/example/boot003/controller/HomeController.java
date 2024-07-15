package com.example.boot003.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home(HttpServletRequest request) {
		List<String> noticeList = new ArrayList<String>();
		noticeList.add("장마가 시작...");
		noticeList.add("Spring Boot수업이 시작...");
		noticeList.add("어제 광화문 광장에 큰 사고...");
		noticeList.add("어쩌고 저쩌고...");
		
		request.setAttribute("noticeList", noticeList);
		return "home";
	}
	
	@GetMapping("/fortune")
	public String fortune(Model model) {
		String fortuneToday = "동쪽으로 가면 귀인을 만나";
		model.addAttribute("fortuneToday", fortuneToday);
		return "fortune";
	}
}
