package com.callor.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.app.service.StudentService;

@Controller  // annotation이 붙은 것은 new를 사용하지 않는다. 제어의 역전
public class StudentController {
	/*
	 * Controller에서 Service interface를 상속받은 
	 * 클래스 중 한 가지를 사용하고자 한다.
	 * 
	 * 전통적인 java에서는 ```interface 객체 = new class생성자()```
	 * 와 같이 사용한다.
	 * spring framework project에서는 
	 * ```private final interface 객체```  와 같이 선언하고, 
	 * 임의 생성자를 만들어 argument로 전달받아
	 * 객체에 대입하는 코드를 만들어준다.
	 * 
	 * 그러면 미리 bean으로 생성돼있는 객체들 중에
	 * 자동으로 주입된다.
	 */
	private final StudentService stService;

	public StudentController(StudentService stService) { //dependancy injection
		this.stService = stService;
	}
	
	@RequestMapping(value="/student", method=RequestMethod.GET)
	public String list() {
		return "student/list_view";
	}
	
	@RequestMapping(value="/student/insert", method= RequestMethod.GET)
	public String insert() {
		return "student/insert";
	}
	
	

}//end class
