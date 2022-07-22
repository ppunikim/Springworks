package com.callor.score.controller.api;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.callor.score.model.StudentVO;
import com.callor.score.service.StudentService;

import lombok.extern.slf4j.Slf4j;

/* @Controller는 request에 대해 (.jsp)파일을 rendering하여 response하도록 설계하는 Router다.
 
 * 이 클래스에 @ResponseBody 부착하면 view를 response하는 대신, 직접 문자열을 전송하거나,
   객체를 JSON으로 response하도록 적용한다.
 
 * @RestController 는 request에 대해 기본값으로 JSON을 Response하도록 설계하는 Router다.
   (view를 rendering 하지 않는다.)
   즉, method에서 @ResponseBody가 붙은 것처럼 작용한다.
   하지만, JSON을 사용하려면 JSON Dependency가 필수적으로 필요하다. 
 */
@Slf4j  
@CrossOrigin(origins = {"http://localhost:3000" , "http://127.0.0.1","http://192.168.0.*:3000"})
@RestController
@RequestMapping(value="/api/student")
public class ApiStudentController {
	
	private final StudentService stService;
	public ApiStudentController(StudentService stService) {
		this.stService = stService;
	}
	
	public void voidMethod() {
		return;     //void는 아무것도 없는 값을 return해 method를 종료한다.
	}
	public int intMethod() {
		return 0;   //정수형, 실수형 같은 경우는, 기본 type을 return 해야 한다.
				    //이것은 더이상 할 일이 없어서 결과 되돌리는 코드이고, 
	}	  			//return 0을 만나면 끝나게 된다.
	public char charMethod() {
		return 'A'; //char은 최소 한개의 문자라도 return 해야 한다.
	}
	public String strMethod() {
		return null; //이 의미는 나를 호출한 곳에 데이터가 없다는 뜻이고, 
	}				 //String은 최소한 null이라도 return 해야한다.
	
	@RequestMapping(value={"/",""} , method=RequestMethod.GET)
	public List<StudentVO> student(StudentVO stVO, Model model) {
		List<StudentVO> stList = stService.selectAll();
		model.addAttribute("LIST",stList);
		return stList;
	}
	
	
	/* Q. http://localhost:8080/score/student/학번/delete로 요청했을 때
	 *    학번에 해당하는 학생 데이터를 삭제할 수 있도록 하는 method생성
	 *    stService.delete(학번), stDao.delete(학번) student-mapper.xml.delete 작성
	*/
	
	@RequestMapping(value="/{st_num}/delete", method=RequestMethod.GET)
	public String delete(@PathVariable("st_num")String id) {
		int ret = stService.delete(id);
		if(ret > 0 ) {
			return "OK";
		} else {
			return "FAIL";
		}
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(@RequestBody StudentVO stVO) {
		log.debug("전달받은 데이터 {}" , stVO.toString());
		int ret = stService.insert(stVO);
		if(ret > 0) {
			return "OK";
		} else {
			return "FAIL";
		}
	}
	
	
	
	
}
