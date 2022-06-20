package com.callor.images.persistance;

import java.util.List;

import com.callor.images.model.FilesVO;

public interface FileDao extends GenericDao<FilesVO, Long>{

	//각 게시판 디테일에서 보여줄 이미지 리스트 가져오기 
	public List<FilesVO> findByBBsSeq(Long b_seq);
	
	
	//선생님 주석 확인
	public int insertFiles(List<FilesVO> fileNames);
	
}
