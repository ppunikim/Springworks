package com.callor.naver.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.callor.naver.config.NaverConfig;
import com.callor.naver.config.QualifierConfig;
import com.callor.naver.model.BookVO;
import com.callor.naver.model.MovieVO;
import com.callor.naver.model.NaverChannel;
import com.callor.naver.model.NaverParent;
import com.callor.naver.model.NewsVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(QualifierConfig.SERVICE.NAVER_V2)
public class NaverServiceImplV2 extends NaverServiceImpl{
	
	@Override
	public String queryString(String cat, String search) {
		String queryString = NaverConfig.NAVER_BOOK_XML_URL;
		String encodeSearch = null;
		try {
			encodeSearch = URLEncoder.encode(search, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			log.debug("URL Encoding 오류발생");
			return null;
		}
		// 이 말은 ~~~book.json?query="내가 가져오고자 하는 말" 이라고 출력에 찍히는 것이다.
		queryString += String.format("?query=%s", encodeSearch);
		log.debug("Query: " + queryString);

		queryString += String.format("&display=%d", 20);
		return queryString;

		
	}
	
	@Override
	public List<Object> getNaver(String queryString) {

		URI restURI = null; //역할은 같지만, url보다 향상된 버젼이다.
		try {
			restURI = new URI(queryString);
		} catch (URISyntaxException e) {
			log.debug("URI 문법오류");
			return null;
		}
		
		//springframework 버젼으로 가져오기
		//http 프로토콜에 보안 정보를 세팅하여 네이버로 전송할 준비를 하는 것이다.
		HttpHeaders headers = new HttpHeaders();
		headers.set(NaverConfig.HEADER.ID, NaverConfig.NAVER_CLIENT_ID);
		headers.set(NaverConfig.HEADER.SEC, NaverConfig.NAVER_CLIENT_SEC);
		
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML)); 
		
		RestTemplate restTemp = new RestTemplate();
		HttpEntity<String> entity = new HttpEntity<String>("parameter", headers); //보내는 용도
		
			ResponseEntity<String> resData = null;	//받는 용도
			resData = restTemp.exchange(
						restURI,
						HttpMethod.GET,
						entity,
						String.class );
			
			System.out.println("=".repeat(100));
			System.out.println(resData.getBody());
			System.out.println("=".repeat(100));
			
			String xmlString = resData.getBody();
			
			//xml 문자열을 VO 객체로 변환하기 위한 도구
			ObjectMapper xmlMapper = new XmlMapper();
			try {
				NaverChannel naverChannel = xmlMapper.readValue(xmlString, NaverChannel.class);
				
				log.debug(naverChannel.channel.item.toString());
				return naverChannel.channel.item;
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			
			//return resData.getBody().items;
			return null;
			
	}//end getNaverBook
	
}//end class