package com.callor.memo.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.callor.memo.model.MemoVO;
import com.callor.memo.persistance.MemoDao;

public interface MemoService extends MemoDao{
	public String fileUp(MultipartFile file) throws Exception;
	public List<MemoVO> findByAuthor(String username);
	public int insertAndUpdate(MemoVO memoVO, MultipartFile file);
	
}
