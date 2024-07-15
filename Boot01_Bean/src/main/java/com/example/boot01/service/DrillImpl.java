package com.example.boot01.service;

import org.springframework.stereotype.Component;

// spring이 component scan해서 해당 클래스로 객체를 생성해 관리하도록 어노테이션을 붙임
@Component
public class DrillImpl implements Drill{

	@Override
	public void hole() {
		System.out.println("드리이이이일~~");
		
	}

}
