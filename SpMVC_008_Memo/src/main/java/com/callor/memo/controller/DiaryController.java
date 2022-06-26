package com.callor.memo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.callor.memo.model.DiaryVO;
import com.callor.memo.service.DiaryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value="/record")
@Controller
public class DiaryController {
	
	private final DiaryService diaryService;
	public DiaryController(DiaryService diaryService) {
		this.diaryService = diaryService;
	}

	@RequestMapping(value="/diary", method = RequestMethod.GET)
	public String write(@ModelAttribute("diaryVO") DiaryVO diaryVO, Model model) {
		model.addAttribute("diaryVO", diaryVO);
		return null;
	}
	@RequestMapping(value="/diary", method = RequestMethod.POST)
	public String write(@ModelAttribute("diaryVO") DiaryVO diaryVO, 
						@RequestParam("d_file") MultipartFile d_file,
						Model model) {
		try {
			String fileName = diaryService.fileUp(d_file);
			diaryVO.setD_image(fileName);
		}catch (Exception e) {
			return "FILE UP FAIL";
		}
		diaryService.insert(diaryVO);
		return "redirect:/";
	}
	
	@ModelAttribute("diaryVO")
	public DiaryVO makeDiary() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		
		DiaryVO diaryVO = DiaryVO.builder().d_date(dayFormat.format(date))
							.d_time(timeFormat.format(date))
							.d_author("ppunikim")
							.build();
		return diaryVO;
	}
	
}
