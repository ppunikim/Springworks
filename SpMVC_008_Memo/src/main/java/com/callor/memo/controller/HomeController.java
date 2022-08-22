package com.callor.memo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.memo.model.ApiDTO;
import com.callor.memo.service.ApiService;
import com.callor.memo.service.impl.ApiServiceQuery;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {


	private final ApiService apiServiceQuery;
	public HomeController(ApiServiceQuery apiServiceQuery) {
		this.apiServiceQuery = apiServiceQuery;
	}


	@RequestMapping(value = "/")
	public String home() {
		return "home";
	}

	@RequestMapping(value="/api/api-detail", method=RequestMethod.GET)
	public String api(Model model) {
		
		String queryString = apiServiceQuery.queryString(null);
		List<ApiDTO> foods = apiServiceQuery.getFoodItems(queryString);
		model.addAttribute("api",foods);
		
		return "api/api-detail";
	}

	@RequestMapping(value="/api/api-detail", method=RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public String api(Model model, String queryString,String search, String cat) {
		
		log.debug("카테고리 {}",cat);
		List<ApiDTO> apiList = apiServiceQuery.findByCat(queryString,search,cat);
		model.addAttribute("api",apiList);
		
		return "api/api-detail";
	}

	@RequestMapping(value = "/api/{UC_SEQ}/api-look", method=RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public String api_look(Model model,@PathVariable("UC_SEQ") String seq) {
		
		ApiDTO apiDTO = apiServiceQuery.findById(seq);
		model.addAttribute("VO",apiDTO);
		return "api/api-look";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/api/json", method=RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public List<ApiDTO> json() {
		String queryString = apiServiceQuery.queryString(null);
		List<ApiDTO> foods = apiServiceQuery.getFoodItems(queryString);
		return foods;
	}
	


}// end class
