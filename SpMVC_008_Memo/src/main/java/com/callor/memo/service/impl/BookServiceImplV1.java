package com.callor.memo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.callor.memo.model.BookDTO;
import com.callor.memo.persistance.BookDao;
import com.callor.memo.service.BookService;
import com.callor.memo.service.FileUpService;

@Service
public class BookServiceImplV1 implements BookService{
	
	protected final FileUpService fileUp;
	protected final BookDao bookDao;
	public BookServiceImplV1(FileUpService fileUp, BookDao bookDao) {
		this.fileUp = fileUp;
		this.bookDao = bookDao;
	}
	
	@Autowired
	public void create_table() {
		bookDao.create_book_table();
	}
	
	
	@Override
	public List<BookDTO> selectAll() {
		
		return null;
	}

	@Override
	public int insertAndUpdate(BookDTO book, MultipartFile file) {
		/*
		 * insert 되는 경우, b_seq가 0일 것이고
		 * update 되는 경우, b_seq가 0이 아닐 것이다
		 */
		long b_seq = book.getB_seq();
		//book 수정일 경우(update, 데이터가 있는 경우) 처리
		if(b_seq != 0) {
			//먼저 seq값으로 table에서 데이터를 가져오고
			BookDTO updateBook = bookDao.findById(b_seq);
			//저장된 fileName을 가져오기
			String fileName = updateBook.getB_image();
			//저장된 파일이름과 새롭게 업로드된 파일 이름이 다르면
			if( !fileName.equals(file.getOriginalFilename())) {
				//기존 파일 삭제하고
				fileUp.fileDelete(updateBook.getB_up_image());
			}
			//파일을 업로드 후, 업로드된 파일 이름 가져오기
			String upLoadFileName = fileUp.fileUp(file);
			//table에 저장하기 위해 원래 파일 이름과 UUID가 부착된 파일 이름을 DTO에 저장
			book.setB_image(file.getOriginalFilename());
			book.setB_up_image(upLoadFileName);
			return bookDao.update(book);
		}
		//insert인 경우
		book.setB_image(file.getOriginalFilename());
		book.setB_up_image(fileUp.fileUp(file));
		return bookDao.insert(book);
	}

	/* 독후감 삭제할 때
	 * 1. 첨부 파일이 있을 경우 파일 먼저 삭제한 후,
	 * 2. 데이터 삭제
	 * 만약 순서 바뀌면 필요없는 파일들이 폴더에 남을 수 있다.
	 */
	@Override
	public int delete(long seq) {
		//seq에 해당하는 data를 select해 book에 담고,
		BookDTO book = bookDao.findById(seq);
		//파일 이름을 fileDelete()에게 보내서 파일 삭제
		fileUp.fileDelete(book.getB_up_image());
		//그 이후에 데이터 삭제한다. 순서조심
		bookDao.delete(seq);
		return 0;
	}

	@Override
	public BookDTO findById(long seq) {
		return bookDao.findById(seq);
	}

	@Override
	public List<BookDTO> findByAuthor(String username) {
		return bookDao.findByAuthor(username);
	}

}
