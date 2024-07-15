package com.example.boot08.service;

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

import com.example.boot08.dto.UserDto;

// bean으로 만들기 위한 어노테이션
@Service
public class CustomUserDetailsService implements UserDetailsService{

	// Spring Security가 로그인 처리시 호출하는 메소드
	// 이 메서드는 UserDetails 객체를 리턴하는게 목적
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 원래 dao를 이용해 DB에서 username에 해당하는 사용자 정보(UserDto)를 얻어와야 한다.
		// 지금은 sample data를 만들어서 사용해보기.
		
		// 실제 DB에는 ROLE_XXX 형식으로 저장이 되어있어야 한다.
		String role="";
		if(username.equals("kimgura")) {
			role="ROLE_USER";
		}else if(username.equals("batman")){
			role = "ROLE_STAFF";
		}else if(username.equals("superman")) {
			role = "ROLE_ADMIN";
		}
		// 비밀번호를 암호화하기 위한 객체
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		// DB에는 암호화된 비밀번호가 저장되어 있다고 가정
		String encodedPwd = encoder.encode("1234");
		
		// Sample UserDto객체 만들기(원래는 DB에서 읽어온 데이터)
		UserDto dto = UserDto.builder()
						.userName(username)
						.password(encodedPwd)
						.email("aaa@naver.com")
						.role(role)
						.build();
		
		// 권한 목록을 List에 담아서	(지금은 1개이지만)
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		authList.add(new SimpleGrantedAuthority(dto.getRole()));
		
		// UserDetails 객체를 생성해서
		UserDetails ud = new User(dto.getUserName(), dto.getPassword(), authList);
		// 리턴해준다
		return ud;
		
	}

}
