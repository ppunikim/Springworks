package com.callor.memo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value="/record")
@Controller
public class DiaryController {
	
	@RequestMapping(value="/diary", method=RequestMethod.GET)
	public String write() {
		return null;
	}
}
