package com.callor.ems.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.ems.model.FilesVO;
import com.callor.ems.service.FileUpService;

public class FileUpServiceImplV1 implements FileUpService {

	@Autowired
	private String upPath;

	public FileUpServiceImplV1(String upPath) {
		this.upPath = upPath;
	}

	@Override
	public String fileUp(MultipartFile file) {
		// TODO 단일 파일 업로드
		if (file == null) {
			return null;
		}
		File dir = new File(upPath);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		String fileName = file.getOriginalFilename();
		String strUUID = UUID.randomUUID().toString();
		
		fileName = String.format("%s-%s",strUUID, fileName);
		File upLoadFile = new File(upPath,fileName);
		try {
			file.transferTo(upLoadFile);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileName;
	}// end fileUp

	@Override
	public List<FilesVO> fileUp(MultipartHttpServletRequest mFile) {
		// TODO 다중 파일 업로드
		
		List<MultipartFile> fileList = mFile.getFiles("mFile");
		List<FilesVO> retFiles = new ArrayList<>();
		for(MultipartFile file : fileList) {
			String originName = file.getOriginalFilename();
			String uuName = this.fileUp(file);
			FilesVO filesVO = FilesVO.builder()
									 .i_originalName(originName)
									 .i_imageName(uuName)
									 .build(); 
			retFiles.add(filesVO);
		}
		return retFiles;
	}
}
