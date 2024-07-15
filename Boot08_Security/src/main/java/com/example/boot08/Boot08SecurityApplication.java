package com.example.boot08;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Boot08SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(Boot08SecurityApplication.class, args);
	
		// 운영체제의 실행환경
		Runtime rt = Runtime.getRuntime();
		try {
			// 크롬 브라우저 실행해서 원하는 url 로딩시키기
			// 명령 프롬프터에서 start chrome.exe http://localhost:8888/boot08하면 열림
			rt.exec("cmd /c start chrome.exe http://localhost:8888/boot08");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
