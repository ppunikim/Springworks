package com.callor.memo.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.memo.persistance.MemoDao;

public interface MemoService extends MemoDao{
	
	public String fileUp(MultipartFile file) throws Exception;
	
}
