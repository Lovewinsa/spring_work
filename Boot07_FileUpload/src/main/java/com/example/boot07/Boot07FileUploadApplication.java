package com.example.boot07;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.multipart.MultipartFile;

import com.example.boot07.dto.FileDto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
/*
 * 	@PropertySource 
 * 	classpath:는 resources 폴더를 가리킨다. 
 */
@PropertySource(value="classpath:custom.properties")
@SpringBootApplication
public class Boot07FileUploadApplication {

	public static void main(String[] args) {
		SpringApplication.run(Boot07FileUploadApplication.class, args);
		
		// Dto에 Builder 어노테이션 덕분에 이런 형식 사용 가능.(But, new FileDto()형식 사용 못함)
		FileDto dto1 = FileDto.builder().num(1).writer("김구라").title("제목").build();
				
		// Dto에 @AllArgsConstructor와 @NoArgsConstructor 어노테이션으로 기존 dto.num형식 사용 가능
		dto1.setNum(1);
		dto1.setWriter("김구라");
	}

}
