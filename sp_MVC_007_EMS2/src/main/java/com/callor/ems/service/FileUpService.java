package com.callor.ems.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.ems.model.FilesVO;

public interface FileUpService {
	public String fileUp(MultipartFile file);
	public List<FilesVO> fileUp(MultipartHttpServletRequest mFile);
}
