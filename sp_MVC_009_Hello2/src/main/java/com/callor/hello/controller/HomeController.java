package com.callor.hello.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.model.AddressVO;
import com.callor.hello.service.HomeService;

@Controller
public class HomeController {
	
	// 밑 코드는 String 인터페이스 주입 패턴이라고 한다.
	// 이것은 응집도를 높이고 결합도는 낮추는 것이다.
	// 그 이유는 interface로 만들고, 그것을 상속받은 여러 impl들을 불러올 수 있기 때문이다.
	private final HomeService homeService;
	
	/*
	 * 코드를 변경 하더라도 최소한으로 코드를 변경하여 작성할 수 있는 장점으로
	 * Qualifier를 사용한다. 
	 */
	
	public HomeController(@Qualifier(QualifyConfig.Home_Service_V1)
						  HomeService homeService) {
		this.homeService = homeService;
	} // 이렇게 하지 않으려면 @ AutoWired로 묶어줘야 한다.
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		/* homeService의 hello, hello("홍길동"), goodBye,goodBye("둘리")
		 * 메서드를 사용하는 HomeController 작성자는 아직 HomeServiceImpl클래스의
		 * 메서드 들이 구체적으로 완성되지는 않았지만
		 * 이것을 보고 어떻게 결과가 나겠다 생각을 하여 
		 * 자신의 코드를 작성할 수 있다. 
		 */
		String hello = homeService.hello();
		hello = homeService.hello("홍길동");
		hello = homeService.goodBye();
		hello = homeService.goodBye("둘리");
		return "home";
	}
	
	//form 에서 보내온 데이터를 각각의 문자열형 변수에 받기
	public String home(String ad_name, String ad_tel, String ad_addr) {
		homeService.insert(ad_name, ad_tel, ad_addr);
		return "home";
	}
	
	/*
	 * 위에서 미리 써주면, AddressVO 클래스 타입의 객체에 한꺼번에 받는 방법.
	 * 위의 코드와 다르게 클래스 타입의 객체로 사용하면 가독성이 높아지고 좋다.
	 */
	@RequestMapping(value="/",method = RequestMethod.POST)
	public String home(AddressVO address) {
		homeService.insert(address);
		return "home";
	}
	
	@RequestMapping(value="/findName" , method = RequestMethod.GET)
	public String findByName(String ad_name, Model model) {
		AddressVO address = homeService.findByName(ad_name);
		model.addAttribute("ADDR", address);
		return "home";
	}
	
}//end class
