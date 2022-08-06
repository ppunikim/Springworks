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


public class MemoController2 {
	
	@Autowired
	private MemoService memoService;
	
	@RequestMapping(value="/m-add", method=RequestMethod.GET)
	public String insert(@ModelAttribute("memoVO") MemoVO memoVO,Model model,
						 HttpSession httpSession) {
		model.addAttribute("memoVO",memoVO);
		return null;
	}
	@RequestMapping(value="/m-add", method=RequestMethod.POST)
	public String insert(@ModelAttribute("memoVO") MemoVO memoVO
						,MultipartFile file,HttpSession httpSession) {
		memoService.insertAndUpdate(memoVO,file);
		return "memo/m-list";
	}
	
	@ModelAttribute("memoVO")
	public MemoVO makeMemo() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

		MemoVO memoVO = MemoVO.builder()
				.m_date(dayFormat.format(date))
				.m_time(timeFormat.format(date))
				.build();
		return memoVO;
	}
	
	@RequestMapping(value="/{seq}/m-detail", method =RequestMethod.GET)
	public String detail(@PathVariable("seq") String seq, Model model,
						 @ModelAttribute("memoVO") MemoVO memoVO) {
		memoVO.getM_seq();
		long m_seq = Long.valueOf(seq);
		memoVO = memoService.findById(m_seq);
		model.addAttribute("M_MEMO",memoVO);
		return "memo/m-detail";
	}
	
	@RequestMapping(value="/{seq}/update", method = RequestMethod.GET)
	public String update(
			@PathVariable("seq") String seq, Model model) {
		MemoVO memoVO = memoService.findById(Long.valueOf(seq));
		model.addAttribute("M_MEMO", memoVO);
		return "memo/m-add";
	}
	@RequestMapping(value="/{seq}/update", method = RequestMethod.POST)
	public String update(@PathVariable("seq") String seq, 
			@ModelAttribute("memoVO") MemoVO memoVO,
			MultipartFile file,
			HttpSession httpSession) {
		Long m_seq = Long.valueOf(seq);
		memoVO.setM_seq(m_seq);
		memoService.insertAndUpdate(memoVO,file);
		return String.format("redirect:/memo/%s/m-detail",seq);
	}
	
	@RequestMapping(value="/{seq}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable("seq") String seq) {
		memoService.delete(Long.valueOf(seq));
		return "redirect:/";
	}
	
}
