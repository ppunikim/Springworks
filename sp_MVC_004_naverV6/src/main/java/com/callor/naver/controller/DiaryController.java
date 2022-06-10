package com.callor.naver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.naver.service.DiaryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value="/diary")
@Controller
public class DiaryController {
	
	@Autowired
	public DiaryService diaryService;
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write(Model model) {
		model.addAttribute("LAYOUT","DIARY");
		return "home";
	}
	

}
