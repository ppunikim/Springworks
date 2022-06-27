package com.callor.memo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

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
@RequestMapping(value="/record")
@Controller
public class DiaryController {
	
	private final DiaryService diaryService;
	public DiaryController(DiaryService diaryService) {
		this.diaryService = diaryService;
	}

	@RequestMapping(value="/diary", method = RequestMethod.GET)
	public String insert(@ModelAttribute("diaryVO") DiaryVO diaryVO, 
					 	  Model model,
					 	  HttpSession httpSession) {
		String username = (String) httpSession.getAttribute("USERNAME");
		if(username == null) {
			return "redirect:/user/login";
		}
		diaryVO.setD_author(username);
		return null;
	}
	
	@RequestMapping(value="/diary", method = RequestMethod.POST)
	public String insert(@ModelAttribute("diaryVO") DiaryVO diaryVO,
					 	 HttpSession httpSession) {
		String username = (String) httpSession.getAttribute("USERNAME");
		diaryVO.setD_author(username);
		diaryService.insert(diaryVO);
		return "redirect:/";
	}
	
	@ModelAttribute("diaryVO")
	public DiaryVO makeDiary() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:SS");
		
		DiaryVO diaryVO = DiaryVO.builder()
							.d_date(dayFormat.format(date))
							.d_time(timeFormat.format(date))
							.build();
		return diaryVO;
	}
	
	@RequestMapping(value="{seq}/detail", method = RequestMethod.GET)
	public String view(@PathVariable("seq") Long seq, Model model,
					    @ModelAttribute("diaryVO") DiaryVO diaryVO) {
		diaryVO = diaryService.findById(seq);
		model.addAttribute("D_DIARY",diaryVO);
		return "record/detail";
	}
	
	@RequestMapping(value="{seq}/update", method=RequestMethod.GET)
	public String update(@PathVariable("seq") Long seq,
						 @ModelAttribute("diaryVO") DiaryVO diaryVO,
						 Model model) {
		diaryVO = diaryService.findById(seq);
		model.addAttribute("D_DIARY",diaryVO);
		return "record/diary";
	}
	
	@RequestMapping(value="{seq}/update", method = RequestMethod.POST)
	public String update(@PathVariable("seq") Long seq,
						 @ModelAttribute("diaryVO") DiaryVO diaryVO,
						 HttpSession httpSession) {
		String username = (String) httpSession.getAttribute("USERNAME");
		if(username == null) {
			return "redirect:/user/login"; 
		}
		diaryVO.setD_author(username);
		diaryVO.setD_seq(seq);
		diaryService.update(diaryVO);
		return  String.format("redirect:/record/%s/detail", diaryVO.getD_seq());
	}
	
	@RequestMapping(value="{seq}/delete", method=RequestMethod.GET)
	public String delete(@PathVariable("seq") Long seq) {
		diaryService.delete(seq);
		return "redirect:/";
	}
	
}
