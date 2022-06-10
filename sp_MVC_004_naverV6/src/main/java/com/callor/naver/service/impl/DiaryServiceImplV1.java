package com.callor.naver.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.naver.model.DiaryVO;
import com.callor.naver.service.DiaryService;

@Service
public class DiaryServiceImplV1 implements DiaryService{

	@Override
	public DiaryVO findByDay(String day) {
		return null;
	}

	@Override
	public List<DiaryVO> findByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DiaryVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DiaryVO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(DiaryVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(DiaryVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
