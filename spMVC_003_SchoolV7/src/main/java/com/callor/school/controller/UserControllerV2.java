package com.callor.school.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.school.model.UserVO;
import com.callor.school.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/user")
public class UserControllerV2 {
	
	/* @Qualifier("userServiceV2")
	 * UserService 인터페이스를 상속받은 클래스가 2개 있다.
	 * User...ImplV1 과 User...ImplV2 가 있는데
	 * 그중에서 @Service("userServiceV2")라고 명시된 클래스를 주입해 달라는 말이다.
	 */
	private final UserService userService;
	public UserControllerV2(@Qualifier("userServiceV2") UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value ="/login", method=RequestMethod.GET)
	public String login() {
	
		return null;
	}
	
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(UserVO userVO,HttpSession session,Model model) {
		
		UserVO loginUser = userService.login(userVO);
		if(loginUser == null) {
			session.removeAttribute("USER");
		} else {
			session.setAttribute("USER", loginUser);
		}
		return "redirect:/";
	}//end login
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("USER");
		
		/* redirect 란 
		 * : 로그아웃이 끝나면 web browser의 주소창에
		 *   /user/login을 입력하고 Enter를 눌러라.
		 */
		return "redirect:/";
	}
	
	@RequestMapping(value="/join",method=RequestMethod.GET)
	public String join() {
		
		/*  이 메서드를 요청하는 url은
		 *  /user/join이다.
		 *  
		 *   return null을 실행하면
		 *   return user/join을 실행한 것과 같다.
		 *   views/user/join.jsp를 rendering 하라는 의미.
		 */
		return null;
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(UserVO userVO) {
		log.debug("JOIN");
		log.debug(userVO.toString());
		userService.join(userVO);
		/* 
		 * return "문자열" : Forwarding
		 * -> views/문자열.jsp 를 rendering하라.
		 * 
		 * return "redirect:/url" : pass, toss, redirect
		 * -> 서버의 localhost:8080/url 을 다시 request하라
		 * -> web browse 주소창에 localhost:8080/url을 입력하고
		 */
		return "redirect:/user/login";
	}
	
	
	/* username 중복검사를 하기 위해서 보통 다음과 같은 요청을 수행한다.
	 *  /user/idcheck?username=yd62322
	 * 
	 * fetch(`${rootPath}/user/idcheck/${username.value}`)
	 * 만약 username에 yd62322를 입력하면
	 *  /user/idchck/yd62322
	 */
	@ResponseBody
	@RequestMapping(value="/idcheck/{username:.+}", method=RequestMethod.GET)
	public String idcheck(@PathVariable  String username) {
		/* 아이디를 이메일 주소로 사용할 때 
		 * PathVariable로 받을 경우,
		 * dot(.) 이후 문자열을 잘라버리는 현상이 있다.
		 * 이 때는 정규식(Rexp)을 사용하여 dot(.) 이후 문자열을
		 * 포함하여 변수에 저장하도록 변수를 수정.
		 * {username:.+} 형식으로 지정한다.
		 */
		UserVO userVO = userService.findById(username);
		//if(username.equalsIgnoreCase(userVO.getUsername()));
//		if(userVO.getUsername().equalsIgnoreCase(username)) {
//			return "FAIL";
//		} else {
//			return "OK";
//		}
		if(userVO == null) {
			return "OK";
		} else {
			return "FAIL";
		}
	}
	
	
}//end class

