package com.callor.home.service.impl;

import org.springframework.stereotype.Service;

import com.callor.home.model.StudentVO;
import com.callor.home.service.StudentService;

@Service  //서비스 클래스를 알리는 것으로, spring 에서는 꼭 적어주기
public class StudentServiceImplV1 implements StudentService{

	// TODO 학생데이터 추가하기
	@Override
	public int insert(StudentVO studentVO) {
		return 0;
	}

	// TODO 전체 데이터 가져오기
	@Override
	public StudentVO[] selectAll() {
		return null;
	}

	// TODO 학생 데이터 id로 조회하기
	@Override
	public StudentVO findById(String stNum) {
		return null;
	}
	
}
