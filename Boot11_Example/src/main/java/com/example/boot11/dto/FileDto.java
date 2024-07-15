package com.example.boot11.dto;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Alias("fileDto") // Mapper xml에서 FileDto type을 간단히 줄여서 쓰기 위해
@AllArgsConstructor // 생성자의 인자로 모든 필드의 값을 전달받는 생성자(Builder이 동작하기 위해서 필요)
@NoArgsConstructor // default 생성자
@Builder
@Data // = @Setter + @Getter + 몇 가지 옵션...
public class FileDto {
	private int num;
	private String writer;
	private String title;
	private String orgFileName;
	// 파일 시스템에 저장된 파일명
	private String saveFileName;
	private long fileSize;
	private String regdate;
	private MultipartFile myFile;
	// 페이징 처리를 위한 필드
	private int startRowNum;
	private int endRowNum;
}
