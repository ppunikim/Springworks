package com.callor.hello.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

// spring아 HomeController클래스를 객체로 생성하여 컨테이너에 보관해 줘라 . 라는 이야기.
@Slf4j
@Controller
public class HomeController {
	
	/* 
	 * localhost:8080/hello/ 의 GET으로 요청이 들어오면, 
	 * WEB-INF/views/home.jsp 파일을 rendering하여
	 * HTML코드로 변환 후 응답하는 것이다.
	*/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home( Model model) {
		
		// model객체, jsp파일을 rendering할때 사용할 데이터를 보내기 위한 장바구니
		// ppuni 라는 이름의 변수에 cute를 담아 보내려는 것이다.
		model.addAttribute("ppuni","cute");
		return "home";
	}

	//이 때, () 안에 들어갈 변수명은 home.jsp와 같은 이름(name)으로 써야한다.
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String home( String puppy, String age) {
		log.debug("강아지 명 : {} " , puppy);
		log.debug("나이 : " + age);
		return "home";
	}

	
	
	
}
