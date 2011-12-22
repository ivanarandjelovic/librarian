package org.aivan.librarian.service;

import java.util.List;

import org.aivan.librarian.dao.BookDao;
import org.aivan.librarian.dao.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The class implement business logic related to books.
 * 
 * @author iarandjelovic
 *
 */
@Service
public class BookService {

	BookDao bookDao;
	
	
	@Autowired
	public BookService(BookDao bookDao) {
		super();
		this.bookDao = bookDao;
	}

	public List<Book> getAllBooks() {
		return bookDao.getAllBooks();
	}
	
	public Book getBook(Long id) {
		return bookDao.getBook(id);
	}

}