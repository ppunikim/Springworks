package com.callor.memo.persistance;

import java.util.List;

import com.callor.memo.model.BookDTO;

public interface BookDao {
	
	public List<BookDTO> selectAll();
	public BookDTO findById(long seq);
	public int insert(BookDTO book);
	public int update(BookDTO book);
	public int delete(long seq);
	
	public List<BookDTO> findByBook(String book);
	public List<BookDTO> findByAuthor(String author);
	
	public void create_book_table();
	
}
