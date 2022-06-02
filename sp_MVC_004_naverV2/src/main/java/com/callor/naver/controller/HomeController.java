package com.callor.naver.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.naver.service.exec.NaverBookServiceEx;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	@ResponseBody
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String home(String title, Model model) {
		log.debug("도서명 : " + title);
		
		NaverBookServiceEx naverService = new NaverBookServiceEx();
		String queryString = naverService.queryString("BOOK", title);
		String resString = naverService.getJasonString(queryString);
		
		return resString;
	}
	
	/* 프로젝트의 요청에 대해 소수의 Controller를 만들고
	 * 처리를 할 수 있다.
	 * 하지만, 프로젝트 규모가 커지면 관리가 어려워지고
	 * 결국에는 프로젝트를 Refactoring해야하는 상황에 직면된다.
	 * 
	 * 밑에 메서드는 쓰지 않을 것이라는 이야기이다. 보여주기 식이다.
	
	@RequestMapping(value="/book/list")
	public String bookList() {
		return "books/list";
	}
	 */
	
}
