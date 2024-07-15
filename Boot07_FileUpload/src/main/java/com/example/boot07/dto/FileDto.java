package com.example.boot07.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor // 생성자의 인자로 모든 필드의 값을 전달받는 생성자(Builder이 동작하기 위해서 필요)
@NoArgsConstructor // default 생성자
@Builder
@Data // = @Setter + @Getter + 몇 가지 옵션...
public class FileDto {
	private int num;
	private String writer;
	private String title;
	private String orgFileName;
	private String saveFileName;
	private long fileSize;
	private MultipartFile myFile;
	
	
}
