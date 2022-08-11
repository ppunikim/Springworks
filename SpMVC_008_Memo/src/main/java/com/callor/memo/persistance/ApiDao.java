package com.callor.memo.persistance;

import java.util.List;

import com.callor.memo.model.ApiDTO;

public interface ApiDao {
	
	public List<ApiDTO> selectAll();
	public ApiDTO findById(long seq);
	public int insert(ApiDTO book);
	public int update(ApiDTO book);
	public int delete(long seq);
	
	public List<ApiDTO> findByBook(String book);
	public List<ApiDTO> findByAuthor(String author);
	
	public void create_book_table();
	
}
