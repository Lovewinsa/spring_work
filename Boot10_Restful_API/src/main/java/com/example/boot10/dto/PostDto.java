package com.example.boot10.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// lombok의 기능을 이용해 dto 클래스 작성
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostDto {
	private int id;
	private String title;
	private String author;
}
