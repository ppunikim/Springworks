package com.callor.ems.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.callor.ems.model.EmsVO;
import com.callor.ems.model.UserVO;
import com.callor.ems.service.QualifyConfig;
import com.callor.ems.service.SendMailService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value="/user")
@Controller
@SessionAttributes("userVO")
public class UserController {
	
	@Autowired
	@Qualifier(QualifyConfig.SERVICE.MAIL_V2)
	private SendMailService xMail;
	
	@RequestMapping(value="/join" , method=RequestMethod.GET)
	public String join(@ModelAttribute("userVO") UserVO userVO, Model model) {
		model.addAttribute("userVO", userVO);
		return null;
	}//end get
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(@Valid UserVO userVO, BindingResult result) {
		if(result.hasErrors()) {
			return null;
		}
		
		EmsVO emsVO = EmsVO.builder()
						   .e_to_email(userVO.getEmail())
						   .e_to_name("새로운 회원")
						   .build();
		xMail.sendMail(emsVO,userVO);
		return "redirect:/user/join_next";
	}//end post
	
	@RequestMapping(value="/join_next", method=RequestMethod.GET)
	public String join_next(@ModelAttribute("userVO") UserVO userVO,
			String error,Model model) {
		model.addAttribute("error",error);
		return null;
	}
	@RequestMapping(value="/join_next", method=RequestMethod.POST)
	public String join_next(
			@Valid @ModelAttribute("userVO") UserVO userVO,
			BindingResult result,
			Model model,
			SessionStatus sessinoStatus) {
		
		if(userVO.getKey().equals(userVO.getKey_ok())) {
			log.debug("인증키 확인 성공");
			sessinoStatus.setComplete();
			return "redirect:/user/join_ok";
		} else {
			log.debug("인증키가 다름");
			return "redirect:/user/join_next?error=key";
		}
//		log.debug("회원정보 :{}",userVO.toString());
//		return null;
	}
	
	/* 어디선가 UserVO usrVO 객체가 필요하면
	 * 자동으로 객체를 생성하여 return 하는 코드가 실행된다.
	 */
	@ModelAttribute("userVO")
	private UserVO userVO() {
		return new UserVO();
	}//end userVO
	
	
}
