package com.example.boot10.dao;

import java.util.List;

import com.example.boot10.dto.PostsDto;

public interface PostsDao {
	public List<PostsDto> getList();
	public void insert(PostsDto dto);
	public void delete(int num);
	public PostsDto getData(int num);
	public void update(PostsDto dto);

}
