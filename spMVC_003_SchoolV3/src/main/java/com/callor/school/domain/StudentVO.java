package com.callor.school.domain;

import lombok.AllArgsConstructor; //모든 필드변수가 있는 것, 임의생성자(필드생성자)
import lombok.Builder; // 
import lombok.Getter; // getter 매서드
import lombok.NoArgsConstructor; // 기본생성자
import lombok.Setter; // setter 매서드
import lombok.ToString; // toString 재정의

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class StudentVO {
	
	private String stNum; // 학번
	private String stName; // 이름
	private int intGrade; // 학년
	private String stTel; // 전번
	private String stAddr; // 주소
	private String stDept; // 학과
	
	
}
