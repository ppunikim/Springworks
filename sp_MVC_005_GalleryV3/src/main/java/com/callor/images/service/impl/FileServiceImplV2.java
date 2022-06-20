package com.callor.images.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.images.config.QualifierConfig;
import com.callor.images.model.FilesVO;
import com.callor.images.service.FileUpService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service(QualifierConfig.SERVICE.FILE_V2)
public class FileServiceImplV2 implements FileUpService{
	
	
	/* servlet-context.xml에 bean 으로 설정된 값을 가져와서
	 * upLoadFolder 변수에 담아달라. 
	 */
	private final String upLoadFolder;
	public FileServiceImplV2(String upLoadFolder) {
		this.upLoadFolder = upLoadFolder;
	}

	@Override
	public String fileUp(MultipartFile file) throws Exception {
		
		if(file == null) {
			return null;
		}
		//폴더 없으면 만들어라는 의미이다.
		File dir = new File(upLoadFolder);
		if( !dir.exists()) {
			dir.mkdirs();
		}
		String fileName = file.getOriginalFilename();
		String strUUID = UUID.randomUUID().toString();
		fileName = String.format("%s-%s",strUUID, fileName);
		log.debug("변경된 파일 이름 {}", fileName);
		
		
		File upLoaFile = new File(upLoadFolder, fileName);
		file.transferTo(upLoaFile);
		return fileName;
	}

	@Override
	public List<FilesVO> filesUp(MultipartHttpServletRequest files) throws Exception {
		//선생님 주석 전체적으로 보기
		List<FilesVO> retFiles = new ArrayList<>();
		List<MultipartFile> fileList = files.getFiles("mFile");
		for(MultipartFile file: fileList) {
			String originName = file.getOriginalFilename();
			String uuName = this.fileUp(file);
			
			FilesVO fileVO = FilesVO.builder().i_originalName(originName)
											  .i_imageName(uuName).build();
			retFiles.add(fileVO);
		}
		return retFiles;
	}

	@Override
	public boolean fileDelate(String filename) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
