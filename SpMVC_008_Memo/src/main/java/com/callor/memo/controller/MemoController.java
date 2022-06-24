package com.callor.memo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
}
