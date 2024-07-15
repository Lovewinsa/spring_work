package com.example.helloboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.helloboot.auto.Car;

@SpringBootApplication
public class HelloBootApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(HelloBootApplication.class, args);
	
		// 만일 달리고 싶다면
		// MyCar car = new MyCar();
		// car.drive();
		
		Car car = ctx.getBean(Car.class);
		car.drive();
	}

}
