package com.callor.naver.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.naver.model.BookVO;
import com.callor.naver.model.UserVO;
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
	
	/* return "문자열"형식은
	 * 명시적으로 어떤 jsp파일을 rendering할 것인지
	 * 알려주는 것이다.
	 * 현재 method를 요청한 URL에 대하여 jsp를 
	 * 명시적으로 전달한다.
	 */
	
	@RequestMapping(value= {"/",""})
	public String home() {
		return "redirect:/books/list";
	}
	
	@RequestMapping(value="/list")
	public String list(Model model) {
		List<BookVO> bookList = bookService.selectAll();
		model.addAttribute("BOOKS", bookList);
		model.addAttribute("LAYOUT","BOOK-LIST");
		return "home";
	}//end list()
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert(Model model, HttpSession session) {
		model.addAttribute("LAYOUT","BOOK-INPUT");
		
		UserVO userVO = (UserVO)session.getAttribute("USER");	//형변환 시켜준 것이다.
		if(userVO == null) {
			model.addAttribute("error","LOGIN_NEED");
			return "redirect:/user/login";
		}
		
		return "home";
	}//end insert()
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(BookVO bookVO) {
		log.debug("도서정보 : " + bookVO.toString());
		bookService.insert(bookVO);
		return "redirect:/books/list";
	}//end insert()
	
	@RequestMapping(value="/{isbn}/detail", method=RequestMethod.GET)
	public String detail(@PathVariable("isbn") String isbn, Model model) {
		
		BookVO bookVO = bookService.findById(isbn);
		model.addAttribute("BOOK", bookVO);

		model.addAttribute("LAYOUT","BOOK-DETAIL");	
		return "home";
	}
	
	@RequestMapping(value="/{isbn}/update", method=RequestMethod.GET)
	public String update(@PathVariable("isbn") String isbn, Model model) {
		
		BookVO bookVO = bookService.findById(isbn);
		model.addAttribute("BOOK",bookVO); //이러한 이름으로 변수를 만들어라 하는 의미이다.
		
		model.addAttribute("LAYOUT","BOOK-INPUT");	
		return "home";

	}
	
	@RequestMapping(value="/{isbn}/update", method=RequestMethod.POST)
	public String update(BookVO bookVO) {
		int ret = bookService.update(bookVO);
		String retStr = String.format("redirect:/books/%s/detail",bookVO.getIsbn());
		return retStr;
	}
	
	@RequestMapping(value="/{isbn}/delete", method=RequestMethod.GET)
	public String delete(@PathVariable("isbn") String isbn) {
		// 삭제한 데이터 갯수를 return 한다.
		int ret = bookService.delete(isbn);
		return "redirect:/books/list";
	}
	
}//end class

