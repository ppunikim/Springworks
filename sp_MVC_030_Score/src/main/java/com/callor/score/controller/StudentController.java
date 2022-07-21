package com.callor.score.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.score.model.StudentVO;
import com.callor.score.service.StudentService;

@Controller
public class StudentController {
	
	private final StudentService stService;
	public StudentController(StudentService stService) {
		this.stService = stService;
	}
	
	
	@RequestMapping(value="/student", method=RequestMethod.GET)
	public String home(Model model) {
		List<StudentVO> stList = stService.selectAll();
		model.addAttribute("LIST",stList);
		return null;
	}
	
//	
//	@RequestMapping(value="/student" ,method=RequestMethod.POST)
//	public String home(StudentVO stVO) {
//		stService.insert(stVO);
//		return null;
//	}
}
