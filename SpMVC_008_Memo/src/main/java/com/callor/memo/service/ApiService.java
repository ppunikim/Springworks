package com.callor.memo.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.callor.memo.model.ApiDTO;

public interface ApiService{

	public List<ApiDTO> selectAll();
	public int insertAndUpdate(ApiDTO book, MultipartFile file);
	public int delete(long seq);
	public ApiDTO findById(long seq);
	public List<ApiDTO> findByAuthor(String username);
}
