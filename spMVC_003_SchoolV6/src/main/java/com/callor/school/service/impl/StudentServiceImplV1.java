package com.callor.school.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.callor.school.dao.StudentDao;
import com.callor.school.model.StudentVO;
import com.callor.school.service.StudentService;

import lombok.extern.slf4j.Slf4j;

/* StudentService stService = new StudentServiceImplV1();
 * 자동으로 위 코드가 만들어지는 것이다.
 * StudentServiceImplV1 대신 stService를 사용하겠다는 의미이다.
 * 이것은 bean의 역할을 하는 것이다.
 */
// lombok이 제공하는 log이다.
@Slf4j
@Service("stServiceV1")  
public class StudentServiceImplV1 implements StudentService{
	
	/*
	 * 생성자 주입
	 */
	private final StudentDao stDao;
	StudentServiceImplV1(StudentDao stDao){
		this.stDao = stDao;
	}
	
	@Override
	public List<StudentVO> selectAll() {
		
		// TODO Auto-generated method stub
		
		return stDao.selectAll();
	}

	@Override
	public StudentVO findByNum(String st_num) {
		// TODO Auto-generated method stub
		return stDao.findByNum(st_num);
	}

	@Override
	public int insert(StudentVO stVO) {
		int count = stDao.insert(stVO);
		return count;
	}

	@Override
	public int update(StudentVO stVO) {
		int count = stDao.update(stVO);
		return count;
	}

	@Override
	public int delate(String st_num) {
		int count = stDao.delate(st_num);
		return count;
	}
		
}
