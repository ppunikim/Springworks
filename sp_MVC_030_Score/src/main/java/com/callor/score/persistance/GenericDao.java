package com.callor.score.persistance;

import java.util.List;

public interface GenericDao<VO,PK> {

	public List<VO> selectAll();
	public VO findById(PK pk);
	public int insert(VO VO);
	public int update(VO VO);
	public int delete(PK pk);
	
}
