package com.callor.naver.model;

import java.util.List;
/* spring의 3.x에서 새롭게 추가된 RestTemplate 클래스를 사용하여
 * Json으로 응답받은 데이터를 한번에 VO리스트로 변환하기 위한
 * Wrapper클래스 선언,
 * VO를 감싸고 있는 클래스
 * Parent 클래스가 VO 리스트를 한꺼번에 감싸고 있는 계층구조 
 * 데이터 선언이다.
 * 
 * Spring 5.0이상에서는 사용을 자제해라. 곧 사라질 것이다...
 */
public class NaverParent<VO> {
	// 데이터들을 계층적으로 부르는 방법이다.
	
	public String rss;  		//-	디버그를 쉽게 하고 RSS 리더기만으로 이용할 수 있게 하기 위해 만든 RSS 포맷의 컨테이너이며 그 외의 특별한 의미는 없다.
	public String channel;  	//-	검색 결과를 포함하는 컨테이너이다. 이 안에 있는 title, link, description 등의 항목은 참고용으로 무시해도 무방하다.
	public String lastBuildDate;  //	datetime	검색 결과를 생성한 시간이다.
	public String total;  		//integer 검색 결과 문서의 총 개수를 의미한다.
	public String start;  		//integer 검색 결과 문서 중, 문서의 시작점을 의미한다.
	public String display;  	//integer 검색된 검색 결과의 개수이다.
	
	/*
	 *  Naver API를 사용하여 News, Books, Movie 정보를 가져오려고 한다.
	 *  이 때, RestTemplate를 사용하여 데이터를 가져오는데
	 *  RestTemplate는 VO를 감싸는 List 변수가 한 개 필요하다.
	 */
	public List<VO> items ;  //items	-	XML 포멧에서는 item 태그로, JSON 포멧에서는 items 속성으로 표현된다. 개별 검색 결과이며 title, link, description을 포함한다.
}
