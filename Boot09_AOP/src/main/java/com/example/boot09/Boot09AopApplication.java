package com.example.boot09;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.boot09.util.Messenger;
import com.example.boot09.util.WritingUtil;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class Boot09AopApplication {

	// spring boot application이 실행될 때 호출되는 메소드
	public static void main(String[] args) {
		/* ApplicationContext ctx = SpringApplication.run(Boot09AopApplication.class, args);*/
		// 내부적으로 Boot09AopApplication 객체가 생성된다. (Spring Bean Container도 만들어진다.)
		SpringApplication.run(Boot09AopApplication.class, args);
	}
	// Spring Bean Container로부터 WritingUtil객체 DI받기
	@Autowired WritingUtil util;
	@Autowired Messenger messenger;
	
	// 이클래스(Boot09AopApplication) 객체가 성공적으로 생성된 이후에 호출되는 메소드
	@PostConstruct
	public void test() {
		util.writeLetter();
		util.writeReport();
		util.writeDiary();
		
		System.out.println("----------");
		
		messenger.sendGreeting("안녕하세요");
		messenger.sendGreeting("안녕하세요 똥깨님!");
		
		String msg = messenger.getMessage();
		System.out.println("Messenger 객체로부터 받은 메세지 : " + msg);
	}
		
		
		//spring이 관리하는 bean들 중에서 WritingUtil type 객체의 참조값 얻어오기
//		WritingUtil util = ctx.getBean(WritingUtil.class);
//		
//		util.writeLetter();
//		util.writeReport();
//		util.writeDiary();
	
	

}
