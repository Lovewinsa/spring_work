package com.example.boot11.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.boot11.dto.FileDto;

@Repository
public class FileDaoImpl implements FileDao {
	
	@Autowired private SqlSession session;

	@Override
	public List<FileDto> getList() {
		/*
		 * 	mapper의 namespace : file
		 * 	sql의 id : getList
		 * 	resultType : FileDto
		 * 	parameterType : 없음
		 */
		return session.selectList("file.getList");
	}

	@Override
	public void upload(FileDto dto) {
		/*
		 * 	mapper의 namespace : file
		 * 	sql의 id : upload
		 * 	resultType : 없음
		 * 	parameterType : FileDto
		 */

		session.insert("file.upload", dto);
	}

	@Override
	public FileDto getData(int num) {
		/*
		 * 	mapper의 namespace : file
		 * 	sql의 id : getData
		 * 	resultType : FileDto
		 * 	parameterType : int
		 */
		return session.selectOne("file.getData", num);
	}

	@Override
	public void delete(int num) {
		/*
		 * 	mapper의 namespace : file
		 * 	sql의 id : delete
		 * 	resultType : 없음
		 * 	parameterType : int
		 */
		session.delete("file.delete", num);
	}

	@Override
	public int getSequence() {
		/*
		 * 	mapper의 namespace : file
		 * 	sql의 id : getSequence
		 * 	resultType : int
		 * 	parameterType : 
		 */
		int seq = session.selectOne("file.getSequence");
		return seq;
	}

	@Override
	public int getCount() {
		/*	mapper의 namespace : file
		 * 	sql의 id : getCount
		 * 	resultType : int
		 */
		return session.selectOne("file.getCount");
	}

}
