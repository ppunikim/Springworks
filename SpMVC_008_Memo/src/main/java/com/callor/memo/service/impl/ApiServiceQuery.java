package com.callor.memo.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.callor.memo.config.ApiConfig;
import com.callor.memo.model.ApiDTO;
import com.callor.memo.model.ApiFood;
import com.callor.memo.service.ApiService;

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
		

		ResponseEntity<ApiFood> fooddata = null;
		RestTemplate resTemp = new RestTemplate();

		fooddata = resTemp.exchange(uri, HttpMethod.GET, entity, ApiFood.class);
		
		log.debug("{}",fooddata);
		

//		return fooddata.getBody().getFoodKr.item;
		return null;
	}

	@Override
	public List<ApiDTO> selectAll() {
		// TODO Auto-generated method stub
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

}// end class
