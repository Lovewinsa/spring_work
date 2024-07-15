package com.example.boot03.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.boot03.dto.MemberDto;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
	/*
	 * 	jsp페이지에게 응답에 필요한 데이터를 전달하는 방법 1
	 * 
	 * 	HttpServletRequest 객체에 .setAttribute() 메서드를 이용해 담는다.
	 */
	@GetMapping("/")
	public String home(HttpServletRequest request) {
		// 공지사항을 DB에서 읽어왔다고 가정
		List<String> noticeList = new ArrayList<>();
		noticeList.add("장마가 시작되었습니다.");
		noticeList.add("Spring Boot수업이 시작되었습니다.");
		noticeList.add("어쩌구...");
		noticeList.add("저쩌구...");
		// request scope에 "noticeList"라는 키값으로 List<String> type를 담기
		request.setAttribute("noticeList", noticeList);
		// "/WEB-INF/views/home.jsp"페이지로 응답을 위임(forward 이동)
		return "home";
	}
	/*
	 * 	jsp페이지에게 응답에 필요한 데이터를 전달하는 방법 2
	 * 
	 * 	Model 객체에 .addAttribute() 메서드를 이용해서 담는다.
	 * 	Model 객체에 담으면 자동으로 servlet request 객체에 담긴다
	 */
	@GetMapping("/fortune")
	public String fortune(Model model) {
		// 오늘의 운세를 DB에서 읽어왔다고 가정
		String fortuneToday = "동쪽으로 가면 귀인을 만나요";
		// "fortuneToday"라는 키값으로 String type를 담고
		model.addAttribute("fortuneToday", fortuneToday);
		// "WEB-INF/views/fortune.jsp"페이지로 응답을 위임하기(forward 이동)
		return "fortune";
	}
	
	@GetMapping("/member")
	public String member(HttpServletRequest request) {
		MemberDto dto = new MemberDto();
		dto.setNum(1);
		dto.setName("김구라");
		dto.setAddr("강남역");
		request.setAttribute("dto", dto);
		
		return "member";
	}
}
