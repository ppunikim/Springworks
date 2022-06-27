package com.callor.memo.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.callor.memo.model.BookDTO;

public interface BookService{

	public List<BookDTO> selectAll();
	public int insertAndUpdate(BookDTO book, MultipartFile file);
	public int delete(long seq);
	public BookDTO findById(long seq);
	public List<BookDTO> findByAuthor(String username);
}
