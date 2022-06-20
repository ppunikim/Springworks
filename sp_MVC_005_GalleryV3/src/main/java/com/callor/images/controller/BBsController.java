package com.callor.images.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.callor.images.model.BBsVO;
import com.callor.images.service.BBsService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@RequestMapping(value="/bbs")
public class BBsController {

	
	@Autowired  //데이터베이스에 파일 이름을 저장하기 위해 사용
	private BBsService bbsService;
	
	
	//선생님 주석 보기
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write(@ModelAttribute("bbsVO") BBsVO bbsVO, Model model) {
		
		
		//주입받은 bbsVO객체 데이트럴 form.jsp로 전달하기.
		model.addAttribute("bbsVO", bbsVO);
		return "bbs/input";
	}//end write()get
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(@ModelAttribute("bbsVO")  BBsVO bbsVO,
			@RequestParam("up_file") MultipartFile file, Model model) {
	
		log.debug("받은 데이터 {}" , bbsVO.toString());
		log.debug("받은 파일 {}" , file.getOriginalFilename());
		
		String imageFile = bbsService.insertBBsAndFile(bbsVO, file);
		model.addAttribute("IMAGE",imageFile);
		return "redirect:/";
	}//end write()post
	
	
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String detail(String seq, Model model) {
		try {
			long b_seq = Long.valueOf(seq);
			BBsVO bbsVO = bbsService.findById(b_seq);
			//bbsVO.setImages(fileDao.findByBBsSeq(b_seq));
			
			model.addAttribute("BBS",bbsVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}//end detail()get
	
	
	
	}//end class
