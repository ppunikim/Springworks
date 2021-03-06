package com.callor.naver.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.callor.naver.model.BuyBooksVO;

public interface BuyBooksDao {

	public List<BuyBooksVO> selectAll(); 
	public BuyBooksVO findByIsbnAndUserName(
			@Param("isbn") String isbn,
			@Param("isbn") String username);
	
	public List<BuyBooksVO> findByIsbn(String isbn);
	public List<BuyBooksVO> findByUserName(String username);
	
	public int insert(BuyBooksVO vo);
	
	// 날짜로 도서추가
	public List<String> findByDate();
	
	public List<BuyBooksVO> findByUserNameAndDate(
			@Param("username") String username,
			@Param("buydate") String buydate
			);
	
}
