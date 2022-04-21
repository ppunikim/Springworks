package com.callor.app.service;

import com.callor.app.domain.StudentVO;

public interface StudentService {
	
	public int insert(StudentVO studentVO);     // 데이터 추가하기.
	public StudentVO[] selectAll();             // 전체리스트 가져오기
	public StudentVO findById(String stNum);    // 한개의 데이터만 가져오기(1개 또는 없음 가져오기)
	
	
	

}//end interface
