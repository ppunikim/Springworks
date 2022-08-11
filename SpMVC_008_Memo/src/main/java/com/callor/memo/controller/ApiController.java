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
import org.springframework.web.multipart.MultipartFile;

import com.callor.memo.model.ApiDTO;
import com.callor.memo.service.ApiService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class ApiController {
	
	@Autowired
	private ApiService bookService;
	
	@RequestMapping(value="/b-add", method = RequestMethod.GET)
	public String insert(@ModelAttribute("book") ApiDTO book,
						 HttpSession httpSession) {
		String username = (String)httpSession.getAttribute("USERNAME");
		if(username == null) {
			return "redirect:/user/login";
		}
		book.setB_author(username);
		return null;
	}
	
	/*
	 * 첨부파일이 있는 프로젝트에서
	 * form의 input box 의 이름은 절대로 VO(DTO) 클래스에
	 * 선언된 이름을 절대 사용하면 안된다.!!!!!!!
	 */
	@RequestMapping(value="/b-add", method = RequestMethod.POST)
	public String insert(@ModelAttribute("book") ApiDTO book,
						 MultipartFile file, HttpSession httpSession) {
		//메모를 저장하기 전, 현재 session에 저장된 username 가져오기
		String username = (String)httpSession.getAttribute("USERNAME");
		//저장 할 메모 정보에 username 세팅
		book.setB_author(username);
		bookService.insertAndUpdate(book, file);
		
		return "redirect:/";
	}

	@RequestMapping(value="/{seq}/b-detail", method=RequestMethod.GET)
	public String detail(@PathVariable("seq")String seq,
						 @ModelAttribute("book") ApiDTO bookDTO,
						 Model model) {
		bookDTO.getB_seq();
		long b_seq = Long.valueOf(seq);
		bookDTO = bookService.findById(b_seq);
		model.addAttribute("book",bookDTO);
		return "book/b-detail";
	}
	
	@RequestMapping(value="/{seq}/update" , method=RequestMethod.GET)
	public String update(@PathVariable("seq") String seq,Model model) {
		ApiDTO book = bookService.findById(Long.valueOf(seq));
		model.addAttribute("BOOK",book);
		return "book/b-add";
	}
	
	@RequestMapping(value="/{seq}/update" , method=RequestMethod.POST)
	public String update(@PathVariable("seq") String seq,
						 @ModelAttribute("book") ApiDTO bookDTO,
						 MultipartFile file,
						 HttpSession httpSession) {
		
		String username = (String) httpSession.getAttribute("USERNAME");
		if(username == null) {
			return "redirect:/user/login";
		}
		bookDTO.setB_author(username);
		
		long b_seq = Long.valueOf(seq);
		bookDTO.setB_seq(b_seq);
		
		bookService.insertAndUpdate(bookDTO,file);
		return String.format("redirect:/book/%s/b-detail",seq);
	}

	
	@RequestMapping(value="/{seq}/delete" ,method=RequestMethod.GET)
	public String delete(@PathVariable("seq") String seq) {
		bookService.delete(Long.valueOf(seq));
		return "redirect:/";
	}
	
	
	
	
	@ModelAttribute("book")
	private ApiDTO bookDTO() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat toDay = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat toTime = new SimpleDateFormat("HH:mm:ss");
		
		ApiDTO book = ApiDTO.builder()
							  .b_date(toDay.format(date))
							  .b_time(toTime.format(date))
							  .build();
		return book;
	}
}
