package com.example.boot11.repository;

import java.util.List;

import com.example.boot11.dto.FileDto;

public interface FileDao {
	// 모든 파일목록 리턴
	public List<FileDto> getList();
	// 새로운 파일 올리기
	public void upload(FileDto dto);
	// 파일 하나 다운로드 받기
	public FileDto getData(int num);
	// 파일 삭제
	public void delete(int num);
	// 저장할 글 번호를 미리 얻어내서 리턴하는 메소드
	public int getSequence();
	// 전체 글의 갯수를 리턴하는 메소드
	public int getCount();
}