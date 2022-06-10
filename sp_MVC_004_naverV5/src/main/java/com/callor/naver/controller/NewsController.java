package com.callor.naver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/news")
public class NewsController {
	
	@RequestMapping(value={"/",""})
	public String list() {
		
		/* return null 이면 value를 보고 알아서 조합한다.
		 * 즉, 암시적으로 어떤 jsp 파일을 rendering할 것인지
		 * 알려주는 것이다.
		 * 현재 method 요청한 URL이 명시적으로 명확할 경우
		 * null을 return 하면 Spring에서 자체적으로 폴더/파일 형식으로
		 * 구성을 해준다.
		 */
		return "news/list";
	}//end list()
	
}//end class
