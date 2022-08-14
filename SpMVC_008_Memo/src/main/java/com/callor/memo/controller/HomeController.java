package com.callor.memo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.memo.service.query.ApiServiceQuery;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {


	@RequestMapping(value = "/")
	public String home() {
		return "home";
	}

	
	@RequestMapping(value="api/api-detail", method=RequestMethod.GET)
	public String api(String hs) {
		log.debug("api 확인={}",hs);
		
		ApiServiceQuery apiQuery = new ApiServiceQuery();
		apiQuery.queryService("API", hs);
		
		return "api/api-detail";
	}


}// end class
