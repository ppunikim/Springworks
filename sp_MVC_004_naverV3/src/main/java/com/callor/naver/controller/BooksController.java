package com.callor.naver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.naver.config.QualifierConfig;
import com.callor.naver.domain.BookVO;
import com.callor.naver.service.BookService;

import lombok.extern.slf4j.Slf4j;

// list.jsp를 처리할 공간
@Slf4j
@Controller
@RequestMapping(value="/books")
public class BooksController {
	
	private final BookService bookService;
	public BooksController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping(value="/list")
	public String list(Model model) {
		
		/* return "문자열"형식은
		 * 명시적으로 어떤 jsp파일을 rendering할 것인지
		 * 알려주는 것이다.
		 * 현재 method를 요청한 URL에 대하여 jsp를 
		 * 명시적으로 전달한다.
		 */
		List<BookVO> bookList = bookService.selectAll();
		model.addAttribute("BOOKS", bookList);
		log.debug(bookList.toString());
		return null;
	}//end list()
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert() {
		return null;
	}//end insert()
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(BookVO bookVO) {
		log.debug("도서정보 : " + bookVO.toString());
		bookService.insert(bookVO);
		return null;
	}//end insert()

//	@RequestMapping(value="/books", method=RequestMethod.GET)
//	public String getBooks(String title,Model model) {
//		
//		log.debug("도서정보 : " + title);
//		
//		
//		model.addAttribute("BOOKS",bookList);
//		return "naver/book_search";
//		
//	}

	
	
}//end class

