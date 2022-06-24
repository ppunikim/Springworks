package com.callor.memo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.memo.model.MemoVO;
import com.callor.memo.service.MemoService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class HomeController {

	private final MemoService memoService;
	public HomeController(MemoService memoService) {
		this.memoService = memoService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		List<MemoVO> memoList = memoService.selectAll();
		model.addAttribute("MEMOLIST", memoList);
		log.debug("여기는 Home");
		return "home";
	}
	
}
