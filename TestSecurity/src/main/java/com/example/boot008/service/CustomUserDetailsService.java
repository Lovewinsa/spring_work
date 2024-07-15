package com.example.boot008.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.boot008.dto.UserDto;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		String role="";
		if(username.equals("kimgura")) {
			role="ROLE_USER";
		}else if(username.equals("batman")) {
			role = "ROLE_STAFF";
		}else if(username.equals("superman")){
			role = "ROLE_ADMIN";
		}
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPwd = encoder.encode("1234");
		
		UserDto dto = UserDto.builder()
						.userName(username)
						.password(encodedPwd)
						.email("bbb@naver.com")
						.role(role)
						.build();
		
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		authList.add(new SimpleGrantedAuthority(dto.getRole()));
		
		UserDetails ud = new User(dto.getUserName(), dto.getPassword(), authList);
			
		return ud;
	}

}
