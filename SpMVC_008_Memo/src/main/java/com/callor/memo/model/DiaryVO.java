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
public class DiaryVO {

	private Long d_seq;
	private String d_author;
	private String d_date;
	private String d_time;	
	private String d_weather; //날씨
	private String d_title;	//제목
	private String d_content; //내용
	private String d_good1; //좋았던일 1
	private String d_good2; 
	private String d_good3;
	private String d_advice; //오늘하루 충고, 정리
	private String d_image;
}
