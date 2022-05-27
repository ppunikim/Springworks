package com.callor.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.home.service.StudentService;

/* @가 붙은 것은 new를 사용하지 않는다. 
 * 이유는 제어의 역전이기 때문에.
 */
@Controller
public class StudentController {
		
	private final StudentService stService;
	
	public StudentController(StudentService stService) {
		this.stService = stService;
	}//end 임의생성자
		
	@RequestMapping(value="/student", method=RequestMethod.GET)
	public String list() {
		return "student/list_view";
	}
	
	@RequestMapping(value="/student/insert", method=RequestMethod.GET)
	public String insert() {
		return "student/insert";
	}
		
}
