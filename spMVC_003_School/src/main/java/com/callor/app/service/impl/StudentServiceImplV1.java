package com.callor.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.app.domain.StudentVO;
import com.callor.app.service.StudentService;

@Service  // 서비스클래스를 알림.
public class StudentServiceImplV1 implements StudentService {
	/*  web application 에서는 Service class의 클래스 영역에
	 * 변수를 선언하지 않는다.
	 */
	// TODO 학생 데이터 추가하기.
	@Override  //java 1.7이상에서는 안써도 된다.
	public int insert(StudentVO studentVO) {
		
		return 0;
	}

	// TODO 학생 데이터 id로 조회하기.
	@Override
	public StudentVO findById(String stNum) {
		
		return null;
	}

	// TODO Auto-generated method stub
	@Override
	public List<StudentVO> selectAll() {
		List<StudentVO> stList = new ArrayList<>();
		StudentVO stVO = new StudentVO();
		stVO.setStNum("00001");
		stVO.setStName("길동");
		stVO.setStDept("컴공과");
		stVO.setIntGrade(3);
		stVO.setStAddr("서울특별시");
		stList.add(stVO);
		
	    stVO = new StudentVO();
		stVO.setStNum("00002");
		stVO.setStName("둘리");
		stVO.setStDept("전자과");
		stVO.setIntGrade(1);
		stVO.setStAddr("광주광역시");
		stList.add(stVO); 
		
		/*
		 *  VO 데이터를 사용하여 새로운 학생정보를 list에 추가하기 위해서는
		 *  반드시 VO를 다시 생성해줘야 한다.
		 */
		stVO = new StudentVO(); // 이런식으로 계속 데이터를 정의해줘야 한다.
		stVO.setStNum("00003");
		stVO.setStName("또치");
		stVO.setStDept("경영학과");
		stVO.setIntGrade(2);
		stVO.setStAddr("전라북도 익산시");
		stList.add(stVO); //저장하는 공간이 같으므로,마지막에 세팅한 데이터만 저장된다.
		
		stVO = new StudentVO();
		stVO.setStNum("00003");
		stVO.setStName("도우너");
		stVO.setStDept("경제학과");
		stVO.setIntGrade(4);
		stVO.setStAddr("광주광역시");
		stList.add(stVO); 
		
		stVO = new StudentVO();
		stVO.setStNum("00004");
		stVO.setStName("마이클");
		stVO.setStDept("경찰행정학과");
		stVO.setIntGrade(4);
		stVO.setStAddr("부산광역시");
		stList.add(stVO); 
		
		stVO = new StudentVO();
		stVO.setStNum("00005");
		stVO.setStName("희동");
		stVO.setStDept("해양생물학과");
		stVO.setIntGrade(1);
		stVO.setStAddr("목포시");
		stList.add(stVO); 
		
		
		return stList;
		}

}
