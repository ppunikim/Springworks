package com.callor.naver.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.naver.config.QualifierConfig;
import com.callor.naver.persistance.BookDao;
import com.callor.naver.service.BookService;
/*
 * bookServiceV1
 * BookService interface를 상속받은 클래스가 다수 있을 때
 * Controller에서 어떤 클래스를 지금 연결하여 사용할 것인가의
 * 문제가 발생한다.
 * 그럴 때 @Service Annotation에 이름(식별자)를 부착하여
 * 클래스 중, 필요한 부분을 선택할 수 있도록 하기 위해 
 * 부착하는 것.
 */
@Service(QualifierConfig.SERVICE.BOOKS_V1)
public class BookServiceImplV1 implements BookService {
	
	@Override
	public List<BookDao> findByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookDao> findByAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookDao> findByPublisher(String Publisher) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookDao> findByPrice(int price) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookDao> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookDao findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(BookDao vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BookDao vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
