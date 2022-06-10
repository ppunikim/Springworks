package com.callor.naver.persistance;


import java.util.List;

import com.callor.naver.model.DiaryVO;

public interface DiaryDao extends GenericDao<DiaryVO, String>{
	
	public DiaryVO findByDay(String day);
	public List<DiaryVO> findByTitle(String title);
	
}
