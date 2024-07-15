package com.example.boot10.controller;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.boot10.dao.PostDao;
import com.example.boot10.dto.PostDto;
import com.example.boot10.service.PostService;

@RestController // @ResponseBody의 기능이 모든 메소드에 포함된다.
public class PostController {
	
	@Autowired
	//필요한 서비스 객체를 interface type으로 DI 받는다.
	private PostService service;
	
	/* @ResponseBody */
	@GetMapping("/posts")
	public List<PostDto> getList(){
		// 글 전체목록을 service 객체를 이용해 읽어와 리턴
		List<PostDto> list = service.getAll();
		return list;
	}
	
	/* @ResponseBody */
//	@PostMapping("/posts")
//	public PostDto insert(String title, String author) {
//		// @Builder의 기능을 이용해 PostDto 객체에 데이터를 담으면서 객체의 참조값 얻어내기
//		PostDto dto = PostDto.builder().title(title).author(author).build();
//		// dao를 이용해 dto에 저장된 정보를 DB에 저장
//		dao.insert(dto);
//		// 추가된 정보 리턴
//		return dto;
//	}
	@PostMapping("/posts")
	public PostDto insert(PostDto dto) { // title과 author가 추출되어 PostDto객체에 담긴 채로 전달된다
		// 글을 저장 + 리턴해주는 service에 dto를 컨트롤러에 담는다.
		return service.addContent(dto);
	}
	
	@GetMapping("/posts/{id}")
	public PostDto getData(@PathVariable("id") int id) {
		// service를 이용해 글 하나의 정보를 얻어온다.
		return service.getContent(id);
	}
	
	@DeleteMapping("/posts/{id}")
	public PostDto delete(@PathVariable("id") int id) {
		// service를 이용해 글을 삭제, 삭제한 글 정보 리턴
		return service.removeContent(id);
	}
	
	@PutMapping("/posts/{id}")
	public PostDto update(@PathVariable("id") int id, PostDto dto) {
		// PostDto에 경로변수로 넘어오는 수정할 글 번호도 담아서
		dto.setId(id);
		// service를 이용해 수정
		service.updateContent(dto);
		// 수정된 데이터 리턴
		return dto;
	}
}
