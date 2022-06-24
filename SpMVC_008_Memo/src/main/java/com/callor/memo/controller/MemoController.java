package com.callor.memo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.memo.model.MemoVO;
import com.callor.memo.service.MemoService;

@RequestMapping(value="/write")
@Controller
public class MemoController {
	
	@Autowired
	private MemoService memoService;
	
	@RequestMapping(value="/memo", method=RequestMethod.GET)
	public String write() {
		return "write/memo";
	}
	@RequestMapping(value="/memo", method=RequestMethod.POST)
	public String write(@ModelAttribute("MEMO") Model model, MemoVO memoVO) {
		model.addAttribute("MEMO", memoVO);
		return "write/memo";
	}
}
