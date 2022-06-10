package com.callor.naver.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.naver.config.QualifierConfig;
import com.callor.naver.model.BookVO;
import com.callor.naver.model.BuyBooksVO;
import com.callor.naver.model.UserVO;
import com.callor.naver.service.BookService;
import com.callor.naver.service.BuyBooksService;
import com.callor.naver.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value="/user")
@Controller
public class UserController {
	
	@Autowired
	@Qualifier(QualifierConfig.SERVICE.USER_V2)
	private UserService userService;
	@Autowired
	private BookService bookService;
	@Autowired
	private BuyBooksService buybookService;
	
	
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
		
		List<BuyBooksVO> buyBooks 
				= buybookService.findByUserName(loginUser.getUsername());
		for(BuyBooksVO buyVO : buyBooks) {
			String isbn = buyVO.getB_isbn();
			BookVO book = bookService.findById(isbn);	
			buyVO.setBook(book);
		}
		model.addAttribute("BUY_BOOKS",buyBooks);
		model.addAttribute("LAYOUT","MYPAGE");
		return "home";
	}//end 마이페이지, 로그인 풀렸을 경우 들어가지 못하게 하는 것.
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@ResponseBody
	@RequestMapping(value="/idcheck/{username}", method=RequestMethod.GET)
	public String idcheck(@PathVariable("username") String username) {
		UserVO userVO = userService.findById(username);
		if(userVO == null) {
			return "OK";
		}
		return "FAIL";
	}
	
	@ResponseBody
	@RequestMapping(value="/emailcheck", method=RequestMethod.GET)
	public String emailcheck(String email) {
		UserVO userVO = userService.findByEmail(email);
		if(userVO == null) {
			return "OK";
		}
		return "FAIL";
	}
	
	
}//end class



















