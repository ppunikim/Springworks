package com.callor.memo.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.memo.model.BookDTO;
import com.callor.memo.model.DiaryVO;
import com.callor.memo.model.MemoVO;
import com.callor.memo.service.BookService;
import com.callor.memo.service.DiaryService;
import com.callor.memo.service.MemoService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class HomeController {

	private final MemoService memoService;
	private final DiaryService diaryService;
	private final BookService bookService;
	public HomeController(MemoService memoService,
						  DiaryService diaryService,
						  BookService bookService) {
		this.memoService = memoService;
		this.diaryService = diaryService;
		this.bookService = bookService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, Locale locale,
					 HttpSession httpSession) {
		
		String username = (String) httpSession.getAttribute("USERNAME");

		List<MemoVO> memoList = memoService.selectAll();
		List<DiaryVO> diaryList = diaryService.selectAll();
		
		if(username != null) {
			List<BookDTO> bookList = bookService.findByAuthor(username);
			model.addAttribute("BOOKLIST", bookList);	
		}
		
		model.addAttribute("MEMOLIST", memoList);
		model.addAttribute("DIARYLIST",diaryList);
		log.debug("여기는 Home");
		return "home";
	}
	
}
