package com.example.boot11.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
public class SecurityConfig {
	/*
	 * 	매개변수에 전달되는 HttpSecurity 객체를 이용해서 우리의 프로젝트 상황에 맞는 설정을 기반으로
	 * 	만들어진 SecurityFilterChain 객체를 리턴해주어야 한다.
	 * 	또, SecurityFilterChain 객체도 spring이 관리하는 Bean이 되어야한다.
	 */
	@Bean	// 메소드에서 리턴되는 SecurityFilterChain을 Bean으로 만들어준다.
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		String[] whiteList = {"/", "/user/loginform", "/user/login_fail", "/user/expired", "/user/signup_form"
				, "/user/signup", "/error", "/upload/images/*", "/file/list", "/file/download"};
		
		httpSecurity
		// csrf는 추상메소드1개짜리인 인터페이스 타입
		.csrf(csrf->csrf.disable())
		.authorizeHttpRequests(config ->
			config
				.requestMatchers(whiteList).permitAll()
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.requestMatchers("/staff/**").hasAnyRole("ADMIN", "STAFF")
				.anyRequest().authenticated()
		)
		.formLogin(config->
			config
				// 인증을 거치지 않은 사용자를 리다이렉트시킬 경로 설정
				.loginPage("/user/required_loginform")
				// 로그인처리를 할 때 요청될 url설정(spring security가 login처리를 대신 해준다.)
				.loginProcessingUrl("/user/login")
				// 로그인처리를 대신 하려면 어떤 파라미터명으로 username과 password가 넘어오는지 알려주기
				.usernameParameter("userName")
				.passwordParameter("password")
				.successHandler(new AuthSuccessHandler()) // 로그인 성공시 forward될 url설정
				.failureForwardUrl("/user/login_fail")
				.permitAll() // 위에 명시한 모든 요청경로를 로그인없이 요청할 수 있도록 설정
		)
		.logout(config ->
			config
				.logoutUrl("/user/logout")	// Spring Security가 자동으로 로그아웃처리할 경로 설정
				.logoutSuccessUrl("/")	// 로그아웃 이후에 리다이렉트시킬 경로 설정
				.permitAll()
		)
		.exceptionHandling(config -> 
			// 403 forbidden인 경우 forward 이동시킬 경로 설정
			config.accessDeniedPage("/user/denied")
		)
		.sessionManagement(config ->
			config
				.maximumSessions(1) // 최대 허용 세션 개수
				.expiredUrl("/user/expired") // 허용 세션 개수가 넘어 로그인이 해제된 경우 리다이렉트 시킬 경로
				
		
		);
		
		return httpSecurity.build();
	}
	
	// 비밀번호를 암호화 해주는 객체를 bean으로 만든다
	@Bean
	PasswordEncoder passwordEncoder() {
		// **여기서 리턴해주는 객체도 bean이 된다.**
		return new BCryptPasswordEncoder();
	}
	
}
