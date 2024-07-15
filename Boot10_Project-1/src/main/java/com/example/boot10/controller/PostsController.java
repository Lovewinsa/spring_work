package com.example.boot10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.boot10.dao.PostsDao;
import com.example.boot10.dto.PostsDto;



@Controller
public class PostsController {
	@Autowired
	private PostsDao dao;
	
	@ResponseBody
	@GetMapping("/posts")
	public List<PostsDto> list() {
		List<PostsDto> list = dao.getList();
	
		return list;
	}	
	
	@ResponseBody
	@PostMapping("/posts")
	public String insert(PostsDto dto) {
		dao.insert(dto);
		return "게시글이 추가되었습니다.";
	}
	
	@ResponseBody
	@GetMapping("/posts/{id}")
	public PostsDto getdata(@PathVariable("id") int id) {
		PostsDto dto = dao.getData(id);
		return dto;
	}
	
	@ResponseBody
	@PutMapping("/posts/{id}")
	public String update(@PathVariable("id") int id, PostsDto dto) {
		dao.update(dto);
		return id + "번 게시글을 수정했습니다.";
	}
	
	@ResponseBody
	@DeleteMapping("/posts/{id}")
	public String delete(@PathVariable("id") int id) {
		dao.delete(id);
		return id + "번 글을 삭제했습니다.";
	}
	
	
		
}
