package com.callor.memo.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.memo.model.ApiDTO;
import com.callor.memo.model.DiaryVO;
import com.callor.memo.model.MemoVO;
import com.callor.memo.service.ApiService;
import com.callor.memo.service.DiaryService;
import com.callor.memo.service.MemoService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class HomeController {

	private final MemoService memoService;
	private final DiaryService diaryService;
	private final ApiService bookService;
	public HomeController(MemoService memoService,
						  DiaryService diaryService,
						  ApiService bookService) {
		this.memoService = memoService;
		this.diaryService = diaryService;
		this.bookService = bookService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, Locale locale,
					 HttpSession httpSession) {
		List<MemoVO> memoList = memoService.selectAll();
		String username = (String) httpSession.getAttribute("USERNAME");		
		if(username != null) {
			List<ApiDTO> bookList = bookService.findByAuthor(username);
			List<DiaryVO> diaryList = diaryService.findByAuthor(username);
			model.addAttribute("BOOKLIST", bookList);	
			model.addAttribute("MEMOLIST", memoList);
			model.addAttribute("DIARYLIST",diaryList);
		}
		log.debug("여기는 Home");
		return "home";
	}
	
	@RequestMapping(value={"/",""}, method=RequestMethod.POST)
	public String home() {
		return "redirect:/";
	}
	
	
	@RequestMapping(value="/{seq}/m-list", method =RequestMethod.GET)
	public String list(@PathVariable("seq") String seq, Model model,
			@ModelAttribute("memoVO") MemoVO memoVO) {
		return "memo/m-list";
	}

}//end class
