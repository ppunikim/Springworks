package com.callor.naver.service.exec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import com.callor.naver.config.NaverConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NaverBookServiceEx {
	
	/*
	 * cat 과 search에 담긴 값을 전달받아서 Naver에 요청할 QueryString을 생성하는 method
	 */
	public String queryString(String cat, String search) {

		// 이름이 길어 짧은 변수에 담은 것.
		// https://open .../book.json 으로 받아올 것이다.
		String queryString = NaverConfig.NAVER_BOOK_URL;

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
	}// end queryString method

	// queryString을 전달받아 네이버에 데이터를 요청하고 응답받은 json string을 return 하기
	public String getJasonString(String queryString) {
		
		// java.net.url 을 import
		URL url = null;
		HttpURLConnection httpCon = null;
		/*queryString(URL, 요청정보)를 사용하여
		  NetWork통해서 보낼 데이터로 생성하기
		*/
			try {
				url = new URL(queryString);
				httpCon = (HttpURLConnection) url.openConnection(); //네이버에 연결해라는 이야기
				httpCon.setRequestMethod("GET");
				httpCon.setRequestProperty(NaverConfig.HEADER.ID, NaverConfig.NAVER_CLIENT_ID);
				httpCon.setRequestProperty(NaverConfig.HEADER.SEC, NaverConfig.NAVER_CLIENT_SEC);
				
				//naver에게 queryString 정보를 보내고 response해줄 데이터가 있는지 먼저 확인.
				int resCode = httpCon.getResponseCode(); //나에게 줄 데이터가 있는지 물어보는 것.
				
				InputStreamReader is = null;
				BufferedReader buffer = null;
				
				// naver가 200코드를 보내면 
				if(resCode == 200) {
					//데이터를 받아올 통로를 연결하기
					is = new InputStreamReader(httpCon.getInputStream()); //데이터를 보낼 통로를만들어줘 라는 의미
				} else {
					//만약 200 코드가 아니면 오류메세지를 받을 통로 연결하기.
					is = new InputStreamReader(httpCon.getErrorStream()); 
				}
				buffer = new BufferedReader(is);
				
				String retString = "";
				while(true) {
					String line = buffer.readLine();
					if(line == null) break;
					retString += line;
				}
				return retString;
				
			} catch (MalformedURLException e) {
				log.debug("QueryString 문자열 오류");
				return null;
			} catch (IOException e) {
				log.debug("네트워크 연결 x");
				return null;
			}
				
	
	
	}//end getJasonString

}// end class
