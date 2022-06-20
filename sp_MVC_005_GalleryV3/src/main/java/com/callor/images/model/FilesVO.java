package com.callor.images.model;

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
public class FilesVO {
	
	private long i_seq;		//이 클래스의 일련번호
	private long i_bseq;	//bbs의 일련번호
	private String i_originalName;//현재 이름
	private String i_imageName;	  //바뀔 이름
	
}
