package com.callor.ems.controller;

import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.ems.model.UserVO;
import com.callor.ems.service.QualifyConfig;
import com.callor.ems.service.SendMailService;
import com.callor.ems.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value="/user")
@Controller
public class UserController {
	
	@Autowired
	@Qualifier(QualifyConfig.SERVICE.MAIL_V2)
	private SendMailService xMail;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/join" , method=RequestMethod.GET)
	public String join(@ModelAttribute("userVO") UserVO userVO, Model model) {
		model.addAttribute("userVO", userVO);
		return null;
	}//end get
	
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String join(@ModelAttribute("userVO") UserVO userVO) {
		userService.join(userVO);
		return "user/join_email";
	}
	
	@RequestMapping(value="/email_ok/{email:.*}")
	public String email_ok(@PathVariable("email") String email, @ModelAttribute("userVO") UserVO userVO) {
		
		UserVO emailUserVO = userService.findById(email);
		if(userVO == null) {
			return "redirect:/user/join?error=error";
		}
		userVO.setUsername(null);
		userVO.setEmail(emailUserVO.getEmail());
		userVO.setPassword("");
		log.debug(email);
		return "user/join_next";
	}
	
	@ModelAttribute("userVO")
	private UserVO userVO() {
		return new UserVO();
	}//end userVO
	


	
	//이해를 위해 작성한 코드이다.
	@RequestMapping(value="{aa}/email_ok/{bb}")
	public String ok(@PathVariable("aa") String aa, @PathVariable("bb") String bb) {
		return "user/join_email";
	}
	
	// ~~/user/email?emails=11
	@RequestMapping(value="/email")
	public String ok(String emails) {
		return "user/join_email";
	}
	
}//end class
