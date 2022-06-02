package com.callor.naver.service.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.callor.naver.config.NaverConfig;
import com.callor.naver.model.NaverBookVO;
import com.callor.naver.model.NaverParent;
import com.callor.naver.service.NaverService;
import com.callor.naver.service.exec.NaverBookServiceEx;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NaverServiceImplV1 extends NaverBookServiceEx implements NaverService{

	//querySelect 는 extends로 상속받았다.
	
	@Override
	public List<NaverBookVO> getNaverBook(String queryString) {

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
		
		//headers에 추가된 정보를 Entity type의 객체로 변환.
		HttpEntity<String> entity = new HttpEntity<String>("parameter", headers); //보내는 용도
		ResponseEntity<NaverParent> resData = null;	//받는 용도
		
		//데이터 교환하는데 () 안에 있는 것을 restTemp로 바꾼다. 그것을 또 table로 만들고자 resData라고 함.
		resData = restTemp.exchange(restURI, HttpMethod.GET, entity, NaverParent.class);
		
		
		
		
		//vNaver에서 받은 데이터는 resData의 body에 담겨있다. body데이터를 get해 그 데이터중 items만 추출해 controller로 return
		return resData.getBody().items;
	}//end getNaverBook
	
}//end class




























