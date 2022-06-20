package com.callor.images.service.impl;

import java.io.File;
import java.util.List;

import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.images.config.QualifierConfig;
import com.callor.images.model.FilesVO;
import com.callor.images.service.FileUpService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service(QualifierConfig.SERVICE.FILE_V1)
public class FileServiceImplV1 implements FileUpService{

	// 선생님 주석 확인
	private final ResourceLoader resLoader;
	public FileServiceImplV1(ResourceLoader resLoader) {
		this.resLoader = resLoader;
	}
	
	@Override
	public String fileUp(MultipartFile file) throws Exception {
		// 선생님 주석 전체적으로 보기
		
		if(file == null) {
			return null;
		}
		String uploadPath = resLoader.getResource("/static/upload")
				 					 .getURI()
				 					 .getPath();
		log.debug("업로드 폴더 {}", uploadPath);
		
		// 3. 업로드할 파일 이름 추출
		String fileName = file.getOriginalFilename();
		
		// 4. 업로드할 폴더 잇는지 검사
		File dir = new File(uploadPath);
		if(!dir.exists()) {
			//4-1. 폴더 생성하기
			dir.mkdirs();
		}
		File upLoadFile = new File(uploadPath, fileName);
		file.transferTo(upLoadFile);
		return fileName;
		}

	@Override
	public List<FilesVO> filesUp(MultipartHttpServletRequest files) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean fileDelate(String filename) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	
}
