package com.callor.home.service;

import com.callor.home.model.StudentVO;

public interface StudentService {
	
	public int insert(StudentVO studentVO);		//StudentVO에 데이터를 넣을 것
	public StudentVO[] selectAll();				//StudentVO 배열을 모두 선택
	public StudentVO findById(String stNum);	//학번으로 학생 찾기
}//end interfece
