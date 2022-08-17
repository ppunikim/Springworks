package com.callor.memo.service.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.callor.memo.config.ApiConfig;
import com.callor.memo.model.ApiDTO;
import com.callor.memo.model.GetFoodKr;
import com.callor.memo.model.FoodRoot;
import com.callor.memo.service.ApiService;
import com.callor.memo.utils.HttpRequestIntercepterV1;
import com.google.protobuf.Api;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ApiServiceQuery implements ApiService {


	public String queryService(String hs, String search) {

		String queryString = ApiConfig.API_URL;
		String encodeSearch = null;
		try {
			encodeSearch = URLEncoder.encode(search, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			log.debug("URL Encoding 오류발생");
			return null;
		}
		queryString += String.format("?serviceKey=%s", encodeSearch);
		log.debug("Query : " + queryString);
		return queryString;
	}// end queryService

	public List<ApiDTO> apiList() {
		URI uri = null;
		try {
			uri = new URI(ApiConfig.API_FULL_URL);
		} catch (URISyntaxException e) {
			log.debug("URI 오류");
		}
		
		 HttpHeaders headers = new HttpHeaders();
		 
		 headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		 HttpEntity<String> entity = new HttpEntity<String>("parameter",headers);
		

		ResponseEntity<GetFoodKr> fooddata = null;
		RestTemplate resTemp = new RestTemplate();

		fooddata = resTemp.exchange(uri, HttpMethod.GET, entity, GetFoodKr.class);
		
		log.debug("{}",fooddata);
		

//		return fooddata.getBody().getFoodKr.item;
		return null;
	}

	@Override
	public List<ApiDTO> selectAll() {
		return null;
	}

	@Override
	public ApiDTO findById(String VO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(ApiDTO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ApiDTO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String queryString(String search) {
		
		String queryString = ApiConfig.API_URL;
		String encodeParams = null;
		
		try {
			encodeParams = "?" + URLEncoder.encode("serviceKey", "UTF-8");
			encodeParams += "=" + ApiConfig.API_CLIENT_ID;
			
			encodeParams += "&" + URLEncoder.encode("pageNo","UTF-8");
			encodeParams += "=1";
			
			encodeParams += "&" + URLEncoder.encode("numOfRows","UTF-8");
			encodeParams += "=10";
			
			encodeParams += "&" + URLEncoder.encode("resultType","UTF-8");
			encodeParams += "=json";
			
		} catch (UnsupportedEncodingException e) {
			log.debug("encode 오류");
		}
		
		queryString += encodeParams;
		log.debug("쿼리 문자열 {}", queryString);
		return queryString;
	}

	@Override
	public List<ApiDTO> getFoodItems(String queryString) {
		URI foodRestURI = null;
		
		try {
			foodRestURI = new URI(queryString);
		} catch (URISyntaxException e) {
			log.debug("foodURI 불러오기 실패");
		}
		
		//API에 JSON type으로 데이터를 요청하기 위한 헤더생성
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> headerEntity = new HttpEntity<String>("parameter",headers);
		
		//데이터를 수신하여 VO로 변환하기 위한 객체 선언
		RestTemplate restTemp = new RestTemplate();
		
		//String type으로 데이터를 수신하여 어떤 형태롤 데이터가 수신되는지 확인하기 위한 절차
		ResponseEntity<String> resString = null;
		resString = restTemp.exchange(foodRestURI, HttpMethod.GET, headerEntity, String.class);
		
		log.debug("=".repeat(100));
		log.debug("{}",resString.getBody());
		log.debug("=".repeat(100));
		
		//수신된 데이터를 VO 변환하기
		ResponseEntity<FoodRoot> resFoodObject = null;
		
		// 인터페이스를 사용하여 객체 생성하기
		// 한번만 사용하고 버릴 클래스, 인스턴스 만들기
		ClientHttpRequestInterceptor httpIntercept = new ClientHttpRequestInterceptor() {
			@Override
			public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
					throws IOException {
				return null;
			}
		}; //방법 1. 변수 있음
		
		restTemp.getInterceptors().add(new ClientHttpRequestInterceptor() {
			@Override
			public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
					throws IOException {
				ClientHttpResponse response = execution.execute(request, body);
				response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
				return response;
			}
		}); //방법 2. 변수 없음(익명 클래스): 일회용 클래스이다.
		
		//인터페이스를 사용하여 Lamda 코드로 주입하기.
		restTemp.getInterceptors().add((request,body,execution) -> {
			ClientHttpResponse response = execution.execute(request, body);
			response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
			return response;	
		}); //방법 3. java1.8 이상에서 사용하는 Lamda 코드, 무명 클래스이다.
		
		
		//RestTemplate 이 수신한 데이터를중간에 가로채서 조작하기
		restTemp.getInterceptors().add(new HttpRequestIntercepterV1());
		
		resFoodObject = restTemp.exchange(foodRestURI, HttpMethod.GET, headerEntity, FoodRoot.class);
		log.debug("수신된 데이터 {} ", resFoodObject.getBody().getFoodKr.item);
		return resFoodObject.getBody().getFoodKr.item;
	}

	
	
	
	
	
	
}// end class
