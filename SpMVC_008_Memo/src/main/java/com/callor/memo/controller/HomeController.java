package com.callor.memo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.memo.model.DiaryVO;
import com.callor.memo.model.MemoVO;
import com.callor.memo.service.DiaryService;
import com.callor.memo.service.MemoService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class HomeController {

	private final MemoService memoService;
	private final DiaryService diaryService;
	public HomeController(MemoService memoService,
						  DiaryService diaryService) {
		this.memoService = memoService;
		this.diaryService = diaryService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		List<MemoVO> memoList = memoService.selectAll();
		List<DiaryVO> diaryList = diaryService.selectAll();
		model.addAttribute("MEMOLIST", memoList);
		model.addAttribute("DIARYLIST",diaryList);
		log.debug("여기는 Home");
		return "home";
	}
	
}
