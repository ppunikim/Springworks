package com.callor.score.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.score.model.StudentVO;
import com.callor.score.persistance.StudentDao;
import com.callor.score.service.StudentService;

@Service
public class StudentServiceImplV1 implements StudentService{

	private StudentDao stDao;
	public StudentServiceImplV1(StudentDao stDao) {
		this.stDao = stDao;
	}
	
	@Override
	public List<StudentVO> selectAll() {
		return stDao.selectAll();
	}

	@Override
	public StudentVO findById(String id) {
		return stDao.findById(id);
	}

	@Override
	public int insert(StudentVO VO) {
		stDao.insert(VO);
		return 0;
	}

	@Override
	public int update(StudentVO VO) {
		stDao.update(VO);
		return 0;
	}

	@Override
	public int delete(String id) {
		return stDao.delete(id);
	}
	
}
