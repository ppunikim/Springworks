package com.callor.memo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.callor.memo.model.MemoVO;
import com.callor.memo.service.MemoService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RequestMapping(value="/write")
@Controller
public class MemoController {
	
	@Autowired
	private MemoService memoService;
	
	@RequestMapping(value="/memo", method=RequestMethod.GET)
	public String insert(@ModelAttribute("memoVO") MemoVO memoVO,Model model,
						 HttpSession httpSession) {
		String username = (String) httpSession.getAttribute("USERNAME");
		if(username == null) {
			return "redirect:/user/login";
		}
		memoVO.setM_author(username);
		model.addAttribute("memoVO",memoVO);
		return null;
	}
	@RequestMapping(value="/memo", method=RequestMethod.POST)
	public String insert(@ModelAttribute("memoVO") MemoVO memoVO
						,MultipartFile file,HttpSession httpSession) {
		String username = (String) httpSession.getAttribute("USERNAME");
		memoVO.setM_author(username);
		memoService.insertAndUpdate(memoVO,file);
		return "redirect:/";
	}
	
	@ModelAttribute("memoVO")
	public MemoVO makeMemo() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:SS");

		MemoVO memoVO = MemoVO.builder()
				.m_date(dayFormat.format(date))
				.m_time(timeFormat.format(date))
				.build();
		return memoVO;
	}
	
	@RequestMapping(value="/{seq}/detail", method =RequestMethod.GET)
	public String detail(@PathVariable("seq") Long seq, Model model,
						 @ModelAttribute("memoVO") MemoVO memoVO) {
		memoVO = memoService.findById(seq);
		model.addAttribute("M_MEMO",memoVO);
		return "write/detail";
	}
	
	@RequestMapping(value="/{seq}/update", method = RequestMethod.GET)
	public String update(
			@PathVariable("seq") Long seq,
			@ModelAttribute("memoVO") MemoVO memoVO, Model model) {
		memoVO = memoService.findById(seq);
		model.addAttribute("M_MEMO", memoVO);
		return "write/memo";
	}
	@RequestMapping(value="/{seq}/update", method = RequestMethod.POST)
	public String update(@PathVariable("seq") Long seq, 
			@ModelAttribute("memoVO") MemoVO memoVO,
			MultipartFile file,
			HttpSession httpSession) {
		String username = (String) httpSession.getAttribute("USERNAME");
		if(username == null) {
			return "redirect:/user/login";
		}
		memoVO.setM_author(username);
		memoVO.setM_seq(seq);
		memoService.insertAndUpdate(memoVO,file);
		return String.format("redirect:/write/%s/detail",memoVO.getM_seq());
	}
	
	@RequestMapping(value="/{seq}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable("seq") Long seq) {
		memoService.delete(seq);
		return "redirect:/";
	}
	
}
