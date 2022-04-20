package com.callor.app;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * 여기는 컨트롤러
 * @Controller 클래스에 부탁하는 Annotation
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		// model 객체에 변수명="데이터" 속성을 추가하여
		// 				jsp에 rendering할 데이터 준비하기
		// model.addAttribute("변수명","데이터");
		model.addAttribute("my_name","길동");
		
		String[] st = {"둘리","또치","도우너","희동"};
		model.addAttribute("ST",st);
		
		
		return "home";
	}
	
}
