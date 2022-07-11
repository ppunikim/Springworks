package com.callor.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/user")
public class UserController {

	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return null; 
	}
	
	@ResponseBody
	@RequestMapping(value="/join", method=RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String join(String username, String password) {
		log.debug(username);
		return username; 
	}

}
