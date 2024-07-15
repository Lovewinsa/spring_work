package com.example.helloboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.example.helloboot.auto.Car;


/*
 *	[ 객체들 간에 의존관계를 느슨하게 하는 원칙 ]
 *
 * 	1. 핵심 의존객체를 직접 생성하지 않고 spring에게 객체 생성과 관리를 맡긴다.
 * 	2. 필요한 객체가 있으면 spring로부터 받아서 사용한다.
 * 	3. 인터페이스type를 적극 활용한다.
 */
@SpringBootTest
class HelloBootApplicationTests {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(HelloBootApplication.class, args);
		
		// 만일 달리고 싶으면
		//MyCar car = new MyCar();
		//car.drive();
		
		Car car = ctx.getBean(Car.class);
		car.drive();
	}

}
