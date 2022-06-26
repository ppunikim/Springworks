package com.callor.memo.persistance;

import com.callor.memo.model.DiaryVO;

public interface DiaryDao extends GenericDao<DiaryVO, Long>{
	public void create_diary_table();
}
