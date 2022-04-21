package com.callor.app.service.impl;

import org.springframework.stereotype.Service;

import com.callor.app.domain.StudentVO;
import com.callor.app.service.StudentService;

@Service  // 서비스클래스를 알림.
public class StudentServiceImplV1 implements StudentService {
	
	// TODO 학생 데이터 추가하기.
	@Override  //java 1.7이상에서는 안써도 된다.
	public int insert(StudentVO studentVO) {

		return 0;
	}

	// TODO 전체 데이터 가져오기.
	@Override
	public StudentVO[] selectAll() {

		return null;
	}

	// TODO 학생 데이터 id로 조회하기.
	@Override
	public StudentVO findById(String stNum) {

		return null;
	}

}
