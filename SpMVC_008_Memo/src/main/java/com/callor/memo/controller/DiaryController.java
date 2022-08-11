package com.callor.memo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.memo.model.DiaryVO;
import com.callor.memo.service.DiaryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value="/diary")
@Controller
public class DiaryController {
	
	private final DiaryService diaryService;
	public DiaryController(DiaryService diaryService) {
		this.diaryService = diaryService;
	}

	@ModelAttribute("diaryVO")
	public DiaryVO makeDiary() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		DiaryVO diaryVO = DiaryVO.builder()
							.d_day(dayFormat.format(date))
							.build();
		return diaryVO;
	}

	
	@RequestMapping(value="/d-list" , method=RequestMethod.GET)
	public String d_home(Model model) {
		List<DiaryVO> dList = diaryService.selectAll();
		model.addAttribute("DIARYLIST",dList);
		log.debug(" 리스트확인" + dList.toString());
		return "diary/d-list";
	}

	@RequestMapping(value="/d-add", method = RequestMethod.GET)
	public String insert(@ModelAttribute("diaryVO") DiaryVO diaryVO, 
					 	  Model model) {
		
		return null;
	}
	
	@RequestMapping(value="/d-add", method = RequestMethod.POST)
	public String insert(@ModelAttribute("diaryVO") DiaryVO diaryVO) {
		diaryService.insert(diaryVO);
		return "redirect:/diary/d-list";
	}
	
	
	@RequestMapping(value="/{d_day}/d-detail", method = RequestMethod.GET)
	public String view(Model model, @PathVariable("d_day") String d_day) {
		DiaryVO diaryVO = diaryService.findById(d_day);
		log.debug(" VO확인" + diaryVO.toString());
		model.addAttribute("D_DIARY",diaryVO);
		return "diary/d-add";
	}
	
	
	@RequestMapping(value="/{d_day}/d-detail", method = RequestMethod.POST)
	public String update(@ModelAttribute("diaryVO") DiaryVO diaryVO
						 ) {
		diaryService.update(diaryVO);
		return "redirect:/diary/d-list";
	}
	
	
	@RequestMapping(value="/{d_day}/delete", method=RequestMethod.GET)
	public String delete(@PathVariable("d_day") String d_day) {
		diaryService.delete(d_day);
		return "redirect:/diary/d-list";
	}
	
}
