package com.example.boot11.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.multipart.MultipartFile;

import com.example.boot11.dto.FileDto;

import com.example.boot11.service.FileService;

@Controller
public class FileController {
	@Value("${file.location}") private String fileLocation;
	
	@Autowired FileService service;
	
	/*
	 * 	FileDto에는 pageNum, condition, keyword값이 담길 수도 있다.
	 * 	(GET방식 파라미터값이 넘어오면 담긴다)
	 */
	@GetMapping("/file/list")
	public String list(Model m, FileDto dto) {
		// 서비스 객체에 Model의 참조값을 전달해서 파일목록이 Model 객체에 담기도록 한다.
		service.getList(m, dto);
		// template 페이지에서 파일목록 응답하기
		return "file/list";
	}
	
	@GetMapping("/file/upload_form")
	public String uploadForm() {
		return "file/upload_form";
	}
	
	@PostMapping("/file/upload")
	public String upload(FileDto dto) {
		
		service.addFile(dto);
		
		return "file/upload";
	}
	
	@GetMapping("/file/delete")
	public String delete(int num) {
		service.removeFile(num);
		return "redirect:/file/list";
	}
	
	@GetMapping("/file/download")
	public ResponseEntity<InputStreamResource> download(int num) {
		
		return service.getFileDate(num);
	}
	
}
