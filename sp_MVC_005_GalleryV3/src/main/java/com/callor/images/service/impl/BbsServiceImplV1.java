package com.callor.images.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.images.config.QualifierConfig;
import com.callor.images.model.BBsVO;
import com.callor.images.model.FilesVO;
import com.callor.images.persistance.BbsDao;
import com.callor.images.persistance.FileDao;
import com.callor.images.service.BBsService;
import com.callor.images.service.FileUpService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service(QualifierConfig.SERVICE.BBS_V1)
public class BbsServiceImplV1 implements BBsService{

	protected final BbsDao bbsDao;
	protected final FileUpService fileService;
	protected final FileDao fileDao;
	


	public BbsServiceImplV1(BbsDao bbsDao, 
			@Qualifier(QualifierConfig.SERVICE.FILE_V2) FileUpService fileService, 
			FileDao fileDao) {
		super();
		this.bbsDao = bbsDao;
		this.fileService = fileService;
		this.fileDao = fileDao;
	}


	@Override
	public String insertBBsAndFile(BBsVO bbsVO, MultipartFile file) {
		//선생님 주석 전체적으로 보기
		
		int ret = bbsDao.insert(bbsVO);
		if(ret > 0) {
			//정상적으로 데이터 베이스 내용이 들어갔으면
			try {
				String fileName = fileService.fileUp(file);
				FilesVO imagesVO = FilesVO.builder()
											.i_originalName(file.getOriginalFilename())
											.i_imageName(fileName)
											.i_bseq(bbsVO.getB_seq())
											.build();
				fileDao.insert(imagesVO);
				return imagesVO.getI_imageName();
				//게시물과 이미지 연결하는것이다. (seq)
			} catch (Exception e) {
				e.printStackTrace();
				return "FILE UP FAIL";
			}
		}
		return null;
	}


	@Override
	public String insertBBsAndFiles(BBsVO bbsVO, MultipartHttpServletRequest files) {
		
		// 게시판 데이터 추가
		int ret = bbsDao.insert(bbsVO);
		/* 실제 이미지 데이터들은 files에 담겨있는데
		 * files에 담겨있는 개별적인 파일을 분리해 List로 바꾸기 위해
		 * files.getFiles() method 를 사용하는데
		 * 이 때, getFiles()에게 form의 input tag 이름을 전달해줘야 한다.
		 */
/*			List<MultipartFile> fileList = files.getFiles("mfile");
			for(MultipartFile file : fileList) {
			log.debug("파일들 : {} ", file.getOriginalFilename());
		}
*/
		try {
			List<FilesVO> fileNames = fileService.filesUp(files);
			for(FilesVO file : fileNames) {
				file.setI_seq(bbsVO.getB_seq());
			}
			ret = fileDao.insertFiles(fileNames);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void create_bbs_table() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<BBsVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public BBsVO findById(Long id) {
		return bbsDao.findById(id);
	}


	@Override
	public int insert(BBsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int update(BBsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}



}
