package com.callor.memo.service.impl;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.callor.memo.model.MemoVO;
import com.callor.memo.persistance.MemoDao;
import com.callor.memo.service.FileUpService;
import com.callor.memo.service.MemoService;

@Service
public class MemoServiceImplV1 implements MemoService{
	
	private final String upLoadFolder;
	
	@Autowired
	private FileUpService fileUp;
	
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
	public MemoVO findById(Long VO) {
		MemoVO memoVO = memoDao.findById(VO);
		return memoVO;
	}

	@Override
	public int insert(MemoVO vo) {
		int intsert = memoDao.insert(vo);
		return intsert;
	}

	@Override
	public int update(MemoVO vo) {
		int update = memoDao.update(vo);
		return update;
	}

	@Override
	public int delete(Long id) {
		MemoVO memo = memoDao.findById(id);
		fileUp.fileDelete(memo.getM_up_image());
		memoDao.delete(id);
		return 0;
	}

	@Override
	public List<MemoVO> findByAuthor(String username) {
		return memoDao.findByAuthor(username);
	}

	@Override
	public int insertAndUpdate(MemoVO memoVO, MultipartFile file) {
		Long m_seq = memoVO.getM_seq();
		if(m_seq != 0) {
			MemoVO updateMemo = memoDao.findById(m_seq);
			String fileName = updateMemo.getM_image();
			if( !fileName.equals(file.getOriginalFilename())) {
				fileUp.fileDelete(updateMemo.getM_up_image());
			}
			String upLoadFileName = fileUp.fileUp(file);
			memoVO.setM_image(file.getOriginalFilename());
			memoVO.setM_up_image(upLoadFileName);
			return memoDao.update(memoVO);
		}
		memoVO.setM_image(file.getOriginalFilename());
		memoVO.setM_up_image(fileUp.fileUp(file));
		return memoDao.insert(memoVO);
	}
}
