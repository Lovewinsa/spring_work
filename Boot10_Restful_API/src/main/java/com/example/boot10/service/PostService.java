package com.example.boot10.service;

import java.util.List;

import com.example.boot10.dto.PostDto;

public interface PostService {
	// 모든 글 목록을 리턴하는 메소드
	public List<PostDto> getAll();
	// 새로운 글 저장 + 저장한 글 정보 리턴
	public PostDto addContent(PostDto dto);
	// 글을 삭제 + 삭제한 글 정보 리턴
	public PostDto removeContent(int id);
	// 글을 수정
	public void updateContent(PostDto dto);
	// 글 하나의 정보를 리턴하는 메서드
	public PostDto getContent(int id);
}
