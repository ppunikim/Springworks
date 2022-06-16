package com.callor.images.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface FileUpService {
	
	public String fileUp(MultipartFile file) throws Exception;
	public List<String> filesUp(MultipartHttpServletRequest files) throws Exception;
	public boolean fileDelate(String filename) throws Exception;
	
	
}
