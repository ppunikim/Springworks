package com.callor.score.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.score.model.ScoreVO;
import com.callor.score.model.StudentVO;
import com.callor.score.service.ScoreService;
import com.callor.score.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value= "/student")
public class StudentController {
	
	private final StudentService stService;
	public StudentController(StudentService stService) {
		this.stService = stService;
	}	
	// public String 이 아니라 public List<StudentVO>로 해줘야 List type으로 return 된다.
//	@RequestMapping(value= "/json", method=RequestMethod.GET)
//	public List<StudentVO> student(StudentVO stVO, Model model) {
//		List<StudentVO> stList = stService.selectAll();
//		model.addAttribute("LIST",stList);
//		return stList;
//	}
	
	@RequestMapping(value="/{st_num}/delete", method=RequestMethod.GET)
	public String delete(@PathVariable("st_num")String id) {
		int ret = stService.delete(id);
		return "redirect:/student";
	}
	

	
	@RequestMapping(value={"/",""} ,method=RequestMethod.GET)
	public String home(StudentVO stVO, Model model , String a) {
		List<StudentVO> stList = stService.selectAll();
		model.addAttribute("STUDENTS", stList);
		return "student/list";
	}
	
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String detail(String st_num, Model model) {
		StudentVO stVO = stService.findById(st_num);
		model.addAttribute("STUDENT",stVO);
//		List<ScoreVO> scList = scService.findByStNum(st_num);
//		log.debug(scList.toString() + "여기");
//		model.addAttribute("SCORE",scList);
		return "student/detail";
	}
	
	@RequestMapping(value="/detail" , method = RequestMethod.POST)
	public String reWrite(String st_num, StudentVO stVO) {
		stService.update(stVO);
		return "redirect:/student/";
	}
	
	
}
