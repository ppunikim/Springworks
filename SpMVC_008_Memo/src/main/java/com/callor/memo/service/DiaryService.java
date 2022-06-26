package com.callor.memo.service;

import org.springframework.web.multipart.MultipartFile;

import com.callor.memo.persistance.DiaryDao;

public interface DiaryService extends DiaryDao{

	public String fileUp(MultipartFile file) throws Exception;
}
