package com.callor.images.service;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.images.model.BBsVO;
import com.callor.images.persistance.BbsDao;

public interface BBsService extends BbsDao{
	public String insertBBsAndFile(BBsVO bbsVO, MultipartFile file);
	public String insertBBsAndFiles(BBsVO bbsVO, MultipartHttpServletRequest files);
	
}
