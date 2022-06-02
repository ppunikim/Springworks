package com.callor.naver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// list.jsp를 처리할 공간
@Controller
@RequestMapping(value="/books")
public class BooksController {
	
	@RequestMapping(value="/list")
	public String list() {
		
		/* return "문자열"형식은
		 * 명시적으로 어떤 jsp파일을 rendering할 것인지
		 * 알려주는 것이다.
		 * 현재 method를 요청한 URL에 대하여 jsp를 
		 * 명시적으로 전달한다.
		 */
		return "books/list";
	
	
	
	
	
	}//end list()
	
}//end class

