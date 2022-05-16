package com.callor.school.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.school.model.StudentVO;
import com.callor.school.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	private final StudentService stService;
	public HomeController(StudentService stService) {
		this.stService = stService;
	}
	
	
	/*private static final Logger log = LoggerFactory.getLogger(HomeController.class);
		클래스에 @Slf4j Annotaion을 부착함으로 다음 코드를 lombok이 대신 만들어준다.
	*/
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		List<StudentVO> stList = stService.selectAll();
		model.addAttribute("ST_LIST",stList);
		return "home";
		
	}
	
}
