package com.callor.naver.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.naver.config.QualifierConfig;
import com.callor.naver.model.UserVO;
import com.callor.naver.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value="/user")
@Controller
public class UserController {
	
	@Autowired
	@Qualifier(QualifierConfig.SERVICE.USER_V2)
	private UserService userService;
	
	
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join(Model model) {
		model.addAttribute("LAYOUT","JOIN");
		return "home";
	}
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(UserVO userVO) {
		log.debug("회원정보 : {}", userVO.toString());
		
		userService.join(userVO);
		return "redirect:/user/login";
	}
	
	
	
	
	
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(String error, Model model) {
		model.addAttribute("error",error);
		model.addAttribute("LAYOUT","LOGIN");
		return "home";
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(UserVO userVO, Model model, HttpSession session) {
		UserVO loginUser = userService.findById(userVO.getUsername());
		if(loginUser == null) {
			model.addAttribute("error","USERNAME_FAIL");
			return "redirect:/user/login";
		}
		loginUser = userService.login(userVO);
		if(loginUser == null) {
			model.addAttribute("error","PASSWORD_FAIL");
			return "redirect:/user/login";
		}
		session.setAttribute("USER", loginUser);
		return "redirect:/";
	}
	
	
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("USER");
		return "redirect:/";
	}//end 로그아웃
	
	
	
	@RequestMapping(value="/mypage", method=RequestMethod.GET)
	public String mypage(Model model, HttpSession session) {
		UserVO loginUser = (UserVO)session.getAttribute("USER");
		if(loginUser == null) {
			model.addAttribute("error","LOGIN_NEED");
			return "redirect:/user/login";
		}
		model.addAttribute("LAYOUT","MYPAGE");
		return "home";
	}//end 마이페이지, 로그인 풀렸을 경우 들어가지 못하게 하는 것.
	
	
	
}//end class



















