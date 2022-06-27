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
public class BookDTO {
	/* DTO : Data Transfer Object
	 * 역할은 VO와 같다.
	 */
	private long b_seq;
	private String b_author;
	private String b_date;
	private String b_time;
	private String b_title;	//책제목
	private String b_content;//책내용
	private String b_genre; //책 장르
	private String b_eval;	//한줄평
	private String b_image;
	
	private String b_up_image;
}
