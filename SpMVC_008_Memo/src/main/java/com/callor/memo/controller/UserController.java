package com.callor.memo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.memo.model.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value="/user")
@Controller
public class UserController {
	
	@RequestMapping(value="/join", method =RequestMethod.GET)
	public String join() {
		return "/user/join";
	}
	
	@RequestMapping(value="/join", method =RequestMethod.POST)
	public String join(String username, String password) {
		log.debug("로그인 정보 {}", username);
		return "redirect:/";
	}
	
	@RequestMapping(value="/login", method =RequestMethod.GET)
	public String login() {
		return "/user/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(UserVO userVO, HttpSession httpSession) {
		httpSession.setAttribute("USER", userVO);
		return "redirect:/";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession httpSession) {
		httpSession.removeAttribute("USERNAME"); //세션 정보 제거
		return "redirect:/";
	}
	
	@RequestMapping(value="/mypage", method =RequestMethod.GET)
	public String mypage() {
		return "/user/mypage";
	}
	
	
}//end class