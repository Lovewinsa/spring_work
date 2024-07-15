package com.example.boot008.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RequestMatchers;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		String[] whiteList = {"/", "/play", "/user/loginform", "/user/login_fail"};
		
		httpSecurity
		.csrf(csrf->csrf.disable())
		.authorizeHttpRequests(config->
			config
			.requestMatchers(whiteList).permitAll()
			.requestMatchers("/admin/**").hasRole("ADMIN")
			.requestMatchers("/staff/**").hasAnyRole("ADMIN", "STAFF")
			.anyRequest().authenticated()
		)
		.formLogin(config->
			config
				.loginPage("/user/required_loginform")
				.loginProcessingUrl("/user/login")
				.usernameParameter("userName")
				.passwordParameter("password")
				.successHandler(new AuthSuccessHandler())
				.failureForwardUrl("/user/login_fail")
				.permitAll()		
		)
		.logout(config->
			config
				.logoutUrl("/user/logout")
				.logoutSuccessUrl("/")
				.permitAll()
		)
		.exceptionHandling(config ->
		 	config.accessDeniedPage("/user/denied")
		);
		return httpSecurity.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	AuthenticationManager authenticationManager(HttpSecurity http,
			BCryptPasswordEncoder encoder, UserDetailsService service) {
		return http.getSharedObject(null);
		
	}
}
