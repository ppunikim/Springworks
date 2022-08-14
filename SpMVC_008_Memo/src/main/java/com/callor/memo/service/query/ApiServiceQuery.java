package com.callor.memo.service.query;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Service;

import com.callor.memo.config.ApiConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ApiServiceQuery {

	public String queryService(String hs, String search) {
		
		String queryString = ApiConfig.API_URL;
		String encodeSearch = null;
		try {
			encodeSearch = URLEncoder.encode(search,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			log.debug("URL Encoding 오류발생");
			return null;
		}
		queryString += String.format("?serviceKey=%s", encodeSearch);
		log.debug("Query : " + queryString);
		return queryString;
	}
	
}//end class
