package com.callor.memo.service;

import java.util.List;

import com.callor.memo.model.ApiDTO;
import com.callor.memo.persistance.ApiDao;

public interface ApiService extends ApiDao{

	public String queryService(String hs, String search);
	public List<ApiDTO> apiList();

}
