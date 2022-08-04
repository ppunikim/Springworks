package com.callor.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/admin")
public class AdminController {

	@RequestMapping(value={"/",""} ,method=RequestMethod.GET)
	public String home() {
		log.debug("여기");
		return "admin/home";
	}
}
