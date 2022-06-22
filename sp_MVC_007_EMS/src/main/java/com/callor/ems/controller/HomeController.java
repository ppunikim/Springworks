package com.callor.ems.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.ems.model.EmsVO;
import com.callor.ems.service.QualifyConfig;
import com.callor.ems.service.SendMailService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	@Value("#{naver['naver.username']}")
	private String naver_username;
	
	@Value("#{app['my.app']}")
	private String myApp;
	
	@Autowired
	private StandardPBEStringEncryptor pbEnc;
	
	@Autowired
	@Qualifier(QualifyConfig.SERVICE.MAIL_V1)
	private SendMailService xMail;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(@ModelAttribute("emsVO") EmsVO emsVO, Model model) {
		
		
		
		Pattern PATT_BLACKET = Pattern.compile("\\([^\\(\\)]+\\)");
		Matcher matcher = PATT_BLACKET.matcher(naver_username);
		if(matcher.find()) {
			int startIndex = matcher.start();
			int endIndex = matcher.end();
			String findText = naver_username.substring(startIndex + 1, endIndex - 1);
			String user = pbEnc.decrypt(findText);
			log.debug("NaverUser {}",user);
		}
		log.debug("Naver User Name {}", naver_username);
		log.debug("앱 이름 {}",myApp);

		model.addAttribute("emsVO",emsVO);
		return "home";
	}
	
	@RequestMapping(value="/",method = RequestMethod.POST)
	public String home(@Valid EmsVO emsVO, BindingResult result) {
		if(result.hasErrors()) {
			return "home";
		}
		xMail.sendMail(emsVO);
		return "redirect:/";
	}
	
	@ModelAttribute("emsVO")
	private EmsVO emsVO() {
		return new EmsVO();
	}
	
	
	
	
	
	
}
