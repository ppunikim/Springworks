package com.callor.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.app.domain.StudentVO;
import com.callor.app.service.StudentService;

@Controller  // annotation이 붙은 것은 new를 사용하지 않는다. 제어의 역전
public class StudentController {
	
	private final StudentService stService;

	public StudentController(StudentService stService) { //dependancy injection
		this.stService = stService;
	}
	
	@RequestMapping(value="/student/detail",method=RequestMethod.GET)
	public String detail(String stNum,Model model) {
		
		StudentVO stVO = stService.findById(stNum);
		model.addAttribute("STUDENT",stVO);
		
		return "student/detail";
	}
	
	@RequestMapping(value="/student", method=RequestMethod.GET)
	public String list(Model model) {
		
		List<StudentVO> stList = stService.selectAll();
		model.addAttribute("STUDENTS",stList );
		
		
		return "student/list_view";
	}
	
	@RequestMapping(value="/student/insert", method= RequestMethod.GET)
	public String insert() {
		return "student/insert";
	}
	
	

}//end class
