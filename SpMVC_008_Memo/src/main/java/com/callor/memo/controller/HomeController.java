package com.callor.memo.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.memo.model.ApiDTO;
import com.callor.memo.model.ApiPlaceDTO;
import com.callor.memo.service.ApiPlaceService;
import com.callor.memo.service.ApiService;
import com.callor.memo.service.impl.ApiServiceQuery;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {


	private final ApiService apiServiceQuery;
	private final ApiPlaceService apiPlaceService;
	public HomeController(ApiService apiServiceQuery, ApiPlaceService apiPlaceService) {
		this.apiServiceQuery = apiServiceQuery;
		this.apiPlaceService = apiPlaceService;
	}

	@RequestMapping(value = "/")
	public String home() {
		return "home";
	}

	
	//지도 API
	@RequestMapping(value="/api/home", method=RequestMethod.GET)
	public String api_home() {
		return "api/api-home";
	}
	
	
	
	
	
	// 맛집 페이지
	@RequestMapping(value="/api/food", method=RequestMethod.GET)
	public String api(Model model, HttpSession session, Principal principal ) {
		if(principal == null) {
			return "redirect:/";
		}
		String queryString = apiServiceQuery.queryString();
		
		List<ApiDTO> foods = apiServiceQuery.getFoodItems(queryString);
		session.setAttribute("fullApi", foods);
		model.addAttribute("api",foods);
		
		model.addAttribute("RANDOM",apiServiceQuery.random(foods));
		return "api/api-food";
	}
	

	@RequestMapping(value="/api/api-food", method=RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String api(Model model, String queryString,String search, String cat, HttpSession session) {
		
		List<ApiDTO> apiList = apiServiceQuery.findByCat(queryString,search,cat);
		model.addAttribute("api",apiList);
		
		ArrayList<ApiDTO> allList = (ArrayList<ApiDTO>)session.getAttribute("fullApi"); 
		model.addAttribute("RANDOM", apiServiceQuery.random(allList));
		return "api/api-detail";
	}

	@RequestMapping(value = "/api/{UC_SEQ}/api-look", method=RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public String api_look(Model model,@PathVariable("UC_SEQ") String seq, HttpSession session) {

		ArrayList<ApiDTO> allList = (ArrayList<ApiDTO>) session.getAttribute("fullApi");
		for(ApiDTO apiDTO : allList) {
			if(apiDTO.getUC_SEQ().equals(seq)) {
				model.addAttribute("VO",apiDTO);
			}
		}
		return "api/api-look";
	}

	
//	@ResponseBody
//	@RequestMapping(value="/api/json", method=RequestMethod.GET, produces = "application/json;charset=UTF-8")
//	public List<ApiDTO> json() {
//		String queryString = apiServiceQuery.queryString();
//		List<ApiDTO> foods = apiServiceQuery.getFoodItems(queryString);
//		return foods;
//	}
	

	
	/*
	 * 부산 명소 controller
	 */
	
	@RequestMapping(value="/api/place", method=RequestMethod.GET)
	public String place(HttpSession session, Model model, Principal principal) {
		
		//로그인 되지 않았다면 로그인 페이지로 돌아가라.
		if( principal == null ) {
			return "redirect:/";
		}
		
		//json type 의 데이터를 쓰기 편하게 List 에 담기
		List<ApiPlaceDTO> placeList = apiPlaceService.getPlaceItems();
		log.debug("전체리스트 크기 진짜  " + placeList.size());
		
		//랜덤값을 담을 리스트 만들기
		List<ApiPlaceDTO> ranList = new ArrayList<>();

		//계속 재시작 되는 것을 방지하기 위해 세션에 담기
		session.setAttribute("AllPlace", placeList);
		

		for(int i = 0; i < 5; i ++) {

			//데이터 전체 숫자를 랜덤값으로 만들어서 intRan 에 담기
			int intRan = (int)(Math.random()*placeList.size());

			//랜덤값이 된 숫자의 전체 VO를 List에 담기
			ranList.add(placeList.get(intRan));
		}
//		log.debug("랜덤값 {}", ranList);
		log.debug("랜덤리스트 크기" + ranList.size());
		log.debug("전체리스트 크기 듀ㅜ번쨰 " + ((List<ApiPlaceDTO>) session.getAttribute("AllPlace")).size());
		//가져온 데이터를 랜덤으로 가져오기
/*		for(ApiPlaceDTO placeDTO : placeList) {
			
		}
*/		
		
		
		//jsp 에 담기 위해 model 에 담기(랜덤값 리스트로 담기)
		model.addAttribute("PLACE", ranList);
		
		return "api/api-place";
		
	}
	
	
	@RequestMapping(value="/api/{UC_SEQ}/place-detail", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public String placeDetail(@PathVariable("UC_SEQ") String seq,HttpSession session, 
								Model model, Principal principal) {

		//로그인 정보 풀리면 데이터가 null값 들어와서 해주는 것
		if(principal == null) {
			return "redirect:/";
		}
		
		//세션에 담은 전체 리스트를 get 하기(불러오기)
		ArrayList<ApiPlaceDTO> placeList = (ArrayList<ApiPlaceDTO>)session.getAttribute("AllPlace");
		log.debug("세션데이터{}",placeList);

/*: 다음부터는 굳이 2중 빈 공간 만들지 말자.
  		//빈 List 만들기
		List<ApiPlaceDTO> apiPlaceList = new ArrayList<>();
		//전체 리스트를 하나하나씩 뜯어보기
		for(ApiPlaceDTO placeDTO : placeList) {
			//만약 한개씩 뜯어본 데이터의 seq 값이 같다면
			if(placeDTO.getUC_SEQ().equals(seq)) {
				//빈 List에 주가
				 apiPlaceList.add(placeDTO);
			}
		}
		log.debug("새로 추가된 데이터{}",apiPlaceList);
		//추가된 데이터를 jsp 로 보여주기 위해 model 에 담기
		model.addAttribute("DETAIL", apiPlaceList);
		//이러면 jsp 에서 forEach 해야만 오류나지않고 가져올 수 있음
: 이 코드는 굳이 새로운 리스트와 새로운 VO 를 만들어서 리스트에 넣은 것을 VO에 또 넣는 방식이다.
*/
		for(ApiPlaceDTO apiPlace : placeList) {
			if(apiPlace.getUC_SEQ().equals(seq)) {
				model.addAttribute("DETAIL",apiPlace);
			}
		}
		// 이렇게 코드 짜는 이유는, 짜피 UC_SEQ 값은 1개일 것이기 때문에 굳이 List를 안만들어도 된다.

		
		return "api/api-place-detail";
	}//end placeDetail
	
	

}// end class
