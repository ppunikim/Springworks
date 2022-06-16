package com.callor.images.service.impl;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.images.config.QualifierConfig;
import com.callor.images.service.FileUpService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(QualifierConfig.SERVICE.FILE_V1)
public class FileServiceImplV1 implements FileUpService{

	//Spring에서 Server의 특정한폴더에 접근하기 위한 중간 도구
	private final ServletContext context;
	private final ResourceLoader resourceLoader;
	
	public FileServiceImplV1(ServletContext context, ResourceLoader resourceLoader) {
		this.context = context;
		this.resourceLoader = resourceLoader;
	}//임의생성자

	@Override
	public String fileUp(MultipartFile file) throws Exception {
		if(file == null) {
			return null;
		}
		String upLoadPath = resourceLoader.getResource("/static/upload").getURI().getPath();
		log.debug(upLoadPath);
		
		String fileName = file.getOriginalFilename();
		
		File dir = new File(upLoadPath);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		//file과 관련된 Commend 명령을 대신 해주는 것이다.
		File upLoadFile = new File(upLoadPath, fileName);
		
		// 이제부터 중요한 것!
		file.transferTo(upLoadFile);
		return fileName;
	}//6월 16일 할 것.

	
	
	
	
	
	
	@Override
	public List<String> filesUp(MultipartHttpServletRequest files) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean fileDelate(String filename) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	
}
