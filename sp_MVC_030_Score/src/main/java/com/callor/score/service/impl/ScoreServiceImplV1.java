package com.callor.score.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.score.model.ScoreVO;
import com.callor.score.persistance.ScoreDao;
import com.callor.score.service.ScoreService;

@Service
public class ScoreServiceImplV1 implements ScoreService{

	@Autowired
	private ScoreDao scDao;
	
	@Override
	public List<ScoreVO> selectAll() {
		return scDao.selectAll();
	}

	@Override
	public ScoreVO findById(String pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(ScoreVO VO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ScoreVO VO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String pk) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ScoreVO> findByStNum(String sc_stnum) {
		return scDao.findByStNum(sc_stnum);
	}

}
