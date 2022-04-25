package com.callor.school.service;

import java.util.List;

import com.callor.school.domain.StudentVO;

public interface StudentService {

	// 앞으로 계속 사용하게 될 메서드: CRUD(Create Read Update Delete) method의 prototype(설계도) 선언
	public List<StudentVO> selectAll();          //List로 선언
	public StudentVO findByStNum(String stNum);  //R  => 학번이 unique해야 하기 때문에 1개에만 담는다.
	public Integer insert(StudentVO stVO);       //C
	public Integer update(StudentVO stVO);       //U
	public Integer delete(String stNum);         //D  => 2개이상 값을 삭제하면 안된다. 그래서 1개값만 삭제하는 학번으로 설정.
	// stNum : id, primary(기본키)
	
	public List<StudentVO> findByStTel(String stTel);
	public List<StudentVO> findByStName(String stName);
	public List<StudentVO> findByStAddr(String stAddr);
	//                                  -------------- -> 구현클래스= 구현체
}
