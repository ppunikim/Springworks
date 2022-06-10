package com.callor.naver.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.callor.naver.model.BookVO;
import com.callor.naver.model.BuyBooksVO;
import com.callor.naver.model.UserVO;
import com.callor.naver.persistance.BookDao;
import com.callor.naver.persistance.BuyBooksDao;
import com.callor.naver.service.BuyBooksService;

@Service
public class BuyBooksServiceImplV1 implements BuyBooksService{
	
	@Autowired
	protected BookDao bookDao;
	@Autowired
	protected BuyBooksDao buyDao;
	
	@Override
	public List<BuyBooksVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BuyBooksVO findByIsbnAndUserName(String isbn, String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BuyBooksVO> findByIsbn(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BuyBooksVO> findByUserName(String username) {
		return buyDao.findByUserName(username);
	}

	//사용x insert
	@Override
	public int insert(BuyBooksVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Transactional
	@Override
	public int insert(UserVO userVO, BookVO bookVO) {
		BookVO resultBook = bookDao.findById(bookVO.getIsbn());
		if(resultBook == null) {
			//데이터 없으면
			bookDao.insert(bookVO);
		} else {
			//데이터 있으면
			bookDao.update(bookVO);
		}
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		
		BuyBooksVO buyBooksVO = BuyBooksVO.builder()
										.b_date(dateFormat.format(date))
										.b_isbn(bookVO.getIsbn())
										.b_username(userVO.getUsername())
										.build();
		buyDao.insert(buyBooksVO);
		return 0;
	}
}//end class
