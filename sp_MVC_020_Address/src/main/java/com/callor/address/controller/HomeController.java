package com.callor.address.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.address.model.AddressVO;
import com.callor.address.service.AddressService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	//Controller와 Service연결하는 코드
	private final AddressService adService;
	public HomeController(AddressService adService) {
		this.adService = adService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		List<AddressVO> adList = adService.selectAll();
		model.addAttribute("ADDR",adList);
		return "home";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String home(AddressVO adVO) {
		log.debug("입력한 값 {}" , adVO);
		adService.insert(adVO);
		return "redirect:/";
	}	
	@RequestMapping(value="/detail", method= RequestMethod.GET)
	public String detail(Model model,
				@RequestParam(name="seq", required = false, defaultValue = "0") 
				long a_seq) {
		AddressVO adVO = adService.findById(a_seq);
		model.addAttribute("address", adVO);
		return "detail";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.GET)
	public String update(
					@RequestParam(name="seq", required = false, defaultValue = "0") long a_seq ,
					Model model) {
		AddressVO adVO = adService.findById(a_seq);
		model.addAttribute("address",adVO);
		return "home";
	}
	
	@RequestMapping(value="/update" , method=RequestMethod.POST)
	public String update(AddressVO adVO,long a_seq) {
		adVO.setA_seq(a_seq);
		adService.update(adVO);
		return "redirect:/detail?seq=" + a_seq;
	}
	
	
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public String delete( @RequestParam(name="seq", required = false, defaultValue = "0")long a_seq) {
		adService.delete(a_seq);
		return "redirect:/";
	}
	
}//end Controller
