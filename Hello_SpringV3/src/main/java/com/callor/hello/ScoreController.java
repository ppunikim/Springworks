package com.callor.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.hello.domain.ScoreVO;

@Controller
public class ScoreController {
	
	@ResponseBody   //home.jsp를 응답하는 것이 아니라 문자값을 그대로(home)을 return하는 것이다.
					// 이게 없으면 views폴더의 home.jsp 파일을 return 하는 것이다.
	@RequestMapping(value="/print")
	public String printScore() {
		
		
		int intKor = 100;
		int intEng = 100;
		
		int intSum = intKor + intEng;
		
		return intSum + ""; //정수형을 문자형으로 만드는 방법
		
	}//end printScore
	
	
	@RequestMapping(value="/score", method=RequestMethod.GET) 
	public String score() {
		
		return "score";
	}//end score
	
	@RequestMapping(value="/score", method=RequestMethod.POST)
	public String score(ScoreVO scoreVO, Model model) {
		model.addAttribute("SCORE",scoreVO);
		return "score";
	}//end score(메서드)

}
