package com.callor.memo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

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
	public String write(@ModelAttribute("memoVO") MemoVO memoVO,Model model) {
		model.addAttribute("memoVO",memoVO);
		return null;
	}
	@RequestMapping(value="/memo", method=RequestMethod.POST)
	public String write(@ModelAttribute("memoVO") MemoVO memoVO
								,@RequestParam("m_file")MultipartFile file, Model model) {
		log.debug("업로드 파일 이름 : {}",file.getOriginalFilename());
		try {
			String fileName = memoService.fileUp(file);
			memoVO.setM_image(fileName);
		} catch (Exception e) {
			return "FILE UP FAIL";
		}
		memoService.insert(memoVO);
		return "redirect:/";
	}
	
	@ModelAttribute("memoVO")
	public MemoVO makeMemo() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

		MemoVO memoVO = MemoVO.builder().m_date(dayFormat.format(date))
				.m_time(timeFormat.format(date))
				.m_author("ppuni@naver.com")
				.build();
		return memoVO;
	}
	
	@RequestMapping(value="/{seq}/detail", method =RequestMethod.GET)
	public String view(@PathVariable("seq") Long seq, Model model) {
		MemoVO memoVO = memoService.findById(seq);
		model.addAttribute("D_MEMO",memoVO);
		return "write/detail";
	}
	
	@RequestMapping(value="/{seq}/update", method = RequestMethod.GET)
	public String update(
			@PathVariable("seq") Long seq,
			@ModelAttribute("memoVO") MemoVO memoVO,
			Model model) {
		memoVO = memoService.findById(seq);
		log.debug(memoVO.toString());
		model.addAttribute("UPDATE", memoVO);
		return "write/memo";
	}
	@RequestMapping(value="/{seq}/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("memoVO") MemoVO memoVO) {
		log.debug("여기" + memoVO.toString());
		memoService.update(memoVO);
//		String retStr = String.format("redirect:/memo/wirte/%s/detail", memoVO.getM_seq());
//		return retStr;
		return "redirect:/";
	}
	
	@RequestMapping(value="/{seq}/delete", method = RequestMethod.GET)
	public String delete() {
		return null;
	}
	
}
