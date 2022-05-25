package com.callor.school.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.school.model.UserVO;
import com.callor.school.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	private final UserService userService;
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value ="/login", method=RequestMethod.GET)
	public String login() {
	
		return null;
	}
	
	/* 1. login.form에서 username과 password받기
	 * 2. userVO에 담겨서 받게 된다.
	 * 3. userVO userService.login에게 전달한다.
	 * 4. UserService.login() method는 username과 password검사
	 * 5. 정상적인(username, password가 일치)정보이면
	 * 	  나머지 user정보를 userVO에 담아 return
	 * 	  만약 정상적인 사용자가 아니라면 null을 return
	 * 
	 * 6. Controller.login.POST method에는
	 * 		HttpSession 클래스를 매개변수로 설정한다.
	 * 7. 정상 사용자 정보이면(userVO가 null이 아니면)
	 * 	  setAttribute() method를 사용하여 사용자 정보를
	 *    변수에 setting한다.
	 * 8. 정상 사용자가 아니면 removeAttribute() method를 사용하여
	 * 	  변수를 제거해 버린다.
	 */
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(UserVO userVO,HttpSession session) {
		log.debug(userVO.toString());
		
		userVO = userService.login(userVO);
		if(userVO == null) {
			session.removeAttribute("USER");
		} else {
			session.setAttribute("USER", userVO);
		}
		return null;
	}//end login
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("USER");
		
		/* redirect 란 
		 * : 로그아웃이 끝나면 web browser의 주소창에
		 *   /user/login을 입력하고 Enter를 눌러라.
		 */
		return "redirect:/user/login";
	}
	
	
	
}//end class
























