package com.example.boot01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.boot01.service.HomeService;

/*
 * 	[ @SpringBootApplication 어노테이션의 기능 ]
 * 	이 클래스가 존재하는 패키지(com.example.boot01) 또는 하위 패키지를 모두 scan해서
 * 	spring이 관리할 객체를 생성하도록 한다.
 */
@SpringBootApplication
public class Boot01BeanApplication {

	public static void main(String[] args) {
		
		ApplicationContext ctx = SpringApplication.run(Boot01BeanApplication.class, args);
		/*
		 * 	spring bean container에서 HomeService type를 찾아서 리턴받는다.
		 */
		HomeService service = ctx.getBean(HomeService.class);
		// 원숭이의 집을 청소하려면?
		service.clean("원숭이");
		// 주뎅이의 빨래를 하려면?
		service.wash("주뎅이");
		// 바닥에 구멍을 뚫으려면?
		service.hole("바닥");
		
	}

}
