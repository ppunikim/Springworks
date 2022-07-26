package com.callor.score.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	private final ScoreService scService;
	public StudentController(StudentService stService,ScoreService scService) {
		this.stService = stService;
		this.scService = scService;
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
	
	/* 자세히 보기 jsp와 수정하기 jsp가 같은 곳에서 이루어지게 만들었으므로
	 * detail로 get 과 post를 만든 것이다.
	 * 만약 자세히 보기와 수정하기를 다르게 만들기 위해서는
	 * detail은 GET만, update는 GET,POST 두개 모두 만들어야 한다.
	 */
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
	public String detail(String st_num, StudentVO stVO, ScoreVO scVO, Model model,
			String[] sb_code, String[] sc_score) {
		stService.update(stVO); //학생 정보 바꾸기
		//return문을 문자열로 만들기: ~~/detail?st_num=%s + stVO.getSt_num()
		log.debug(sb_code.toString() + " 요기");
//		stVO = stService.findById(st_num); //학생 성적 바꾸기
//		model.addAttribute("STUDENT",stVO);
		for(int i = 0; i < sb_code.length; i ++) {
			log.debug("받은 {} {} {}", st_num, sb_code[i], sc_score[i]);
		}
//		Map<String , List<String>> scoreList = new HashMap<>();
		
	scService.updateScore(st_num, sb_code, sc_score);
		return "redirect:/student/";
	}
	
	
	
	
	
}
