package com.callor.score.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.score.model.StudentVO;
import com.callor.score.service.StudentService;

@Controller
@RequestMapping(value= "/student")
public class StudentController {
	
	private final StudentService stService;
	public StudentController(StudentService stService) {
		this.stService = stService;
	}
	
	
	// public String 이 아니라 public List<StudentVO>로 해줘야 List type으로 return 된다.
	@RequestMapping(value= {"/",""}, method=RequestMethod.GET)
	public List<StudentVO> student(StudentVO stVO, Model model) {
		List<StudentVO> stList = stService.selectAll();
		model.addAttribute("LIST",stList);
		return stList;
	}
	
	@RequestMapping(value="/{st_num}/delete", method=RequestMethod.GET)
	public String delete(@PathVariable("st_num")String id) {
		int ret = stService.delete(id);
		return "redirect:/student";
	}
	

//	
//	@RequestMapping(value="/student" ,method=RequestMethod.POST)
//	public String home(StudentVO stVO) {
//		stService.insert(stVO);
//		return null;
//	}
}
