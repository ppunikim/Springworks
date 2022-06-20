package com.callor.images.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.images.model.BBsVO;
import com.callor.images.service.BBsService;
import com.callor.images.service.FileUpService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/file")
public class FileUpController {
	
	private final BBsService bbsService;
	public FileUpController(BBsService bbsService) {
		this.bbsService = bbsService;
	}
	
	// 선생님 주석 보기
	@RequestMapping(value="/fileups", method=RequestMethod.GET)
	public String upFiles(@ModelAttribute("bbsVO") BBsVO bbsVO,
						  Model model) {
		return null;
	}//end upFiles()
	
	@RequestMapping(value="/fileups", method=RequestMethod.POST)
	public String upFiles(@ModelAttribute("bbsVO") BBsVO bbsVO,
						  MultipartHttpServletRequest mFiles, 
						  Model model) {
		bbsService.insertBBsAndFiles(bbsVO, mFiles);
		return null;
	}//end upFiles()
	
	
	@ModelAttribute("bbsVO")
	private BBsVO bbsVO() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		
		BBsVO bbsVO = BBsVO.builder().b_date(dayFormat.format(date))
									.b_time(timeFormat.format(date))
									.b_writer("ppunikim")
									.build();
		log.debug(bbsVO.toString());
	return bbsVO;
	}

	
}//end FileUpController
