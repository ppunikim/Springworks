package com.callor.images.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.callor.images.model.BBsVO;
import com.callor.images.persistance.FileDao;
import com.callor.images.service.BBsService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@RequestMapping(value="/bbs")
public class BBsController {

	
	@Autowired  //데이터베이스에 파일 이름을 저장하기 위해 사용
	private BBsService bbsService;
	@Autowired
	private FileDao fileDao;
	
	
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write(Model model) {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		
		BBsVO bbsVO = BBsVO.builder().b_date(dayFormat.format(date))
									.b_time(timeFormat.format(date))
									.b_writer("ppunikim")
									.build();
		model.addAttribute("BBS", bbsVO);
		return "bbs/input";
	}//end write()
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(BBsVO bbsVO,
			@RequestParam("up_file") MultipartFile file, Model model) {
		
		log.debug("게시판 : {}", bbsVO.toString());
		log.debug("업로드한 파일 이름 : {}", file.getOriginalFilename());
		String ret = bbsService.insertBBsAndFile(bbsVO, file);
		if(ret.equals("OK")) {
			model.addAttribute("seq",bbsVO.getB_seq());
			return "redirect:/bbs/detail";
		}
//		try {
//			String fileName = fileService.fileUp(file);
//			model.addAttribute("FILE",fileName);
//			return "home";
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String detail(String seq, Model model) {
		try {
			long b_seq = Long.valueOf(seq);
			BBsVO bbsVO = bbsService.findById(b_seq);
			bbsVO.setImages(fileDao.findByBBsSeq(b_seq));
			
			model.addAttribute("BBS",bbsVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}//end detail
	
	
	
	}//end class
