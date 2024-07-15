package com.example.boot11.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// 예외 컨트롤러는 @ControllerAdvice 어노테이션을 붙여 bean으로 만든다.
@ControllerAdvice
public class ExceptionController {
	/*
	 *	spring이 동작하는 중에 PasswordException type의 예외가 발생하면 이 메소드가 자동호출
	 *	매개변수에는 해당 예외객체의 참조값이 전달됨
	 *	일반 컨트롤러처럼 필요한 객체를 선언하면 스프링이 알아서 전달해준다.
	 *	템플릿 페이지로 forward 이동해서 응답할 수도 있고 리다이렉트 응답할 수도 있다.
	 */
//	@ExceptionHandler(PasswordException.class)
//	public String password(PasswordException pe, Model model) {
//		/*
//		 * 	"exception"이라는 키값으로 예외객체를 담으면
//		 * 	템플릿 페이지에서 예외객체는 ${exception}으로 참조할 수 있고
//		 * 	예외 메세지는 ${exception.message}로 읽어낼 수가 있다.
//		 * 	.message는 getter메서드 즉 .getMessage()를 호출하는 것이다. 
//		 */
//		model.addAttribute("exception", pe);
//		// /templates/error/password.html 템플릿 페이지로 응답
//		return "error/password";
//	}
	
	/*
	 * 	RedirectAttribute 객체를 이용하면 리다이렉트 응답된 페이지에 데이터를 전달할 수 있다.
	 */
	@ExceptionHandler(PasswordException.class)
	public String password(PasswordException pe, RedirectAttributes ra) {
		
		// 리다이렉트 이동된 페이지에서도 한번 사용할 수 있다.
		// Thymeleaf에서 ${exception}으로 참조 가능
		ra.addFlashAttribute("exception", pe);
		
		// /user/pwd_updateform로 요청을 다시 하라고 리다이렉트 응답
		return "redirect:/user/pwd_updateform";
	}
	
	@ExceptionHandler(NotOwnerException.class)
	public String notOwner(NotOwnerException noe, Model m) {
		// "exception"이라는 키값으로 예외 객체를 담는다.
		m.addAttribute("exception", noe);
		// view페이지에서 에러정보를 응답한다.
		return "error/info";
	}
}
