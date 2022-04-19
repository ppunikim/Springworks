package com.callor.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/* spring에서는 main이 없는데, 대신
 * @Keyword
 * Annotation(주석)
 * 역할부여
 */
@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String home(String st_num1, String st_num2, Model model) {

			int intNum1 = Integer.valueOf(st_num1);
			int intNum2 = Integer.valueOf(st_num2);
			int intSum = intNum1 + intNum2;
			model.addAttribute("result", intSum);
		return "home";
	}


	@RequestMapping(value = "/Korea", method=RequestMethod.GET)
	public String Korea(String st_name, Model model) {
		
		model.addAttribute("result",st_name);
		return "Korea";
	}
	@RequestMapping(value = "/Korea", method=RequestMethod.POST)
	public String Korea(String st_name, String st_num ,Model model) {
		
		model.addAttribute("result",st_name);
		return "Korea";
	}
}
//웹 서비스가 작동되는 가장 기초적인 것이다.