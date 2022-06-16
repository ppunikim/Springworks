package com.callor.images.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.images.config.QualifierConfig;
import com.callor.images.model.BBsVO;
import com.callor.images.model.ImagesVO;
import com.callor.images.persistance.BbsDao;
import com.callor.images.persistance.FileDao;
import com.callor.images.service.BBsService;
import com.callor.images.service.FileUpService;

@Service(QualifierConfig.SERVICE.BBS_V1)
public class BbsServiceImplV1 implements BBsService{

	protected final BbsDao bbsDao;
	protected final FileUpService fileService;
	protected final FileDao fileDao;
	


	public BbsServiceImplV1(BbsDao bbsDao, FileUpService fileService, FileDao fileDao) {
		super();
		this.bbsDao = bbsDao;
		this.fileService = fileService;
		this.fileDao = fileDao;
	}


	@Override
	public String insertBBsAndFile(BBsVO bbsVO, MultipartFile file) {
		
		int ret = bbsDao.insert(bbsVO);
		if(ret > 0) {
			//정상적으로 데이터 베이스 내용이 들어갔으면
			try {
				String fileName = fileService.fileUp(file);
				ImagesVO imagesVO = ImagesVO.builder()
											.i_originalName(fileName)
											.i_imageName(fileName)
											.i_bseq(bbsVO.getB_seq())
											.build();
				fileDao.insert(imagesVO);
				return "OK";
				//게시물과 이미지 연결하는것이다. (seq)
			} catch (Exception e) {
				return "FILE UP FAIL";
			}
										
		}
		
		return null;
	}


	@Override
	public String insertBBsAndFiles(BBsVO bbsVO, MultipartHttpServletRequest files) {
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
