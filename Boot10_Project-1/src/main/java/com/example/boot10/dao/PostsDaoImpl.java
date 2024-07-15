package com.example.boot10.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.boot10.dto.PostsDto;

@Repository
public class PostsDaoImpl implements PostsDao {

	@Autowired
	private SqlSession session;
	
	@Override
	public List<PostsDto> getList() {
		List<PostsDto> list = session.selectList("posts.getList");
		return list;
	}

	@Override
	public void insert(PostsDto dto) {
		session.insert("posts.insert", dto);
		
	}

	@Override
	public void delete(int id) {
		session.delete("posts.delete", id);
		
	}

	@Override
	public PostsDto getData(int id) {
		PostsDto dto = session.selectOne("posts.getData", id);
		return dto;
	}

	@Override
	public void update(PostsDto dto) {
		session.update("posts.update", dto);
		
	}

}
