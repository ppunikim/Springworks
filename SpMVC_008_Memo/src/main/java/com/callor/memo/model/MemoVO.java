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
public class MemoVO {

	private Long m_seq;
	private String m_author;
	private String m_date;
	private String m_time;
	private String m_memo;
	private String m_image;
	private String m_up_image;
	
}
