package com.callor.memo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ApiDTO {
	// 부산광역시 맛집정보 api를 이용하려한다.
	/* DTO : Data Transfer Object
	 * 역할은 VO와 같다.
	 */
//	private String numOfRows;		//한 페이지 결과수
//	private String resultCode;		//결과코드
//	private String resultMsg;		//결과 메세지
//	private String pageNo;			//페이지수
//	private String totalCount; 		//데이터 총 갯수
	private String UC_SEQ;			//콘텐츠ID
	private String MAIN_TITLE; 
	private String GUGUN_NM; 		//구군
	private String PLACE; 
	private String CNTCT_TEL; 
	private String TITLE; 
	private String SUBTITLE; 
	private String ADDR1;
	private String HOMEPAGE_URL;
	private String USAGE_DAY_WEEK_AND_TIME;	//운영시간 및 시간
	private String RPRSNTV_MENU;	//대표메뉴
	private String MAIN_IMG_NORMAL;
	private String MAIN_IMG_THUMB;
	private String ITEMCNTNTS;		//상세내용

}
