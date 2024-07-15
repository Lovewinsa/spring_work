package com.example.boot008.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
	private int id;
	private String userName;
	private String password;
	private String email;
	private String role;
}
