package com.callor.memo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	
	@RequestMapping(value="api/api-detail", method=RequestMethod.GET)
	public String api(String hs, Model model) {
		log.debug("api 확인={}",hs);
		
//		ApiServiceQuery apiQuery = new ApiServiceQuery();
//		apiQuery.queryService("API", hs);
		
		List<ApiDTO> apiList = new ArrayList<>();
		apiList = apiServiceQuery.apiList();
		
		model.addAttribute("api",apiList);
		
		return "api/api-detail";
	}


}// end class
