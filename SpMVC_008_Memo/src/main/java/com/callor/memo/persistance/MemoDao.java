package com.callor.memo.persistance;

import com.callor.memo.model.MemoVO;

public interface MemoDao extends GenericDao<MemoVO, String>{
	public void create_memo_table();
}
