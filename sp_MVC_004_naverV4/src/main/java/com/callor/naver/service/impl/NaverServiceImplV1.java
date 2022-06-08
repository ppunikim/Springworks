package com.callor.naver.service.impl;

import java.net.URI;
import java.net.URISyntaxException;
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
import com.callor.naver.domain.BookVO;
import com.callor.naver.model.MovieVO;
import com.callor.naver.model.NaverParent;
import com.callor.naver.model.NewsVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(QualifierConfig.SERVICE.NAVER_V1)
public class NaverServiceImplV1 extends NaverServiceImpl{

	//querySelect 는 extends로 상속받았다.
	
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
		
		//JSON데이터 타입으로 받겠다.
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON)); //깨진 데이터를 정상적으로 받기 위한 코드
		
		RestTemplate restTemp = new RestTemplate();
		HttpEntity<String> entity = new HttpEntity<String>("parameter", headers); //보내는 용도
		
		if(cat.equals("BOOK")) {
			ResponseEntity<NaverParent<BookVO>> resData = null;	//받는 용도
			resData = restTemp.exchange(
						restURI,
						HttpMethod.GET,
						entity,
						new ParameterizedTypeReference<NaverParent<BookVO>>() {} );
			return resData.getBody().items;
		} else if(cat.equals("NEWS")) {
			ResponseEntity<NaverParent<NewsVO>> resData = null;	//받는 용도
			resData = restTemp.exchange(
					restURI,
					HttpMethod.GET,
					entity,
					new ParameterizedTypeReference<NaverParent<NewsVO>>() {} );
			return resData.getBody().items;
		} else if(cat.equals("MOVIE")) {
			ResponseEntity<NaverParent<MovieVO>> resData = null;	//받는 용도
			resData = restTemp.exchange(
					restURI,
					HttpMethod.GET,
					entity,
					new ParameterizedTypeReference<NaverParent<MovieVO>>() {} );
			return resData.getBody().items;
		}
		return null;
	}//end getNaverBook
	
}//end class




























