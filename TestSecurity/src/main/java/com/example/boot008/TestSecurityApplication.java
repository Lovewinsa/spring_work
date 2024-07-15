package com.example.boot008;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestSecurityApplication.class, args);
	
	Runtime rt = Runtime.getRuntime();
	
	try {
		rt.exec("cmd /c start chrome.exe http://localhost:8888/boot008");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
}
