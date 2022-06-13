package com.callor.images.persistance;

import java.util.List;

public interface GenericDao<VO,PK> {
	// 기본적으로 사용할 CRUD 만들기
	public List<VO> selectAll();
	public VO findById(PK id);
	public int insert(VO vo);
	public int update(VO vo);
	public int delete(PK id);
	
}
