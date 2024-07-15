package com.example.boot01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/*
 * 	[ spring이 관리하는 객체로 만드는 방법 = bean을 만드는 방법 ]
 * 
 * 	1. component scan이 일어나는 위치에 클래스가 존재해야 한다.
 * 	2. 적절한 어노테이션이 클래스에 붙어있어야 한다.(용도에 따라 다양한 어노테이션 존재)
 */
@Component
public class HomeServiceImpl implements HomeService{
	/*
	 * 	필요한 type을 필드로 선언하고 @Autowired 어노테이션을 붙여놓으면
	 * 	해당 객체가 자동으로 주입된다.
	 * 	원래 필드는 선언만 하면 null이 들어있다.
	 */
	@Autowired // DI(Dependency Injection)
	private Drill drill;
	
	
	@Override
	public void clean(String name) {
		System.out.println(name + " 의 집을 청소해요");
	}

	@Override
	public void wash(String name) {
		System.out.println(name + " 의 빨래를 해요");
	}

	@Override
	public void hole(String name) {
		System.out.println(name + " 에 구멍을 뚫어요");
		drill.hole();
	}

}
