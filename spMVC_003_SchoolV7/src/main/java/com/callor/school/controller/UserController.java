package com.callor.school.controller;

import javax.servlet.http.HttpSession;

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
	public String login(UserVO userVO,HttpSession session,Model model) {
		
		/* 로그인 폼에 입력한 username과 password는 userVO에 담겨
		 * 이곳에 도착한다.
		 */
		log.debug(userVO.toString());
		
		/* 서버와 view사이에서 약속된 protocal을 사용하기 위해
		 * 변수를 선언하고(1)
		 */
		String loginMessage = null;
		/* 로그인 폼에서 전송된 데이터중 username으로
		 * findById() 즉, SelectOne(username)을 실행한다.
		 * 그리고 결과를 loginUserVO에 담는다.
		 * 만약 username정보가 user table에 없으면
		 * 결관 null이고, 정보가 있으면 관련데이터가 포함된 vo가 만들어진다.
		 */
		UserVO loginUserVO = userService.findById(userVO.getUsername());
		
		// 아이디(username)가 없을 때 
		if(loginUserVO == null) {
			//가입된 적이 없다는 키워드를 생성하고(2)
			loginMessage = "USERNAME FAIL";
		} else if(!loginUserVO.getPassword().equals(userVO.getPassword())) {
			//비밀번호가 잘못 됐으면 잘못됐다는 키워드 생성하고(3)
			loginMessage = "PASSWORD FAIL";
		}
		
		//로그인 됐는지 아닌지 session에 setting(담기)(5)
		if(loginMessage == null ) {
			session.setAttribute("USER", loginUserVO);
		} else {
			session.removeAttribute("USER");
		}
		//view로 보낼 메세지 프로토콜을 setting하기(4)
		model.addAttribute("LOGIN_MESSAGE", loginMessage);
		return "user/login_ok";
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

