package com.example.boot05.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.boot05.dao.MemberDao;
import com.example.boot05.dto.MemberDto;

@Controller
public class MemberController {
	// spring bean container로부터 MemberDto type 주입(DI)받기
	@Autowired
	private MemberDao dao;
		
	@GetMapping("/member/list")
	public String list(Model model) {
		// DB에서 회원목록(List<MemberDto>)을 얻어와서 Model 객체에 담고
		List<MemberDto> list = dao.getList();
		model.addAttribute("list", list);
		// Thymeleaf view 페이지를 이용해서 응답하기
		return "member/list";
	}
	
	@GetMapping("/member/insertform")
	public String insertForm() {
		
		return "member/insertform";
	}
	
	@PostMapping("/member/insert")
	public String insert(MemberDto dto) { // 요청 파라미터가 추출되어 MemberDto객체에 담겨서 전달된다
		// MemberDao 객체를 이용해서 DB에 저장하고
		dao.insert(dto);
		// 응답하기
		return "member/insert";
	}
	
	@GetMapping("/member/delete")
	public String delete(int num) { // 삭제할 번호가 자동으로 추출되어 num매개변수에 전달된다
		// MemberDao 객체를 이용해서 삭제하고
		dao.delete(num);
		//회원목록 보기로 리다이렉트 이동하라는 응답
		return "redirect:/member/list";
	}
	
	@GetMapping("/member/updateform")
	public String updateForm(int num, Model model) {
		// 수정할 회원의 번호를 이용해서 회원정보를 얻어온다.
		MemberDto dto = dao.getData(num);
		// 얻어온 회원 정보를 Model 객체에 담는다
		model.addAttribute("dto", dto);
		// 회원정보 수정폼을 응답한다		
		return "member/updateform";
	}
	
	@PostMapping("/member/update")
	public String update(MemberDto Dto) {
		dao.update(Dto);
		return "member/update";
	}
}
