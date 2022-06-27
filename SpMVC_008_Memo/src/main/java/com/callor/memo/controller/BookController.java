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

import com.callor.memo.model.BookDTO;
import com.callor.memo.service.BookService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RequestMapping(value="/read")
@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value="/book", method = RequestMethod.GET)
	public String insert(@ModelAttribute("book") BookDTO book,
						 HttpSession httpSession) {
		String username = (String)httpSession.getAttribute("USERNAME");
		if(username == null) {
			return "redirect:/user/login";
		}
		book.setB_author(username);
		return "read/book";
	}
	
	/*
	 * 첨부파일이 있는 프로젝트에서
	 * form의 input box 의 이름은 절대로 VO(DTO) 클래스에
	 * 선언된 이름을 절대 사용하면 안된다.!!!!!!!
	 */
	@RequestMapping(value="/book", method = RequestMethod.POST)
	public String insert(@ModelAttribute("book") BookDTO book,
						 MultipartFile file, HttpSession httpSession) {
		//메모를 저장하기 전, 현재 session에 저장된 username 가져오기
		String username = (String)httpSession.getAttribute("USERNAME");
		//저장 할 메모 정보에 username 세팅
		book.setB_author(username);
		bookService.insertAndUpdate(book, file);
		
		return "redirect:/";
	}

	@RequestMapping(value="/{seq}/detail", method=RequestMethod.GET)
	public String detail(@PathVariable("seq")String seq,
						 @ModelAttribute("book") BookDTO bookDTO,
						 Model model) {
		bookDTO.getB_seq();
		long b_seq = Long.valueOf(seq);
		bookDTO = bookService.findById(b_seq);
		model.addAttribute("book",bookDTO);
		return "read/detail";
	}
	
	@RequestMapping(value="/{seq}/update" , method=RequestMethod.GET)
	public String update(@PathVariable("seq") String seq,Model model) {
		BookDTO book = bookService.findById(Long.valueOf(seq));
		model.addAttribute("BOOK",book);
		return "read/book";
	}
	
	@RequestMapping(value="/{seq}/update" , method=RequestMethod.POST)
	public String update(@PathVariable("seq") String seq,
						 @ModelAttribute("book") BookDTO bookDTO,
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
		return String.format("redirect:/read/%s/detail",seq);
	}

	
	@RequestMapping(value="/{seq}/delete" ,method=RequestMethod.GET)
	public String delete(@PathVariable("seq") String seq) {
		bookService.delete(Long.valueOf(seq));
		return "redirect:/";
	}
	
	
	
	
	@ModelAttribute("book")
	private BookDTO bookDTO() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat toDay = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat toTime = new SimpleDateFormat("HH:mm:SS");
		
		BookDTO book = BookDTO.builder()
							  .b_date(toDay.format(date))
							  .b_time(toTime.format(date))
							  .build();
		return book;
	}
}
