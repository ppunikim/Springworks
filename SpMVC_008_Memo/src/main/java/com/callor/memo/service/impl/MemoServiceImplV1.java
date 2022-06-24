package com.callor.memo.service.impl;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.callor.memo.model.MemoVO;
import com.callor.memo.persistance.MemoDao;
import com.callor.memo.service.MemoService;

@Service
public class MemoServiceImplV1 implements MemoService{
	
	private final String upLoadFolder;
	
	private final MemoDao memoDao;
	public MemoServiceImplV1(MemoDao memoDao, String upLoadFolder) {
		this.memoDao = memoDao;
		this.upLoadFolder = upLoadFolder;
	}

	@Override
	public String fileUp(MultipartFile file) throws Exception {
		if(file == null) {
			return null;
		}
		File dir = new File(upLoadFolder);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		String fileName = file.getOriginalFilename();
		String strUUID = UUID.randomUUID().toString();
		fileName = String.format("%s-%s", strUUID,fileName);
		File upLoFile = new File(upLoadFolder,fileName);
		file.transferTo(upLoFile);
		return fileName;
	}
	
	
	@Override
	public void create_memo_table() {
		// TODO Auto-generated method stub
	}

	@Override
	public List<MemoVO> selectAll() {
		List<MemoVO> memoList = memoDao.selectAll();
		return memoList;
	}

	@Override
	public MemoVO findById(String VO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(MemoVO vo) {
		int intsert = memoDao.insert(vo);
		return intsert;
	}

	@Override
	public int update(MemoVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}



}
